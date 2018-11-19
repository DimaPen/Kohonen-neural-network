

package network;


import activationFunction.ActivationFunctionModel;
import java.util.Random;
import activationFunction.*;


public class DefaultNeuronWithBias implements NeuronModel {
    

    private double bias = 0;

    private double[] weight;
    

    private ActivationFunctionModel activationFunction;
    
   

    public DefaultNeuronWithBias(int weightNumber, double[] maxWeight, ActivationFunctionModel activationFunction) {
        if(weightNumber == maxWeight.length){
            Random rand = new Random();
            weight = new double[weightNumber];
            for(int i=0; i< weightNumber; i++){
                weight[i] = rand.nextDouble() * maxWeight[i];
            }
        }
        this.activationFunction = activationFunction;
    }
    

    public DefaultNeuronWithBias(double[] weightArray,ActivationFunctionModel activationFunction){
        int weightSize = weightArray.length;
        weight = new double[weightSize];
        for(int i=0; i< weightSize; i++){
            weight[i] = weightArray[i];
        }
        this.activationFunction = activationFunction;
    }


    public double[] getWeight() {
        return weight.clone();
    }


    public void setWeight(double[] weight) {
        for (int i=0; i < weight.length; i++ ){
            this.weight[i] = weight[i]; 
        }
    }


    public double getValue(double[] inputVector) {
        double value = 0;
        int inputSize = inputVector.length;
        
        for(int i=0; i< inputSize; i++){
            value = value + inputVector[i] * weight[i];
        }
        
        if( activationFunction != null)
            return activationFunction.getValue(value) - bias;
        else
            return value - bias;
    }


    public double getBias() {
        return bias;
    }
 

    public void setBias(double bias) {
        this.bias = bias;
   }


    public ActivationFunctionModel getActivationFunction() {
        return activationFunction;
    }

    

    public void setActivationFunction(ActivationFunctionModel activationFunction) {
        this.activationFunction = activationFunction;
    }
    
}
