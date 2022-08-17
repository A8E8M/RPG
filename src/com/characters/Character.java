package src.com.characters;

public class Character {
    protected String name;                      // имя
    protected CharRace charRace;                // раса
    protected CharClass charClass;              // класс
    protected int level;                        // уровень
    protected double exp;                       // опыт до уровня

    protected boolean alive = true;             // живой
    protected int maxHp;                        // максимальное количество жизни
    protected double hp = maxHp;                        // количество жизней

    protected double attack;                    // атака
    protected double magicPower;                // сила магии
    protected double critChance;                // шанс крита, %
    protected double crit;                      // добавка крита, %
    protected double contreAttack;              // шанс контратаки, %

    protected double miss;                      // шанс промаха, %

    protected double defence;                   // защита
    protected double dodge;                     // шанс увернуться от удара, %
    protected double parry;                     // шанс парировать удар, %

    public Character (String name, CharRace charRace, CharClass charClass){
        this.name = name + "["+charRace.getNameRace()+"-"+charClass.getNameClass()+"]";
        this.charRace = charRace;
        this.charClass = charClass;
        this.maxHp = (int) (charRace.maxHp + charClass.maxHp);

        this.attack = charRace.attack + charClass.attack;                       // атака
        this.magicPower = charRace.magicPower + charClass.magicPower;           // сила магии
        this.critChance = charRace.critChance + charRace.critChance;            // шанс крита, %
        this.crit = charRace.crit + charClass.crit;                             // добавка крита, %
        this.contreAttack = charRace.contreAttack + charClass.contreAttack;     // шанс контратаки, %
        this.miss = charRace.miss + charClass.miss;                             // шанс промаха, %
        this.defence = charRace.defence + charClass.defence;                    // защита
        this.dodge = charRace.dodge + charClass.dodge;                          // шанс увернуться от удара, %
        this.parry = charRace.parry + charClass.parry;                          // шанс парировать удар, %
    }
    public void printChar (){
        System.out.println(name + "/" + maxHp + "/" +  attack + "/" +  magicPower + "/" +  critChance + "/" +  crit + "/" +  contreAttack + "/" +  miss + "/" +  defence + "/" +  dodge + "/" +  parry);
    }
}
