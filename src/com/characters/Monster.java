package src.com.characters;

public class Monster extends Character{
    int level;
    public Monster(String name, CharRace charRace, CharClass charClass, int level) {
        super(name, charRace, charClass);
        this.level = level;
    }
}
