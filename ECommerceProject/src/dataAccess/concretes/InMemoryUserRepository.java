package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserDao {

    List<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
        users.add(new User(1, "Ekrem", "Uğur", "ekremugur_07@hotmail.com", "123456"));
        users.add(new User(2, "Berkan", "Taş", "berkan@hotmail.com", "123456"));
    }

    @Override
    public void add(User user) {
        users.add(user);

    }

    @Override
    public User getById(int id) {
        for(User user: users){
            if (user.getId()== id);
            return user;
        }
        return null;
    }


    @Override
    public List<User> getAll () {
        return users;
    }

    @Override
    public User getByMail (String mail){
        for (User user : users) {
            if (user.getMail() == mail) {
                return user;
            }
        }


        return null;
    }
}





