package core.concretes;
import core.abstracts.AuthenticationService;
import entities.concretes.User;
import googleService.GoogleAuthentication;

public class GoogleAuthenticationServiceAdapter implements AuthenticationService {
    @Override
    public boolean authenticate(User user) {
        GoogleAuthentication googleAuthentication = new GoogleAuthentication();
        return googleAuthentication.authenticateWithGoogle(user);


    }
}
