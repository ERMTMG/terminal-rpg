package trpg.game;

public class StatBlock {
    private int strength;
    public int getStrength() {
        return strength;
    }
    private int intelligence;
    public int getIntelligence() {
        return intelligence;
    }
    private int agility;
    public int getAgility() {
        return agility;
    }
    private int luck;
    public int getLuck() {
        return luck;
    }
    private int resistance;
    public int getResistance() {
        return resistance;
    }

    public StatBlock() {
        this.strength = 0;
        this.intelligence = 0;
        this.agility = 0;
        this.luck = 0;
        this.resistance = 0;
    }

    public StatBlock(int strength, int intelligence, int agility, int luck, int resistance) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.luck = luck;
        this.resistance = resistance;
    }

    public static StatBlock newFromStrength(int strength) {
        return new StatBlock(strength, 0, 0, 0, 0);
    }

    public static StatBlock newFromIntelligence(int intelligence) {
        return new StatBlock(0, intelligence, 0, 0, 0);
    }

    public static StatBlock newFromAgility(int agility) {
        return new StatBlock(0, 0, agility, 0, 0);
    }
    
    public static StatBlock newFromLuck(int luck) {
        return new StatBlock(0, 0, 0, luck, 0);
    }

    public static StatBlock newFromResistance(int resistance) {
        return new StatBlock(0, 0, 0, 0, resistance);
    }

    public void add(StatBlock increment) {
        this.strength += increment.strength;
        this.intelligence += increment.intelligence;
        this.agility += increment.agility;
        this.luck += increment.luck;
        this.resistance += increment.resistance;
    }

    public StatBlock combinedWith(StatBlock rhs) {
        return new StatBlock(
            this.strength + rhs.strength, 
            this.intelligence + rhs.intelligence, 
            this.agility + rhs.agility, 
            this.luck + rhs.luck, 
            this.resistance + rhs.resistance
        );
    }

    @Override 
    public String toString() {
        StringBuilder str = new StringBuilder()
            .append("[STR: ").append(this.strength).append(", ")
            .append("INT: ").append(this.intelligence).append(", ")
            .append("AGI: ").append(this.agility).append(", ")
            .append("LUC: ").append(this.luck).append(", ")
            .append("RES: ").append(this.resistance).append("]");
        return str.toString();
    }
}
