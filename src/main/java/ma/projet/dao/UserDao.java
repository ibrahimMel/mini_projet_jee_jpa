package ma.projet.dao;

import ma.projet.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);
    User findByUsername(String username);
    List<User> findAll();
}
