package Runner; /**
 * Created by notauser on 9/29/16.
 * Main Class
 */

import Interface.LogIn;

public class Runner {
    public static void main(String[] args) throws Exception {
        LogIn log = new LogIn();
        log.start();
    }
}
