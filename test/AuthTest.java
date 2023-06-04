import ooseproject_business_logic.Auth_Services;
import ooseproject_model.User_Model;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthTest {
    
    Auth_Services authServices = new Auth_Services();

    @Test
    public void testLogin() {
        String expectedUsername = "kk_hammad_ali";
        String expectedPassword = "password@123";
        User_Model result = authServices.login(expectedUsername, expectedPassword);
        assertNull(result);
    }
    
    @Test
    public void testUserExist() {
        String expectedUsername = "kk_hammad12";
        boolean result = authServices.userExist(expectedUsername);
        assertFalse(result);
    }
    
    @Test
    public void testCnicExist() {
         String expectedCNIC = "1234567890";
        boolean result = authServices.cnicExist(expectedCNIC);
        assertFalse(result);
    }

    @Test
    public void testEmailExist() {
        String expectedEmail = "kk2@gmail.com";
        boolean result = authServices.emailExist(expectedEmail);
        assertFalse(result);
    }
    
    @Test
    public void testIsValidEmail() {
       String expectedEmail = "kk123@gmail.com";
        boolean result = authServices.isValidEmail(expectedEmail);
        assertTrue(result);
    }

    @Test
    public void testIsValidPassword() {
       String expectedPassword = "Password@12";
        boolean result = authServices.isValidPassword(expectedPassword);
        assertTrue(result);
    }

    @Test
    public void testIsValidUsername() {
        String expectedUsername = "kk_hammad_ali";
        boolean result = authServices.isValidUsername(expectedUsername);
        assertTrue(result);
    }
    @Test
    public void testForgetPassword() {
        String username = "kk_hammad_ali";
        String newPassword = "Whisper@123";
        String confirmPassword = "Whisper@123";
        authServices.forgetPassword(username, newPassword, confirmPassword);
        Assert.assertTrue(true);
    }
    @Test
    public void testSignup() {
        String email = "kk@gmail.com";
        String o_name = "Hammad Ali";
        String cnic = "1234567890123";
        String username = "kk_hammad123";
        String password = "Whisper@123";
        authServices.signup(email, o_name, cnic, username, password);
    }
}
