package src.com;

import src.com.characters.CharClass;
import src.com.characters.CharRace;
import src.com.characters.Player;

import java.io.*;
import java.util.Scanner;

public abstract class GameLogic {
    private static final String filePath = "src/com/saves/saves.bin";       // расположение файла с сохранением
    private static final File saves = new File(filePath);                   // файл с сохранением

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
    public static Player loadChar () throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(saves);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Player pers = (Player) ois.readObject();                            // Чтение персонажа из файла
        ois.close();                                                        // Закрытие потока
        return pers;
    }

    // Сохранение персонажа в файл
    public static void saveChar (Player charSave) {
        try {
            FileOutputStream fos = new FileOutputStream(saves);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(charSave);                                          // Запись персонажа в файл
            oos.close();                                                        // Закрытие потока
            System.out.println("Персонаж сохранен!");
        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }

    }

}
