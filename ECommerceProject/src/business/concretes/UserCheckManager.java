package business.concretes;

import business.abstracts.UserCheckServices;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;
import java.util.regex.Pattern;

public class UserCheckManager implements UserCheckServices {

    List<User> users;
    public UserCheckManager(UserDao userDao){
        this.users= userDao.getAll();
    }
    @Override
    public boolean checkName(String name) {
        if (name.isEmpty()) {
            System.out.println("name is cant be empty");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkSurName(String surname) {
        if (surname.isEmpty()) {
            System.out.println("surname cant be empty.");
            return false;
        }

        return true;
    }

    @Override
    public boolean isValidPassword(String password) {
        if(password.isEmpty()){
            System.out.println("password cant be empty");
            return false;
        }
        if (password.length()<6){
            System.out.println("passwords character must be bigger than 6 characters");
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidMail(String mail) {
        String regex = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        if (mail.isEmpty()) {
            System.out.println("Here is cant be empty");
            return false;

        } else {
            if (!pattern.matcher(mail).find()) {
                System.out.println("invalid!");
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean isUniqueMail(String mail) {
        for (User user : users) {
            if (user.getMail().equals(mail)) {
                System.out.println("You can't use this mail. This mail is already taken.");
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean isValid(User user) {
        return checkName(user.getName()) && checkSurName(user.getSurname()) && isValidMail(user.getMail()) &&
                isUniqueMail(user.getMail()) && isValidPassword(user.getPassword());
    }
}
