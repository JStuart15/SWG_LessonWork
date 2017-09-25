/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OpenCSV {

    public static void main(String[] args) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("yourfile.csv"), ',');
        // feed in your array (or convert your data to an array)
        String[] entries = new String[4];
        entries[0] = "1";
        entries[1] = "WALMART, Inc.";
        entries[2] = "MN";
        entries[3] = "6.35";
//                + "6,35" + CSVDELIMETER
//                + "3" + CSVDELIMETER
//                + "TILE" + CSVDELIMETER
//                + "3,45" + CSVDELIMETER
//                + "2,24" + CSVDELIMETER
//                + "1,23" + CSVDELIMETER
//                + "54" + CSVDELIMETER
//                + "50" + CSVDELIMETER
//                + "25" + CSVDELIMETER
//                + "100" + CSVDELIMETER
//                + "2017-09-23";
        writer.writeNext(entries);
        writer.flush();

        entries = new String[4];
        entries[0] = "2";
        entries[1] = "Target, Inc.";
        entries[2] = "MN";
        entries[3] = "6.35";
        writer.writeNext(entries);
        writer.flush();

        writer.close();

        CSVReader reader = new CSVReader(new FileReader("yourfile.csv"), ',');
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0]);
            System.out.println(nextLine[1]);
            System.out.println(nextLine[2]);
            System.out.println(nextLine[3]);
//+ nextLine[1] + nextLine[2]);
        }

    }
}
