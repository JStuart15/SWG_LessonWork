/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.dao;

/**
 *
 * @author jstuart15
 */
public class HomeInventoryPersistenceException extends Exception{
    
    public HomeInventoryPersistenceException(String message){
        super(message);
    }
    
    public HomeInventoryPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
}
