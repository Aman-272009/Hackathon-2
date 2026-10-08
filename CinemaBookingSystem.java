import java.util.Scanner;

class MovieTicket {
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;

    // Parameterized Constructor
    public MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Calculates the total ticket amount
    public double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    // Provides a 10% discount if the number of tickets is 5 or more
    public double calculateDiscount() {
        double total = calculateTotal();
        if (numberOfTickets >= 5) {
            return total * 0.10;
        } else {
            return 0.0;
        }
    }

    // Calculates the final amount after deducting the discount
    public double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    // Displays the complete bill with monetary values formatted to two decimal places
    public void displayBill() {
        double total = calculateTotal();
        double discount = calculateDiscount();
        double finalAmount = calculateFinalAmount();

        System.out.println("\n--- Cinema Ticket Booking Bill ---");
        System.out.println("Movie Name       : " + movieName);
        System.out.println("Ticket Price     : $" + String.format("%.2f", ticketPrice));
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Total Amount     : $" + String.format("%.2f", total));
        System.out.println("Discount         : $" + String.format("%.2f", discount));
        System.out.println("Final Amount     : $" + String.format("%.2f", finalAmount));
        System.out.println("----------------------------------");
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input values
        System.out.print("Enter Movie Name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter Ticket Price: ");
        double ticketPrice = scanner.nextDouble();

        System.out.print("Enter Number of Tickets: ");
        int numberOfTickets = scanner.nextInt();

        // Creating MovieTicket object using the parameterized constructor
        MovieTicket ticket = new MovieTicket(movieName, ticketPrice, numberOfTickets);

        // Invoking displayBill method which internally calls calculation methods
        ticket.displayBill();

        scanner.close();
    }
}


