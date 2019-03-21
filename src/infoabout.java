import javax.swing.*;

public class infoabout {
    public JTextArea infoAbout;
    public JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("infoabout");
        frame.setContentPane(new infoabout().panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
