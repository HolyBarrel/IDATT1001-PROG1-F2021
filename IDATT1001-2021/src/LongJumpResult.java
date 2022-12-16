import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * Class for describing long jump results
 * @version 1.0
 * @since 16.12.2021
 * @author 10113
 */
public class LongJumpResult {
    private final int STARTNUMBER;
    private final String NAMEOFATHLETE;
    private double result;
    private boolean faul;
    private LocalTime time;

    /**
     * Constructor for the long jump
     * @param STARTNUMBER, must be positive integer
     * @param NAMEOFATHLETE, is string, not null
     * @param result, must be positive double
     * @param faul, boolean
     * @param time, is an inputted string, which is then parsed to a LocalTime object
     * @throws IllegalArgumentException, if the limitations mentioned are breached
     */
    public LongJumpResult(int STARTNUMBER, String NAMEOFATHLETE, double result, boolean faul, String time) throws
            IllegalArgumentException, DateTimeParseException, NullPointerException{
        if(STARTNUMBER < 1) throw new IllegalArgumentException("Wrongly inputted start number, " +
                "needs to be a positive integer");

        if(NAMEOFATHLETE == null) throw new IllegalArgumentException("No name inputted!");

        if(result < 0) throw new IllegalArgumentException("Results cannot be negative!");

        this.STARTNUMBER = STARTNUMBER;
        this.NAMEOFATHLETE = NAMEOFATHLETE;
        this.result = result;
        this.faul = faul;
        this.time = LocalTime.parse(time);
    }

    /**
     * Second constructor for later use of deep copying
     * @param jumpParam, is a created object
     */
    public LongJumpResult(LongJumpResult jumpParam){
        this(jumpParam.getSTARTNUMBER(), jumpParam.getNAMEOFATHLETE(),
                jumpParam.getResult(), jumpParam.isFaul(), String.valueOf(jumpParam.getTime()));
    }

    /**
     * Getter for
     * @return int number
     */
    public int getSTARTNUMBER() {
        return STARTNUMBER;
    }

    /**
     * Getter for name of athelete
     * @return String name
     */
    public String getNAMEOFATHLETE() {
        return NAMEOFATHLETE;
    }

    /**
     * Getter for result
     * @return double result
     */
    public double getResult() {
        return result;
    }

    /**
     * Setter for result
     * @param result, cannot be negative
     * @throws IllegalArgumentException, if negative input
     */
    public void setResult(double result) throws IllegalArgumentException{
        if(result < 0){
            throw new IllegalArgumentException("Results cannot be negative!");
        }
        this.result = result;
    }

    /**
     * Returner for faul
     * @return boolean faul
     */
    public boolean isFaul() {
        return faul;
    }

    /**
     * Setter for faul
     * @param faul, is boolean
     *              this app will not use the set-methods, as it decreases coupling between the
     *              user-class and this one.
     */
    public void setFaul(boolean faul) {
        this.faul = faul;
    }

    /**
     * Getter for time
     * @return LocalTime time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Setter for time
     * @param time, needs string as input
     *              this app will not use the set-methods, as it decreases coupling between the
     *              actual user-class and this one.
     */
    public void setTime(String time) throws DateTimeParseException{
        this.time = LocalTime.parse(time);
    }

    @Override
    public String toString() {
        return  "\nStart Number: " + STARTNUMBER +
                ", Athlete Name: " + NAMEOFATHLETE +
                ", Jump Result (Meters):" + result +
                ", Was the jump a verified?: " + faul +
                ", TimeStamp of Jump (HH:MM:(SS)): " + time;
    }
}
