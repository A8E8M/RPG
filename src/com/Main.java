package src.com;

import src.com.characters.*;
import src.com.characters.Character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player;
        Player p1 = new Player("Саша", CharRace.HUMAN, CharClass.ARCHER);
        Monster npc1 = new Monster("Гулджин", CharRace.TROLL, CharClass.MAG, 1);
        Monster npc2 = new Monster("Тралл", CharRace.ORC, CharClass.WARRIOR, 1);
        p1.printChar();
        npc2.printChar();

        p1.setExp(80);
        p1.setExp(20);
        p1.setExp(100);
        p1.setExp(500);
        p1.setExp(900);


        /*System.out.print("(1.Новый герой)/(2.Загрузить): ");
        Scanner input = new Scanner(System.in);
        if (input.next().charAt(0) == '2') {player = GameLogic.loadChar();
        } else {player = GameLogic.newChar();}
        input.close();
        player.printChar();
        GameLogic.saveChar(player);*/
    }
}
