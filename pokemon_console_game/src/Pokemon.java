
public class Pokemon{
    public String name;
    public int level;
    public int hp;
    public int damage;
    public int mana;

    public Pokemon(String name, int level, int hp, int damage, int mana){
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.damage = 4 + 2*level;
        this.mana = mana;
    }
}