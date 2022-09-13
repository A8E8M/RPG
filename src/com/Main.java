package src.com;

import src.com.characters.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player;
        Monster npc1 = new Monster("Гулджин", CharRace.TROLL, CharClass.MAG, 1);
        Monster npc2 = new Monster("Тралл", CharRace.ORC, CharClass.WARRIOR, 1);

        // создание или загрузка персонажа
        System.out.print("(1.Новый персонаж)/(2.Загрузить): ");
        Scanner input = new Scanner(System.in);
        if (input.next().charAt(0) == '2') {
            try {
                player = GameLogic.loadChar();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка чтения!");
                player = GameLogic.newChar();
            }
        } else {player = GameLogic.newChar();}

        System.out.println(player);
        System.out.println(npc1);
        //System.out.println(npc2);
        BattleLogic.startBattle(player,npc1);
        input.close();

        // сохранение персонажа, если живой
        if (player.isAlive()) { GameLogic.saveChar(player); }
    }
}
