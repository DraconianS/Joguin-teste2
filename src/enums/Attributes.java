package enums;

/**
 * Created by notauser on 9/29/16.
 */
public enum Attributes {
    // -1 deve ser ignorado em todos os modsfiers
    BaseStats(100,50,150),
    // st1 = modvida  st2 = moddano st3 = moddef
    Forca(5,2,3),
    //st1 = modmana st2= moddano st3= moddef
    Sabedoria(6,3,1),
    // st1 = modmana st2=moddano st3=null
    Inteligencia(1,10,-1),
    //st1 = critico st2= esquiva st3 = HK;
    Luck(1.5f,2f,0.00023f),
    // D treta never ends
    Treta(9001,9001,9001);


    private final float Stat1 ;
    private final float Stat2;
    private final float Stat3;


    Attributes(float st1,float st2,float st3){
        this.Stat1 = st1;
        this.Stat2 = st2;
        this.Stat3 = st3;
    }

    public float getStat1() {
        return Stat1;
    }

    public float getStat2() {
        return Stat2;
    }

    public float getStat3() {
        return Stat3;
    }
}
