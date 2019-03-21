import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class newCalculator {
    private JPanel newcalculator;
    private JTextField textField1;
    private JRadioButton radioButtonBruNet;
    private JRadioButton radioButtonNetBru;
    private JTextField textFieldResult;
    private JButton ButtonResult;
    private JLabel alert;
    private JButton ButtonReset;
    public JMenuBar menuBar;
    private JMenu info;
    private JMenuItem showInfo;
    private double tax = 1.23;
    private double resultNiB;
    private double resultBiN;

    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("newCalculator");
        frame.setContentPane(new newCalculator().newcalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public newCalculator() {
        radioButtonBruNet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BruttoIntoNetto();
            }
        });
        radioButtonNetBru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NettoIntoBrutto();
            }
        });
        ButtonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textFieldResult.setText("");
            }
        });
        ButtonResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonBruNet.isSelected()) {
                    BruttoIntoNetto();
                } else {
                    NettoIntoBrutto();
                }
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (((input < '0') || (input > '9')) && (input != '\b')) {
                    e.consume();
                    alert.setText("type only numbers !");
                }

            }
        });

        menuBar = new JMenuBar();
        info = new JMenu("Info");
        menuBar.add(info);
        showInfo = new JMenuItem("Info about author");
        info.add(showInfo);
        menuBar.setVisible(true);

        showInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("infoabout");
                frame.setContentPane(new infoabout().panel1);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });

        frame.setJMenuBar(menuBar);
    }


    public void NettoIntoBrutto() {
        resultNiB = Double.parseDouble(textField1.getText()) * tax;
        java.text.DecimalFormat resultNnBk = new java.text.DecimalFormat();
        resultNnBk.setMaximumFractionDigits(2);
        resultNnBk.setMinimumFractionDigits(2);
        textFieldResult.setText(resultNnBk.format(resultNiB));
    }

    public void BruttoIntoNetto() {
        resultBiN = Double.parseDouble(textField1.getText()) / tax;
        java.text.DecimalFormat resultBnNk = new java.text.DecimalFormat();
        resultBnNk.setMaximumFractionDigits(2);
        resultBnNk.setMinimumFractionDigits(2);
        textFieldResult.setText(resultBnNk.format(resultBiN));
    }
}
