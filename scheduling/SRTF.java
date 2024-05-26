// Preemptive SJF
public class SRTF {
    public static void main(String[] args) {
        int n = 5;

        int[] AT = {0, 1, 4, 5, 7};
        int[] BT = {3, 4, 2, 1, 5};
        int[] WT = new int[n];
        int[] TAT = new int[n];
        int[] RT = BT.clone();

        int completed = 0;
        int time = 0;

        while(completed != n){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < n; i++){
                if(RT[i] > 0 && AT[i] <= time){
                    if(RT[i] < min){
                        min = RT[i];
                        minIndex = i;
                    }
                }
            }

            if(minIndex == -1){
                System.out.println("ERROR");
                break;
            }

            RT[minIndex]--;
            time++;

            if(RT[minIndex] == 0){
                completed++;
                TAT[minIndex] = time - AT[minIndex];
                WT[minIndex] = TAT[minIndex] - BT[minIndex];
            }
        }

        System.out.println("ID\tAT\tBT\tWT\tTAT");
        for(int i = 0; i < n; i++){
            System.out.println(i + "\t" + AT[i] + "\t" + BT[i] + "\t" + WT[i] + "\t" + TAT[i]);
        }
    }    
}
