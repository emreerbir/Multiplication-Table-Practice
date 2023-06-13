import java.awt.Window;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import nypproje.LoginPanel;
import nypproje.MainAdminPanel;

import static org.junit.Assert.*;

public class LoginTest {

    private LoginPanel loginPanel;

    @Before
    public void setUp() {
        loginPanel = new LoginPanel();
    }

    @Test
    public void testLoginButtonActionPerformed() {
        // Set up test data
        loginPanel.kullaniciAdi.setText("admin");
        loginPanel.sifre.setText("admin123");

        // Simulate a button click event
        ActionEvent event = new ActionEvent(loginPanel.loginButton, ActionEvent.ACTION_PERFORMED, "Login");
        loginPanel.loginButton.getActionListeners()[0].actionPerformed(event);

        // Check if the login was successful
        Window[] windows = Window.getWindows();
        boolean adminPanelOpened = false;
        for (Window window : windows) {
            if (window instanceof MainAdminPanel) {
                adminPanelOpened = true;
                break;
            }
        }
        assertTrue(adminPanelOpened);
    }
}
