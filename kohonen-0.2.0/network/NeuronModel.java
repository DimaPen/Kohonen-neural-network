

package network;

import activationFunction.ActivationFunctionModel;
import java.util.Random;
import metrics.MetricModel;
import activationFunction.*;


public interface NeuronModel{
    

     public double[] getWeight();
    

     public void setWeight(double[] weight);
    

    public double getValue(double[] inputVector);

}
