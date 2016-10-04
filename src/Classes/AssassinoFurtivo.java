package Classes;

import Enums.Attributes;
import Enums.Weapons;

import java.util.HashMap;

/**
 * Created by notauser on 10/2/16.
 */
public class AssassinoFurtivo {
    private int Dmg;
    private HashMap<String, Integer> arma;
    private HashMap<String,Integer> raca;

    private void setArma(){
        arma.put(Weapons.Adaga.name(),Weapons.Adaga.getDano());
        arma.put(Weapons.Espada.name(),Weapons.Espada.getDano());
    }

    public void setDmg(){
        Dmg = Dmg+50;
    }

}
