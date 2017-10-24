/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealornodeal;

import java.math.BigDecimal;

/**
 *
 * @author Hayden
 */
public enum CaseValue {
    PENNY(new BigDecimal("0.01")),ONE(new BigDecimal("1")),FIVE(new BigDecimal("5")),TEN(new BigDecimal("10")),TWENTY_FIVE(new BigDecimal("25")),FIFTY(new BigDecimal("50")),SEVENTY_FIVE(new BigDecimal("75")),
    HUNDRED(new BigDecimal("100")),TWO_HUNDRED(new BigDecimal("200")),THREE_HUNDRED(new BigDecimal("300")),FOUR_HUNDRED(new BigDecimal("400")),FIVE_HUNDRED(new BigDecimal("500")),SEVEN_HUNDRED_FIFTY(new BigDecimal("500")),
    THOUSAND(new BigDecimal("1000")),FIVE_THOUSAND(new BigDecimal("5000")),TEN_THOUSAND(new BigDecimal("10000")),TWENTY_FIVE_THOUSAND(new BigDecimal("25000")),FIFTY_THOUSAND(new BigDecimal("50000")),
    SEVENTY_FIVE_THOUSAND(new BigDecimal("75000")),ONE_HUNDRED_THOUSAND(new BigDecimal("100000")),TWO_HUNDRED_THOUSAND(new BigDecimal("200000")),
    THREE_HUDNRED_THOUSAND(new BigDecimal("300000")),FOUR_HUNDRED_THOUSAND(new BigDecimal("400000")),FIVE_HUNDRED_THOUSAND(new BigDecimal("500000")),SEVEN_HUNDRED_FIFTY_THOUSAND(new BigDecimal("750000")),
    MILLION(new BigDecimal("1000000"));
    
 private BigDecimal cashValue;
 
CaseValue(BigDecimal cashValue){
this.cashValue = cashValue;
}

public BigDecimal getCashValue(){
return cashValue;
}
}
