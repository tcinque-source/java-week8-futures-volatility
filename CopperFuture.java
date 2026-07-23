import java.util.ArrayList;
import java.util.List;

class CopperFuture extends FutureContract {
    public CopperFuture() {
        super("Copper", 50.0, 35.0, 2.0); //name underlyingPrice, optionPrice, timeToExpiration
    }
    @Override 
    public double computeImpliedVolatility() { //no super for this method
        return Math.random();
    }
    @Override
    public double computeVolatility(List prices) {
        MonteCarloVolatility copperVolatility = new MonteCarloVolatility();
        return copperVolatility.computeVolatility(prices);
    }
}