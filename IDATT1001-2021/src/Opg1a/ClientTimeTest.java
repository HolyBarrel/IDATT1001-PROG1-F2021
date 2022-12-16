package Opg1a;

import java.time.LocalTime;

/**
 * Simple wrapper-method to contain the main-client for the test code
 * @version 1.0
 * @since 16.12.2021
 * @author 10113
 */
public class ClientTimeTest {
    /**
     * Main-client
     * @param args, String-array of params
     */
    public static void main(String[] args) {
        LocalTime time = LocalTime.parse("10:23:15");
        LocalTime time2 = LocalTime.parse("11:23:20");

        System.out.println("The inputted variable has: " + time.getMinute()+ " minutes.");

        System.out.println("Is 'time' before 'time2'? = " + time.isBefore(time2));
        System.out.println("Is 'time2' after 'time'? = " + time2.isAfter(time));
    }
}