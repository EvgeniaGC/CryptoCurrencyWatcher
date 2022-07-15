package com.example.CryptoCurrencyWatcher.service;

import com.example.CryptoCurrencyWatcher.model.Currency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {

    Currency getCurrencyBySymbol(String symbol);

    Currency saveCurrency(Integer idCur);

    public Currency getCurById(Integer id);

    List<Currency> getAllFirst10Currency ();

}
