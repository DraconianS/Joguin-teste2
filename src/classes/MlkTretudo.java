package classes;

import enums.Racas;
import enums.Weapons;

/**
 * Created by notauser on 10/2/16.
 */
public class MlkTretudo extends ModelClasses {
    @Override
    public int showStats() {
        return  Dmg;

    }
    @Override
    public void setDmg(int extra) {
        Dmg = Dmg +extra+9999;
    }

    @Override
    public void initializeClass() {
        setRaca();
        setArma();
        setDmg(9999);
    }

    @Override
    public void setRaca() {
        String thing = Racas.RacaTretuda.getVida()+" - "+ Racas.RacaTretuda.getMana()+" - "+ Racas.RacaTretuda.getEnergia() ;
        raca.put(Racas.RacaTretuda.name(),thing);
    }

    @Override
    public void setArma() {
        arma.put(Weapons.Espada.name(),Weapons.Espada.getDano());
        arma.put(Weapons.Pedaco_de_Pau.name(),Weapons.Pedaco_de_Pau.getDano());
        arma.put(Weapons.Adaga.name(),Weapons.Adaga.getDano());
        arma.put(Weapons.Treta.name(),Weapons.Treta.getDano());
    }
}
