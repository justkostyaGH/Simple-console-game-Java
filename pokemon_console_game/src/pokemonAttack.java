import java.util.Random;

public class pokemonAttack{
    public Random rand = new Random();
    public void normalAttack(Pokemon target, Pokemon pokemonAttacking){
        if (pokemonAttacking.mana >= 10) {
            if (rand.nextInt(10) + 1 >= 8) {
                target.hp -= pokemonAttacking.damage * 2;
                System.out.println(pokemonAttacking.name + " dealt crit: " + pokemonAttacking.damage * 2 + " damage to " + target.name);
            } else {
                target.hp -= pokemonAttacking.damage;
                System.out.println(pokemonAttacking.name + " dealt: " + pokemonAttacking.damage + " damage to " + target.name);
            }

            if (target.hp > 0) {
                System.out.println("Now " + target.name + " has: " + target.hp + " hp");
            } else {
                System.out.println(target.name + " defeated");
            }

            pokemonAttacking.mana -= 10;
        }
        else{
            System.out.println("You don't have enough mana:(");
        }
    }

    public void heavyAttack(Pokemon target, Pokemon pokemonAttacking){
        if(pokemonAttacking.mana >= 30) {
            if (rand.nextInt(5) + 1 >= 5) {
                System.out.println(pokemonAttacking.name + " missed:)");
                System.out.println(target.name + " still has: " + target.hp + " hp");
            }
            else {
                target.hp -= pokemonAttacking.damage * 3;
                System.out.println(pokemonAttacking.name + " dealt heavy: " +pokemonAttacking.damage * 3 + " damage to "+target.name);
                if (target.hp > 0) {
                    System.out.println("Now " + target.name +" has: " + target.hp + " hp");
                } else {
                    System.out.println(target.name + " defeated");
                }
                pokemonAttacking.mana -= 30;
            }
        }
        else{
            System.out.println("You don't have enough mana:(");
        }
    }


    public void healPokemon(Pokemon target) {
        if (target.mana >= 15) {
            target.hp += (int) ((float) target.hp * 0.4);
            target.mana -= 15;
            System.out.println(target.name + " now has: " + target.hp + " hp and his mana: " + target.mana);
        }
        else{
            System.out.println(target.name + "don't have enough mana");
        }
    }
}
