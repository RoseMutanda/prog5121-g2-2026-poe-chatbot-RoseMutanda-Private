

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("kyle!!!!!!!", "Password1!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login("kyl_1", "Password1!", "0838968976", "Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber());
    }
}