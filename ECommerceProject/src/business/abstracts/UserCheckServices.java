package business.abstracts;

import entities.concretes.User;

public interface UserCheckServices {
    boolean checkName(String name);
    boolean checkSurName(String surname);
    boolean isValidPassword(String password);
    boolean isValidMail(String mail);
    boolean isUniqueMail(String Mail);
    boolean isValid(User user);
}
