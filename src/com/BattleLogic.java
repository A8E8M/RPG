package src.com;

import src.com.characters.Character;
import src.com.characters.Monster;
import src.com.characters.Player;

import java.util.Scanner;

import static java.lang.String.format;

public abstract class BattleLogic {

    // сражение
    public static void startBattle(Player p1, Monster p2){                          // добавить <T>

        System.out.println(p1.getName() + " бъется с " + p2.getName());
        boolean escape = false;
        String log1;
        String log2;

        // сражение
        while (p1.isAlive() && p2.isAlive() && !escape){
            switch (playerAction()) {                                                                   // действие игрока
                case (2) -> log1 = "Heal";/*log1 = Spells.heal(p1, p1);  */                                             // лечение
                case (0) -> {escape = true; log1 = format("%s сбежал", p1.getName());}                  // побег
                default -> log1 = attackChar(p1, p2);                                                   // атака игрока
            }
            log2 = attackChar(p2, p1);                                                                  // атака монстра
            System.out.printf("%s.\n%s.\n", log1, log2);                                                // лог боя
        }

        // итог сражения
        if (p1.isAlive() && !escape) {
            System.out.println(p1.getName() + " победил!");
            p1.setExp(100 * ((double)p2.getLevel()/ p1.getLevel()));
        } else if (!p1.isAlive()){
            System.out.println(p1.getName() + " проиграл!");
        } else {
            System.out.println(p1.getName() + " сбежал!");
        }
    }

    // децствия игрока
    private static int playerAction(){
        // действие игрока
        int action;
        System.out.print("Ваши действия? (1.Ударить)/(2.Лечиться)/(0.Бежать): ");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) { action = input.nextInt();} else {action = 1;}
        return action;
    }

    // один раунд боя
    private static String attackChar (Character p1, Character p2){
        // p1 - атакует, p2 - защищается
        String log;

        if (!p1.isAlive()) { log = format("%s убит", p1.getName());                      // проверка "жив ли" атакующий (p1)
        } else if (p1.missed()) { log = format("%s промахнулся", p1.getName());          // проверка на промах атакующим (p1)
        } else if (p2.parried()){ log = format("%s парировал", p2.getName());            // проверка на парирование защищающимся (p2)
        } else if (p2.dodged()) { log = format("%s увернулся", p2.getName());            // проверка на уворот защищающимся (p2)
        } else { double dmgP1 = p2.takeDamage(p1.dealDamage());                          // нанесено урона защищающемуся (p2)
            if (p2.contreAttack()){                                                      // проверка на контратаку (p2)
                double dmgP2 = p1.takeDamage(p2.dealDamage());
                log = format("%s нанес %s урон %.1f (осталось: %.1f)",p1.getName(), p2.getName(), dmgP1, p2.getHp() ) + format(", %s контратаковал %s и нанес урон %.1f (осталось: %.1f)", p2.getName(), p1.getName(), dmgP2, p1.getHp());
            } else {log = format("%s нанес %s урон %.1f (осталось: %.1f)",p1.getName(), p2.getName(), dmgP1, p2.getHp() );}    // лог обычного урона
        }
        return log;
    }

}
