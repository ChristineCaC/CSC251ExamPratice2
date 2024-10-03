public class MuseumMembership {

    // Fields
    private String customerName;
    private String membershipType;
    private int numberOfVisits;

    // Constants for membership costs
    private static final double GENERAL_COST_PER_VISIT = 3.99;
    private static final double PREMIUM_COST_PER_VISIT = 7.99;
    private static final double ALL_ACCESS_COST_PER_VISIT = 12.99;

    // Constructors

    // No-arg constructor
    public MuseumMembership() {
        customerName = "";
        membershipType = "";
        numberOfVisits = 0;
    }

    // Constructor that accepts arguments for each field
    public MuseumMembership(String n, String t, int v) {
        customerName = n;
        membershipType = t;
        numberOfVisits = v;
    }

    // Setters
    public void setCustomerName(String n) {
        customerName = n;
    }

    public void setMembershipType(String t) {
        membershipType = t;
    }

    public void setNumberOfVisits(int v) {
        numberOfVisits = v;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    // Method to calculate the cost per museum visit based on membership type
    public double calculateMuseumVisitCost() {
         switch (membershipType) {
             case "A":
                 return GENERAL_COST_PER_VISIT; // Standard
             case "B":
                 return PREMIUM_COST_PER_VISIT; // Premium
             case "C":
                 return ALL_ACCESS_COST_PER_VISIT; // All-Access
             default:
                 return 0.0; // If no valid membership type is provided
        }
    }
    // Method to calculate the reservation fee based on the number of visits
    public double calculateMembershipReservationFee() {
        if (numberOfVisits >= 1 && numberOfVisits <= 8) {
            return 14.00;
        } else if (numberOfVisits >= 9 && numberOfVisits <= 15) {
            return 23.59;
        } else if (numberOfVisits >= 16 && numberOfVisits <= 20) {
            return 18.50;
        } else {
            return 0.0;
        }
    }

    // Method to calculate the total membership price
    public double calculateMembershipPrice() {
        double visitCost = calculateMuseumVisitCost();
        double reservationFee = calculateMembershipReservationFee();
        return (visitCost * numberOfVisits) + reservationFee;
    }
}
