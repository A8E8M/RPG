package src.com;

import src.com.characters.CharClass;
import src.com.characters.CharRace;
import src.com.characters.Monster;
import src.com.characters.Player;
import src.com.characters.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.String.format;

public abstract class GameLogic {
    private static final String filePath = "src/com/saves/saves";       // расположение файла с сохранением
    private static final File saves = new File(filePath);               // файл с сохранением

    // Создание нового персонажа.
    public static Player newChar(){
        CharRace charRace = CharRace.HUMAN;                             // раса по умолчанию
        CharClass charClass = CharClass.WARRIOR;                        // класс по умолчанию

        Scanner input = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = input.nextLine();

        System.out.print("Выберите расу (1.Человек)/(2.Троль)/(3.Орк): ");
        String choiceString = input.nextLine();
        try {
            switch (Integer.parseInt(choiceString)) {
                case 2 -> charRace = CharRace.TROLL;
                case 3 -> charRace = CharRace.ORC;
            }
        } catch (Exception ignored) {        }

        System.out.print("Выберите класс (1.Воин)/(2.Маг)/(3.Лучник): ");
        choiceString = input.nextLine();
        try {
            switch (Integer.parseInt(choiceString)) {
                case 2 -> charClass = CharClass.MAG;
                case 3 -> charClass = CharClass.ARCHER;
            }
        } catch (Exception ignored) {        }
        return new Player(name, charRace, charClass);
    }

    // Загрузка персонажа из файла. Если не удается, создаем нового.
    public static Player loadChar () {
        Player pers;
        String saveStr;
        try {
            Scanner input = new Scanner(saves);
            saveStr = input.nextLine();
            if (!saveStr.isEmpty()){
                pers = new Player(saveStr);
            } else {
                System.out.println("Отсутствует сохранение! Создайте нового персонажа:");
                pers = newChar();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Отсутствует файл! Создайте нового персонажа:");
            pers = newChar();
        }
        return pers;
    }

    // Сохранение персонажа в файл
    public static void saveChar (Player charSave) {
        try {
            FileWriter writer = new FileWriter(saves, false);
            writer.write(charSave.saveChar());
            System.out.println("Персонаж сохранен!");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Не удалось сохранить!");
        }
    }

}
