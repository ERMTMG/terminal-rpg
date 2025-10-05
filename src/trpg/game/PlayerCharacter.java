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
    }

    public PlayerCharacter() { this("Player"); }

    public void takeDamage(int amount) {
        this.health.decrease(amount);
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
}
