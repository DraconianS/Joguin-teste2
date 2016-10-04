package Enums;

/**
 * Created by notauser on 9/29/16.
 */
public enum Racas {
    // Vida,Mana,Stamina
    Humano(100,50,75),
    Elfo(75,200,50),
    Gigante(300,50,300),
    RacaTretuda(9001,9001,9001);

    private final int vida;
    private final int mana;
    private final int stamina;

    Racas(int vida,int mana,int stamina){
        this.vida = vida;
        this.mana = mana;
        this.stamina = stamina;
    }

    public int getVida(){return vida;}
    public int getMana(){return mana;}
    public int getEnergia(){return stamina;}
}
