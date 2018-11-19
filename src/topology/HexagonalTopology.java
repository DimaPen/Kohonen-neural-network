

package topology;

import java.util.ArrayList;
import java.util.TreeMap;



public class HexagonalTopology implements TopologyModel{
    
    private int colNumber, rowNumber;
    private int radius;
    

    public HexagonalTopology(int row, int col) {
        this.rowNumber = row;
        this.colNumber = col;
    }
    

    public void setRowNumber(int rowNumber){
        this.rowNumber = rowNumber;
    }
    

    public void setColNumber(int colNumber){
        this.colNumber = colNumber;
    }
    

    public int getRowNumber(){
        return this.rowNumber;
    }
    

    public int getColNumber(){
        return this.colNumber;
    }
    

    public void setRadius(int radius) {
        this.radius = radius;
    }


    public int getRadius() {
        return radius;
    }
    

    public ArrayList getConnectedNeurons(int neuronNumber){
        ArrayList connectedNeurons = new ArrayList();
        
        int neuronRow = ((neuronNumber - 1) / colNumber ) + 1;
        
        if(neuronRow%2 == 1){
            if((neuronNumber-(colNumber+1)>0) && ((neuronNumber%colNumber) != 1))
                connectedNeurons.add(neuronNumber-(colNumber+1));
            if(neuronNumber-colNumber>0)
                connectedNeurons.add(neuronNumber-colNumber);
            if((neuronNumber-1 >0) && ((neuronNumber%colNumber) != 1))
                connectedNeurons.add(neuronNumber-1); 
            if(neuronNumber+1 <= colNumber*rowNumber && ((neuronNumber%colNumber) != 0))
                connectedNeurons.add(neuronNumber+1);
            if(neuronNumber+(colNumber-1)<colNumber*rowNumber && ((neuronNumber%colNumber) != 1))
                connectedNeurons.add(neuronNumber+(colNumber-1)); 
            if((neuronNumber+colNumber<=colNumber*rowNumber) )
                connectedNeurons.add(neuronNumber+colNumber); 
        }else{
            if(neuronNumber-colNumber>0)
                connectedNeurons.add(neuronNumber-colNumber);
            if((neuronNumber-(colNumber-1)>0) && ((neuronNumber%colNumber) != 0))
                connectedNeurons.add(neuronNumber-(colNumber-1));
            if((neuronNumber-1 >0) && ((neuronNumber%colNumber) != 1))
                connectedNeurons.add(neuronNumber-1); 
            if(neuronNumber+1 <= colNumber*rowNumber && ((neuronNumber%colNumber) != 0))
                connectedNeurons.add(neuronNumber+1);
            if((neuronNumber+colNumber<=colNumber*rowNumber) )
                connectedNeurons.add(neuronNumber+colNumber); 
            if(neuronNumber+(colNumber+1)<=colNumber*rowNumber && ((neuronNumber%colNumber) != 0))
                connectedNeurons.add(neuronNumber+(colNumber+1)); 
        }
        return connectedNeurons;
    }
    

    public int getNumbersOfNeurons(){
        return colNumber*rowNumber;
    }


    private ArrayList getN(ArrayList tempConnection){
        ArrayList neighborgoodConn = new ArrayList();
        ArrayList tempConn = new ArrayList();
        for (int j=0; j<tempConnection.size(); j++){
            tempConn = getConnectedNeurons((Integer)tempConnection.get(j));
            for (int i=0; i<tempConn.size();i++){
                if(!neighborgoodConn.contains(tempConn.get(i)))
                    neighborgoodConn.add(tempConn.get(i));
            }
        }
        return neighborgoodConn;
    }


    public TreeMap getNeighbourhood(int neuronNumber){
        TreeMap<Integer,Integer> neighbornhood = new TreeMap<Integer,Integer>();
        ArrayList tempConnection = new ArrayList();
        ArrayList  neighborgoodConn = new ArrayList ();
        tempConnection.add(neuronNumber);
        int[] temp = null;
        int key = 0;
        for(int i=0; i<radius; i++){
                neighborgoodConn = getN(tempConnection);
                for(int k=0; k< neighborgoodConn.size(); k++){
                    key = (Integer)neighborgoodConn.get(k);
                    if(!neighbornhood.containsKey(key))
                        neighbornhood.put(key,i+1);
                }
                tempConnection =(ArrayList) neighborgoodConn.clone();
        }
        return neighbornhood;
    }


    public int getNeuronNumber(Coords coords){
        if ((coords.x < rowNumber) &&  (coords.y < colNumber)){
             return (coords.x - 1) * colNumber + coords.y;
        }
        return -1;
    }
    

    public Coords getNeuronCoordinate(int neuronNumber){
        int x = ((neuronNumber - 1) / colNumber ) + 1;
        int y = neuronNumber - ((x - 1 ) * colNumber); 
        return new Coords(x,y);
    }


    public String toString() {
        ArrayList tempList = new ArrayList();
        String conn = "";
        for(int i=1; i< colNumber*rowNumber + 1; i++){
            tempList = getConnectedNeurons(i);
            conn = conn + i + "\t" +  tempList + "\n";
        }
        return conn;
    }
}
