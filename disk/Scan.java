package OsJava.disk;

import java.util.*;

public class Scan {
    public static void main(String[] args) {
        int n, headPosition, tracks, direction, tso = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of requests: ");
        n = scanner.nextInt();
        System.out.println("Enter number of tracks: ");
        tracks = scanner.nextInt();
        System.out.println("Enter direction: ");
        direction = scanner.nextInt();
        System.out.println("Enter head position: ");
        headPosition = scanner.nextInt();

        int request[] = new int[n];

        for(int i = 0 ; i < n; i++){
            System.out.println("Enter request " + (i+1) + ": ");
            request[i] = scanner.nextInt();
        }

        Arrays.sort(request);
        int headCopy = headPosition;

        if(direction == 1){
            for(int i = headPosition; i < tracks; i++){
                for(int j = 0; j < n; j++){
                    if(request[j] == i){
                        tso += Math.abs(request[j] - headPosition);
                        headPosition = i;
                        System.out.print(i + " ");
                    }
                }
            }

            if(headPosition != tracks - 1){
                tso += tracks - 1 - headPosition;
                headPosition = tracks - 1;
            }

            for(int i = headCopy - 1; i >= 0; i--){
                for(int j = 0; j < n; j++){
                    if(request[j] == i){
                        tso += Math.abs(request[j] - headPosition);
                        headPosition = i;
                        System.out.print(i + " ");
                    }
                }
            }
        }

        else if(direction == 0){
            for(int i = headPosition; i >= 0; i--){
                for(int j = 0; j < n; j++){
                    if(request[j] == i){
                        tso += Math.abs(request[j] - headPosition);
                        headPosition = i;
                        System.out.print(i + " ");
                    }
                }
            }

            if(headPosition != 0){
                tso += headPosition;
                headPosition = 0;
            }

            for(int i = headCopy + 1; i < tracks; i++){
                for(int j = 0; j < n; j++){
                    if(request[j] == i){
                        tso += Math.abs(request[j] - headPosition);
                        headPosition = i;
                        System.out.print(i + " ");
                    }
                }
            }
        }

        System.out.println("Total seek operations: " + tso);
        System.out.println("Avg seek operations: " + tso);

        scanner.close();
    }
}
