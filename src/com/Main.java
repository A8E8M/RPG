package src.com;

import src.com.characters.CharClass;
import src.com.characters.CharRace;
import src.com.characters.Character;

public class Main {
    public static void main(String[] args) {
        Character p1 = new Character("Саша", CharRace.HUMAN, CharClass.WARRIOR);
        Character p2 = new Character("Гулджин", CharRace.TROLL, CharClass.MAG);
        p1.printChar();
        p2.printChar();

    }
}
