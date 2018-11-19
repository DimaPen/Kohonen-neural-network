

package network;

import topology.TopologyModel;
import topology.*;




public interface NetworkModel{
    

    public NeuronModel getNeuron(int neuronNumber);
    

    public int getNumbersOfNeurons();
    

    public TopologyModel getTopology();
    

    public void setTopology(TopologyModel topology);
    
}