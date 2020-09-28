import utils.*;

/*
    SWE637- HW3 Test doubles using an inheritance seamwith dependency injection

 */
public class ReservationServiceWithDependencyInjection {
    // instance variables, constructors, other methods omitted for now

    // create a seam outside reserve
    private RankingService rankingService;
    private int Max_availability;
    private int current_seat;

    public ReservationServiceWithDependencyInjection() {
        this.rankingService = new RankingService();
        Max_availability = 600; // average number of seats in planes
        current_seat =0;
    }

    // create an enabling point for Dependency with Injection - package protected access
    void setRankingService(RankingService rankingService){
        this.rankingService = rankingService;
    }

    /*
     *  We are assuming 5 zones so based on the rank given with respect to the size of plane
     * */
    public void reserve (Customer customer) {
        // get the rank of the current user
        Rank rank = rankingService.getRank(customer, Max_availability-current_seat);

        //make the reservation based on the rank, what seat they get, and what class they board in maybe based on zones?
        customer.setSeat(current_seat+1);
        current_seat ++;
        Max_availability--;

        double x = rank.getRank();
        System.out.println("rank "+x);
        //zone 1
        if (x >=0.8){
            customer.setBoardingGroup(1);
        }
        //zone 2
        else if (x >= 0.6 && x <0.8){
            customer.setBoardingGroup(2);
        }
        //zone 3
        else if (x>= 0.4 && x <0.6){
            customer.setBoardingGroup(3);
        }
        //zone 4
        else if(x>= 0.2 && x <0.4){
            customer.setBoardingGroup(4);
        }
        //zone 5
        else{
            customer.setBoardingGroup(5);
        }

        String output = String.format("%s,\n Your reservation has been made successfully. Your boarding group is: %d\n Your seat number is: %d", customer.getName(), customer.getBoardingGroup(),customer.getSeat());
        System.out.println(output);

    }

    // used to set the preconditions before tests
    public void setMax_availability(int max_availability) {
        Max_availability = max_availability;
    }

    public void setCurrent_seat(int current_seat) {
        this.current_seat = current_seat;
    }
}
