/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class ProductDaoFileImpl implements ProductDao {
    
    public static final String PRODUCT_FILE = "flooringProduct.txt";
    public static final String DELIMETER = ",";

    Map<Integer, Product> products = new HashMap<>();

    @Override
    public Map<Integer, Product> getAllProducts() throws FlooringPersistenceException {
        loadProducts();
        return products;
    }

    private void loadProducts() throws FlooringPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));

        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load product file into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            Product currentProduct = new Product(
                    Integer.parseInt(currentTokens[0]),
                    currentTokens[1].toUpperCase(),
                    new BigDecimal(currentTokens[2]),
                    new BigDecimal(currentTokens[3]));
            

            products.put(currentProduct.getProductId(), currentProduct);
        }
        scanner.close();    }
}
