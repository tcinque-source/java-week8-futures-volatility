import java.util.List;
import java.util.Random;

public class MonteCarloVolatility implements IVolatilityCalculator {
    public double computeVolatility(List prices) {
       
        double yesterday;
        double today;
        
        //ensures there is enough data to calculate returns
        if (prices.size() < 2) {
            System.out.println("insufficient price data");
            System.out.println("make sure text file is named and formatted correctly");
            System.out.println(" ");
            return Double.NaN;
        }
        
        //creates array of daily returns and finds standard deviaiton
        else {
        yesterday = Double.valueOf(prices.get(0).toString());
        today = Double.valueOf(prices.get(1).toString());
        double dailyReturns[] = new double[prices.size() - 1]; 
        for(int i = 0; i != dailyReturns.length; i++) {
            dailyReturns[i] = (today - yesterday) / yesterday;
            yesterday = today;
            if (i != dailyReturns.length - 1) { 
                today = Double.valueOf(prices.get(i + 2).toString());
            }
        }
        StandardDeviation std = new StandardDeviation();
        return std.standardDeviationPopulation(dailyReturns);
        }
    }
}