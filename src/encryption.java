import javax.crypto.EncryptedPrivateKeyInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class encryption     extends JFrame {
    private Container cp;
    private JTextArea jtaR = new JTextArea("", 30, 15);
    private JTextArea jtaL = new JTextArea("", 30, 15);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JPanel jpnC = new JPanel(new GridLayout(9, 1, 5, 5));
    private JPanel jpnR = new JPanel(new GridLayout(1, 1, 5, 5));
    private JPanel jpnL = new JPanel(new GridLayout(1, 1, 5, 5));
    private JLabel jlb1 = new JLabel("Method");
    private String method[] = {"DES", "AES", "Caesar", "XOR"};
    private JComboBox jca = new JComboBox<String>(method);
    private JLabel jlb2 = new JLabel("Password");
    private JTextField jtf = new JTextField();
    private JRadioButton jrb1 = new JRadioButton("Encrypt");
    private JRadioButton jrb2 = new JRadioButton("Decrypt");
    private JButton jbtrun = new JButton("Run");
    private JButton jbtclose = new JButton("Close");
    private ButtonGroup buttonGroup = new ButtonGroup();

    public encryption() {
        ex1();
    }

    private void ex1() {
        this.setBounds(100, 100, 560, 400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Frame2 frm = new Frame2();
                frm.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpnL, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnR, BorderLayout.EAST);
        jpnL.add(jspL);
        jpnR.add(jspR);
        jpnC.add(jlb1);
        jpnC.add(jca);
        jpnC.add(jlb2);
        jpnC.add(jtf);
        jpnC.add(jrb1);
        jpnC.add(jrb2);
        jpnC.add(jbtrun);
        jpnC.add(jbtclose);
        buttonGroup.add(jrb1);
        buttonGroup.add(jrb2);
        jbtrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb1.isSelected()) {
                    int dataLength = jtaL.getText().length();
                    if (dataLength > 0) {
                        switch (jca.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedIndex() + "not implement yet");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedIndex() + "not implement yet");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtf.getText());
                                    char data[] = jtaL.getText().toCharArray();
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }
                                    jtaR.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(encryption.this, "key is not number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(encryption.this, "Error" + exp1.toString());
                                }
                                break;
                                case 3:
                                JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedIndex() + "not implement yet");
                                break;

                        }
                    }
                } else if (jrb2.isSelected()) {
                    if (jrb2.isSelected()) {
                        int dataLength = jtaR.getText().length();
                        if (dataLength > 0) {
                            switch (jca.getSelectedIndex()) {
                                case 0:
                                    JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedIndex() + "not implement yet");
                                    break;
                                case 1:
                                    JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedIndex() + "not implement yet");
                                    break;
                                case 2:
                                    try {
                                        int key = Integer.parseInt(jtf.getText());
                                        char data[] = jtaR.getText().toCharArray();
                                        for (int i = 0; i < dataLength; i++) {
                                            data[i] = (char) (data[i] - key);
                                        }
                                        jtaL.setText(new String(data));
                                    } catch (NumberFormatException exp) {
                                        JOptionPane.showMessageDialog(encryption.this, "key is not number");
                                    } catch (Exception exp1) {
                                        JOptionPane.showMessageDialog(encryption.this, "Error" + exp1.toString());
                                    }
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedIndex() + "not implement yet");
                                    break;
                            }
                        }
                    }
                }
            }
        });
        }
    }