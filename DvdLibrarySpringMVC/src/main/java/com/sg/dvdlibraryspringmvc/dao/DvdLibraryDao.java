/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface DvdLibraryDao {
            
    public Dvd addDvd(Dvd dvd);
    
    public void removeDvd(int dvdId);
    
    public void updateDvd(Dvd dvd);
    
    public List<Dvd> getAllDvds();
    
    public Dvd getDvdById(int dvdId);
    
}
