package classes;

import enums.Racas;
import enums.Weapons;

import javax.swing.*;

/**
 * Created by notauser on 10/2/16.
 */

public class Espadachin extends ModelClasses {


    @Override
    public int showStats() {
        return Dmg;
    }

    @Override
    public void setDmg(int extra) {
        Dmg +=extra;
    }

    @Override
    public void initializeClass() {
        setArma();
        setRaca();
        setDmg(66);
    }

    @Override
    public void setRaca() {
        raca = Racas.Humano.name();
    }

    @Override
    public void setArma() {
        arma.put(Weapons.Espada.name(),Weapons.Espada.getDano());
    }
}
