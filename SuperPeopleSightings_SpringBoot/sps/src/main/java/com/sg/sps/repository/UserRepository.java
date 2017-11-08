/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sps.repository;

import com.sg.sps.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jstuart15
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByLastName(String lastname);
    
}
