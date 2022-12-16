/**
 * Simple wrapper-method to contain the main-client
 * @version 1.0
 * @since 16.12.2021
 * @author 10113
 */
public class ClientMain {
    /**
     * Main-client
     * @param args, String-array of params
     */
    public static void main(String[] args) {
        //Initialising the App for Olympic Games long jump women 2020
        LongJumpGUI runApp = new LongJumpGUI();
        runApp.start();
    }
}
