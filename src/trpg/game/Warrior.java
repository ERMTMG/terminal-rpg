package trpg.game;

public class Warrior extends PlayerCharacter {
    @Override
    public int getBaseHealth() { return 10; }

    @Override
    public int getBaseMana() { return 0; }

    @Override
    public StatBlock getBaseStats() {
        return new StatBlock(5, 2, 2, 3, 3);
    }

    public Warrior() { super(); }
    public Warrior(String name) { super(name); }
}
