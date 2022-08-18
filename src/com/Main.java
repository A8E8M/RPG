package src.com;

import src.com.characters.CharClass;
import src.com.characters.CharRace;
import src.com.characters.Character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character p1 = new Character("Саша", CharRace.HUMAN, CharClass.WARRIOR);
        Character p2 = new Character("Гулджин", CharRace.TROLL, CharClass.MAG);
        p1.printChar();
        p2.printChar();
        String saveStr = "Cаша HUMAN WARRIOR 150 40 25 20 45 50 25 70 35 20";
        Character p3 = new Character(saveStr);
        p3.printChar();
       /* System.out.println("(1.Новый герой)/(2.Загрузить)");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()){
            switch (input.nextLine()){
                case (1) -> {

                };
                case (0) -> {};
            }
        }
        scanner.close();
        */
    }
}
