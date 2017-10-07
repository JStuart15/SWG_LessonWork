/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author jstuart15
 */
public class Change {

    public String makeChange(BigDecimal totalIn, BigDecimal cost) {
        String changeString = "";

        BigDecimal differenceInCents = totalIn
                .subtract(cost)
                .multiply(new BigDecimal(100));

        if (differenceInCents.compareTo(new BigDecimal(100.00)) >= 0) {
            int numDollars = differenceInCents.divide(new BigDecimal(100)).intValue();
            differenceInCents = differenceInCents.subtract(new BigDecimal(numDollars * 100));
            if (numDollars == 1) {
                changeString += numDollars + " Dollar ";
            } else if (numDollars > 1) {
                changeString += numDollars + " Dollars ";
            }
        }
        if (differenceInCents.compareTo(new BigDecimal(25.00)) >= 0) {
            int numQuarters = differenceInCents.divide(new BigDecimal(25)).intValue();
            differenceInCents = differenceInCents.subtract(new BigDecimal(numQuarters * 25));
            if (numQuarters == 1) {
                changeString += numQuarters + " Quarter ";
            } else if (numQuarters > 1) {
                changeString += numQuarters + " Quarters ";
            }
        }
        if (differenceInCents.compareTo(new BigDecimal(10.00)) >= 0) {
            int numDimes = differenceInCents.divide(new BigDecimal(10)).intValue();
            differenceInCents = differenceInCents.subtract(new BigDecimal(numDimes * 10));
            if (numDimes == 1) {
                changeString += numDimes + " Dime ";
            } else if (numDimes > 1) {
                changeString += numDimes + " Dimes ";
            }
        }
        if (differenceInCents.compareTo(new BigDecimal(5.00)) >= 0) {
            int numNickels = differenceInCents.divide(new BigDecimal(5)).intValue();
            differenceInCents = differenceInCents.subtract(new BigDecimal(numNickels * 5));
            if (numNickels == 1) {
                changeString += numNickels + " Nickel ";
            } else if (numNickels > 1) {
                changeString += numNickels + " Nickel ";
            }
        }
        if (differenceInCents.compareTo(new BigDecimal(1.00)) >= 0) {
            int numPennies = differenceInCents.divide(new BigDecimal(1)).intValue();
            differenceInCents = differenceInCents.subtract(new BigDecimal(numPennies * 1));
            if (numPennies == 1) {
                changeString += numPennies + " Penny";
            } else if (numPennies > 1) {
                changeString += numPennies + " Pennies";
            }
        }
        return changeString;
    }
}
