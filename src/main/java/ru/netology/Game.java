package ru.netology;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.HashMap;

public class Game {
    HashMap<String, Player> players;

    public Game(HashMap<String, Player> players) {
        this.players = players;
    }

    public void register(Player player) {
        if (players.get(player.getName()) == null) {
            players.put(player.getName(), player);
        } else {
            throw new KeyAlreadyExistsException(
                    "Участнмк с именем " + player.getName() + "уже зарегестрирован!" +
                            "Введите другое имя."
            );
        }
    }

//    public Player findByName(String name) {
//        for (Player player : players) {
//            if (player.getName() == name) {
//                return player;
//            }
//        }
//        return null;
//    }

    public int round(String playerName1, String playerName2) {
        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException(
                    "Участник " + playerName1 + " не может участвовать, т.к. не зарегестрирован!"
            );
        }
        if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException(
                    "Участник " + playerName2 + "не может участвовать, т.к. не зарегестрирован!"
            );
        }
        if (players.get(playerName1).getStrength() > players.get(playerName2).getStrength()) {
            return 1;
        } else if (players.get(playerName1).getStrength() < players.get(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
