/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public interface StateDao {

    Map<String, BigDecimal> getAllStates() throws FlooringPersistenceException;

}
