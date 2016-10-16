package classes;

import enums.Racas;
import enums.Weapons;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by notauser on 10/2/16.
 */
public class AssassinoFurtivo extends ModelClasses {


    @Override
    public void setArma(){
        arma.put(Weapons.Adaga.name(),Weapons.Adaga.getDano());
        arma.put(Weapons.Espada.name(),Weapons.Espada.getDano());
    }

    @Override
    public void setDmg(int x){Dmg += x; }

    @Override
    public void setRaca(){
        String thing = Racas.Gigante.getVida()+" - "+ Racas.Gigante.getMana()+" - "+ Racas.Gigante.getEnergia() ;
        raca.put(Racas.Gigante.name(),thing);
    }

    @Override
    public String showStats() {
        return "Dano base: "+Dmg;

    }

    @Override
    public void initializeClass() {
        setArma();
        setRaca();
        setDmg(90);
    }
}
