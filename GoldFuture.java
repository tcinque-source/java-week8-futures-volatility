import java.util.ArrayList;
import java.util.List;

class GoldFuture extends FutureContract {
    
    
    public GoldFuture() {
        super("Gold", 100.0, 70.0, 3.0); //name underlyingPrice, optionPrice, timeToExpiration
        
    }
    @Override 
    public double computeImpliedVolatility() { //no super for this method
    //    System.out.println("Computing Gold...");
        return Math.random();
    }
    
    
    @Override
    public double computeVolatility(List prices) {
        MonteCarloVolatility goldVolatility = new MonteCarloVolatility();
        return goldVolatility.computeVolatility(prices);
    }
    //Copy constructor
    public GoldFuture(GoldFuture copy) {
        super(copy);
    }
}
