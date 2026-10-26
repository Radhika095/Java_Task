import java.util.*;

// Abstract Passenger class (Abstraction)
abstract class Passenger {
    protected String name;
    protected int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract double getDiscount(); // Polymorphism
    public String getName() { return name; }
    public int getAge() { return age; }
}

// Regular Passenger (Inheritance)
class RegularPassenger extends Passenger {
    public RegularPassenger(String name, int age) {
        super(name, age);
    }
    @Override
    public double getDiscount() {
        return 0.0; // No discount
    }
}

// Student Passenger (Inheritance)
class StudentPassenger extends Passenger {
    public StudentPassenger(String name, int age) {
        super(name, age);
    }
    @Override
    public double getDiscount() {
        return 0.10; // 10% discount
    }
}

// Flight class (Encapsulation)
class Flight {
    private String code;
    private String airline;
    private String source;
    private String destination;
    private int availableSeats;
    private double baseFare;

    public Flight(String code, String airline, String source, String destination, int availableSeats, double baseFare) {
        this.code = code;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.baseFare = baseFare;
    }

    public String getCode() { return code; }
    public String getAirline() { return airline; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }
    public double getBaseFare() { return baseFare; }

    public void reduceSeats(int count) {
        availableSeats -= count;
    }

    public void displayFlight() {
        System.out.println(code + " | " + airline + " | " + source + " -> " + destination +
                " | Seats: " + availableSeats + " | Fare: " + baseFare);
    }
}

// Booking class
class Booking {
    private static int bookingCounter = 1000;
    private String bookingId;
    private Passenger passenger;
    private Flight flight;
    private int ticketCount;
    private double finalAmount;

    public Booking(Passenger passenger, Flight flight, int ticketCount) {
        this.bookingId = "BK" + (++bookingCounter);
        this.passenger = passenger;
        this.flight = flight;
        this.ticketCount = ticketCount;
        this.finalAmount = calculateFare();
    }

    private double calculateFare() {
        double subtotal = flight.getBaseFare() * ticketCount;
        double discount = subtotal * passenger.getDiscount();
        return subtotal - discount;
    }

    public void displaySummary() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Flight: " + flight.getCode() + " | " + flight.getSource() + " to " + flight.getDestination());
        System.out.println("Passenger: " + passenger.getName() + " | Age: " + passenger.getAge());
        System.out.println("Tickets: " + ticketCount);
        System.out.println("Base fare per ticket: " + flight.getBaseFare());
        double subtotal = flight.getBaseFare() * ticketCount;
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + (subtotal * passenger.getDiscount()));
        System.out.println("Final amount: " + finalAmount);
    }
}

// FlightBookingSystem class
public class FlightBookingSystem {
    private List<Flight> flights = new ArrayList<>();
    private Booking lastBooking = null;
    private Scanner sc = new Scanner(System.in);

    public FlightBookingSystem() {
        flights.add(new Flight("PN101", "Kiran Air", "Pune", "Delhi", 20, 4000));
        flights.add(new Flight("MB202", "Kiran Air", "Mumbai", "Bengaluru", 15, 3500));
        flights.add(new Flight("PH303", "Kiran Air", "Pune", "Hyderabad", 25, 3000));
    }

    public void start() {
        System.out.println("Welcome to Kiran Air Booking");
        while (true) {
            System.out.println("\n1. View Flights\n2. Book Flight\n3. View Booking\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: viewFlights(); break;
                case 2: bookFlight(); break;
                case 3: viewBooking(); break;
                case 4: System.out.println("Thank you for using Kiran Air Booking!"); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewFlights() {
        for (Flight f : flights) f.displayFlight();
    }

    private void bookFlight() {
        System.out.print("Enter flight code: ");
        String code = sc.nextLine();
        Flight selected = findFlight(code);
        if (selected == null) {
            System.out.println("Invalid flight code.");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();
        if (name.isBlank()) {
            System.out.println("Name cannot be blank.");
            return;
        }

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        if (age <= 0) {
            System.out.println("Invalid age.");
            return;
        }

        System.out.print("Passenger type (Regular/Student): ");
        String type = sc.nextLine();
        Passenger passenger;
        if (type.equalsIgnoreCase("Student")) {
            passenger = new StudentPassenger(name, age);
        } else {
            passenger = new RegularPassenger(name, age);
        }

        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();
        sc.nextLine();
        if (tickets <= 0) {
            System.out.println("Invalid ticket count.");
            return;
        }

        if (tickets > selected.getAvailableSeats()) {
            System.out.println("Booking failed: Not enough seats available.");
            return;
        }

        selected.reduceSeats(tickets);
        lastBooking = new Booking(passenger, selected, tickets);
        System.out.println("Booking confirmed!");
        lastBooking.displaySummary();
    }

    private Flight findFlight(String code) {
        for (Flight f : flights) {
            if (f.getCode().equalsIgnoreCase(code)) return f;
        }
        return null;
    }

    private void viewBooking() {
        if (lastBooking == null) {
            System.out.println("No booking exists.");
        } else {
            lastBooking.displaySummary();
        }
    }

    public static void main(String[] args) {
        new FlightBookingSystem().start();
    }
}
