import javax.swing.*;

public class InfoAbout {
    public JTextArea infoTextArea;
    public JPanel infoPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("InfoAbout");
        frame.setContentPane(new InfoAbout().infoPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
