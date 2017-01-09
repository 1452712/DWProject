/**
 * Created by deado on 2016/12/6.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//example:
//Movie Url:https://www.amazon.com/dp/B00006HAXW/
//User Url: https://www.amazon.com/gp/cdp/member-reviews/A1RSDE90N6RSZF
public class InfoRetriever {


    public InfoRetriever(String id,String fromFile){
        this.fromFile = fromFile;
        this.threadId = id;
    }


    public class Movie{
        public String         movieASIN;
        public String         movieName;
        public Double         price;
        public Float          averageComment;
        public List<String>   directors;
        public List<String>   actors;
        public String         publishTime;
        public String         edition;
        public String         format;
        public String         rate;
        public List<String>   category;
        public List<Comment>  comments;
        public Movie(){
            this.directors = new ArrayList<String>();
            this.actors    = new ArrayList<String>();
            this.comments  = new ArrayList<Comment>();
            this.category  = new ArrayList<String>();
            movieName = " ";
            movieName = " ";
            price = 0.0;
            averageComment = 0.0f;
            publishTime = " ";
            edition = " ";
            format = " ";
            rate = " ";
        }
    }
    public class Comment{
        public String  userASIN;
        public String  userName;
        public Float   commentScore;
        public String  commentSummery;
        public String  commentText;
        public String  commentTime;
        public Integer helpfulness;
    }


    //unit method to get information of one movie (Page type normal)
    //Example:https://www.amazon.com/dp/B002MVPPMI/
    private Movie retrieveMovieInfoTypeNormal(Document doc, Elements ProDetails, String url){

        try{
            //return value
            Movie ret = new Movie();

            //ASIN:
            String asin = url.substring(url.indexOf("dp/")+3);
            if(asin.charAt(asin.length()-1)=='/'){
                asin = asin.substring(0,asin.length()-1);
            }
            ret.movieASIN = asin;




            /**********************************Part one*****************************/
            //name and edition
            String proTitle = doc.getElementById("productTitle").text();
            Integer pareBeg = proTitle.indexOf("(");
            Integer mPareBeg = proTitle.indexOf("[");
            if(pareBeg > 0){
                ret.movieName = "\"" + proTitle.substring(0,pareBeg) + "\"" ;
                ret.edition = "\""+ proTitle.substring(pareBeg+1, proTitle.indexOf(")")) + "\"";
            }
            else{
                if(mPareBeg > 0){// without [ and ]
                    ret.movieName = "\"" + proTitle.substring(0,mPareBeg) + "\"" ;
                }else{
                    ret.movieName = "\"" + proTitle.substring(0,proTitle.length()) + "\"";
                }
            }

            try{
                //byline Element to get format
                Element byline = doc.getElementById("byline");
                //format
                String  formatHtml = byline.html();
                String  formatKey = "<span class=\"a-color-secondary\">Format: </span>";
                Integer formatStartPt = formatHtml.indexOf(formatKey);
                String  formatContentWithTag = formatHtml.substring(formatStartPt+formatKey.length(), formatHtml.length());
                ret.format = formatContentWithTag.substring(formatContentWithTag.indexOf("<span>")+6, formatContentWithTag.indexOf("</span>"));
            }catch(Exception formatE){
                //ignore
            }


            //tmmSwatches to get price
            Element tmm = doc.getElementById("tmmSwatches");
            //price
            try{
                Elements PriceClass = tmm.getElementsByTag("ul").first().getElementsByClass("selected").first().
                        getElementsByClass("a-color-price");
                if(0 != PriceClass.size()){
                    ret.price = Double.valueOf(PriceClass.first().text().substring(1));
                }
            }catch(Exception e){
                //ignore
            }




            try{
                //get category
                Element categoryDiv = doc.getElementsByClass("content").last();
                Elements categoryLi = categoryDiv.getElementsByTag("li");
                for(Element e :categoryLi){
                    String cateText = e.getElementsByTag("a").last().text();
                    Integer middlePot = cateText.indexOf("&");
                    if(0 > middlePot){
                        ret.category.add(cateText);
                    } else{
                        ret.category.add(cateText.substring(0,middlePot-1));
                        ret.category.add(cateText.substring(middlePot+2));
                    }
                }
            }catch(Exception categoryE){
                //ignore
            }

            /***********************************************************************/

            Pattern release = Pattern.compile("<b>DVD Release Date:</b>");
            Pattern review = Pattern.compile("<b>Average Customer Review:</b>");
            Pattern actors = Pattern.compile("<b>Actors:</b>");
            Pattern director = Pattern.compile("<b>Directors:</b>");
            Pattern rated = Pattern.compile("<b>Rated:");
            //from product details
            Matcher matcher = null;
            for(Element e: ProDetails){
                String html = e.html();

                //release time
                matcher = release.matcher(html);
                if(matcher.find()){
                    Integer startPt = html.indexOf("</b>");
                    ret.publishTime = html.substring(startPt+4, html.length());
                    ret.publishTime = ret.publishTime.replace(',',' ');
                }


                try{
                    //review point
                    //target string  title="4.4 out of 5 stars
                    matcher = review.matcher(html);
                    if(matcher.find()){
                        //get title text
                        Pattern reviewPattern = Pattern.compile("(\\d.\\d) out of 5 stars");
                        Matcher reviewMatcher = reviewPattern.matcher(html);
                        //get float point
                        if(reviewMatcher.find()){
                            String strAverageComment= reviewMatcher.group().substring(0,3);
                            ret.averageComment = Float.valueOf(strAverageComment);
                        }
                    }

                    //actors
                    matcher = actors.matcher(html);
                    if(matcher.find()){
                        Elements actorsEles = e.getElementsByTag("a");
                        for(Element ae: actorsEles){
                            ret.actors.add(ae.text());
                        }
                    }

                    //directors
                    matcher = director.matcher(html);
                    if(matcher.find()){
                        Elements directorsEles = e.getElementsByTag("a");
                        for(Element ae: directorsEles){
                            ret.directors.add(ae.text());
                        }

                    }
                }catch(Exception bigE){
                    //ignore
                }


                //rated
                try{
                    matcher = rated.matcher(html);
                    if(matcher.find()){
                        ret.rate = e.getElementsByClass("a-size-small").first().text();
                    }
                }catch(Exception rateE){
                    //ignore
                }


            }
            return ret;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //unit method to get information of one movie (Page type Amazon Video)
    //Examples:https://www.amazon.com/dp/B01KH23NVS
    private Movie retrieveMovieInfoAmazonVideo(Document doc, Elements ProDetails, String url){
        try{
            Movie ret = new Movie();
            //ASIN:
            String asin = url.substring(url.indexOf("dp/")+3);
            if(asin.charAt(asin.length()-1)=='/'){
                asin = asin.substring(0,asin.length()-1);
            }
            ret.movieASIN = asin;

            //movie name
            Element titleDiv = doc.getElementById("dv-dp-title-content");
            ret.movieName = "\"" + titleDiv.getElementsByTag("h1").first().text() + "\"";
            //publish time
            try{
                ret.publishTime = titleDiv.getElementsByTag("h2").first().text();
                ret.publishTime.replace(',',' ');
            }catch(Exception e){

            }


            //averageComment
            try{
                Element reviewStarI = doc.getElementById("reviewStars");
                Pattern reviewValuePattern = Pattern.compile("(\\d.\\d) out of 5 stars");
                Matcher reviewMatcher = reviewValuePattern.matcher(reviewStarI.text());
                if(reviewMatcher.find()){
                    ret.averageComment = Float.valueOf(reviewMatcher.group().substring(0,3));
                }
            }catch(Exception averageCommentE){
                //ignore
            }



            //price
            Element priceDiv = doc.getElementById("dv-action-box").getElementsByClass("dv-purchase-options").first();
            Elements allFormInPriceDiv = priceDiv.getElementsByTag("form");
            for(Element e: allFormInPriceDiv){
                Element buyEle = e.getElementsByClass("dv-button-text").first();

                if(-1 != buyEle.text().indexOf("Buy")){
                    String buyContent = buyEle.text();
                    String priceStr = buyContent.substring(buyContent.indexOf("$")+1);
                    ret.price = Double.valueOf(priceStr);
                    break;
                }
            }

            /******************************************************************************************/

            Matcher matcher = null;
            //get info from Product details
            for(Element e: ProDetails){
                Element tr = e.getElementsByTag("tr").first();
                Element th = tr.getElementsByTag("th").first();
                Element td = tr.getElementsByTag("td").first();

                String detailStr = th.text();

                //category
                if(0 == detailStr.compareTo("Genres")){
                    Elements aEles = td.getElementsByTag("a");
                    for(Element ae:aEles){
                        ret.category.add(ae.text());
                    }
                }

                //director
                if(0 == detailStr.compareTo("Director")){
                    Elements aEles = td.getElementsByTag("a");
                    for(Element ae:aEles){
                        ret.directors.add(ae.text());
                    }
                }

                //actors
                if(0 == detailStr.compareTo("Starring")){
                    Elements aEles = td.getElementsByTag("a");
                    for(Element ae:aEles){
                        ret.actors.add(ae.text());
                    }
                }

                //rate
                if(0 == detailStr.compareTo("MPAA rating")){
                    String rateTemp = td.text();
                    Integer pareIndex = rateTemp.indexOf("(");
                    if(0 < pareIndex){
                        ret.rate = rateTemp.substring(0,pareIndex-1);
                    }
                    else{
                        ret.rate = rateTemp;
                    }
                }

                //format
                if(0 == detailStr.compareTo("Format")){
                    String formatTemp = td.text();
                    Integer pareIndex = formatTemp.indexOf("(");
                    if(0 < pareIndex){
                        ret.format = formatTemp.substring(0,pareIndex-1);
                    }
                    else{
                        ret.format = formatTemp;
                    }
                }


            }

            return ret;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //unit method to get information of one movie (Page type TV serials)
    //Examples:https://www.amazon.com/dp/B01MXDAMKE/
    private Movie retrieveMovieInfoTVSerials(Document doc, Elements ProDetails, String url){
        try{
            Movie ret = new Movie();
            //ASIN:
            String asin = url.substring(url.indexOf("dp/")+3);
            if(asin.charAt(asin.length()-1)=='/'){
                asin = asin.substring(0,asin.length()-1);
            }
            ret.movieASIN = asin;

            //serial name
            //id:dv-dp-title-content
            Element titleName = doc.getElementById("dv-dp-title-content");
            Element h = titleName.getElementsByTag("h1").first();
            ret.movieName = h.text();

            //price
            //dv-sub-box
            try{
                Element priceDiv = doc.getElementById("dv-sub-box");
                String  priceText = priceDiv.getElementsByTag("p").text();
                String  priceStr = priceText.substring(priceText.indexOf("$")+1, priceText.indexOf("/"));
                ret.price = Double.valueOf(priceStr);
            }catch(Exception e){
                //ignore
            }


            //averageComment
            //id:reviewStars
            Element starSpan = doc.getElementById("reviewStars").getElementsByTag("span").first();
            String  starText = starSpan.text();
            ret.averageComment = Float.valueOf(starText.substring( 0, starText.indexOf(" out") ));

            //directors--no such info on web page
            //TODO:null

            //actors & format
            //from the input para
            for(Element e: ProDetails){
                Element tr = e.getElementsByTag("tr").first();
                Element th = tr.getElementsByTag("th").first();
                Element td = tr.getElementsByTag("td").first();
                String detailStr = th.text();

                //actors
                if(0 == detailStr.compareTo("Starring")){
                    Elements aEles = td.getElementsByTag("a");
                    for(Element ae:aEles){
                        ret.actors.add(ae.text());
                    }
                }

                //format
                if(0 == detailStr.compareTo("Format")){
                    String formatText = td.text();
                    Integer pareIndex = formatText.indexOf("(");
                    if(0 < pareIndex){
                        ret.format = formatText.substring(0,pareIndex-1);
                    }
                    else{
                        ret.format = formatText;
                    }
                }
            }

            //publish time -- get from the first episode
            //rate  -- get from the first episode
            //id:dv-el-id-1
            try{
                Element timeDiv = doc.getElementById("dv-el-id-1").getElementsByClass("dv-el-synopsis-content").first();
                Element timeSpan = timeDiv.getElementsByClass("dv-el-attr-value").last();
                ret.publishTime = timeSpan.text();
                ret.publishTime.replace(',',' ');

                Element  rateSpan = timeDiv.getElementsByClass("dv-el-badge").first();
                ret.rate = rateSpan.text();
            }catch(Exception e){
                //ignore
            }


            //edition -- no such info on web page
            //TODO:null
            //category -- no such info on web page
            //TODO:null

            return ret;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //to handle different pages
    //amazon suckers
    private Movie SpiderDispatcher(String url){
        try{


            Movie ret = null;

            //new a client
            HttpClient client = HttpClients.custom()
                    .setUserAgent(this.agentList[this.count%4])
                    .build();

            //set get
            HttpGet request = new HttpGet(url);


            String  htmlContext = EntityUtils.toString(client.execute(request).getEntity());

            Document doc = Jsoup.parse(htmlContext);

            ////check if the page is the error page
            Element title = doc.getElementsByTag("title").first();
            if(0 < title.text().indexOf("Page Not Found")){
                ret = new Movie();
                ret.movieASIN = "error";
                return ret;
            }


            Element  ProDetails ;
            //case one -- normal page
            ProDetails = doc.getElementById("detail-bullets");
            if(null != ProDetails){
                ret = this.retrieveMovieInfoTypeNormal(doc,ProDetails.getElementsByTag("li"), url);

            }
            //case two -- AmazonVideo
            ProDetails = doc.getElementById("dv-center-features");
            if(null != ProDetails){
                Element typeCheck = doc.getElementById("dv-sub-box");
                ProDetails = ProDetails.getElementsByTag("tbody").first();
                if(null == typeCheck){ // Movies
                    ret = this.retrieveMovieInfoAmazonVideo(doc,ProDetails.getElementsByTag("tr"), url);
                }else{ // TV serials
                    ret = this.retrieveMovieInfoTVSerials(doc,ProDetails.getElementsByTag("tr"), url);
                }
            }

            if(ret!=null && ret.movieName == null){
                ret.movieName="error";
                return ret;
            }



            return ret;

        }catch(Exception e){
            System.out.print(url + "    error!\n");
            e.printStackTrace();
            return null;
        }
    }


    //main controller method
    //attentions:
    //  1. change browser info
    //  2. change frequency
    //  3. change ip (two serves or restart router)
    public synchronized void mainController(){
        try{

            File movieUrl = new File(this.fromFile);
            FileWriter movieOuput = null;
            FileWriter recordOutput = null;
            BufferedReader lineReader = new BufferedReader(new FileReader(movieUrl));
            String url = null;
            Boolean flag = true;
            Integer maxTime = 5;

            //read all url in memory
            ArrayList<String> urlPool = new ArrayList<String>();
            while(null != (url = lineReader.readLine())){
                urlPool.add(url);
            }


            //each url
            Iterator<String> itr = urlPool.iterator();
            while(itr.hasNext()){
                if(flag){
                    url=itr.next();
                }
                Movie item = this.SpiderDispatcher(url.substring(0,url.indexOf(32)));
                //output to file
                if(null != item && item.movieASIN.compareTo("error")!=0){
                    count++;
                    System.out.print("[ " + this.threadId + " ]");
                    System.out.print("          get  ");
                    System.out.print(count);
                    System.out.print("\n");
                    movieOuput = new FileWriter("res_"+this.fromFile, true);
                    movieOuput.write(item.movieASIN + ","
                            + item.movieName + ","
                            + item.price.toString() + ","
                            + item.averageComment.toString() + ","
                            + item.publishTime + ","
                            + item.rate + ","
                            + item.edition + ","
                            + item.format
                            + "\r\n");
                    movieOuput.close();
                    if(!flag){
                        flag=true;
                    }
                    //record
                    recordOutput = new FileWriter("record_"+this.fromFile, false);
                    recordOutput.write(url);
                    recordOutput.close();
                }else if(null != item && item.movieASIN.compareTo("error")==0){
                    System.out.print("[ " + this.threadId + " ]");
                    System.out.print(url + "    not found  ");
                    System.out.print(count++);
                    System.out.print("\n");
                    if(!flag){
                        flag = true;
                    }
                }
                else{
                    flag = false;
                    maxTime--;
                    if(maxTime>0){
                        System.out.print("[ " + this.threadId + " ]");
                        System.out.print(url + "    abandon......retry\n");
                        routerRestarter.restartRouter();
                    }
                    else{
                        maxTime = 5;
                        flag = true;
                    }

                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private Integer count = 0;
    private String  fromFile;
    private String threadId;

    private String[] agentList={"Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393",
            "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko"};
    static private  RouterRestarter routerRestarter= new RouterRestarter();


    static public void main(String[] argv){
        InfoRetriever ir = new InfoRetriever("1","MovieUrl_1.txt");
        ir.mainController();
        System.out.print("done");
    }

}
