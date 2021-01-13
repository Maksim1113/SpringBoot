package ru.khaustov.springcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.khaustov.springcrud.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByName(username);

    }
}
