package com.example.CryptoCurrencyWatcher.service.impl;

import com.example.CryptoCurrencyWatcher.model.Currency;
import com.example.CryptoCurrencyWatcher.model.User;
import com.example.CryptoCurrencyWatcher.model.UserResponse;
import com.example.CryptoCurrencyWatcher.repository.CurrencyRepository;
import com.example.CryptoCurrencyWatcher.repository.UserRepository;
import com.example.CryptoCurrencyWatcher.service.CurrencyService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    @Override
    public Currency getCurrencyBySymbol(String symbol) {
        return null;
    }

    @Override
    public Currency saveCurrency(Integer idCur) {
        String url = "https://api.coinlore.net/api/ticker/?id=" + idCur;
        String json = "";
        try (java.io.InputStream is = new java.net.URL(url).openStream()) {
            json = new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        json = json.substring(1, json.length() - 1);
        JSONObject jsonOb = new JSONObject(json);

        Currency currencyToSave = new Currency();
        currencyToSave.setId(jsonOb.getInt("id"));
        currencyToSave.setSymbol(jsonOb.getString("symbol"));
        currencyToSave.setName(jsonOb.getString("name"));
        currencyToSave.setNameId(jsonOb.getString("nameid"));
        currencyToSave.setRank(jsonOb.getInt("rank"));
        currencyToSave.setPriceUsd(jsonOb.getDouble("price_usd"));
//        currencyToSave.setPercentChange24h(jsonOb.getDouble("percent_change_24h"));
//        currencyToSave.setPercentChange1h(jsonOb.getDouble("percent_change_1h"));
//        currencyToSave.setPercentChange7d(jsonOb.getDouble("percent_change_7d"));
//        currencyToSave.setMarketCapUsd(jsonOb.getBigDecimal("market_cap_usd"));
//        currencyToSave.setVolume24(jsonOb.getBigDecimal("volume24"));
//        currencyToSave.setVolume24Native(jsonOb.getBigDecimal("volume24_native"));
//        currencyToSave.setCsupply(jsonOb.getBigDecimal("csupply"));
//        currencyToSave.setPriceBtc(jsonOb.getDouble("price_btc"));
//        currencyToSave.setTsupply(jsonOb.getBigInteger("tsupply"));
//        currencyToSave.setMsupply(jsonOb.getBigInteger("msupply"));

        Currency savedCurrency = repository.save(currencyToSave);
        return savedCurrency;
    }

    @Override
    public Currency getCurById(Integer id) {
        if (id >= 1 && id <= 100) {
            return repository.findCurrencyById(id);
        } else {
            // todo: error
            return null;
        }
    }

    @Override
    public List<Currency> getAllFirst10Currency() {
        List<Currency> allCur = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            allCur.add(saveCurrency(i));
        }
        return allCur;
    }


}
