package enums;

/**
 * Created by notauser on 9/29/16.
 * Set Default weapons
 */
public enum Weapons {
    Espada(25),
    //Mage only
    Pedaco_de_Pau(20),
    // AssassinoFurtivo only
    Adaga(50),
    //MlkTretudo only
    Treta(9001);

    private final int dano;
    Weapons(int dano){this.dano = dano;}
    public int getDano() {return dano;}
}
