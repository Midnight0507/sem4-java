import java.awt.Desktop;
import java.net.URI;

public class YoutubeVideo implements Runnable {
    public String url;
    YoutubeVideo(String url) {
        this.url = url;
    }
    @Override
    public void run() {
        try {
            // Create a URI object from the URL
            URI uri = new URI(url);

            // Get the desktop instance
            Desktop desktop = Desktop.getDesktop();

            // Check if the Desktop class supports browsing
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                // Open the YouTube URL in the default browser
                desktop.browse(uri);
            } else {
                System.out.println("Browsing not supported on your platform.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
