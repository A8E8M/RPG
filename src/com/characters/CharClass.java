package src.com.characters;

public enum CharClass {   // класс персонажа
    WARRIOR ("воин", 100, 25, 0, 10, 25, 30, 10, 50, 25, 20),  // класс воин
    MAG ("маг", 80, 5, 30, 15, 20, 0, 7, 15, 5, 0);            // класс маг
    final String className;
    final double maxHp, attack, magicPower, critChance, crit, contreAttack, miss, defence, dodge, parry;

    CharClass(String className, double maxHp, double attack, double magicPower, double critChance, double crit, double contreAttack, double miss, double defence, double dodge, double parry) {
        this.className = className;
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
    String getNameClass(){
        return className;
    }
}