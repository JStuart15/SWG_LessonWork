/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jstuart15
 */
public class VendingMachineDaoDbImpl implements VendingMachineDao {

    private static final String SQL_SELECT_ALL_ITEMS
            = "select * from Items";
    
    private static final String SQL_SELECT_ITEM
            = "select * from Items where itemId = ?";
    
    private static final String SQL_UPDATE_ITEM
            = "update Items set Quantity = ? "
            + "where itemId = ?"; 
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ItemMapper());
    }

    @Override
    public Item getItem(int itemId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, 
                    new ItemMapper(), itemId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(SQL_UPDATE_ITEM, item.getQuantityAvailable());
    }
    
    private static final class ItemMapper implements RowMapper<Item>{

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setItemId(rs.getInt("itemId"));
            item.setItemName(rs.getString("itemName"));
            item.setItemCost(rs.getBigDecimal("itemCost"));
            item.setQuantityAvailable(rs.getInt("Quantity"));
            return item;
        }
        
    }
}
