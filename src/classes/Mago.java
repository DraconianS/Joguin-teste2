package classes;

import enums.Racas;
import enums.Weapons;

/**
 * Created by notauser on 10/2/16.
 */
public class Mago extends ModelClasses {
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
        setDmg(50);
    }

    @Override
    public void setRaca() {
        String thing = Racas.Elfo.getVida()+" - "+ Racas.Elfo.getMana()+" - "+ Racas.Elfo.getEnergia() ;
        raca.put(Racas.Elfo.name(),thing);
    }

    @Override
    public void setArma() {
        arma.put(Weapons.Pedaco_de_Pau.name(),Weapons.Pedaco_de_Pau.getDano());
        arma.put(Weapons.Espada.name(),Weapons.Espada.getDano());
    }
}
