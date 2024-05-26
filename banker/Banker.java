import java.util.*;

public class Banker{
   int n = 5;
   public static void main(String[] args){
       int[][] need = {{7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
    //    int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0 ,2}, {2, 2, 2}, {4, 3, 3}};
       int[][] alloc = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
       int[] available = {3, 3, 2};
       boolean[] isFinished = new boolean[5];
       ArrayList<Integer> result = new ArrayList<>();
    
       for(int i = 0; i < 5; i++){
           int curr = -1;
           boolean canAllocate = false;
           for(int j = 0; j < 5; j++){
               if(!isFinished[j] && available[0] >= need[j][0] && available[1] >= need[j][1] && available[2] >= need[j][2]){
                   curr = j;
                   canAllocate = true;
                   break;
               }
           }
           if(canAllocate){
               for(int k = 0; k < 3; k++){
                   available[k] += alloc[curr][k];
                   alloc[curr][k] = 0;
               }
  
               isFinished[curr] = true;
               result.add(curr);
  
               System.out.println(i);
               System.out.println(Arrays.deepToString(alloc));
               System.out.println(Arrays.toString(available));
               System.out.println();
           }
           else{
               System.out.println("Deadlock Detected");
               break;
           }
       }

       System.out.println();
       System.out.println("Order: ");
       System.out.println(result);
   }
}
