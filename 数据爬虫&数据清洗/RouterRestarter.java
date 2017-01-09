import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



/**
 * Created by deado on 2016/12/14.
 */
public class RouterRestarter {
    //restart router
    public void restartRouter(){
        try{
            HttpClient client = HttpClients.custom().
                    setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
                    .build();
            HttpUriRequest mainGet = new HttpGet("http://192.168.1.1/userRpm/SysRebootRpm.htm?Reboot=%D6%D8%C6%F4%C2%B7%D3%C9%C6%F7");
            HttpHost target = new HttpHost("192.168.1.1");
            mainGet.addHeader("Cookie", "Authorization=Basic%20YWRtaW46ODUyMTQ3;ChgPwdSubTag=");
            mainGet.addHeader("Referer", "http://192.168.1.1/userRpm/SysRebootRpm.htm");

            String mainPage = EntityUtils.toString(client.execute(target,mainGet).getEntity());
        }catch(Exception e){
            //ignore
        }
    }

    static public void main(String[] argv){
        RouterRestarter r = new RouterRestarter();
        r.restartRouter();
    }
}
