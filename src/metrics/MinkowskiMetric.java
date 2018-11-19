

package metrics;



public class MinkowskiMetric implements MetricModel{
    

    private double p = 1;
    

    public MinkowskiMetric(double p) {
        this.p = p;
    }
    

    public void setParameteres(double[] paramateresList) {
        p = paramateresList[0];
    }


    public double[] getParamateres() {
        double [] parameter = new double[1];
        parameter[0] = p;
        return parameter;
    }
    

    public double getDistance(double[] firstVector, double[] secondVector) {
        double distance = 0;
        double x = 0, w = 0;
        double sum = 0;
        int weightLenght = firstVector.length;
        
        if(firstVector.length != secondVector.length)
            return -1;
        
        for(int i=0; i< weightLenght; i++){
            w = firstVector[i]; 
            x = secondVector[i];
            sum +=Math.pow(Math.abs(x - w),p);
        }
        distance = Math.pow(sum,1/p);
        return distance;
    }
}


