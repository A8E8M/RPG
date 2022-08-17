package src.com.characters;

public enum CharRace {   // класс персонажа
    HUMAN ("человек", 20, 10, 20, 7, 10, 10, 10, 15, 5, 5),     // раса человек
    TROLL ("троль", 15, 12, 15, 10, 7, 12, 7, 10, 7, 10);       // раса троль
    final String raceName;
    final double maxHp, attack, magicPower, critChance, crit, contreAttack, miss, defence, dodge, parry;

    CharRace(String className, double maxHp, double attack, double magicPower, double critChance, double crit, double contreAttack, double miss, double defence, double dodge, double parry) {
        this.raceName = className;
        this.maxHp = maxHp;                     // максимальное количество жизни
        this.attack = attack;                   // атака
        this.magicPower = magicPower;           // сила магии
        this.critChance = critChance;           // шанс крита, %
        this.crit = crit;                       // добавка крита, %
        this.contreAttack = contreAttack;       // шанс контратаки, %
        this.miss = miss;                       // шанс промаха, %
        this.defence = defence;                 // защита
        this.dodge = dodge;                     // шанс увернуться от удара, %
        this.parry = parry;                     // шанс парировать удар, %

    }
    String getNameRace(){
        return raceName;
    }
}
