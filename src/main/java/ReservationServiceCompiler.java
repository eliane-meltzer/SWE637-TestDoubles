import utils.*;

/*
    SWE637- HW3 Test doubles using an inheritance seamwith dependency injection

 */
public class ReservationServiceCompiler {
    // instance variables, constructors, other methods omitted for now

    // create a seam outside reserve
    private RankingService rankingService;
    private int Max_availability;
    private int current_seat;

    private boolean TEST_MODE;


    public ReservationServiceCompiler() {
        Max_availability = 600; // average number of seats in planes
        current_seat =0;
        TEST_MODE = false;
    }

    public ReservationServiceCompiler(boolean mode) {
        Max_availability = 600; // average number of seats in planes
        current_seat =0;
        TEST_MODE = mode;

        if(TEST_MODE)
            this.rankingService =  new FakeRankingService();
        else
            this.rankingService = new RankingService();
    }

    /*
     *  We are assuming 5 zones so based on the rank given with respect to the size of the plane
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
