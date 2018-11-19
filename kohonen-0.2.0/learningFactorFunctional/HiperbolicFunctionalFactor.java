

package learningFactorFunctional;


public class HiperbolicFunctionalFactor implements LearningFactorFunctionalModel{
    private double c1;
    
    private double c2;
    

    public HiperbolicFunctionalFactor(double c1, double c2) {
        this.c1 = c1;
        this.c2 = c2;
    }
    

    public double[] getParameters(){
        double[] parameters = new double[2];
        parameters[0] = c1;
        parameters[1] = c2;
        return parameters;
    }
    

    public double getValue(int k){
        return c1/(c2 + k);
    }
}
