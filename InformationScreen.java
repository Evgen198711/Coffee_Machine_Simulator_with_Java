package machine;

import java.util.Scanner;

public class InformationScreen {

    Scanner sc = new Scanner(System.in);

    CoffeeRecipe espresso;
    CoffeeRecipe latte;
    CoffeeRecipe cappuccino;

    Ingredients coffeeMachine;

    public InformationScreen() {
        this.espresso = new CoffeeRecipe(4, 250, 0, 16);
        this.latte = new CoffeeRecipe(7, 350, 75, 20);
        this.cappuccino =  new CoffeeRecipe(6, 200, 100, 12);
        this.coffeeMachine = new Ingredients();

    }

    public void start() {

    mainMenu();


    }

    public void mainMenu () {

      loop : while(true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String input = sc.nextLine();

            switch (input) {
                case "buy":
                    buyMenu();
                    break;
                case "fill":
                    fillMenu();
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.printStatus();
                    break;
                case "exit":
                    break loop;
            }
        }
    }

    private void buyMenu () {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String option = sc.nextLine();

        switch(option) {
            case "1":
                coffeeMachine.buy(espresso);
                break;
            case "2":
                coffeeMachine.buy(latte);
                break;
            case "3":
                coffeeMachine.buy(cappuccino);
                break;
            default:
                System.out.println("Invalid enter");
        }

    }

    private void fillMenu () {
        System.out.println("Write how many ml of water you want to add: ");
        int water = Integer.parseInt(sc.nextLine());

        System.out.println("Write how many ml of milk you want to add: ");
        int milk = Integer.parseInt(sc.nextLine());

        System.out.println("Write how many grams of coffee beans you want to add: ");
        int beans = Integer.parseInt(sc.nextLine());

        System.out.println("Write how many disposable cups you want to add: ");
        int cups = Integer.parseInt(sc.nextLine());

        coffeeMachine.fill(water, milk, beans, cups);
    }
}
