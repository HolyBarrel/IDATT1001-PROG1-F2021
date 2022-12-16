import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Class that handles the User Input
 * @version 1.0
 * @since 16.12.2021
 * @author 10113
 */
public class LongJumpGUI {

    //Object variable
    private final JumpRegistry UIREGISTRY;

    //Class variables
    private static final int REGISTER_JUMP = 1;
    private static final int LIST_RESULTS = 2;
    private static final int SEARCH_FOR_CONTESTANT = 3;
    private static final int SHOW_WINNER = 4;
    private static final int CALCULATE_AVG_JUMP = 5;
    private static final int EXIT = 6;

    /**
     * Simple constructor that creates a registry
     */
    public LongJumpGUI(){
        this.UIREGISTRY = new JumpRegistry();
    }

    /**
     * Private method to Show Menu and take user input, could have been divided into to methods
     * for a tad better cohesion
     * @return integer choice
     */
    private int showMenu() {
        System.out.println("\nOL-games [Summer] Length Jumps Women 2020"
                + "App \n\n");
        System.out.println("1. Register a new jump");
        System.out.println("2. List all registered results");
        System.out.println("3. Search for a contestant");
        System.out.println("4. Show winner-jump");
        System.out.println("5. Calculate average jump-length");
        System.out.println("6. Exit");
        System.out.println("\nPlease enter a number between 1 and 5, or 6 to exit the app.\n");
        return inputNewInt();
    }

    //INPUT-checks
    /**
     * Private helper-method to easily check integer inputs
     * @return int scanner input
     */
    private int inputNewInt(){
        for(;;){//one way of writing an infinite loop
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()){
                int num = sc.nextInt();
                if(num > -1) {
                    return num;
                }
            }
            System.out.println("Enter a positive integer: ");
        }
    }
    /**
     * Private helper-method to easily take in String inputs
     * @return String scanner input
     */
    private String inputNewString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    /**
     * Private helper-method to easily check long inputs
     * @return long scanner input
     */
    private double inputNewDouble(){
        for(;;){
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextDouble()){
                double dNum = sc.nextDouble();
                if(dNum > -1) {
                    return dNum;
                }
            }
            System.out.println("Enter a positive double: ");
        }
    }

    /**
     * Public method that uses the private method showMenu, and runs a while loop to gather UI
     * Two classes, means better cohesion
     */
    public void start() {
        this.fillRegister();
        boolean finished = false;
        // The while-loop will run as long as the user has not selected
        // to quit the application
        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case REGISTER_JUMP:
                    //using the private methods to filter bad input
                    System.out.println("Input a positive integer for a start number: ");
                    int startNum = inputNewInt();

                    System.out.println("Input a String for a name, not null: ");
                    String inpName = inputNewString();

                    System.out.println("Input a positive double for a result: ");
                    double inpResult = inputNewDouble();

                    System.out.println("Input a String, 'true' for a valid jump, " +
                            "'false' for invalid ones");
                    String boolInp = inputNewString();
                    Boolean inpBoolean = null;
                    //checking bool input
                    if(boolInp.equalsIgnoreCase("true")){
                        inpBoolean = true;
                    }else if(boolInp.equalsIgnoreCase("false")){
                        inpBoolean = false;
                    }

                    System.out.println("Input a timeStamp in the format- 'HH:MM:SS': ");
                    String inpTime = inputNewString();
                    //handling eventual exceptions thrown based on UI
                    try{
                        UIREGISTRY.registerAJump(startNum, inpName,inpResult, inpBoolean, inpTime);
                    }catch (IllegalArgumentException | DateTimeParseException | NullPointerException e){
                        System.out.println(e.getMessage());
                    }


                    break;
                case LIST_RESULTS:
                    System.out.println(UIREGISTRY);
                    break;
                case SEARCH_FOR_CONTESTANT:
                    System.out.println("Input a name-String to search for a contestants' jumps: ");
                    String inpString = inputNewString();
                    System.out.println(UIREGISTRY.searchForName(inpString));
                    break;
                case SHOW_WINNER:
                    System.out.println(UIREGISTRY.returnBestJump());
                    break;
                case CALCULATE_AVG_JUMP:
                    //double may print weird, but the value is valid
                    System.out.println("The average jump-length of all verified jumps, are: "
                    + UIREGISTRY.returnAvgJumpLength() + " meters");
                    break;
                case EXIT:
                    //case to shut program
                    System.out.println("Thank you for checking out this register " +
                            "application!\n");
                    finished = true;
                    break;
                default:
                    System.out.println("You chose an invalid integer as a menu choice." +
                            " Retry.");
            }
        }
    }

    /**
     * Filler-method to auto-input test data
     * Data is shortened for time-purposes
     */
    private void fillRegister(){
        //inputs five jump-cases
        UIREGISTRY.registerAJump(210,"Mala Mish", 6.98, true, "10:15:00");
        UIREGISTRY.registerAJump(210,"Mala Mish", 6.12, true, "10:40:00");
        UIREGISTRY.registerAJump(211,"Tara Davi", 6.85, true, "10:17:00");
        UIREGISTRY.registerAJump(211,"Tara Davi", 6.42, false, "10:24:00");
        UIREGISTRY.registerAJump(204,"Brit Rees", 6.52, true, "10:19:00");
    }
}
