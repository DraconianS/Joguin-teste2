package Interface;

import classes.ModelClasses;
import enums.Attributes;
import enums.Classes;
import enums.Weapons;
import weapons.ModelWeapons;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by notauser on 9/29/16.
 */
public class CharCreation extends JFrame {
    DefaultListModel listmodel = new DefaultListModel();
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
        classesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
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
                Statslist.setModel(listmodel);
            }
        });
    weaponsBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            /*try {
                setWeaponStat();
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
            Statslist.setModel(listmodel);*/
        }
        });
    }

    private void setWeaponStat()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        listmodel.clear();
        String select = weaponsBox.getSelectedItem().toString();

        for(Weapons w: Weapons.values()){

            if(select.substring(0,select.length()-3).toLowerCase().equals(w.name().toLowerCase())){

                Class<? extends ModelWeapons> cla = (Class<? extends ModelWeapons>) Class.forName("weapons."+w.name());
                if(("weapons."+ select.substring(0,select.length()-3).toLowerCase()).equals(cla.getName().toLowerCase())){
                    System.out.println("!!!!!!!!!!!!!!11classes :v");

                    ModelWeapons clazz = cla.newInstance();
                    listmodel.addElement(select);

                    clazz.setWeaponstats();

                    for(Map.Entry<String,Integer> entry: clazz.weaponstats.entrySet()){
                        System.out.println(entry);
                        listmodel.addElement(entry.getKey()+": "+entry.getValue());
                    }

                }else System.out.println("ERROR!!");
                break;
            }else System.out.println("classe nao encontrada");
        }
    }

    // Set the LOCK stuff for each class
    private void setStatsList() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String selected = classesBox.getSelectedItem().toString();
        listmodel.clear();
        //Loop for all classe within the enums.Classes
        for (Classes c: Classes.values()) {
            if(selected.toLowerCase().equals(c.name().toLowerCase())){

                // Set the selected class in cl
                Class<? extends ModelClasses> cl = (Class<? extends ModelClasses>) Class.forName("classes." + c.name());

                if(("classes." + selected.toLowerCase()).equals(cl.getName().toLowerCase() )){
                   // Instantiate cl in clazz
                    ModelClasses clazz = cl.newInstance();

                    listmodel.addElement(selected);

                    clazz.initializeClass();

                    // Set the LOCKED weapons for clazz
                    weaponsBox.removeAllItems();
                    for (Map.Entry<String,Integer> entry: clazz.arma.entrySet()) {
                        System.out.println(entry);
                        weaponsBox.addItem(entry);
                    }

                    // Set the LOCKED races for clazz
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
        setWeaponStat();
    }
    // Set the base maximum of the bars
    private void baseBar(){
        healthBar.setMaximum((int) Attributes.BaseStats.getStat1());
        manaBar.setMaximum((int) Attributes.BaseStats.getStat2());
        staminaBar.setMaximum((int) Attributes.BaseStats.getStat3());
    }

    // Set the standard stuff
    public void firstUpDate(){

        setBox(Classes.class,classesBox);
        baseBar();
    }
    // Method to set a whole Enum in a ComboBox
    private <E extends Enum<?>> void setBox(Class<E> c,JComboBox box){

        for (E s: c.getEnumConstants()){
            box.addItem(s);
        }
    }
    // Initialize the creation window
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
