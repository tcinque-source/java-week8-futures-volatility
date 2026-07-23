import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract class FutureContract implements IVolatilityCalculator {
    String name;
    double underlyingPrice;
    double optionPrice;
    double timeToExpiration; //time is in years
     //parameterized constructor
    public FutureContract(String name, double underlyingPrice, double optionPrice, double timeToExpiration) {
        this.name = name;
        this.underlyingPrice = underlyingPrice;
        this.optionPrice = optionPrice;
        this.timeToExpiration = timeToExpiration;  //time is in years
    }
    //copy constructor
    public FutureContract(FutureContract copy) {
        this.name = copy.name;
        this.underlyingPrice = copy.underlyingPrice;
        this.optionPrice = copy.optionPrice;
        this.timeToExpiration = copy.timeToExpiration;  //time is in years
    }
    
    public abstract double computeImpliedVolatility();
    
    ArrayList<Double> prices = new ArrayList<Double>();
    public void loadPricesFromFile(String filename) {
        
        double histPrice;
        try {
            String line;
            BufferedReader inputStream = new BufferedReader(new FileReader(filename));
            line = inputStream.readLine();
            while (line != null) {
                //store line to array index
                histPrice = Double.parseDouble(line); 
                prices.add(histPrice); 
                line = inputStream.readLine(); //read at the end so it knows to stop before it starts
            }
            
            inputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(filename + " could not be found or could not be opened.");
        }
        catch(IOException e) {
            System.out.println("Error reading " + filename);
        }
        
    }
    
    public ArrayList getPrices() {
        return this.prices;
    }

    public void displayContract() {
        System.out.println(name);
        System.out.println("Underlying Price: $" + underlyingPrice); //format for currency
        System.out.println("Option Price: $" + optionPrice); //format for currency
        System.out.println("Time to Expiratation: " + timeToExpiration + " years");
    }
}
