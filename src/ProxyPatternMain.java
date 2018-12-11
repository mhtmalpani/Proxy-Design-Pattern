public class ProxyPatternMain {

    public static void main(String[] args) {

        Internet internet = new ProxyInternet();

        try {
            internet.connectToUrl("www.google.com");
            internet.connectToUrl("www.facebook.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
