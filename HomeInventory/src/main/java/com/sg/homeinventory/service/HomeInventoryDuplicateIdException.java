/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.homeinventory.service;

/**
 *
 * @author jstuart15
 */
public class HomeInventoryDuplicateIdException extends Exception {

    public HomeInventoryDuplicateIdException(String message) {
        super(message);
    }

    public HomeInventoryDuplicateIdException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
