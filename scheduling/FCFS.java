import java.util.ArrayList;

class Process{
    int Id;
    int arrivalTime;
    int burstTime;
    int waitingTime;
    int turnaroundTime;
    int completionTime;
    int priority;
    
    Process(int id, int at, int bt){
        Id = id;
        arrivalTime = at;
        burstTime = bt;
    }

    Process(int id, int at, int bt, int p){
        Id = id;
        arrivalTime = at;
        burstTime = bt;
        priority = p;
    }
}
public class FCFS {
    public static void main(String[] args) {
        ArrayList<Process> list = new ArrayList<>();
        list.add(new Process(1, 0, 3));
        list.add(new Process(2, 1, 5));
        list.add(new Process(3, 2, 2));

        list.sort((Process a, Process b) -> a.arrivalTime - b.arrivalTime);

        int currentTime = 0;
        for (Process p : list) {
            if (p.arrivalTime > currentTime) { 
                currentTime = p.arrivalTime;
            }
            p.waitingTime = currentTime - p.arrivalTime;
            currentTime += p.burstTime;
            p.completionTime = currentTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
        }
        
        System.out.println("ID\tAT\tBT\tWT\tTAT\tCT");
        for (Process p : list) {
            System.out.println(p.Id + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime + "\t" + p.completionTime);
        }
    }    
}
