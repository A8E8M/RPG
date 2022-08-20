package src.com;

import src.com.characters.CharClass;
import src.com.characters.CharRace;
import src.com.characters.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class GameLogic {
    private static final String filePath = "src/com/saves/saves";
    private static final File saves = new File(filePath);
    public static Character newChar(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = input.nextLine();
        System.out.print("Выберите расу (1.Человек)/(2.Троль)/(3.Орк): ");
        CharRace charRace;
        switch (input.nextInt()) {
            case 2 -> charRace = CharRace.TROLL;
            case 3 ->charRace = CharRace.ORC;
            default -> charRace = CharRace.HUMAN;
        }
        System.out.print("Выберите класс (1.Воин)/(2.Маг)/(3.Лучник): ");
        CharClass charClass;
        switch (input.nextInt()){
            case 2 -> charClass = CharClass.MAG;
            case 3 -> charClass = CharClass.ARCHER;
            default -> charClass = CharClass.WARRIOR;
        }
        return new Character(name, charRace, charClass);
    }
    public static Character loadChar () {
        Character pers;
        String saveStr;
        try {
            Scanner input = new Scanner(saves);
            saveStr = input.nextLine();
            pers = new Character(saveStr);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось загрузить! Создайте нового персонажа:");
            pers = newChar();
        }
        return pers;
    }
    public static void saveChar (Character charSave) {

        System.out.println(charSave.saveChar());
    }
}
