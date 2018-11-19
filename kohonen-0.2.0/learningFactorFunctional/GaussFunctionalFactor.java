

package learningFactorFunctional;



public class GaussFunctionalFactor implements LearningFactorFunctionalModel{
    
    private double r;   //radius
    

    public double[] getParameters(){
        double[] paremateres = new double[1];
        paremateres[0] = r;
        return paremateres;    
    }
    

    public void setParameters(double[] parameters){
        r = parameters[0];
    }
    

    public double getValue(int k){
       return java.lang.Math.exp(-(java.lang.Math.pow(k,2))/ (2 * r * r ));
    }
}
