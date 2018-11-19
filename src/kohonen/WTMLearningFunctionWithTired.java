


package kohonen;

import java.util.Iterator;
import learningFactorFunctional.LearningFactorFunctionalModel;
import network.NetworkModel;
import network.NeuronModel;
import topology.NeighbourhoodFunctionModel;
import metrics.MetricModel;
import java.util.ArrayList;
import topology.TopologyModel;
import java.util.TreeMap;
import network.TiredNeuronModel;



public class WTMLearningFunctionWithTired extends WTMLearningFunction{
    

    public WTMLearningFunctionWithTired(NetworkModel networkModel,int maxIteration,MetricModel metrics,
            LearningDataModel learningData,LearningFactorFunctionalModel functionalModel,
            NeighbourhoodFunctionModel neighboorhoodFunction) {
    super(networkModel,maxIteration,metrics,learningData,functionalModel,
            neighboorhoodFunction);
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
    
    

    protected void changeNeuronWeight(int neuronNumber, double[] vector, int iteration, int distance){
        super.changeNeuronWeight(neuronNumber,vector,iteration,distance);
        
        TiredNeuronModel tempNeuron = (TiredNeuronModel) networkModel.getNeuron(neuronNumber);
        int tiredness = tempNeuron.getTiredness();
        tempNeuron.setTiredness(tiredness - 2); 
    }
}
