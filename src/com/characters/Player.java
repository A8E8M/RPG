package src.com.characters;

public class Player extends Character{
    protected int[] expToLevel = {0, 50, 110, 180, 260, 350, 450, 560, 680, 810, 1000};     // Если коли кол-во опыта между i и i+1, то уровень i+1
    protected int maxLeveL = expToLevel.length-1;                                           // Максимальный уровент 10
    public Player(String name, CharRace charRace, CharClass charClass) {
        super(name, charRace, charClass);
    }
    public Player(String saveStr) {
        super(saveStr);
    }
    // получение опыта
    @Override
    public void setExp (double exp){
        super.exp += exp;
        if (super.exp>expToLevel[maxLeveL]){super.exp = expToLevel[maxLeveL];}              // проверка на максимальное кол-во опыта
        for (int i = level; i<maxLeveL; i++) {                                              // перебор всех уровней больше текущего
            if (super.exp>expToLevel[i] & super.exp<=expToLevel[i+1]){
                setLevel(i+1);
             }
        }
    }
    // повышение уровня
    @Override
    protected void setLevel(int level){
        super.level=level;
        maxHp += (level-1)*50;
        attack += (level-1)*10;
        defence += (level-1)*5;
        System.out.println("Новый уровень!");
        hp = maxHp;
    }
}
