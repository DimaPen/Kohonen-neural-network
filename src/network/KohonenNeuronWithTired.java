

package network;

import activationFunction.ActivationFunctionModel;


public class KohonenNeuronWithTired extends KohonenNeuron implements TiredNeuronModel{


    int tiredness = 10;
    

    public KohonenNeuronWithTired(int weightNumber, double[] maxWeight, ActivationFunctionModel activationFunction) {
        super(weightNumber,maxWeight,activationFunction);
    }
    
    

    public KohonenNeuronWithTired(double[] weightArray,ActivationFunctionModel activationFunction) {
        super(weightArray,activationFunction);
    }
    
    

    public void setTiredness(int tiredness){
        this.tiredness = tiredness;
    }
    

    public int getTiredness(){
        return this.tiredness;
    }
}
