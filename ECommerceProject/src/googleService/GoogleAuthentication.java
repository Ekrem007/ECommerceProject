package googleService;
import entities.concretes.User;

public class GoogleAuthentication {
    public  boolean authenticateWithGoogle(User user){
        System.out.println(user.getName() + ": user joined with google service.");
        return true;

    }
}
