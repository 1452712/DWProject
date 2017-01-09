/**
 * Created by deado on 2016/12/14.
 */
public class MultiThreadController extends Thread{
    private InfoRetriever infoRetriever ;
    MultiThreadController(String id, String filename){
        this.infoRetriever = new InfoRetriever(id,filename);
    }

    public void run(){
        this.infoRetriever.mainController();
    }

    static public void main(String[] argv){
        MultiThreadController thread_1 = new MultiThreadController("1","MovieUrl_1.txt");
        MultiThreadController thread_2 = new MultiThreadController("2","MovieUrl_2.txt");
        thread_1.start();
        thread_2.start();

    }
}
