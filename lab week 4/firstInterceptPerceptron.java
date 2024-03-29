import java.util.Arrays;
import java.util.Random;

public class firstInterceptPerceptron {
    public static void main(String[] args) {

        Random r = new Random();

        int[][] neuronInputs = {{0,1},{0,0},{1,0},{1,1}};
        int[] output = {0,0,0,1};
        int[] randomWeight = new int[3]; // Initialize the randomWeight array
        int[] netj = new int[4];

        //initialized weights
        for(int i = 0; i< 3; i++){
                int temp = r.nextInt(30);

            randomWeight[i] = temp;
        }

        //calculating netj for each input
        int count = 0; 

        for(int[] arr : neuronInputs){
            int net = arr[0]*randomWeight[0]+arr[1]*randomWeight[1];
            
            if(net > 0){
                netj[count] = 1;
                
            }else{
                netj[count] = 0;
            }
            count++;
        }

        // System.out.println(Arrays.toString(netj));

        //comparing the output weight with netj weights

        double alpha = 0.03; //learning rate

        for(int i = 0; i< 4; i++){
            double expectedOutput = output[i];
            double gainedOutput = netj[i];

            // if output is not expected
            if(expectedOutput != gainedOutput){
                if(gainedOutput > expectedOutput) { // when gainedOuptut = 1 > expectedOutput = 0
                    int[] abc = neuronInputs[i]; // abc = {0,0}
                    //increase the weight of the first element in abc by a certain

                    double sum = abc[0] * alpha + abc[1] * alpha;
                    //changing the weight
                    gainedOutput = gainedOutput - sum;
                }else{
                    int[] abc = neuronInputs[i];
                    double sum = abc[0] * alpha + abc[1] * alpha;
                    gainedOutput = gainedOutput + sum;
                }
            }
            netj[i] = (int) gainedOutput;
        }
        System.out.println(Arrays.toString(netj));
        System.out.println(Arrays.toString(output));
    }
}

