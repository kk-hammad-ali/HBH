import org.junit.Test;
import java.util.ArrayList;
import ooseproject_business_logic.Booking_Services;
import ooseproject_model.Booking_Model;

public class BookingTest {
    private final Booking_Services bookingServices = new Booking_Services();
    
    @Test
    public void testBookingDetails() {
        // Test bookingDetails method
        int hosid = 1;
        String hosname = "Khan Hostel";
        String hosemail = "khanhostel@gmail.com";
        int hosfee = 5000;
        int userid = 1;
        String username = "kk_hammad_ali";
        String useremail = "kk@gmail.com";
        String usercnic = "1234567890";
        bookingServices.bookingDetails(hosid, hosname, hosemail, hosfee, userid, username, useremail, usercnic);
    }

    @Test
    public void testGetAllBooked() {
        int userid = 1;
        ArrayList<Booking_Model> bookings = bookingServices.getallbooked(userid);
    }

    @Test
    public void testDeleteBooking() {
        String hostelname = "Khan Hostel";
        bookingServices.deletebooking(hostelname);
    }
}
