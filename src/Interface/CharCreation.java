package Interface;

import classes.Mago;
import classes.ModelClasses;
import enums.Attributes;
import enums.Classes;
import enums.Racas;
import enums.Weapons;
import sun.security.jca.GetInstance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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

    public CharCreation() throws Exception{
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,NameField.getText());
            }
        });
        classesBox.addMouseListener(new MouseAdapter() {

        });
        classesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                /*try {setStatsList();}
                catch (ClassNotFoundException e) {e.printStackTrace();}*/
                try {
                    setStatsList();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setStatsList() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        DefaultListModel listmodel = new DefaultListModel();
        String selected = classesBox.getSelectedItem().toString();

        for (Classes c: Classes.values()) {
            if(selected.toLowerCase().equals(c.name().toLowerCase())){

                Class<? extends ModelClasses> cl = (Class<? extends ModelClasses>) Class.forName("classes." + c.name());


                if(("classes." + selected.toLowerCase()).equals(cl.getName().toLowerCase() )){
                    ModelClasses clazz = cl.newInstance();

                    listmodel.addElement(selected);

                    clazz.initializeClass();
                    weaponsBox.removeAllItems();
                    for (Map.Entry<String,Integer> entry: clazz.arma.entrySet()) {
                        System.out.println(entry);
                        weaponsBox.addItem(entry);
                    }

                    racaBox.removeAllItems();
                    for (Map.Entry<String,String> entry: clazz.raca.entrySet()) {
                        System.out.println(entry);
                        racaBox.addItem(entry);
                    }

                    listmodel.addElement(clazz.showStats());


                    System.out.println("Arroz");
                }else JOptionPane.showMessageDialog(null, "EROOR!");
            }
        }

        Statslist.setModel(listmodel);
    }


    public void firstUpDate(){

        setBox(Classes.class,classesBox);
        //setBox(Weapons.class,weaponsBox);
        //setBox(Racas.class,racaBox);
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
