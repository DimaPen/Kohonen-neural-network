

package metrics;



public class CityBlockMetric implements MetricModel{
    

    public CityBlockMetric() {
    }
    

    public double getDistance(double[] firstVector, double[] secondVector){
        double distance = 0;
        double x = 0, w = 0;
        int weightLenght = firstVector.length;
        
        if(firstVector.length != secondVector.length)
            return -1;
        
        for(int i=0; i< weightLenght; i++){
            w = firstVector[i]; 
            x = secondVector[i];
            distance += Math.abs(x - w);
        }
        return distance;
    }
}
