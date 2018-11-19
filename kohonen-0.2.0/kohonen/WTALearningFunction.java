

package kohonen;
import learningFactorFunctional.LearningFactorFunctionalModel;
import metrics.MetricModel;
import java.util.ArrayList;
import network.NetworkModel;
import network.NeuronModel;


public class WTALearningFunction {
    

    protected MetricModel metrics;

    protected NetworkModel networkModel; 

    protected int maxIteration;

    protected LearningDataModel learningData;

    protected LearningFactorFunctionalModel functionalModel;

    private boolean showComments;
    

    public WTALearningFunction(NetworkModel networkModel,int maxIteration,MetricModel metrics,
            LearningDataModel learningData,LearningFactorFunctionalModel functionalModel) {
        this.maxIteration = maxIteration;
        this.networkModel = networkModel;
        this.metrics = metrics;
        this.learningData = learningData;
        this.functionalModel = functionalModel;
    }


    public boolean isShowComments() {
        return showComments;
    }


    public void setShowComments(boolean showComments) {
        this.showComments = showComments;
    }


    public MetricModel getMetrics() {
        return metrics;
    }


    public void setMetrics(MetricModel metrics) {
        this.metrics = metrics;
    }


    public void setNetworkModel(NetworkModel networkModel) {
        this.networkModel = networkModel;
    }


    public NetworkModel getNetworkModel() {
        return networkModel;
    }


    public void setMaxIteration(int maxIteration) {
        this.maxIteration = maxIteration;
    }


    public int getMaxIteration() {
        return maxIteration;
    }


    public void setLearningData(LearningDataModel learningData) {
        this.learningData = learningData;
    }


    public LearningDataModel getLearningData() {
        return learningData;
    }


    public void setFunctionalModel(LearningFactorFunctionalModel functionalModel) {
        this.functionalModel = functionalModel;
    }


    public LearningFactorFunctionalModel getFunctionalModel() {
        return functionalModel;
    }
    

    protected int getBestNeuron(double[] vector){
        NeuronModel tempNeuron;
        double distance, bestDistance = -1;
        int networkSize = networkModel.getNumbersOfNeurons();
        int bestNeuron = 0;
        for(int i=0; i< networkSize; i++){
            tempNeuron = networkModel.getNeuron(i);
            distance = metrics.getDistance(tempNeuron.getWeight(), vector);
            if((distance < bestDistance) || (bestDistance == -1)){
                bestDistance = distance;
                bestNeuron = i;
            }
        }
        return bestNeuron;
    }
    

    protected void changeNeuronWeight(int neuronNumber, double[] vector, int iteration){
        double[] weightList = networkModel.getNeuron(neuronNumber).getWeight();
        int weightNumber = weightList.length;
        double weight;
                if(showComments){
            String vectorText="[";
            for(int i=0; i<vector.length; i++){
                vectorText += vector[i];
                if(i < vector.length -1 ){
                    vectorText += ", ";
                }
            }
            vectorText += "]";
            System.out.println("Vector: " + vectorText);
            String weightText="[";
            for(int i=0; i<weightList.length; i++){
                weightText += weightList[i];
                if(i < weightList.length -1 ){
                    weightText += ", ";
                }
            }
            weightText += "]";
            System.out.println("Neuron "+ (neuronNumber +1 ) + " weight before change: " + weightText);    
        }
        for (int i=0; i<weightNumber; i++){
            weight = weightList[i];
            weightList[i] += functionalModel.getValue(iteration) * (vector[i] - weight);
        }
        if(showComments){
            String weightText="[";
            for(int i=0; i<weightList.length; i++){
                weightText += weightList[i];
                if(i < weightList.length -1 ){
                    weightText += ", ";
                }
            }
            weightText += "]";
            System.out.println("Neuron "+ (neuronNumber +1 )  + " weight after change: " + weightText);
        }
    }
    

    public void learn(){
        int bestNeuron = 0;
        double[] vector;
        
        int dataSize = learningData.getDataSize();
        for (int i=0; i< maxIteration; i++){
            if(showComments){
                System.out.println("Iteration number: " + (i + 1));
            }
            for(int j= 0; j<dataSize; j++){
                vector = learningData.getData(j);
                bestNeuron = getBestNeuron(vector);
                if(showComments){
                    System.out.println("Best neuron number: " + (bestNeuron + 1));
                }
                changeNeuronWeight(bestNeuron, vector, i);
            }
        }
    }
}
