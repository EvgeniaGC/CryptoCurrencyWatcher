package com.example.CryptoCurrencyWatcher.service;

import com.example.CryptoCurrencyWatcher.model.User;
import com.example.CryptoCurrencyWatcher.model.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserResponse regUser(User userToCreate);

    User getUserByEmail (String email);

    public UserResponse logIn(User userToLogIn);

}
