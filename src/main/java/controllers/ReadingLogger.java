package controllers;

import entities.User;
import entities.Reading;
import entities.ReadingLog;
import java.util.Scanner;

public class ReadingLogger {

    private User loggedInUser;

    //Creates a ReadingLogger object with the logged in User.
    public ReadingLogger(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //Adds the reading generated to the user's reading log.
    public void logReading(Reading reading) {
        //*
         // @param reading: The Reading object generated and to be added to the user's reading log.
         //
        Scanner name = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter reading name");  // Ask for a reading name
        reading.readingName = name.nextLine(); // Define reading name
        ReadingLog readingLog = loggedInUser.getReadingLog();
        readingLog.addToLog(reading);
    }
}

