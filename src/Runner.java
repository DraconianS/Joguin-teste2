/**
 * Created by notauser on 9/29/16.
 */
import Interface.CharCreation;
import Interface.LogIn;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) throws Exception {
        LogIn log = new LogIn();
        log.start();
        CharCreation debug = new CharCreation();
        //debug.start();


    }
}
