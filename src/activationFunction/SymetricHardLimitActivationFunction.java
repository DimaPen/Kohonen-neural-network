

package activationFunction;


public class SymetricHardLimitActivationFunction implements ActivationFunctionModel{
    
    
    private double p = 0;
    
   
    public SymetricHardLimitActivationFunction(double p) {
        this.p = p;
    }
    
    
    public void setParameteres(double[] paramateresList){
        p = paramateresList[0];
    }
    
   
    public double[] getParamateres(){
        double [] parameter = new double[1];
        parameter[0] = p;
        return parameter;
    }

    
    public double getValue(double inputValue) {
        double value;
        if (inputValue > p)
            return 1;
        else
            return -1;
    }
}
