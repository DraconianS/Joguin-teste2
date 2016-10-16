package weapons;

import java.util.HashMap;

/**
 * Created by notauser on 10/16/16.
 */
public abstract class ModelWeapons {
    public HashMap<String,Integer> weaponstats;

    /*int dano;
    int def;
    int health;
    int mana;
    int energia;
    int treta;
    float esquiva;
    float hk;
    float crit;*/
    abstract public HashMap getWeaponStats();
    abstract public void setWeaponstats();

    ModelWeapons(){
        weaponstats = new HashMap<>();
    }
}
