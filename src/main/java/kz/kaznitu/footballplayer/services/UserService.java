package kz.kaznitu.footballplayer.services;

import kz.kaznitu.footballplayer.models.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
