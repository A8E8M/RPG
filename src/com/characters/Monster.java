package src.com.characters;

public class Monster extends Character{
    public Monster(String name, CharRace charRace, CharClass charClass, int level) {
        super(name, charRace, charClass);
        super.level = level;
        maxHp += (level-1)*50;
        attack += (level-1)*10;
        defence += (level-1)*5;
        hp = maxHp;

    }
    // получение опыта
    @Override
    public void setExp(double exp) {
        System.out.println("Лучше не стало.");
    }
    // получение уровня
    @Override
    protected void setLevel(int level) {
        System.out.println("Это не возможно.");
    }
}
