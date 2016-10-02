package Enums;

/**
 * Created by notauser on 9/29/16.
 */
public enum Weapons {
    Espada(25),
    //Mage only
    Pedaco_de_Pau(25),
    // Gigante only
    Adaga(50),
    //Mlktretudo only
    Treta(9001);

    private final int id;
    Weapons(int id){this.id = id;}
    public int getId() {return id;}
}
