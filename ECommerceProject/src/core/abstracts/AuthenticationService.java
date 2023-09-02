package core.abstracts;

import entities.concretes.User;

public interface AuthenticationService {
        boolean authenticate(User user);
}
