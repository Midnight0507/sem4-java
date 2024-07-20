import java.lang.Thread;
import java.util.*;

public class trialThread {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    Thread thr = new Thread(new counter());
	    System.out.print("Enter the url: ");
	    String url =sc.next();
	    Thread youtube = new Thread(new YoutubeVideo(url));
	    thr.start();
	    System.out.println("Thread Active Count Before:" + Thread.activeCount());
	    youtube.start();
	    System.out.println("Thread Active Count After:" + Thread.activeCount());
	}
}