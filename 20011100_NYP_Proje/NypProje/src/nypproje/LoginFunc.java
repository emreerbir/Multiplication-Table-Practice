/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nypproje;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

/**
 *
 * @author emre
 */
public class LoginFunc {

    public LoginFunc() {
    }
    
    public static HashMap<String, String> initializeCredentialsMap(String yol) {
        //HashMap<String, String> credentialsMap = new HashMap<>();
        try {
            HashMap<String, String> credentialsMap;
            FileInputStream fileIn = new FileInputStream(yol);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            credentialsMap = (HashMap<String, String>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            return credentialsMap;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public static boolean validateCredentials(String username, String password, HashMap<String, String> credentialsMap) {
        String storedPassword = credentialsMap.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
    
}
