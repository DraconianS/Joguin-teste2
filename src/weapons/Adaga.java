package weapons;

import java.util.HashMap;

/**
 * Created by notauser on 10/16/16.
 * Set Default Adaga Stat, that should be used only for the gigantes
 *                          feels bad .-.
 */
public class Adaga extends ModelWeapons {
    @Override
    public HashMap getWeaponStats() {
        return weaponstats;
    }

    @Override
    public void setWeaponstats() {
        weaponstats.put("Força",4);
        weaponstats.put("Sabedoria",2);
        weaponstats.put("Inteligencia",3);
        weaponstats.put("Luck",10);
        weaponstats.put("Treta",1);
    }
}
