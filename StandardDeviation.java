public class StandardDeviation {

public double standardDeviationPopulation(double[] dataset) {
    double sum = 0.0;
    double std = 0.0;
        
    for (double n: dataset) {
        sum += n;
    }
        
    double mean = sum/dataset.length;
        
    for (double n: dataset) {
        std += ((n-mean)*(n-mean));
    }
    return Math.sqrt(std/dataset.length);
}
}