import java.util.*; 

public class FCFS {

    public static void main(String[] args) {
        int n, headPosition;
        float tso = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of requests: ");
        n = sc.nextInt();
        System.out.println("Head Position : ");
        headPosition = sc.nextInt();
        
        int[] request = new int[n];

        for(int i = 0; i < n; i++){
            System.out.println("Enter request " + (i+1) + " : ");
            request[i] = sc.nextInt();
        }

        System.out.println("Sequence: ");
        for(int i = 0; i < n; i++){
            tso += Math.abs(headPosition - request[i]); 
            headPosition = request[i];

            System.out.print(request[i] + " ");

        }

        System.out.println("Total movement:" + tso);
        System.out.println("Avg movement:" + tso/n);

        sc.close();
    }
}