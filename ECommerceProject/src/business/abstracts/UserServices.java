package business.abstracts;

import entities.concretes.User;

public interface UserServices {
    void login(String mail, String password);
    void register(String name, String surname, String mail, String password);
    boolean loginWithGoogleServices(User user);
}
