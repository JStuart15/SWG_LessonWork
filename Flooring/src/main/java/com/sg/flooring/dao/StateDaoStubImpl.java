/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.State;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public class StateDaoStubImpl implements StateDao {

    State state1 = new State();
    State state2 = new State();
    Map<String, BigDecimal> stateList = new HashMap<>();

    public StateDaoStubImpl() {
        state1.setAbbr("MN");
        state1.setTaxRate(new BigDecimal(7.25));
        stateList.put(state1.getAbbr(), state1.getTaxRate());

        state2.setAbbr("AZ");
        state2.setTaxRate(new BigDecimal(6.25));
        stateList.put(state2.getAbbr(), state2.getTaxRate());

    }

    @Override
    public Map<String, BigDecimal> getAllStates() throws FlooringPersistenceException {
        return Collections.unmodifiableMap(stateList);
    }

}
