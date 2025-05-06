package ma.projet.service;

import ma.projet.dao.UserDao;
import ma.projet.dao.impl.UserDaoImpl;
import ma.projet.model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean authenticate(String username, String password) {
        User user = userDao.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public void register(User user) {
        userDao.save(user);
    }
}
