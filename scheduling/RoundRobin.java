import java.util.*;

public class RoundRobin {
    public static void main(String[] args) {
      int n = 4;
      int[] AT = {0, 1, 2, 3};
      int[] BT = {8, 4, 9, 5};
      int[] RT = BT.clone();
      
      int[] Arrived = new int[n];
      int[] WT = new int[n];
      int[] TAT = new int[n];
      
      int q = 4;
      int time = 0;
      int completed = 0;
      Queue<Integer> readyQueue = new LinkedList<>();
      
      while(completed < n){
        for(int i = 0; i < n; i++){
          if(AT[i] <= time && RT[i] > 0 && Arrived[i] == 0){
            readyQueue.add(i);
            Arrived[i] = 1;
          }
        }
        
        if(!readyQueue.isEmpty()){
          int curr = readyQueue.poll();
          int executionTime = Math.min(RT[curr], q);
          
          time += executionTime;
          RT[curr] -= executionTime;
          
          for(int i = 0; i < n; i++){
            if(AT[i] <= time && RT[i] > 0 && Arrived[i] == 0){
              readyQueue.add(i);
              Arrived[i] = 1;
            }
          }
          
          if(RT[curr] == 0){
            TAT[curr] = time - AT[curr];
            WT[curr] = TAT[curr] - BT[curr];
            completed++;
          }
          else{
            readyQueue.add(curr);
          }
          
        }
        else{
          time++;
        }
        System.out.println(Arrays.toString(RT) + " " + time);
        System.out.println(readyQueue);
        
      }
      
      System.out.println("ID\tAT\tBT\tWT\tTAT");
        for(int i = 0; i < n; i++){
            System.out.println(i + "\t" + AT[i] + "\t" + BT[i] + "\t" + WT[i] + "\t" + TAT[i]);
        }
      
  }
}