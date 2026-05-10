public class UserAuthentication {
    public boolean authenticate(String username, String password) {
        if (username != null && username.equals("admin") && 
            password != null && password.equals("password123")) {
            return true;
        } else {
            return false;
        }
    }
}