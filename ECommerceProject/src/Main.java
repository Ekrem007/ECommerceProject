import business.abstracts.UserServices;
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import core.concretes.GoogleAuthenticationServiceAdapter;
import dataAccess.concretes.InMemoryUserRepository;
import entities.concretes.User;

public class Main {
    public static void main(String[] args) {
        UserServices userManager = new UserManager(
                new GoogleAuthenticationServiceAdapter(),
                new InMemoryUserRepository(),
                new UserCheckManager(new InMemoryUserRepository()));

        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        User user1 = inMemoryUserRepository.getByMail("ekremugur_07@hotmail.com");

        userManager.login("ekremugur_07@hotmail.com", "123456");
        userManager.register( "Berkan", "taş", "berkan@hotmail.com", "1234567");
        userManager.loginWithGoogleServices(user1);


    }
}

