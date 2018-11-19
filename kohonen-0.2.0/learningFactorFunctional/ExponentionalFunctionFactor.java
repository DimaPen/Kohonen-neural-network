

package learningFactorFunctional;


public class ExponentionalFunctionFactor implements LearningFactorFunctionalModel{
   
    private double n0;
    
    
    private double c;
    
    

    public ExponentionalFunctionFactor(double n0, double c) {
        this.n0 = n0;
        this.c = c;
    }
    

    
    public double[] getParameters(){
        double[] parameters = new double[2];
        parameters[0] = n0;
        parameters[1] = c;
        return parameters;
    }
    

    public void setParameters(double[] parameters){
        n0 = parameters[0];
        c = parameters[1];
    }
    

    public double getValue(int k){
        return n0*java.lang.Math.exp(-c*k);
    }
}
