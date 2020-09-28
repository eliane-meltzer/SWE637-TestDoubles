package utils;

import java.util.ArrayList;
import java.util.Random;

/*  This is the test double class */
public class FakeRankingService extends RankingService {

    public FakeRankingService() {
        super();
     }


    // rank range is between 1 and 0 and it is computed based on the customer
    //  membership level and seats availability
    @Override
    public Rank getRank(Customer customer, int availability) {

        String level = customer.getMembership();
        if ("Platinum".equals(level)) {
            System.out.println("rank given: "+ (4+availability)/600.0);
            customer.setRank((4+availability)/600.0);
            return new Rank((4+availability)/600.0);
        } else if ("Gold".equals(level)) {
            customer.setRank((3+availability)/600.0);
            return new Rank((3+availability)/600.0);
        } else if ("Silver".equals(level)) {
            customer.setRank((2+availability)/600.0);
            return new Rank((2+availability)/600.0);
        } else {
            customer.setRank((1+availability)/600.0);
            return new Rank((1+availability)/600.0);
        }

    }


}
