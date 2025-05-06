package ma.projet.service;

import ma.projet.model.User;

public interface UserService {
    boolean authenticate(String username, String password);
    void register(User user);
}
