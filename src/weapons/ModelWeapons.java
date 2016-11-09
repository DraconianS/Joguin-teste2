package weapons;

import java.util.HashMap;

/**
 * Created by notauser on 10/16/16.
 * Initialize weaponstats HashMap
 */
public abstract class ModelWeapons {
    public HashMap<String,Integer> weaponstats;
    abstract public HashMap getWeaponStats();
    abstract public void setWeaponstats();

    ModelWeapons(){
        weaponstats = new HashMap<>();
    }
}
