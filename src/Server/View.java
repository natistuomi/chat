package Server;

import javax.swing.*;

public class View {
    private JPanel pane;
    private JTextArea chatarea;
    private JTextField inputfield;
    private JButton button;

    public JButton getButton(){return button;}

    public JPanel getPane() {
        return pane;
    }

    public JTextArea getChatarea(){return chatarea;}

    public JTextField getInputfield(){return inputfield;}

    public void setChatarea(JTextArea chatarea){this.chatarea = chatarea;}
}
