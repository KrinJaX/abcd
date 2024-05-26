import java.util.*; 

public class SSTF {

    public static void main(String[] args) {
        int n, headPosition;
        float tso = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of requests: ");
        n = sc.nextInt();
        System.out.println("Head Position : ");
        headPosition = sc.nextInt();
        
        int[] request = new int[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            System.out.println("Enter request " + (i+1) + " : ");
            request[i] = sc.nextInt();
        }

        System.out.println("Sequence: ");
        
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = 0; j < n; j++){
                if(!visited[j] && Math.abs(request[j] - headPosition) < min){
                    min = Math.abs(request[j] - headPosition);
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            System.out.print(request[minIndex] + " ");
            tso += Math.abs(request[minIndex] - headPosition);
            headPosition = request[minIndex];
        }

        System.out.println();
        System.out.println("Total movement:" + tso);
        System.out.println("Avg movement:" + tso/n);

        sc.close();
    }
}