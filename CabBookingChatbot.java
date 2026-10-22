import java.util.Random;
import java.util.Scanner;

public class CabBookingChatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Predefined cab rates
        int autoRate = 12;
        int sedanRate = 18;
        int suvRate = 25;

        // Predefined routes (distance in km)
        String[] sources = {"Pune Station", "Swargate", "Hinjawadi"};
        String[] destinations = {"Shivajinagar", "Kothrud", "Wakad"};
        int[] distances = {5, 8, 10};

        System.out.println("Welcome to Kiran Cab Booking Chatbot!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                // Choose cab type
                System.out.println("\nChoose Cab Type:");
                System.out.println("1. Auto (₹12/km)");
                System.out.println("2. Sedan (₹18/km)");
                System.out.println("3. SUV (₹25/km)");
                System.out.print("Enter choice: ");
                int cabChoice = sc.nextInt();

                int rate = 0;
                String cabType = "";
                if (cabChoice == 1) {
                    rate = autoRate;
                    cabType = "Auto";
                } else if (cabChoice == 2) {
                    rate = sedanRate;
                    cabType = "Sedan";
                } else if (cabChoice == 3) {
                    rate = suvRate;
                    cabType = "SUV";
                } else {
                    System.out.println("Invalid cab choice. Returning to main menu.");
                    continue;
                }

                // Choose route
                System.out.println("\nChoose Route:");
                for (int i = 0; i < sources.length; i++) {
                    System.out.println((i + 1) + ". " + sources[i] + " to " + destinations[i] + " (" + distances[i] + " km)");
                }
                System.out.print("Enter choice: ");
                int routeChoice = sc.nextInt();

                if (routeChoice < 1 || routeChoice > sources.length) {
                    System.out.println("Invalid route choice. Returning to main menu.");
                    continue;
                }

                String source = sources[routeChoice - 1];
                String destination = destinations[routeChoice - 1];
                int distance = distances[routeChoice - 1];

                // Fare calculation
                int fare = rate * distance;
                System.out.println("\nRide Details:");
                System.out.println("Cab Type: " + cabType);
                System.out.println("Route: " + source + " → " + destination);
                System.out.println("Distance: " + distance + " km");
                System.out.println("Rate: ₹" + rate + " per km");
                System.out.println("Total Fare: ₹" + fare);

                // Confirmation before OTP
                System.out.println("\nConfirm Booking:");
                System.out.println("1. Confirm & Share OTP");
                System.out.println("2. Cancel Ride");
                System.out.print("Enter choice: ");
                int confirmChoice = sc.nextInt();

                if (confirmChoice == 1) {
                    int otp = 1000 + rand.nextInt(9000); // 4-digit OTP
                    System.out.println("Booking Confirmed! Your OTP is: " + otp);
                    System.out.println("Note: Cancellation is not allowed after OTP is shared.");
                } else if (confirmChoice == 2) {
                    System.out.println("Ride cancelled. Returning to main menu.");
                } else {
                    System.out.println("Invalid choice. Returning to main menu.");
                }

            } else if (choice == 2) {
                System.out.println("Thank you for using Kiran Cab Booking Chatbot. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
