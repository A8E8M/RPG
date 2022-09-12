package src.com;

import src.com.characters.*;
import src.com.characters.Character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player;
        Monster npc1 = new Monster("Гулджин", CharRace.TROLL, CharClass.MAG, 1);
        Monster npc2 = new Monster("Тралл", CharRace.ORC, CharClass.WARRIOR, 1);

        System.out.print("(1.Новый герой)/(2.Загрузить): ");
        Scanner input = new Scanner(System.in);

        if (input.next().charAt(0) == '2') {player = GameLogic.loadChar();
        } else {player = GameLogic.newChar();}

        System.out.println(player);
        System.out.println(npc1);
        System.out.println(npc2);
        BattleLogic.startBattle(player,npc1);
        if (player.isAlive()) { GameLogic.saveChar(player); }
        input.close();
    }
}
