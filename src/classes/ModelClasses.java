package classes;

import java.util.HashMap;

/**
 * Created by notauser on 10/4/16.
 */
public abstract class ModelClasses {
    int Dmg;
    public HashMap<String, Integer> arma;
    public HashMap<String, String> raca;
    abstract public String showStats();
    abstract public void setDmg(int extra);
    abstract public void initializeClass();
    abstract public void setRaca();
    abstract public void setArma();
    ModelClasses () {
        raca = new HashMap<>();
        arma = new HashMap<>();
    }
}
