

package learningFactorFunctional;



public class LinearFunctionalFactor implements LearningFactorFunctionalModel {
    private double n0;
    
    private double maxIteration;

    
    public LinearFunctionalFactor(double n0, double maxIteration) {
        this.n0 = n0;
        this.maxIteration = maxIteration;
    }
    

     public double[] getParameters(){
         double[] parameters= new double[2];
         parameters[0] = n0;
         parameters[1] = maxIteration;
        return parameters;    
    }
    

    public void setParameters(double[] parameters){
        n0 = parameters[0];
        maxIteration = parameters[1];
    }
    

    public double getValue(int k){
        return (n0/maxIteration)*(maxIteration-k); 
    }
}

