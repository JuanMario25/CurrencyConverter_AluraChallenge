package com.alurachallenge.jmario.classes;

import com.alurachallenge.jmario.menu.Menu;

import java.time.LocalDateTime;

public class CurrencyConverter {
    private final String result;
    private final String documentation;
    private final String terms_of_use;
    private final String time_last_update_unix;
    private final String time_last_update_utc;
    private final String time_next_update_unix;
    private final String time_next_update_utc;
    private final String base_code;
    private final String target_code;
    private final double conversion_rate;
    private double money_amount;
    private double conversion_result;
    private String summary;
    private final String query_date_time;

    public CurrencyConverter(CurrencyConversionData currencyConversionData) {
        this.result = currencyConversionData.result();
        this.documentation = currencyConversionData.documentation();
        this.terms_of_use = currencyConversionData.terms_of_use();
        this.time_last_update_unix = currencyConversionData.time_last_update_unix();
        this.time_last_update_utc = currencyConversionData.time_last_update_utc();
        this.time_next_update_unix = currencyConversionData.time_next_update_unix();
        this.time_next_update_utc = currencyConversionData.time_next_update_utc();
        this.base_code = currencyConversionData.base_code();
        this.target_code = currencyConversionData.target_code();
        this.conversion_rate = Double.parseDouble(currencyConversionData.conversion_rate());
        this.query_date_time = "%S".formatted(LocalDateTime.now()).substring(0,19).replace(":","-");
    }

    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public String getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public String getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getMoney_amount() {
        return money_amount;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public String getSummary() {
        return summary;
    }

    public String getQuery_date_time() {
        return query_date_time;
    }

    public void setConversion_result(double money_amount) {
        this.money_amount = money_amount;
        this.conversion_result = this.money_amount * this.conversion_rate;
    }
    public void setSummary(){
        this.summary = Menu.printResult(this.money_amount, this.conversion_result, this.base_code, this.target_code);
    }
}
