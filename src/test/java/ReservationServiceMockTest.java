import mockit.Mocked;
import utils.*;
import mockit.Expectations;
import mockit.Mock;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ReservationServiceMockTest {

    @Mocked RankingService rankingServiceMock;

    @Test public void testReservationServiceMock () {
        new Expectations() {{
            rankingServiceMock.getRank(new Customer("John Smith"),600);
            result = new Rank(100);

            rankingServiceMock.getRank(new Customer("Jane Doe"),600);
            result = new Rank(400);

        }};
        ReservationServiceMock reservationService = new ReservationServiceMock();

        Customer JohnSmith = new Customer("John Smith");
        reservationService.reserve(JohnSmith);
        assertEquals(1, JohnSmith.getBoardingGroup());

        Customer JaneDoe = new Customer("Jane Doe");
        reservationService.reserve(JaneDoe);
        assertEquals(1, JaneDoe.getBoardingGroup());
    }
}
