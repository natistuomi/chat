package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    static Model model = new Model("10.70.45.159", 1234) ;
    static View view = new View();

    public Control() {
        view.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JFrame frame = new JFrame("View");
        frame.setContentPane(view.getPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        model.getStreams();
        Thread listener = new Thread(model.getListenerThread());
        listener.start();
        model.runProtocol();
        listener.join();
        model.shutDown();
    }
}
