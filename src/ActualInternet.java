public class ActualInternet implements Internet {

    @Override
    public void connectToUrl(String url) {
        System.out.println("Making connection to: " + url);
    }
}
