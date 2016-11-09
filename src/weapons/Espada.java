package weapons;

import java.util.HashMap;

/**
 * Created by notauser on 10/16/16.
 * Set Default Espada Stat
 */
public class Espada extends ModelWeapons {
    @Override
    public HashMap getWeaponStats() {
        return weaponstats;
    }

    @Override
    public void setWeaponstats() {
        weaponstats.put("Força",10);
        weaponstats.put("Sabedoria",1);
        weaponstats.put("Inteligencia",2);
        weaponstats.put("Luck",6);
        weaponstats.put("Treta",2);
    }
}
