

package com.company;

import kohonen.LearningData;
import kohonen.WTALearningFunction;
import learningFactorFunctional.ConstantFunctionalFactor;
import metrics.EuclidesMetric;
import network.DefaultNetwork;
import topology.MatrixTopology;
import java.io.*;
import java.io.FileWriter;
import java.util.Random;


public class Main {


    private static final String TRAINING_DATA_PATH = "trainning_data.txt";
    private static final String WEIGHTS_PATH = "weights.txt";

    public static void main(String[] args) {

        try {
            randomData(TRAINING_DATA_PATH, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MatrixTopology topology = new MatrixTopology(5,10);
        DefaultNetwork network = new DefaultNetwork(2,new double[]{100,200},topology);
        ConstantFunctionalFactor constantFactor = new ConstantFunctionalFactor(0.8);
        LearningData fileData = new LearningData(TRAINING_DATA_PATH);

        WTALearningFunction learning = new WTALearningFunction(network, 20, new EuclidesMetric(), fileData, constantFactor);

        learning.learn();

        System.out.println(network);
    }

    private static void randomData(String filename, int lines) throws IOException {
        File file = new File(filename);
        Random random = new Random();

        FileWriter writer = new FileWriter(file);
        for (int i=0; i<lines; i++){
           writer.write(random.nextInt(1000) + "\t" + random.nextInt(1000)+"\n");
        }
        writer.close();
    }
}
