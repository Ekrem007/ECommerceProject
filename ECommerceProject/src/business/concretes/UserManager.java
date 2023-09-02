package business.concretes;

import business.abstracts.UserCheckServices;
import business.abstracts.UserServices;
import core.abstracts.AuthenticationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;


public class UserManager implements UserServices {
    private final AuthenticationService googleService;
    private UserDao userDao;
    private UserCheckServices userCheckServices;



    public UserManager(AuthenticationService googleService, UserDao userDao, UserCheckServices userCheckServices) {
        this.googleService = googleService;
        this.userDao = userDao;
        this.userCheckServices = userCheckServices;
    }

    @Override
    public void login(String mail, String password) {
        User user = userDao.getByMail(mail);
        if (user.getMail().equals(mail) && user.getPassword().equals(password)){
            System.out.println("login succesfull.");
        }else{
            System.out.println("Login failed. Check your name or password. ");
        }

    }


    @Override
    public void register(String name, String surname, String mail, String password) {
        if (userCheckServices.checkName(name) && userCheckServices.checkSurName(surname) &&
            userCheckServices.isUniqueMail(mail) && userCheckServices.isValidMail(mail) &&
            userCheckServices.isValidPassword(password)){

            System.out.println("you have registered with the username: "+ name + " " + surname +" registered w");


        }else {
            System.out.println("Register failed. Check your mail or password.");
        }

    }

    @Override
    public boolean loginWithGoogleServices(User user) {
        return googleService.authenticate(user);
    }
}
