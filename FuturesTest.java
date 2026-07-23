import java.util.ArrayList;

public class FuturesTest {
    public static void main(String[] args) {
        
        //gold contract
        GoldFuture goldTest = new GoldFuture();
        goldTest.loadPricesFromFile("goldPrices.txt");
        ArrayList goldPrices = goldTest.getPrices();
        goldTest.displayContract();
        System.out.println("Volatility: " + goldTest.computeVolatility(goldPrices));
        System.out.println(" ");
        
        //coffee contract
        CoffeeFuture coffeeTest = new CoffeeFuture();
        coffeeTest.loadPricesFromFile("coffeePrices.txt");
        ArrayList coffeePrices = coffeeTest.getPrices();
        coffeeTest.displayContract();
        System.out.println("Volatility: " + coffeeTest.computeVolatility(coffeePrices));
        System.out.println(" ");
        
        //copper contract
        CopperFuture copperTest = new CopperFuture();
        copperTest.loadPricesFromFile("copperPrices.txt");
        ArrayList copperPrices = copperTest.getPrices();
        copperTest.displayContract();
        System.out.println("Volatility: " + copperTest.computeVolatility(copperPrices));
        System.out.println(" ");
    }
}