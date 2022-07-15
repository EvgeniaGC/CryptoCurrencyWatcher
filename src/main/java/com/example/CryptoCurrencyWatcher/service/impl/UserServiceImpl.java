package com.example.CryptoCurrencyWatcher.service.impl;

import com.example.CryptoCurrencyWatcher.model.User;
import com.example.CryptoCurrencyWatcher.model.UserResponse;
import com.example.CryptoCurrencyWatcher.repository.UserRepository;
import com.example.CryptoCurrencyWatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserResponse regUser(User userToCreate) {
        UserResponse response = new UserResponse();
        User userFromDB = repository.findUserByEmail(userToCreate.getEmail());

        User savedUser = null;
        if (userFromDB == null) {
            if (userToCreate.getPass().equals(userToCreate.getRepeatedPass())) {
                User userToSave = new User();
                userToSave.setEmail(userToCreate.getEmail());
                userToSave.setPass(userToCreate.getPass());
                userToSave.setName(userToCreate.getName());
                userToSave.setRepeatedPass(userToCreate.getRepeatedPass());

                savedUser = repository.save(userToSave);
                response.setUserToCreate(savedUser);
                response.setMessage("You have successfully registered");
            } else {
                response = new UserResponse(null, "Check your password. 'Password' and 'repeated password' don't match.");
            }
        } else {
            response = new UserResponse(null, "User with such email has already existed.");
        }
        return response;
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    @Override
    public UserResponse logIn(User userToLogIn) {
        UserResponse response = new UserResponse();
        User userFromDB = repository.findUserByEmail(userToLogIn.getEmail());
        if (userFromDB != null) {
            if (userFromDB.getPass().equals(userToLogIn.getPass())) {
                response.setUserToCreate(userFromDB);
            } else {
                response.setMessage("Wrong password.");
            }
        } else {
            response.setMessage("User with such email doesn't exist.");
        }
        return response;
    }




}
