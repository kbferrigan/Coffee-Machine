package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int beans;
    private int water;
    private int milk;
    private int cups;
    private int money;

    private Scanner scan;
    public CoffeeMachine(){
        beans = 120;
        water = 400;
        milk = 540;
        cups = 9;
        money = 550;
        scan = new Scanner(System.in);
    }

    private void cupsCalc() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many cups of coffee?");
        int cups = scan.nextInt();
        System.out.println("For " + cups + " Cups you will need:");
        System.out.println(cups * 200 +"ml of water");
        System.out.println(cups * 50 +"ml of milk");
        System.out.println(cups * 15 +"g of coffee beans");

        scan.nextLine(); //get rid of \n
    }

    private void servingsCalc() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterPortions = (scan.nextInt()/200);
        System.out.println( "Write how many ml of milk the coffee machine has: ");
        int milkPortions = (scan.nextInt()/50);
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beansPortions = (scan.nextInt()/15);
        System.out.println("Write how many cups of coffee you will need: ");
        int coffeeCups = scan.nextInt();
        int maxCups = 0;

        while (waterPortions != 0 && milkPortions != 0 && beansPortions != 0) {
            waterPortions--;
            milkPortions--;
            beansPortions--;
            maxCups++;
        }

        int result = maxCups-coffeeCups;
        if(result < 0) { //not enough cups
            System.out.println("No, I can only make "+ maxCups +"cup(s) of coffee");
        } else {
            if (result==0) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even "+ result +" more than that)");
            }
        }
        scan.nextLine(); //get rid of \n
    }

    private void state(){
        System.out.println(
                "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$"+money+" of money"
        );
    }
    private void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        switch(scan.next()){
            case "1"://expresso - 250ml water, 16g beans, $4
                if (water >= 250 && beans >= 16){
                    water = water - 250;
                    beans = beans - 16;
                    cups--;
                    money = money + 4;
                } else {
                    System.out.println("Not enough resources");
                }
                break;

            case "2"://latte - 350 ml water, 75ml milk, 20g beans, $7
                if (water >= 350 && milk >= 75 && beans >= 20){
                    water = water - 350;
                    milk = milk - 75;
                    beans = beans - 20;
                    cups--;
                    money = money + 7;
                } else {
                    System.out.println("Not enough resources");
                }
                break;

            case "3"://cappuccino - 200ml water, 100ml milk, 12g beans, $6
                if (water >= 200 && milk >= 100 && beans >= 12){
                    water = water - 200;
                    milk = milk - 100;
                    beans = beans - 12;
                    cups--;
                    money = money + 6;
                } else {
                    System.out.println("Not enough resources");
                }
                break;

            case "back":
                return;

            default:
                System.out.println("Not an option");
                break;
        }
        scan.nextLine(); //get rid of \n
    }
    private void fill(){
        System.out.println("Write how many ml of water you want to add: ");
        water = water + scan.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk = milk + scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans = beans + scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups = cups + scan.nextInt();
        scan.nextLine(); //get rid of \n
    }
    private void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }
    private void actions(){
        boolean exit = false;
        while (exit == false){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            switch(scan.nextLine()){
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    state();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        CoffeeMachine machine1 = new CoffeeMachine();
        machine1.actions();
    }
}
