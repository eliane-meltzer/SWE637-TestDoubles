import org.junit.Test;
import utils.*;

import static org.junit.Assert.assertEquals;

public class ReservationServiceWithDependencyInjectionTest {

    @Test
    public void testReservationServiceWithoutDependencyInjection () {
        ReservationServiceWithDependencyInjection reservationService = new ReservationServiceWithDependencyInjection();

        // change the Rankingservice to the inherited test-double
        reservationService.setRankingService(new FakeRankingService());  // FakeRankingService

        // test using the test double
        Customer JohnSmith = new Customer("John Smith","Platinum");
        reservationService.reserve(JohnSmith);
        assertEquals(1, JohnSmith.getBoardingGroup());

        Customer JaneDoe = new Customer("Jane Doe");
        reservationService.reserve(JaneDoe);
        assertEquals(1, JaneDoe.getBoardingGroup());
    }

}

