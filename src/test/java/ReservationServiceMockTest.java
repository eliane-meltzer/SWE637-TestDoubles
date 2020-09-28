import mockit.Mocked;
import utils.*;
import mockit.Expectations;
import mockit.Mock;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ReservationServiceMockTest {
    Customer JohnSmith = new Customer ("John Smith");

    @Mocked FakeRankingService rankingServiceMock;

    @Test public void testReservationServiceMock () {
        new Expectations() {{
            rankingServiceMock.getRank(JohnSmith,600);
            result = new Rank(1.00166);
        }};
        ReservationServiceMock reservationService = new ReservationServiceMock();

        reservationService.reserve(JohnSmith);
        assertEquals(1, JohnSmith.getBoardingGroup());
        assertEquals(1, JohnSmith.getSeat());
    }
}
