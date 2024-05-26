package OsJava.placement;
import java.util.Scanner;

public class NextFit {
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

        int curr = 0;

        for(int i = 0; i < numProc; i++){
            for(int j = 0; j < numBlocks; j++){
                if(processes[i] <= blocks[curr]){
                    System.out.println("Process " + (i+1) + " is allocated to block " + (curr+1));
                    blocks[curr] -= processes[i];
                    curr = (curr + 1) % numBlocks;
                    break;
                }
                curr = (curr + 1) % numBlocks;
            }
        }

        scanner.close();

    }
}
