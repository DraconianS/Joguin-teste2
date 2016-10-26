package Interface;

import classes.ModelClasses;
import enums.Attributes;
import enums.Classes;
import enums.Racas;
import enums.Weapons;
import weapons.ModelWeapons;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

/**
 * Created by notauser on 9/29/16.
 */
public class CharCreation extends JFrame {
    DefaultListModel listmodel = new DefaultListModel();
    String ListHead;
    private ArrayList status_arma = new ArrayList();
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(NameField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Digite um nome","Digite um nome",2);
                    NameField.grabFocus();
                }else{
                    File f = new File("saves/"+NameField.getText()+".txt");
                    if (f.isFile()){
                       JOptionPane.showMessageDialog(null,"Nome em uso","Erro",1);
                    }
                  else{
                      JOptionPane.showMessageDialog(null, NameField.getText());
                        PrintWriter writer = null;
                     try {
                         writer = new PrintWriter("saves/"+NameField.getText()+".txt","UTF-8");
                     } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                       }
                     writer.print("Nome: "+NameField.getText());
                     writer.print("\nClasse: "+ classesBox.getSelectedItem().toString());
                     writer.print("\nRaça: "+ racaBox.getSelectedItem().toString());
                     writer.print("\nWeapon: "+ weaponsBox.getSelectedItem().toString());
                     writer.print(status_arma);
                     writer.close();
                    }

                }
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

            }
        });
        weaponsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
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
                Statslist.setModel(listmodel);
            }
        });
        racaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(healthBar.getValue()+"|"+manaBar.getValue()+"|"+staminaBar.getValue());
                try {
                    setModBar();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println(healthBar.getValue()+"|"+manaBar.getValue()+"|"+staminaBar.getValue());
            }
        });
    }

    private void setModBar() throws ClassNotFoundException {
        String select = racaBox.getSelectedItem().toString();

        for (Racas r: Racas.values()) {
            if(select.toLowerCase().equals(r.name().toLowerCase())){
                baseBar();

                healthBar.setMaximum(healthBar.getValue()+r.getVida());
                manaBar.setMaximum(manaBar.getValue()+r.getMana());
                staminaBar.setMaximum(staminaBar.getValue()+r.getEnergia());

                healthBar.setValue(healthBar.getValue()+r.getVida());
                manaBar.setValue(manaBar.getValue()+r.getMana());
                staminaBar.setValue(staminaBar.getValue()+r.getEnergia());
            }
        }
    }

    private void setWeaponStat()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        listmodel.clear();
        listmodel.addElement(ListHead);
        String select = weaponsBox.getSelectedItem().toString();
        System.out.println(select);
        for(Weapons w: Weapons.values()){

            if(select.toLowerCase().equals(w.name().toLowerCase())){

                Class<? extends ModelWeapons> cla = (Class<? extends ModelWeapons>) Class.forName("weapons."+w.name());
                if(("weapons."+ select.toLowerCase()).equals(cla.getName().toLowerCase())){

                    ModelWeapons clazz = cla.newInstance();
                    listmodel.addElement(select);

                    clazz.setWeaponstats();
                    status_arma.clear();
                    for(Map.Entry<String,Integer> entry: clazz.weaponstats.entrySet()){
                        status_arma.add("\n"+entry);
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
                    for(int i=0; i < weaponsBox.getItemCount();i++){weaponsBox.removeItemAt(i);}
                    for (Map.Entry<String,Integer> entry: clazz.arma.entrySet()) {
                        String Sentry = entry.toString().substring(0,entry.toString().indexOf("="));
                        weaponsBox.addItem(Sentry);
                    }

                    for(int i=0; i < racaBox.getItemCount();i++){racaBox.removeItemAt(i);}
                    for (Map.Entry<String,String> entry: clazz.raca.entrySet()) {
                        String Sentry = entry.toString().substring(0,entry.toString().indexOf("="));
                        racaBox.addItem(Sentry);
                    }

                    ListHead = clazz.showStats().toString();

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

        healthBar.setValue((int) Attributes.BaseStats.getStat1());
        manaBar.setValue((int) Attributes.BaseStats.getStat2());
        staminaBar.setValue((int) Attributes.BaseStats.getStat3());

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
