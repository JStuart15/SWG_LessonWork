package LambdasAndStreams_ServerInventory;


import LambdasAndStreams_ServerInventory.ServerDao;
import LambdasAndStreams_ServerInventory.ServerDaoInMemImpl;
import LambdasAndStreams_ServerInventory.Server;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jstuart15
 */
public class App {

    public static void main(String[] args) {
        ServerDao dao = new ServerDaoInMemImpl();

        //create several Servers to manipulate
        Server myServer = new Server();
        myServer.setName("web01");
        myServer.setIp("192.168.1.1");
        myServer.setManufacturer("Dell");
        myServer.setRam(8);
        myServer.setNumProcessors(9);
        myServer.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);

        myServer = new Server();
        myServer.setName("db01");
        myServer.setIp("192.168.3.45");
        myServer.setManufacturer("HP");
        myServer.setRam(16);
        myServer.setNumProcessors(24);
        myServer.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);

        myServer = new Server();
        myServer.setName("hr124");
        myServer.setIp("192.168.32.111");
        myServer.setManufacturer("IBM");
        myServer.setRam(16);
        myServer.setNumProcessors(12);
        myServer.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);

        myServer = new Server();
        myServer.setName("eng16");
        myServer.setIp("192.168.32.56");
        myServer.setManufacturer("HP");
        myServer.setRam(4);
        myServer.setNumProcessors(8);
        myServer.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);

        myServer = new Server();
        myServer.setName("eng64");
        myServer.setIp("192.168.34.56");
        myServer.setManufacturer("HP");
        myServer.setRam(8);
        myServer.setNumProcessors(16);
        myServer.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);

        List<Server> dells = dao.getServersByManufacturer("HP");
        for (Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }

        //do the same printing but with lambdas
        System.out.println("Printing with Lambda");
        dells.stream()
                .forEach(s -> System.out.println(s.getName()));

        Map<String, List<Server>> serverMap = dao.getAllServersGroupByManufacturer();
        //get a list of manufacturers
        Set<String> manufacturers = serverMap.keySet();
        //for each manufacturer, print the servers
        manufacturers.stream()
                .forEach(name -> {
                    System.out.println("============================");
                    System.out.println("Manufacturer: " + name);
                    serverMap.get(name).stream().forEach(s -> System.out.println(s.getName()));
                });
    }
}
