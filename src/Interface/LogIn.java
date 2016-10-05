package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Created by notauser on 9/29/16.
 */
public class LogIn extends JFrame {
    private JPanel LogInPanel;
    private JTextField nomeTextField;
    private JPasswordField passwordPasswordField;
    private JButton button1;


    public LogIn() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(nomeTextField.getText().equals("user") && passwordPasswordField.getText().equals("123")){
                    //JOptionPane.showMessageDialog(null,"fazer os treco funcionar","TESTE!!",-1);
                    CharCreation toon = null;
                    try {
                        toon = new CharCreation();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    toon.start();
                }
            }
        });


        nomeTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                super.focusGained(focusEvent);
                nomeTextField.setText("");
            }
        });
        passwordPasswordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                super.focusGained(focusEvent);
                passwordPasswordField.setText("");
            }
        });
    }
    public void start(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setContentPane(this.LogInPanel);
        this.setEnabled(true);
        this.setVisible(true);
        this.setSize(250,250);
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        this.setTitle("Log In");
    }
    public JPanel getLogInPanel() {
        return LogInPanel;
    }
}


