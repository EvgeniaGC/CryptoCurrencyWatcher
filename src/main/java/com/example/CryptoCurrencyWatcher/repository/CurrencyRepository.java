package com.example.CryptoCurrencyWatcher.repository;

import com.example.CryptoCurrencyWatcher.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    Currency findCurrencyById (Integer id);

}
