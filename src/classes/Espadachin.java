package classes;

import enums.Racas;
import enums.Weapons;

/**
 * Created by notauser on 10/2/16.
 * Set the things for the EspadaCHIN
 */

public class Espadachin extends ModelClasses {


    @Override
    public String showStats() {
        return "Dano base: "+Dmg;
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
        String thing = Racas.Elfo.getVida()+" - "+Racas.Elfo.getMana()+" - "+Racas.Elfo.getEnergia();
        raca.put(Racas.Humano.name(),thing);

        thing = Racas.Elfo.getVida()+" - "+ Racas.Elfo.getMana()+" - "+ Racas.Elfo.getEnergia() ;
        raca.put(Racas.Elfo.name(),thing);
    }

    @Override
    public void setArma() {
        arma.put(Weapons.Espada.name(),Weapons.Espada.getDano());
        arma.put(Weapons.Pedaco_de_Pau.name(),Weapons.Pedaco_de_Pau.getDano());
    }
}
