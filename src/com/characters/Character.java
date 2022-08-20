package src.com.characters;

public class Character {
    protected String name;                      // имя
    protected CharRace charRace;                // раса
    protected CharClass charClass;              // класс
    protected int level = 1;                    // уровень
    protected double exp;                       // опыт до уровня

    protected boolean alive = true;             // живой
    protected int maxHp;                        // максимальное количество жизни
    protected double hp = maxHp;                // количество жизней

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
        this.maxHp = Integer.parseInt(save[4]);                     // количество жизней
        this.attack = Double.parseDouble(save[5]);                  // атака
        this.magicPower = Double.parseDouble(save[6]);              // сила магии
        this.critChance = Double.parseDouble(save[7]);              // шанс крита, %
        this.crit = Double.parseDouble(save[8]);                    // добавка крита, %
        this.contreAttack = Double.parseDouble(save[9]);            // шанс контратаки, %
        this.miss = Double.parseDouble(save[10]);                   // шанс промаха, %
        this.defence = Double.parseDouble(save[11]);                // защита
        this.dodge = Double.parseDouble(save[12]);                  // шанс увернуться от удара, %
        this.parry = Double.parseDouble(save[13]);                  // шанс парировать удар, %
    }
    public String saveChar (){
        return name+" "+charRace.getNameRace()+" "+charClass.getNameClass() +" " + level+" " + maxHp + " " +  attack + " " +  magicPower + " " +  critChance + " " +  crit + " " +  contreAttack + " " +  miss + " " +  defence + " " +  dodge + " " +  parry;
    }
    public boolean isAlive (){
        return alive;
    }
    public void printChar (){
        System.out.println(name + "["+charRace.getNameRace()+"-"+charClass.getNameClass()+"]"+ "["+level+"ур.]/" + maxHp + "/" +  attack + "/" +  magicPower + "/" +  critChance + "/" +  crit + "/" +  contreAttack + "/" +  miss + "/" +  defence + "/" +  dodge + "/" +  parry);
    }

}
