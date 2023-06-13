

import java.util.HashMap;
import nypproje.LoginFunc;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginFuncTest {

    public LoginFuncTest() {
    }

    @Test
    public void testValidateCredentials_ValidCredentials_ReturnsTrue() {
        // Arrange
        String username = "admin";
        String password = "admin123";
        HashMap<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("admin", "admin123");

        // Act
        boolean result = LoginFunc.validateCredentials(username, password, credentialsMap);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testValidateCredentials_InvalidCredentials_ReturnsFalse() {
        // Arrange
        String username = "admin";
        String password = "wrongpassword";
        HashMap<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("admin", "admin123");

        // Act
        boolean result = LoginFunc.validateCredentials(username, password, credentialsMap);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInitializeCredentialsMap_ValidFile_ReturnsCredentialsMap() {
        // Arrange

        // Act
        HashMap<String, String> result = LoginFunc.initializeCredentialsMap("child.ser");

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testInitializeCredentialsMap_InvalidFile_ReturnsNull() {
        // Arrange

        // Act
        HashMap<String, String> result = LoginFunc.initializeCredentialsMap("yanlis.ser");

        // Assert
        assertNull(result);
    }
}
