

package activationFunction;


public class LinearActivationFunction implements ActivationFunctionModel{
    
    private double a = 1;
    
    
    private double b = 0;
    
    
    public LinearActivationFunction() {
    }
    
    
    public void setParameteres(double[] paramateresList){
        a = paramateresList[0];
        b = paramateresList[1];
    }
    
    
    public double[] getParamateres(){
        double [] parameter = new double[2];
        parameter[0] = a;
        parameter[1] = b;
        return parameter;
    }
    
    public double getValue(double inputValue) {
        return a * inputValue + b;
    }
}
