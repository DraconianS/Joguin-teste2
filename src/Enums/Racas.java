package Enums;

/**
 * Created by notauser on 9/29/16.
 */
public enum Racas {
    Humano(100,50,75),
    Elfo(75,200,50),
    Gigante(300,50,300),
    RacaTretuda(9001,9001,9001);

    private final int id1;
    private final int id2;
    private final int id3;

    Racas(int id1,int id2,int id3){
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
    }

    public int getVida(){return id1;}
    public int getMana(){return id3;}
    public int getEnergia(){return id3;}
}
