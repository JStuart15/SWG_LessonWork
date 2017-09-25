/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public class ProductDaoStubImpl implements ProductDao {

    Map<Integer, Product> prodList = new HashMap<>();
    Product prod = new Product();

    
    public ProductDaoStubImpl() {
        prod.setProductId(1);
        prod.setProductName("carpet");
        prod.setLaborCostPsf(new BigDecimal(2.25));
        prod.setMatCostPsf(new BigDecimal(2.10));
        prodList.put(prod.getProductId(), prod);

        prod.setProductId(2);
        prod.setProductName("cork");
        prod.setLaborCostPsf(new BigDecimal(6.25));
        prod.setMatCostPsf(new BigDecimal(3.45));
        prodList.put(prod.getProductId(), prod);
        
        prod.setProductId(3);
        prod.setProductName("laminate");
        prod.setLaborCostPsf(new BigDecimal(1.75));
        prod.setMatCostPsf(new BigDecimal(2.10));
        prodList.put(prod.getProductId(), prod);

        prod.setProductId(4);
        prod.setProductName("tile");
        prod.setLaborCostPsf(new BigDecimal(3.25));
        prod.setMatCostPsf(new BigDecimal(2.25));
        prodList.put(prod.getProductId(), prod);
    }

    @Override
    public Map<Integer, Product> getAllProducts() throws FlooringPersistenceException {
        return prodList;
    }

}
