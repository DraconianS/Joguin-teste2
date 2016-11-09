package classes;

import enums.Racas;
import enums.Weapons;

/**
 * Created by notauser on 10/2/16.
 * Set AssassinoFurtivo weapons and races
 * It should work only for the gigante but it doesn't
 */
public class AssassinoFurtivo extends ModelClasses {


    @Override
    public void setArma(){
        arma.put(Weapons.Espada.name(),Weapons.Espada.getDano());
        arma.put(Weapons.Adaga.name(),Weapons.Adaga.getDano());
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
