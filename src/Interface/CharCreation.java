package Interface;

import enums.Attributes;
import enums.Classes;
import enums.Racas;
import enums.Weapons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 import classes.*;
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
        classesBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                for (Attributes b: Attributes.values() ) {
                    if(b.name() == Statslist.getSelectedValue()){
                        JOptionPane.showMessageDialog(null,"AEEEEEEEEEEEEEEEE");
                    }
                }
            }
        });
        classesBox.addMouseListener(new MouseAdapter() {

        });
        classesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Statslist.clearSelection();


                JOptionPane.showMessageDialog(null,classesBox.getSelectedItem());
                try {setStatsList();} catch (ClassNotFoundException e) {JOptionPane.showMessageDialog(null,e.getMessage());}

                JOptionPane.showMessageDialog(null,"AEEEEEEEEEEEEEEEE");

            }
        });
    }

    private void setStatsList() throws ClassNotFoundException {
        DefaultListModel listmodel = new DefaultListModel();
        String selected = classesBox.getSelectedItem().toString();
        Mago asd = new Mago();
        //asd.initializeClass();
        //listmodel.addElement(selected);
        //listmodel.addElement(asd.showStats());
        for (Classes c: Classes.values()) {
            if(c.name().toLowerCase() == selected.toLowerCase()){
                JOptionPane.showMessageDialog(null,"BOOOOOOOOOM!");
                //listmodel.addElement(selected);
                //Class<?> cl = Class.forName("classes."+c.name());
                String path = "classes."+selected;
                Class cl = path.getClass();
                if(cl.getName().toLowerCase() == "Mago".toLowerCase()){
                    JOptionPane.showMessageDialog(null,"BOOOOOOOOOM2!");
                    //asd.showStats(listmodel,selected);
                    asd.initializeClass();
                    listmodel.addElement(selected);
                    listmodel.addElement(asd.showStats());
                    Statslist.setModel(listmodel);
                }else JOptionPane.showMessageDialog(null, "EROOR!");
            }
        }
        /*switch (selected){
            case "Espadachin":
                listmodel.addElement(selected);
                break;
            case "Mago":
                listmodel.addElement(selected);
                break;
            case "AssassinoFurtivo":
                listmodel.addElement(selected);
                break;
            case "MlkTretudo":
                listmodel.addElement(selected);
                break;
            default:
                JOptionPane.showMessageDialog(null,"Error","ERROR!",1);
        }*/
        Statslist.setModel(listmodel);
    }


    public void firstUpDate(){
       /* for (classes s: classes.values()) {
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
        this.setSize(850,250);
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        firstUpDate();
        this.setTitle("Criação de Personagem");

    }

}
