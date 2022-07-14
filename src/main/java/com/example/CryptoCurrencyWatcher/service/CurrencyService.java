package com.example.CryptoCurrencyWatcher.service;

import com.example.CryptoCurrencyWatcher.model.Currency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {

    Currency getCurrencyBySymbol(String symbol);

    void saveCurrency(String symbolId);

    List<Currency> getAllCurrencyList();

}
