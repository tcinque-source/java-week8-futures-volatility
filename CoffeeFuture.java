import java.util.ArrayList;
import java.util.List;

class CoffeeFuture extends FutureContract {
    public CoffeeFuture() {
        super("Coffee", 30.0, 20.0, 1.0); //name underlyingPrice, optionPrice, timeToExpiration
    }
    @Override 
    public double computeImpliedVolatility() { //no super for this method
        return Math.random();
    }
    @Override
    public double computeVolatility(List prices) {
        MonteCarloVolatility coffeeVolatility = new MonteCarloVolatility();
        return coffeeVolatility.computeVolatility(prices);
    }
}