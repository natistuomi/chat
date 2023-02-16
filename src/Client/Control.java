package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    Model model = new Model("10.70.45.159", 1234) ;
    View view = new View();

    public Control(Model m, View v) {
        this.model = m;
        this.view = v;

        view.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Fyll i senare. Vad gör knappen?*/
            }
        });

        JFrame frame = new JFrame("View");
        frame.setContentPane(view.getPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
