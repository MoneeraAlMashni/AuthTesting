import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserAuthenticationTest {

    UserAuthentication authSystem = new UserAuthentication();

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            { "admin", "password123", true },    
            { "admin", "wrongPass", false },     
            { "wrongUser", "password123", false },
            { "", "", false },                   
            { null, null, false },               
            { "admin", "", false },              
            { "ADMIN", "password123", false }   
        };
    }

    @Test(dataProvider = "loginData")
    public void testAuthenticate(String user, String pass, boolean expected) {
        boolean actual = authSystem.authenticate(user, pass);
        
        Assert.assertEquals(actual, expected, 
            "Failed for credentials: " + user + " / " + pass);
    }
}