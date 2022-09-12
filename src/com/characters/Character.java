package src.com.characters;

public abstract class Character {
    private final String name;                  // имя
    private final CharRace charRace;            // раса
    private final CharClass charClass;          // класс
    protected int level = 1;                    // уровень
    protected double exp = 0;                   // опыт

    protected boolean alive = true;             // живой
    protected int maxHp;                        // максимальное количество жизни
    protected double hp;                        // количество жизней

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
        this.name = name;
        this.charRace = charRace;
        this.charClass = charClass;
        this.maxHp = (int) (charRace.maxHp + charClass.maxHp);                  // количество жизней
        this.hp = this.maxHp;
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
    public Character (String saveStr) {
        String[] save = saveStr.split(" ");
        this.charRace = CharRace.valueOf(save[1]);                  // раса
        this.charClass = CharClass.valueOf(save[2]);                // класс
        this.name = save[0];                                        // имя
        this.level = Integer.parseInt(save[3]);                     // уровень
        this.exp = Double.parseDouble(save[4]);
        this.maxHp = Integer.parseInt(save[5]);                     // количество жизней
        this.hp = maxHp;
        this.attack = Double.parseDouble(save[6]);                  // атака
        this.magicPower = Double.parseDouble(save[7]);              // сила магии
        this.critChance = Double.parseDouble(save[8]);              // шанс крита, %
        this.crit = Double.parseDouble(save[9]);                    // добавка крита, %
        this.contreAttack = Double.parseDouble(save[10]);            // шанс контратаки, %
        this.miss = Double.parseDouble(save[11]);                   // шанс промаха, %
        this.defence = Double.parseDouble(save[12]);                // защита
        this.dodge = Double.parseDouble(save[13]);                  // шанс увернуться от удара, %
        this.parry = Double.parseDouble(save[14]);                  // шанс парировать удар, %
    }

    // сохранение персонажа
    public String saveChar (){
        return name+" "+charRace+" "+charClass +" " + level+" " + exp + " " + maxHp + " " +  attack + " " +  magicPower + " " +  critChance + " " +  crit + " " +  contreAttack + " " +  miss + " " +  defence + " " +  dodge + " " +  parry;
    }
    // получаем имя
    public String getName(){return name;}
    // получаем максимальное количество жизни
    public double getMaxHp () {
    return maxHp;
    }
    // получаем текущее количество жизни
    public double getHp() {return hp;}
    // проверяем, жив ли?
    public boolean isAlive (){
        return alive;
    }
    // критический удар (да/нет)
    public boolean critChance () {
        return Math.random() > (1 - critChance/100);
    }
    // контратакуе (да/нет)
    public boolean contreAttack() { return Math.random() > (1 - contreAttack/100);}
    // уворачивается (да/нет)
    public boolean dodged (int opponentLvl) {return Math.random() > (1 - dodge/100*getLevel()/opponentLvl);}
    // промахивается (да/нет)
    public boolean missed (int opponentLvl) {return Math.random() > (1 - miss/100*getLevel()/opponentLvl);}
    // парирует (да/нет)
    public boolean parried (int opponentLvl) {return Math.random() > (1 - parry/100*getLevel()/opponentLvl);}
    // наносит урон
    public double dealDamage (int opponentLvl) {
        if (alive) {
            double critDmg;
            if (critChance()) {critDmg = (1+crit/100);} else {critDmg = 1;}
            return attack*getLevel()/opponentLvl*(0.3*Math.random()+0.7)*critDmg;
        } else return 0;
    }
    // получает урон (без учета уровня оппонента, так как учтено в dealDamage)
    public double takeDamage (double damage){
        double dmg = damage*(1-defence/1000);
        hp -= dmg;
        if (hp <= 0) {alive = false; hp = 0;}
        return dmg;
    }
    // получение опыта
    public abstract void setExp (double exp);
    // повышение уровня
    protected abstract void setLevel(int level);
    // получить уровень
    public int getLevel(){
        return level;
    }

    public String toString (){
        return  name + "["+charRace.getNameRace()+"-"+charClass.getNameClass()+"]"+ "["+level+"ур.]/" + exp + "/" + maxHp + "//" + hp +"/" +  attack + "/" +  magicPower + "/" +  critChance + "/" +  crit + "/" +  contreAttack + "/" +  miss + "/" +  defence + "/" +  dodge + "/" +  parry;
    }
}
