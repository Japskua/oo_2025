package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * TimezoneConverter
 *
 * A simple Java program to demonstrate working with dates, times, and timezones.
 * The program displays the user's current local time, identifies their timezone,
 * and allows them to query the current time in a predefined list of cities.
 * Additionally, it calculates and displays the time difference in hours.
 */
public class App {
    public static void main(String[] args) {
        // Format for displaying the date and time
        SimpleDateFormat localFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Get the current date and time
        Date currentDate = new Date();
        // Get the local timezone of the user
        TimeZone localTimeZone = TimeZone.getDefault();
        // Set the formatter to use the local timezone
        localFormat.setTimeZone(localTimeZone);

        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);
        // Variable to store the user's input
        String cityInput;

        // Infinite loop to keep the program running until the user exits
        while (true) {
            // Display the local time
            System.out.println("Your current time: " + localFormat.format(currentDate));
            // Display the local timezone ID
            System.out.println("Your timezone: " + localTimeZone.getID());

            // Map some city capitals to their timezone IDs
            String[][] cities = {
                {"Helsinki", "Europe/Helsinki"},
                {"New York", "America/New_York"},
                {"Tokyo", "Asia/Tokyo"},
                {"Sydney", "Australia/Sydney"},
                {"London", "Europe/London"}
            };

            // Ask the user for a city
            System.out.println("Enter a city (Helsinki, New York, Tokyo, Sydney, London) or type 'exit' to quit:");
            // Read user input
            cityInput = scanner.nextLine();

            // Check if the user wants to exit the program
            if (cityInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                // Exit the loop
                break;
            }

            // Variable to store the timezone ID of the selected city
            String timeZoneId = null;
            // Loop through the list of cities to find a match
            for (String[] city : cities) {
                // Check if the input matches a city name
                if (city[0].equalsIgnoreCase(cityInput)) {
                    // Assign the matching timezone ID
                    timeZoneId = city[1];
                    // Exit the loop
                    break;
                }
            }

            // If a valid timezone ID was found
            if (timeZoneId != null) {
                // Formatter for the target timezone
                SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // Set the formatter to use the target timezone
                targetFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));

                // Format the current date for the target timezone
                String targetTime = targetFormat.format(currentDate);
                // Display the target city's time
                System.out.println("The current time in " + cityInput + " is: " + targetTime);

                // Get the target timezone
                TimeZone targetTimeZone = TimeZone.getTimeZone(timeZoneId);
                // Calculate the time difference in milliseconds
                long timeDifferenceMillis = targetTimeZone.getRawOffset() - localTimeZone.getRawOffset();
                // Convert milliseconds to hours
                int timeDifferenceHours = (int) (timeDifferenceMillis / (1000 * 60 * 60));

                // Display the time difference
                System.out.println("Time difference: " + timeDifferenceHours + " hours");
            } else {
                // If the city is not recognized
                System.out.println("City not recognized. Please try again.");
            }
        }

        // Close the scanner to free resources
        scanner.close();
    }
}
