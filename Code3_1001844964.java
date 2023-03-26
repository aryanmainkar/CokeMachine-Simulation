
package code3_1001844964;

/**
 *
 * @author Aryan
 */
import java.util.Scanner;

import code3_1001844964.CokeMachine.ACTION;

public class Code3_1001844964 {

    /**
     * @param args the command line arguments
     */

    public static String displayMoney(int money) {
        String strMoney;
        String moneyQ = String.valueOf(money / 100);
        String moneyD = String.valueOf(money % 100);
        strMoney = "$" + moneyQ + "." + (moneyD.length() == 1 ? "0" : "") + moneyD;

        return strMoney;
    }

    public static int CokeMenu() {
        int choice = 0;

        Scanner in = new Scanner(System.in);

        do {
            if (choice < 0 || choice > 3) {
                System.out.println("\n\nInvalid Menu Choice. Please choose again.");
            }

            System.out
                    .print("\n\n0. Walk away\n1. Buy a Coke\n2. Restock Machine\n3. Add change\n4. Display Machine Info");

            System.out.print("\n\nChoice? ");

            try {
                choice = in.nextInt();
            }

            catch (Exception e) {
                choice = -1;
                in.nextLine();
            }
        } while (choice < 0 || choice > 4);

        return choice;
    }

    public static void main(String[] args) {
        int choice = -1;
        int userpayment = 0;
        int restock = 0;
        int useraddchange = 0;
        Scanner in = new Scanner(System.in);
        boolean success = false;

        CokeMachine MyCokeMachine = new CokeMachine("CSE 1325 Coke Machine", 5, 50, 0);
        ACTION action = ACTION.OK;

        while (choice != 0) {
            System.out.printf("\n\n\n%s\n\n", MyCokeMachine.getMachineName());
            choice = CokeMenu();

            switch (choice) {

                case 0:
                    if (choice == 0) {
                        if (MyCokeMachine.getNumberOfCokesSold() == 0) {
                            System.out.print("Are you sure you aren't really THIRSTY and need a Coke?");
                        } else {
                            System.out.print("Bye - enjoy your Coke");
                        }

                    }
                    break;

                case 1:

                    System.out.printf("A coke costs %s\n", displayMoney(MyCokeMachine.getCokePrice()));
                    System.out.printf("\nInsert payment ");
                    userpayment = in.nextInt();
                    System.out.print("\n\n");
                    action = MyCokeMachine.buyACoke(userpayment);

                    switch (action) {
                        case INSUFFICIENTFUNDS:
                            System.out.print("Insufficient payment...returning your payment");
                            break;

                        case EXACTPAYMENT:
                            MyCokeMachine.getInventoryLevel();
                            MyCokeMachine.incrementChangeLevel(MyCokeMachine.getCokePrice());
                            System.out.print("Thank you for exact payment.\nHere's your coke");
                            break;

                        case DISPENSECHANGE:
                            MyCokeMachine.incrementChangeLevel(MyCokeMachine.getCokePrice());
                            System.out.printf("Here's your coke and your change of %s",
                                    displayMoney(MyCokeMachine.getChangeDispensed()));
                            break;

                        case INSUFFICIENTCHANGE:
                            System.out.println(
                                    "Unable to give change at this time...returning your payment");
                            break;

                        case MAXCHANGELEVEL:
                            System.out.println("Unable to sell Coke - call 1800WEDONTCARE to register a complaint.");

                    }
                    break;

                case 2:
                    System.out.print("How much product are you adding to the machine? ");
                    restock = in.nextInt();
                    success = MyCokeMachine.incrementInventoryLevel(restock);

                    if (success == false) {
                        System.out.print(
                                "\n\nYou have exceeded your machine's max capacity - no inventory was added\n\n");
                        System.out.printf("Your inventory level is %s",
                                MyCokeMachine.getInventoryLevel());
                    }

                    else {
                        System.out.print("\n\nYour machine has been restocked");
                        System.out.printf("\n\nYour inventory level is %s",
                                MyCokeMachine.getInventoryLevel());
                    }
                    break;

                case 3:
                    System.out.printf("How much change are you adding to the machine? ");
                    useraddchange = in.nextInt();
                    success = MyCokeMachine.incrementChangeLevel(useraddchange);

                    if (success == false) {
                        System.out.print("\n\nYou have exceeded your machine's max capacity - no change added");
                        System.out.printf("\nYour change level is %s with a max capacity of %s",
                                displayMoney(MyCokeMachine.getChangeLevel()),
                                displayMoney(MyCokeMachine.getMaxChangeCapacity()));
                    } else {
                        System.out.print("\n\nYour change level has been updated.\n\n");
                        System.out.printf("Your change level is %s with a max capacity of %s",
                                displayMoney(MyCokeMachine.getChangeLevel()),
                                displayMoney(MyCokeMachine.getMaxChangeCapacity()));
                    }

                    break;

                case 4:
                    System.out.println(MyCokeMachine);
                    break;
            }

        }

    }

}
