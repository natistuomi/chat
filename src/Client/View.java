package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JTextArea chatarea;
    private JPanel pane;
    private JTextField inputfield;
    private JButton button;

    public JButton getButton() {
        return button;
    }

    public JPanel getPane(){return pane;}

    public JTextArea getChatarea(){return chatarea;}

    public JTextField getInputfield(){return inputfield;}

    public void setChatarea(JTextArea chatarea){this.chatarea = chatarea;}
}
