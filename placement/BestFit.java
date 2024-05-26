import java.util.Scanner;

public class BestFit {
    public static void main(String[] args) {
        int numBlocks, numProc;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of blocks: ");
        numBlocks = scanner.nextInt();
        System.out.println("Enter the number of Processes: ");
        numProc = scanner.nextInt();

        int[] blocks = new int[numBlocks];
        int[] processes = new int[numProc];

        for(int i = 0;i < numBlocks; i++){
            System.out.println("Enter the size of block " + (i+1) + ": ");
            blocks[i] = scanner.nextInt();   
        }

        for(int i = 0; i < numProc; i++){
            System.out.println("Enter the size of process " + (i+1) + ": ");
            processes[i] = scanner.nextInt();
        }

        for(int i = 0; i < numProc; i++){
            int bestFit = -1;
            for(int j = 0; j < numBlocks; j++){
                if(blocks[j] >= processes[i] && (bestFit == -1 || blocks[j] < blocks[bestFit])){
                    bestFit = j;
                }
            }

            if(bestFit == -1){
                System.out.println("Cannot place Block " + i);
                continue;
            }

            blocks[bestFit] -= processes[i];
            System.out.println("Process " + (i+1) + " is placed in block " + (bestFit+1));
        }

        scanner.close();

    }
}
