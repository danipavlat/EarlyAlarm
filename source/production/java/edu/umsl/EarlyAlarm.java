package edu.umsl;

import java.util.InputMismatchException;
import java.util.Scanner;

//Computes the ideal time for Steve's morning alarm: 45 minutes before leaving bed.
//INPUT: two integers H and M (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) separated by a single space
//OUTPUT: Time - 45 minutes (24-hour-time format)
public class EarlyAlarm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hour = -1, minutes = -1;

        //prompt for 24hr input: H M
        System.out.println("What time would you like to wake up?");

        try {
            System.out.println("Please enter hour and minutes separated by a single space.");
            hour = input.nextInt();
            minutes = input.nextInt();

            while ((hour < 0 || hour > 23) || (minutes < 0 || minutes > 59)) {
                //24 hour input validation
                if (hour < 0 || hour > 23) {
                    System.out.println("Please enter a valid hour (0 ≤ H ≤ 23):");
                    hour = input.nextInt();
                }
                if (minutes < 0 || minutes > 59) {
                    System.out.println("Please enter valid minutes (0 ≤ M ≤ 59):");
                    minutes = input.nextInt();
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Let's try again. Please enter only integers (0 ≤ H ≤ 23 and 0 ≤ M ≤ 59)");
            System.out.println();
            main(args);
        }

        //Calculate time - 45 minutes
        //Minute check: does hour roll back?
        if (minutes < 45) {
            int minutesUnderHour = 45 - minutes;
            minutes = 60 - minutesUnderHour;
            hour = hour - 1;
        } else {
            minutes = 60 - minutes;
        }

        //Display output
        if (hour < 10 && minutes < 10) {
            System.out.println("Set tomorrow's alarm for 0" + hour + ":0" + minutes);
        } else if (hour < 10) {
            System.out.println("Set tomorrow's alarm for 0" + hour + ":" + minutes);
        } else if (minutes < 10) {
            System.out.println("Set tomorrow's alarm for " + hour + ":0" + minutes);
        } else {
            System.out.println("Set tomorrow's alarm for " + hour + ":" + minutes);
        }

        //Ending program
        System.out.println("Good night!");
    }
}
