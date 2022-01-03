package com.letscode.battleship.service;

import com.letscode.battleship.entities.Player;
import com.letscode.battleship.utils.BattleshipPrinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHandler {
  static ArrayList<Player> playersGameStats;

  public static void readFile(String path){
    playersGameStats = new ArrayList<Player>();
    try {
      FileReader file = new FileReader(path);
      BufferedReader reader = new BufferedReader(file);
      String line = reader.readLine();
      while (line != null){
        if (path.equals("Game_Statistics.txt")){
          getPlayerFromFile(line);
        } else {
          System.out.println(line);
        }
        line = reader.readLine();
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void savePlayerStatistics(Player player){
    try {
      FileWriter file = new FileWriter("Game_Statistics.txt", true);
      PrintWriter fileWriter = new PrintWriter(file);
      fileWriter.print(player.getName() + ","
                      + player.getWins() + ","
                      + player.getLosses() + ","
                      + player.getTies() + "\n"
      );
      fileWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void getPlayerFromFile(String lineFromFile){
    String[] splittedLine = lineFromFile.split(",");
    playersGameStats.add(new Player((splittedLine[0]),
                                      Integer.parseInt(splittedLine[1]),
                                      Integer.parseInt(splittedLine[2]),
                                      Integer.parseInt(splittedLine[3])
                                   )
    );
  }

  public static void getRanking(){
    readFile("Game_Statistics.txt");
    playersGameStats.sort(new PlayerComparator());
    BattleshipPrinter.printRanking(playersGameStats);
  }
}
