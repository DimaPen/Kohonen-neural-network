

package kohonen;

import javax.security.auth.kerberos.KerberosKey;
import learningFactorFunctional.LearningFactorFunctionalModel;
import metrics.MetricModel;
import java.util.ArrayList;
import network.NetworkModel;
import network.NeuronModel;
import network.TiredNeuronModel;



public class WTALearningFunctionWithTired extends WTALearningFunction{
    

    public WTALearningFunctionWithTired(NetworkModel networkModel,int maxIteration,MetricModel metrics,
            LearningDataModel learningData,LearningFactorFunctionalModel functionalModel) {
        super(networkModel,maxIteration,metrics,learningData,functionalModel);
    }
    
    

    protected int getBestNeuron(double[] vector){
        int bestNeuron = super.getBestNeuron(vector);
        TiredNeuronModel tempNeuron;
        int networkSize = networkModel.getNumbersOfNeurons();
        int tiredness;
        for(int i=0; i< networkSize; i++){
            tempNeuron = (TiredNeuronModel) networkModel.getNeuron(i);
            tiredness = tempNeuron.getTiredness();
            tempNeuron.setTiredness(++tiredness);
        }
        return bestNeuron;
    }
    

    
    protected void changeNeuronWeight(int neuronNumber, double[] vector, int iteration){
        super.changeNeuronWeight(neuronNumber,vector,iteration);
        
        TiredNeuronModel tempNeuron = (TiredNeuronModel) networkModel.getNeuron(neuronNumber);
        int tiredness = tempNeuron.getTiredness();
        tempNeuron.setTiredness(tiredness - 2); 
    }
}
