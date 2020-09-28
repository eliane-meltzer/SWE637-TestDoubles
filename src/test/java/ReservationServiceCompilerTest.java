import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;
import utils.*;
import mockit.Mocked;
import utils.*;
import mockit.Expectations;
import mockit.Mock;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ReservationServiceCompilerTest {

    @Test public void testReservationServiceCompiler () {

        boolean TEST_MODE = true;
        ReservationServiceCompiler reservationService = new ReservationServiceCompiler(TEST_MODE);

        Customer JohnSmith = new Customer("John Smith");
        reservationService.reserve(JohnSmith);
        assertEquals(1, JohnSmith.getBoardingGroup());
        assertEquals(1, JohnSmith.getSeat());

        Customer JaneDoe = new Customer("Jane Doe");
        reservationService.reserve(JaneDoe);
        assertEquals(1, JaneDoe.getBoardingGroup());
        assertEquals(2, JaneDoe.getSeat());

    }
}
