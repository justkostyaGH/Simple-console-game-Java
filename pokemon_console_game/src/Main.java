import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Pokemon yourPokemon;
    static Pokemon enemyPokemon;

    static String[] names = new String[4];
    static Random rand = new Random();
    public static ArrayList<Pokemon> pokemons = new ArrayList<>();

    static pokemonAttack attacks = new pokemonAttack();

    public static void main(String[] args) {
        names[0] = "Eevee";
        names[1] = "Bulbazavr";
        names[2] = "Charizard";
        names[3] = "Squirtle";

        pokemons.add(new Pokemon("Pikachu", 3, 25, 4, 45));
        for (int i = 0; i<3; i++){
            pokemons.add(newPokemons());
        }

        yourPokemon = pokemons.get(0);
        System.out.println("Your pokemon name is: " + yourPokemon.name);
        System.out.println("Your pokemon level is: " + yourPokemon.level);
        System.out.println("Your pokemon hp value is: " + yourPokemon.hp);
        System.out.println("Your pokemon deals " + yourPokemon.damage + " damage");
        System.out.println("Your pokemon have " + yourPokemon.mana + " mana");
        game();
    }

    static Pokemon newPokemons() {
        String name = names[rand.nextInt(3)];
        int level = rand.nextInt(5)+1;
        int hp = rand.nextInt(30) + 10;
        int damage = rand.nextInt(7)+1;
        int mana = rand.nextInt(50)+15;

        return new Pokemon(name, level, hp, damage, mana);
    }
    public static void game(){
        Scanner scan = new Scanner(System.in);
        System.out.println(" ");
        enemyPokemon = pokemons.get(1);
        System.out.println("Enemy's pokemon name is: " + enemyPokemon.name);
        System.out.println("Enemy's pokemon level is: " + enemyPokemon.level);
        System.out.println("Enemy's pokemon hp value is: " + enemyPokemon.hp);
        System.out.printf("Enemy's pokemon deals " + enemyPokemon.damage + " damage%n");
        System.out.printf("Enemy's pokemon has " + enemyPokemon.mana + " mana%n");
        System.out.printf("%n////////////GAME STARTS///////////////");
        loop: while(true) {
            if(enemyPokemon.hp<=0 || yourPokemon.hp<=0){
                break loop;
            }
            System.out.printf("%nYourAction?%n1.Normal Attack(10 mana)%n2.Heavy Attack(30 mana)%n3.Healing(15 mana)%n");
            switch (scan.nextInt()) {
                case 1:
                    attacks.normalAttack(enemyPokemon, yourPokemon);
                    break;
                case 2:
                    attacks.heavyAttack(enemyPokemon, yourPokemon);
                    break;
                case 3:
                    attacks.healPokemon(yourPokemon);
                    break;
                case 99:
                    System.out.println("Ok");
                    break loop;
                default:
                    System.out.println("What blud choosing?\uD83D\uDC80");
            }
            if(enemyPokemon.hp<=0 || yourPokemon.hp<=0){
                if(enemyPokemon.hp <= 0){
                    System.out.println("////////////END/////////////");
                    System.out.println("////////////YOU WON/////////////");
                }
                else if(yourPokemon.hp <= 0){
                    System.out.println("////////////END/////////////");
                    System.out.println("////////////YOU LOST/////////////");
                }
                break loop;
            }
            enemyAttacking(enemyPokemon);

            enemyPokemon.mana += 5;
            yourPokemon.mana += 5;
            System.out.println("You have: " + yourPokemon.mana + " mana");
            System.out.println("Enemy has: " + enemyPokemon.mana + " mana");
        }
    }

    public static void enemyAttacking(Pokemon enemy){
        int randX = rand.nextInt(10)+1;
        if(enemy.mana > 30){
            if(randX < 4){
                attacks.heavyAttack(yourPokemon, enemy);
            }
            else{
                attacks.normalAttack(yourPokemon, enemy);
            }
        }
        else if (enemy.mana > 15){
            if(rand.nextInt(10)+1 > 5) {
                attacks.healPokemon(enemyPokemon);
            }
            else{
                attacks.normalAttack(yourPokemon, enemy);
            }
        }
        else{
            attacks.normalAttack(yourPokemon, enemy);
        }
    }
}