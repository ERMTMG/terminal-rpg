package trpg;
import trpg.game.*;;

public class Main {
    public static void main(String[] args) throws Exception {
        PlayerCharacter character = new Warrior("John");
        System.out.println(character);
        character.takeDamage(5);
        character.gainExp(100);
        System.out.println(character);
        character.gainExp(1000);
        System.out.println(character);
        assert(character.takeDamage(100) == true);
        System.out.println("Assert passed!");
    }
}
