package com.example.CryptoCurrencyWatcher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idInTable;
    private Integer id;
    private String symbol;
    private String name;
    private String nameId;
    private Integer rank;
    private Double priceUsd;
    private Double percentChange24h;
    private Double percentChange1h;
    private Double percentChange7d;
    private BigDecimal marketCapUsd;
    private BigDecimal volume24;
    private BigDecimal volume24Native;
    private BigDecimal csupply;
    private Double priceBtc;
    private BigInteger tsupply;
    private BigInteger msupply;

}
