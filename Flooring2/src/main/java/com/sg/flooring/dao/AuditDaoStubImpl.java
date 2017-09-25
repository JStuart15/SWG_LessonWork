/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

/**
 *
 * @author jstuart15
 */
public class AuditDaoStubImpl implements AuditDao {

    @Override
    public void writeAuditEntry(String entry) throws FlooringPersistenceException {
        // do nothing for this stub because no need to write audit files
    }

}
