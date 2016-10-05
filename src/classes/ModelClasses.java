package classes;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by notauser on 10/4/16.
 */
public abstract class ModelClasses {
    int Dmg;
    public HashMap<String, Integer> arma;
    public String raca;
    abstract public int showStats();
    abstract public void setDmg(int extra);
    abstract public void initializeClass();
    abstract public void setRaca();
    abstract public void setArma();
    ModelClasses () {
        arma = new HashMap<>();
    }
}
