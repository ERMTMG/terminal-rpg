package trpg.game;

import java.util.HashMap;

class ItemInformation {
    public final String defaultName;
    public final boolean container;
    public final boolean stackable;
    public final boolean equippable;
    public final int containerCapacity;

    public ItemInformation(String defaultName, boolean container, boolean stackable, boolean equippable, int containerCapacity) {
        this.defaultName = defaultName;
        this.container = container;
        this.stackable = stackable;
        this.equippable = equippable;
        this.containerCapacity = containerCapacity;
    }
}

public class Item {
    private final int itemID;
    private String name;
    private int count;
    private static final HashMap<Integer, ItemInformation> ITEM_DEFAULT_INFOS = new HashMap<>();

    public boolean canBeContained() { return true; }
    public boolean isStackable() { return true; }
    
    public Item(int id, int count, String name) {
        this.itemID = id;
        this.count = count;
        if (name == null) {
            ItemInformation info = ITEM_DEFAULT_INFOS.get(id);
            if (info != null) {
                this.name = info.defaultName;
            }
        } else {
            this.name = name;
        }
    }
    
    public Item(int id, int count) {
        this(id, count, null);
    }

    public Item(int id, String name) {
        this(id, 1, name);
    }

    public Item(int id) {
        this(id, 1, null);
    }

    public static void initializeItemNameHashMap() { /* TODO: this */ }

    public boolean sameTypeAs(Item other) {
        return this.itemID == other.itemID;
    }

    public String name() {
        return this.name;
    }

    public void rename(String newName) {
        if (newName != null && !newName.isBlank()) {
            this.name = newName;
        } else {
            ItemInformation info = ITEM_DEFAULT_INFOS.get(this.itemID);
            if (info != null) {
                this.name = info.defaultName;
            }
        }
    }
    
    public void add(int amount) {
        if(isStackable()) {
            this.count += amount;
        }
    }

    public boolean remove(int amount) {
        if(amount > this.count) {
            return false;
        } else {
            this.count -= amount;
            return true;
        }
    }

    public boolean ranOut() {
        return (this.count == 0);
    }
}
