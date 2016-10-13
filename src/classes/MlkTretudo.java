package classes;

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
        Dmg = Dmg +extra;
    }

    @Override
    public void initializeClass() {

    }

    @Override
    public void setRaca() {

    }

    @Override
    public void setArma() {

    }
}
