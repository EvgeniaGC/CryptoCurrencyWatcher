package com.example.CryptoCurrencyWatcher.repository;

import com.example.CryptoCurrencyWatcher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);
}
