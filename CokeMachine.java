/*
 * Aryan Mainkar 1001844964
 */
package code3_1001844964;

/**
 *
 * @author Aryan
 */
public class CokeMachine {
    private String MachineName;
    private int changeLevel;
    private int maxChangeCapacity = 5000;
    private int inventoryLevel;
    private int maxInventoryCapacity = 100;
    private int CokePrice; // What is coke price??
    private int changeDispensed;
    private static int numberOfCokesSold = 0;

    public String toString() {

        return String.format(
                "\n\nMachine Name \t\t %s \nCurrent Inventory\t %d\nCurrent Change Level\t %d\nLast Change Dispensed\t %d\nInventory Capacity\t %d\nChange Capacity\t\t %d\nCoke Price\t\t %d\nCokes Sold\t\t %d\n",
                getMachineName(), getInventoryLevel(), getChangeLevel(), getChangeDispensed(),
                getMaxInventoryLevel(),
                getMaxChangeCapacity(), getCokePrice(), getNumberOfCokesSold());

    }

    public enum ACTION {
        DISPENSECHANGE, INSUFFICIENTCHANGE, INSUFFICIENTFUNDS, EXACTPAYMENT, NOINVENTORY, MAXCHANGELEVEL, OK;
    }

    public CokeMachine(String name, int cost, int change, int inventory) {
        MachineName = name;
        changeLevel = change;
        inventoryLevel = inventory;
        CokePrice = cost;

    }

    public String getMachineName() {
        return MachineName;
    }

    public int getChangeLevel() {
        return changeLevel;
    }

    public int getMaxChangeCapacity() {
        return maxChangeCapacity;
    }

    public int getInventoryLevel() {
        return inventoryLevel;
    }

    public int getMaxInventoryLevel() {
        return maxInventoryCapacity;
    }

    public int getCokePrice() {
        return CokePrice;
    }

    public int getChangeDispensed() {
        return changeDispensed;
    }

    public int getNumberOfCokesSold() {
        return numberOfCokesSold;
    }

    public boolean incrementInventoryLevel(int levelToAdd) {
        if (levelToAdd + getInventoryLevel() > getMaxInventoryLevel()) {
            return false;
        } else {
            inventoryLevel += levelToAdd;
            return true;
        }
    }

    public boolean incrementChangeLevel(int amountToAdd) {
        if (amountToAdd + getChangeLevel() > getMaxChangeCapacity()) {
            return false;
        } else {
            changeLevel += amountToAdd;
            return true;
        }
    }

    public ACTION buyACoke(int Payment) {
        ACTION action = ACTION.OK;

        if (getInventoryLevel() == 0) {
            action = ACTION.MAXCHANGELEVEL;
        }

        if (getInventoryLevel() != 0) {

            if (getChangeLevel() == getMaxChangeCapacity()) {
                action = ACTION.MAXCHANGELEVEL;
            }

            if (getChangeLevel() < Payment && getChangeLevel() != getMaxChangeCapacity()) {
                action = ACTION.INSUFFICIENTCHANGE;
            }

            if (Payment < getCokePrice()) {
                action = ACTION.INSUFFICIENTFUNDS;
            }

            if (getChangeLevel() != getMaxChangeCapacity() && Payment == getCokePrice()) {
                inventoryLevel--;
                numberOfCokesSold++;
                action = ACTION.EXACTPAYMENT;
            }

            if (getChangeLevel() != getMaxChangeCapacity() && Payment > getCokePrice() && Payment < getChangeLevel()) {
                inventoryLevel--;
                numberOfCokesSold++;
                changeDispensed = Payment - getCokePrice();
                action = ACTION.DISPENSECHANGE;
            }
        }
        return action;
    }
}
