package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.repositories.UserRepository;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> index() {
        return userRepository.findAll();

    }

    public User show(Long id) {
        return  userRepository.getOne(id);
    }

    public User create(User user) {
       return  userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id,User newUser) throws Exception {
        User user = userRepository.getOne(id);
        if (user == null) {
            throw new Exception();
        }
        if (user.getId() != id) {
            throw new IllegalArgumentException();
        }

            newUser.setId(id);
            User userDB = userRepository.save(newUser);
            return userDB;
    }



}
