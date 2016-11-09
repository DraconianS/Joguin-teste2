package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by notauser on 10/26/16.
 * Random screen to joke with the user :v KAPPA123
 */
public class Lobby extends JFrame {
    private JButton criarUmPersonagemButton;
    private JPanel Lobbypanel;
    private JButton carregarUmPersonagemButton;

    public Lobby() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        criarUmPersonagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CharCreation tooncrea = null;
                try {tooncrea = new CharCreation();} catch (Exception e) {e.printStackTrace();}
                tooncrea.start();
            }
        });
        carregarUmPersonagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Faça o personagem carregar","Faça o personagem carregar", 0);
            }
        });
    }
    public void start(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setContentPane(this.Lobbypanel);
        this.setEnabled(true);
        this.setVisible(true);
        this.setSize(250,250);
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        this.setTitle("Lobby");
    }
}
