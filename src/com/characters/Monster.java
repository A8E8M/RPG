package src.com.characters;

public class Monster extends Character{
    int level;
    public Monster(String name, CharRace charRace, CharClass charClass, int level) {
        super(name, charRace, charClass);
        this.level = level;
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
