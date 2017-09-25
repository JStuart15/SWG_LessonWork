/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author jstuart15
 */
public class SimpleCalculator {

    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        return a.divide(b, 2, RoundingMode.HALF_UP);
    }
}
