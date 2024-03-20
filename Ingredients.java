package machine;

public class Ingredients {

    private int money;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;

    public Ingredients() {
        this(550, 400, 540, 120, 9);
    }
    public Ingredients (int money, int water, int milk, int coffeeBeans, int cups) {
        this.money = money;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
    }

    public void buy(CoffeeRecipe type) {
        buy(type, 1);
    }

    public void buy(CoffeeRecipe type, int cups) {
        boolean status = true;

        if(maxCanMake(type) < cups) {
            return;
        }
        this.money += type.price();

        if(this.water >= type.water()) {

            this.water -= type.water();
        } else {
            System.out.println("Sorry, not enough water!");
            status = false;
        }

        if(this.milk >= type.milk()) {
            this.milk -= type.milk();
        } else {
            System.out.println("Sorry, not enough milk!");
            status = false;
        }

        if(this.coffeeBeans >= type.coffeeBeans()) {
            this.coffeeBeans -= type.coffeeBeans();
        } else {
            System.out.println("Sorry, not enough coffee beans!");
            status = false;
        }

        if(this.cups > cups) {
            this.cups -= cups;
        } else {
            System.out.println("Sorry, not enough cups!");
            status = false;
        }


        if(status) {
            System.out.println("I have enough resources, making you a coffee!\n");
        }
    }

    public void fill(int water, int milk, int coffeeBeans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += coffeeBeans;
        this.cups += cups;
    }

    public void take() {
        System.out.println("I gave you " + this.money);
        this.money = 0;
    }

    private int maxCanMake(CoffeeRecipe type) {
        int maxCupsWater = this.water / type.water();
        int maxMilk = maxCupsWater;
        try {
            maxMilk = this.milk / type.milk();
        } catch (ArithmeticException e) {}

        int maxCoffeeBeans = this.coffeeBeans / type.coffeeBeans();
        return Math.min(Math.min(maxCupsWater, maxMilk), Math.min(maxCoffeeBeans, this.cups));
    }

    public void printStatus() {

        String info = "\nThe coffee machine has:\n" +
                this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.coffeeBeans + " g of coffee beans\n" +
                this.cups + " disposable cups\n" +
                "$" + this.money + " of money\n";

        System.out.println(info);
    }
}
