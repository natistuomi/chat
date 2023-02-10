package Client;

public class Control {
    static Model model = new Model("10.70.45.159", 1234) ;

    public static void main(String[] args) throws InterruptedException {
        model.getStreams();
        Thread listener = new Thread(model.getListenerThread());
        listener.start();
        model.runProtocol();
        listener.join();
        model.shutDown();
    }
}
