package com.letscode.battleship.service;

import com.letscode.battleship.entities.Player;
import com.letscode.battleship.utils.BattleshipPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FileHandler {
  static ArrayList<Player> playersGameStats;

  public static void readFile(String path){
    playersGameStats = new ArrayList<>();
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

  public static void savePlayerStatistics(){
    clearStatsFile();
    try {
      FileWriter file = new FileWriter("Game_Statistics.txt", true);
      PrintWriter fileWriter = new PrintWriter(file);

      for (Player player: playersGameStats){
        fileWriter.print(player.getName() + ","
                + player.getWins() + ","
                + player.getLosses() + ","
                + player.getTies() + "\n"
        );
      }
      fileWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void updatePlayerStatistics(Player player) {
    boolean hasToAddPlayer = true;
    if (playersGameStats == null){
      readFile("Game_Statistics.txt");
    }

    for (Player playerOnFile: playersGameStats){
      if (Objects.equals(playerOnFile.getName(), player.getName())){
        playerOnFile.setWins(player.getWins());
        playerOnFile.setLosses(player.getLosses());
        playerOnFile.setTies(player.getTies());
        hasToAddPlayer = false;
      }
    }

    if (hasToAddPlayer)  playersGameStats.add(player);
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

  public static void clearStatsFile() {
    try{
      PrintWriter fileWriter = new PrintWriter("Game_Statistics.txt");
      fileWriter.print("");
      fileWriter.close();
    } catch (FileNotFoundException ex){
      System.out.println("Stats File not found");
    }
  }
}
