import org.junit.Test;
import java.util.ArrayList;
import ooseproject_business_logic.Hostel_Services;
import ooseproject_model.Hostel_Model;

public class HostelTest {
    
    private final Hostel_Services hostelServices = new Hostel_Services();
    @Test
    public void testGetHostel() {
        String type = "Boys";
        ArrayList<Hostel_Model> hostels = hostelServices.getHostel(type);    
    }

    @Test
    public void testGetHostelCity() {
        String city = "Wah";
        ArrayList<Hostel_Model> hostels = hostelServices.getHostelCity(city);
    }

    @Test
    public void testGetOneHostel() {
        String name = "Khan Hostel";
        Hostel_Model hostel = hostelServices.getOneHostel(name);
    }
}
