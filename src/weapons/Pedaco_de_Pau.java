package weapons;

import java.util.HashMap;

/**
 * Created by notauser on 10/16/16.
 * Set Default Pedaço de Pau stat
 */
public class Pedaco_de_Pau extends ModelWeapons {
    @Override
    public HashMap getWeaponStats() {
        return weaponstats;
    }

    @Override
    public void setWeaponstats() {
        weaponstats.put("Força",1);
        weaponstats.put("Sabedoria",8);
        weaponstats.put("Inteligencia",7);
        weaponstats.put("Luck",2);
        weaponstats.put("Treta",1);
    }
}
