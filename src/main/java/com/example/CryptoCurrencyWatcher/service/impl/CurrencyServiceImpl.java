package com.example.CryptoCurrencyWatcher.service.impl;

import com.example.CryptoCurrencyWatcher.model.Currency;
import com.example.CryptoCurrencyWatcher.repository.CurrencyRepository;
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
import java.util.logging.Logger;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    private List<Currency> currencyList = Arrays.asList();

    @Override
    public Currency getCurrencyBySymbol(String symbol) {
        return null;
    }


    //TODO:
    // - msupply is null in "https:...,80" ?
    @Override
    public void saveCurrency(String symbolId) {
        String url = "https://api.coinlore.net/api/ticker/?id=" + symbolId;
        Currency savedCurrency;
        RestTemplate response = new RestTemplate();

        Currency forObject = response.getForObject(url, Currency.class);
//
//        String json = "";
//        try (java.io.InputStream is = new java.net.URL(url).openStream()) {
//            json = new String(is.readAllBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        json = json.substring(1, json.length() - 1);
//
//        JSONObject jsonOb = new JSONObject(json);
//
//        Currency currencyToSave = new Currency();
//        currencyToSave.setId(jsonOb.getInt("id"));
//        currencyToSave.setSymbol(jsonOb.getString("symbol"));
//        currencyToSave.setName(jsonOb.getString("name"));
//        currencyToSave.setNameId(jsonOb.getString("nameid"));
//        currencyToSave.setRank(jsonOb.getInt("rank"));
//        currencyToSave.setPriceUsd(jsonOb.getDouble("price_usd"));
//        currencyToSave.setPercentChange24h(jsonOb.getDouble("percent_change_24h"));
//        currencyToSave.setPercentChange1h(jsonOb.getDouble("percent_change_1h"));
//        currencyToSave.setPercentChange7d(jsonOb.getDouble("percent_change_7d"));
//        currencyToSave.setMarketCapUsd(jsonOb.getDouble("market_cap_usd"));
//        currencyToSave.setVolume24(jsonOb.getDouble("volume24"));
//        currencyToSave.setVolume24Native(jsonOb.getDouble("volume24_native"));
//        currencyToSave.setCsupply(jsonOb.getDouble("csupply"));
//        currencyToSave.setPriceBtc(jsonOb.getDouble("price_btc"));
//        currencyToSave.setTsupply(jsonOb.getInt("tsupply"));
//  //      currencyToSave.setMsupply(jsonOb.getInt("msupply"));

        if(Objects.nonNull(forObject)){
            savedCurrency = repository.save(forObject);
        }else {
            System.out.println("something when wrong");
            //todoToMessageResponse
        }

    //todo create response with {
        // List<Currency> symbol
        ////
        // messageError
        // }

        //todo set all to response in not present
        List<Currency> all = repository.findAll();
       //resp symbols.addAll(all)
    }

    @Override
    public List<Currency> getAllCurrencyList() {
        String url = "https://api.coinlore.net/api/ticker/getAll";
        RestTemplate restTemplate = new RestTemplate();
        List<Currency> getAll = (List<Currency>) restTemplate.getForObject(url, Currency.class);
        return getAll;
    }
}
