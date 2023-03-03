package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    private Model model;
    private View view;

    public Control(Model m, View v) {
        this.model = m;
        this.view = v;

        view.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Fyll i senare*/
            }
        });

        JFrame frame = new JFrame("View");
        frame.setContentPane(view.getPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void main(String[] args) {
        Model m = new Model("10.70.45.159", 1234);
        View v = new View();
        Control c =  new Control(m,v);
        /*Behöver inte acceptera klienter eftersom detta inte är server*/
        c.model.getStreams();
        Thread listener = new Thread(c.model.getListenerThread());
        listener.start();
        runProtocol(c);

        c.model.shutDown();
    }

    public void runProtocol(Control c){
        String msg = String.valueOf(view.getInputfield());
        msg = c.model.makeMsg(msg);
        /* Send message to view? */
    }
}
