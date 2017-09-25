/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdasAndStreams_ServerInventory;

import LambdasAndStreams_ServerInventory.Server;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public interface ServerDao {
    //add, list, remove
      public void addServer(Server server);
      public Server getServer(String name);
      public void removeServer(String name);
      public List<Server> getAllServers();
      
      public Map<String, List<Server>> getAllServersGroupByManufacturer();
      public List<Server> getServersByManufacturer(String manufacturer);
      public List<Server> getServersOlderThan(int ageInYears);
      public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears);
      public double getAverageServerAge();
}
