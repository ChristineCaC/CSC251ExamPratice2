import java.util.ArrayList;
import java.util.Scanner;

public class ExamPratice2_Christine_Chapman {
    public static void main(String[] args) {
        ArrayList<MuseumMembership> memberships = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String repeat;
        int totalVisits = 0;
        double totalRevenue = 0;

        do {
            // Getting user input
            System.out.print("\nEnter the customer's name: ");
            String name = sc.nextLine();

            String type;
            do {
                System.out.println("\nChoose from one of the following Museum Memberships:");
                System.out.println("      A. Standard - $3.99 / per visit");
                System.out.println("      B. Premium - $7.99 / per visit");
                System.out.println("      C. All-Access - $12.99 / per visit");
                System.out.print("Enter your choice (A, B, or C): ");
                type = sc.nextLine();

                // Check for valid input and handle invalid choice
                if (type == null || (!type.equalsIgnoreCase("A") && !type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("C"))) {
                    System.out.println("\nERROR: INVALID CHOICE, please try again.");
                }
            } while (!type.equalsIgnoreCase("A") && !type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("C"));

            // Asking for the number of visits
            int visits;
            do {
                System.out.print("\nHow many museum visits are being purchased? (Min: 1, Max: 20 museum visits) ");
                visits = sc.nextInt();

                if (visits < 1 || visits > 20) {
                    System.out.println("\nERROR: INVALID NUMBER OF MUSEUM VISITS ENTERED, please try again.");
                }
            } while (visits < 1 || visits > 20);

            // Create and store MuseumMembership object
            memberships.add(new MuseumMembership(name, type, visits));

            // Scanner reset
            sc.nextLine(); // Clears the buffer after nextInt()

            // Ask if they want to enter more data
            System.out.print("\nDo you wish to enter information for another museum membership (Y/N)? ");
            repeat = sc.nextLine();

        } while (repeat.equalsIgnoreCase("Y"));

        // Output all memberships
        System.out.println("\nMuseum Membership List");
        System.out.println("---------------------------");

        for (MuseumMembership m : memberships) {
            System.out.printf("Customer Name: %s\n", m.getCustomerName());
            System.out.printf("Museum Membership: %s\n", m.getMembershipType().equalsIgnoreCase("A") ? "Standard" :
                                                        m.getMembershipType().equalsIgnoreCase("B") ? "Premium" : "All-Access");
            System.out.printf("Number of Visits: %d\n", m.getNumberOfVisits());
            System.out.printf("Cost Per Museum Visit: $%.2f\n", m.calculateMuseumVisitCost());
            System.out.printf("Membership Subtotal: $%.2f\n", m.calculateMuseumVisitCost() * m.getNumberOfVisits());
            System.out.printf("Membership Reservation Fee: $%.2f\n", m.calculateMembershipReservationFee());
            System.out.printf("Membership Price: $%.2f\n\n", m.calculateMembershipPrice());

            // Track total visits and revenue
            totalVisits += m.getNumberOfVisits();
            totalRevenue += m.calculateMembershipPrice();
        }

        // Summary of totals
        System.out.println("\nTotals:");
        System.out.println("---------------------------");
        System.out.printf("Total Museum Memberships: %d\n", memberships.size());
        System.out.printf("Total Visits Purchased: %d\n", totalVisits);
        System.out.printf("Total Ticket Revenue: $%.2f\n", totalRevenue);

        sc.close();
    }
}