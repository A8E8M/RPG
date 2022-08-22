package src.com;

import src.com.characters.CharClass;
import src.com.characters.CharRace;
import src.com.characters.Character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character player;
        Character p1 = new Character("Саша", CharRace.HUMAN, CharClass.WARRIOR);
        Character p2 = new Character("Гулджин", CharRace.TROLL, CharClass.MAG);
        p1.printChar();
        p2.printChar();

        System.out.print("(1.Новый герой)/(2.Загрузить): ");
        Scanner input = new Scanner(System.in);
        if (input.next().charAt(0) == '2') {player = GameLogic.loadChar();
        } else {player = GameLogic.newChar();}
        input.close();
        player.printChar();
        GameLogic.saveChar(player);
    }
}
