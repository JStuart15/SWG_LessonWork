/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbos.lambdaandstreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public abstract class FileDataStore {

    public void runPerRecord(String filePath, Consumer<String[]> lineFunc) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // throw out header...
            while ((line = reader.readLine()) != null) {

                lineFunc.accept(line.split(","));

            }
        }
    }
}
