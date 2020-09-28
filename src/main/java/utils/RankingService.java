package utils;

import java.util.Random;

/*

******This is the class we are building a test double for *******

It is useed to aid airlines reservations. the higher ranking customers
get better arrangements (better seats, early boarding, etc.). We are not
 testing the ranking service, and we should assume it’s stochastic
 (possibly different answers every time).

 This is the parent class
 */
public class RankingService {

    // each RankingService has its own implementation
    public Rank getRank(Customer customer, int availability){
        return new Rank(-1);
    }


}