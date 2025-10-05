package trpg;
import trpg.game.*;;

public class Main {
    public static void main(String[] args) throws Exception {
        PlayerCharacter character = new Warrior("John");
        System.out.println(character.name);
    }
}
