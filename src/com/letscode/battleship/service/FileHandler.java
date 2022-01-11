package com.letscode.battleship.service;

import com.letscode.battleship.entities.Player;
import com.letscode.battleship.utils.BattleshipPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FileHandler {
  static ArrayList<Player> playerStatsFromFile;
  static ArrayList<Player> updatedPlayerStats;
  final static String GAME_STATISTICS = "src/com/letscode/battleship/resources/game_statistics.txt";

  public static void readFile(String path){
    playerStatsFromFile = new ArrayList<>();
    try {
      FileReader file = new FileReader(path);
      BufferedReader reader = new BufferedReader(file);
      String line = reader.readLine();
      while (line != null){
        if (path.equals(GAME_STATISTICS)){
          getPlayerFromFile(line);
        } else {
          System.out.println(line);
        }
        line = reader.readLine();
      }
      reader.close();
    } catch (FileNotFoundException ex){
      System.out.println("The game_statistics.txt file will be created on your game folder.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void savePlayerStatistics(){
    clearStatsFile();
    try {
      FileWriter file = new FileWriter(GAME_STATISTICS, true);
      PrintWriter fileWriter = new PrintWriter(file);

      if (updatedPlayerStats == null) updatedPlayerStats = playerStatsFromFile;

      if (updatedPlayerStats != null){
        for (Player player: updatedPlayerStats){
          fileWriter.print(player.getName() + ","
                  + player.getWins() + ","
                  + player.getLosses() + ","
                  + player.getTies() + "\n"
          );
        }
      }
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Stats File Created");
    }
  }

  public static void updatePlayerStatistics(Player player) {
    boolean hasToAddPlayer = true;

    Player playerOnFile = checkIfPlayerExistsOnFile(player);

    if (playerStatsFromFile != null){
      for (Player updatedPlayer : updatedPlayerStats){
        if (Objects.equals(updatedPlayer.getName(), player.getName())){

          if (playerOnFile != null){
            updatedPlayer.setWins(player.getWins() + playerOnFile.getWins());
            updatedPlayer.setLosses(player.getLosses() + playerOnFile.getLosses());
            updatedPlayer.setTies(player.getTies() + playerOnFile.getTies());
          }
          hasToAddPlayer = false;
        }
      }
    }
    if (hasToAddPlayer && !updatedPlayerStats.contains(playerOnFile))  updatedPlayerStats.add(player);
  }

  public static void getPlayerFromFile(String lineFromFile){
    if (!Objects.equals(lineFromFile, "")){
      String[] splittedLine = lineFromFile.split(",");
      playerStatsFromFile.add(new Player((splittedLine[0]),
                      Integer.parseInt(splittedLine[1]),
                      Integer.parseInt(splittedLine[2]),
                      Integer.parseInt(splittedLine[3])
              )
      );
    }

  }

  public static void getRanking(){
    readFile(GAME_STATISTICS);
    if (updatedPlayerStats == null){
      playerStatsFromFile.sort(new PlayerComparator());
      BattleshipPrinter.printRanking(playerStatsFromFile);
    } else {
      updatedPlayerStats.sort(new PlayerComparator());
      BattleshipPrinter.printRanking(updatedPlayerStats);
    }

  }

  private static Player checkIfPlayerExistsOnFile(Player player){
    for (Player playerOnFile : playerStatsFromFile){
      if (Objects.equals(playerOnFile.getName(), player.getName())){
        return playerOnFile;
      }
    }
    return null;
  }

  public static void clearStatsFile() {
    try{
      PrintWriter fileWriter = new PrintWriter(GAME_STATISTICS);
      fileWriter.print("");
      fileWriter.close();
    } catch (FileNotFoundException ex){
      System.out.println("Stats File not found");
    }
  }

  public static void initMatchStats(){
    readFile(GAME_STATISTICS);
    updatedPlayerStats = new ArrayList<>(playerStatsFromFile);
    savePlayerStatistics();
  }
}
