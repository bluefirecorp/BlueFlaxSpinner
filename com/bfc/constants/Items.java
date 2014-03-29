
package com.bfc.constants;

/**
 * @package com.bfc.constants
 * @class Items
 * @version 1.0
 * @author bluefirecorp
 * @date Mar 29, 2014
 */
public enum Items {
    FLAX(1779, "Flax", true, false, true, false, false, 3, 2, "Drop", -1, 25000, "I should use this with a spinning wheel.", 0.4),
    BOWSTRING(1777, "Bowstring", false, false, true, false, false, 60, 40, "Drop", 100, 10000, "I need a bow stave to attach this to.", 0.0);
    
    private int itemID;
    
    private String itemName;
    
    private boolean isMembers;
    private boolean isQuestItem;
    private boolean isTradeable;
    private boolean isEquipable;

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isIsMembers() {
        return isMembers;
    }

    public boolean isIsQuestItem() {
        return isQuestItem;
    }

    public boolean isIsTradeable() {
        return isTradeable;
    }

    public boolean isIsEquipable() {
        return isEquipable;
    }

    public boolean isIsStackable() {
        return isStackable;
    }

    public int getHighAlch() {
        return highAlch;
    }

    public int getLowAlch() {
        return lowAlch;
    }

    public String getDestroyText() {
        return destroyText;
    }

    public int getBuyLimit() {
        return buyLimit;
    }

    public String getExamineText() {
        return examineText;
    }

    public double getWeight() {
        return weight;
    }

    public int getStorePrice() {
        return storePrice;
    }
    
    private boolean isStackable;
    
    private int highAlch;
    private int lowAlch;
    
    private String destroyText;
    
    private int buyLimit;
    private String examineText;
    
    private double weight;
    
    private int storePrice;
    
    private Items(int itemID, String itemName, boolean isMembers, boolean isQuestItem,
            boolean isTradeable, boolean isEquipable, boolean isStackable,
            int highAlch, int lowAlch, String destroyText, int storePrice,
            int buyLimit, String examineText, double weight) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.isMembers = isMembers;
        this.isQuestItem = isQuestItem;
        this.isTradeable = isTradeable;
        this.isEquipable = isEquipable;
        this.isStackable = isStackable;
        this.highAlch = highAlch;
        this.lowAlch = lowAlch;
        this.destroyText = destroyText;
        this.buyLimit = buyLimit;
        this.examineText = examineText;
        this.weight = weight;
        this.storePrice = storePrice;
    }
}
