import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {

    private List<String> restrictedUrls;
    private ActualInternet actualInternet;

    public ProxyInternet() {
        createRestrictedUrlList();
    }

    private void createRestrictedUrlList() {
        restrictedUrls = new ArrayList<>();

        restrictedUrls.add("www.facebook.com");
        restrictedUrls.add("www.twitter.com");
        restrictedUrls.add("www.youtube.com");
    }

    @Override
    public void connectToUrl(String url) throws Exception {

        //Example of Protection Proxy
        //The proxy object makes some condition checks to act as a firewall
        if (restrictedUrls.contains(url)) {

            throw new Exception("Access Denied.\n" + url + " is a restricted url");

        } else {

            //Example of Virtual Proxy
            //The proxy object offloads multiple heavy object creations to a single time
            //Instantiates the real object when client requests for it the first time
            if (actualInternet == null) {
                actualInternet = new ActualInternet();
            }

            actualInternet.connectToUrl(url);
        }
    }
}
