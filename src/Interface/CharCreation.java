package Interface;

import Enums.Attributes;
import Enums.Classes;
import Enums.Racas;
import Enums.Weapons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by notauser on 9/29/16.
 */
public class CharCreation extends JFrame {
    private JPanel CreationPanel;
    private JButton submitButton;
    private JComboBox classesBox;
    private JList Statslist;
    private JComboBox weaponsBox;
    private JComboBox racaBox;
    private JTextField NameField;
    private JProgressBar manaBar;
    private JProgressBar healthBar;
    private JProgressBar staminaBar;

    public CharCreation() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,NameField.getText());
            }
        });
    }

    public void firstUpDate(){
       /* for (Classes s: Classes.values()) {
            classesBox.addItem(s.name());
        }*/

        setBox(Classes.class,classesBox);
        setBox(Weapons.class,weaponsBox);
        setBox(Racas.class,racaBox);
        healthBar.setMaximum((int) Attributes.BaseStats.getStat1());
        manaBar.setMaximum((int) Attributes.BaseStats.getStat2());
        staminaBar.setMaximum((int) Attributes.BaseStats.getStat3());

    }

    private <E extends Enum<?>> void setBox(Class<E> c,JComboBox box){

        for (E s: c.getEnumConstants()){
            box.addItem(s);
        }
    }
    public void start(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setContentPane(this.CreationPanel);
        this.setEnabled(true);
        this.setVisible(true);
        this.setSize(625,250);
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        firstUpDate();
        this.setTitle("Criação de Personagem");

    }

}
