package trpg.game;


public abstract class PlayerCharacter {
    public final String name;
    protected PointBar health;
    protected PointBar mana;
    protected PointBar experience;
    protected int currLevel;
    StatBlock stats;

    public abstract int getBaseHealth();
    public abstract int getBaseMana();
    public abstract StatBlock getBaseStats();
    public abstract String getClassName();

    public PlayerCharacter(String name) {
        final int BASE_EXP_NECESSARY = 100;

        this.name = name;
        this.health = new PointBar(getBaseHealth());
        int manaValue = getBaseMana();
        if(manaValue != 0) {
            this.mana = new PointBar(manaValue);
        } else {
            this.mana = null;
        }
        this.stats = getBaseStats();
        this.experience = PointBar.newEmpty(BASE_EXP_NECESSARY);
        this.currLevel = 1;
    }

    public PlayerCharacter() { this("Player"); }

    public boolean takeDamage(int amount) {
        int pointsBelow = this.health.decrease(amount);
        return (pointsBelow > 0);
    }

    public void heal(int amount) {
        this.health.increase(amount);
    }

    public void consumeMana(int amount) {
        if(this.mana != null) {
            this.mana.decrease(amount);
        }
    }

    public void restoreMana(int amount) {
        if(this.mana != null) {
            this.mana.increase(amount);
        }
    }

    public int getHealth() {
        return health.value();
    }

    public int getMaxHealth() {
        return health.getMaxValue();
    }

    public int getMana() {
        return mana == null ? 0 : mana.value();
    }

    public int getMaxMana() {
        return mana == null ? 0 : mana.getMaxValue();
    }

    protected void levelUp() {
        this.currLevel++;
        int previousExpCap = this.experience.getMaxValue();
        this.experience.setMaxAndReset(previousExpCap + (previousExpCap >> 3));
    }

    public boolean gainExp(int amount) {
        int overfill = this.experience.increase(amount);
        if (overfill > 0 || this.experience.isFull()) {
            levelUp();
            gainExp(overfill);
            return true;
        }
        return false;
    }

    public int getLevel() {
        return currLevel;
    }

    public int getStrength() {
        return stats.getStrength();
    }

    public int getIntelligence() {
        return stats.getIntelligence();
    }

    public int getAgility() {
        return stats.getAgility();
    }

    public int getLuck() {
        return stats.getLuck();
    }

    public int getResistance() {
        return stats.getResistance();
    }

    public StatBlock getStats() {
        return this.stats;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.name)
            .append(" (Level ").append(currLevel).append(" ").append(this.getClassName())
            .append(") {\n")
            .append("\tHP: ").append(this.health).append("\n");
        if (mana != null) {
            str.append("\tMP: ").append(this.mana).append('\n');
        }
            str.append("\tStatis: ").append(this.stats).append('\n')
            .append("\tExperience: ").append(this.experience).append('\n')
            .append('}');
        return str.toString();
    }
}
