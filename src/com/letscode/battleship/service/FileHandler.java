package com.letscode.battleship.service;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileHandler {

  public static void readFile(String path){
    try {
      FileReader file = new FileReader(path);
      BufferedReader reader = new BufferedReader(file);
      String line = reader.readLine();
      while (line != null){
        System.out.println(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
