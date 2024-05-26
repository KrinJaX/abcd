package OsJava.scheduling;

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
public class SJF {
    public static void main(String[] args) {
        ArrayList<Process> list = new ArrayList<>();
        list.add(new Process(1, 0, 3));
        list.add(new Process(2, 1, 5));
        list.add(new Process(3, 2, 1));

        list.sort((Process a, Process b) -> a.arrivalTime - b.arrivalTime);

        ArrayList<Process> listCopy = new ArrayList<>(list);

        int currentTime = 0;
        int completed = 0;
        while(completed < listCopy.size()){
            Process p = null;
            for(Process proc : list){
                if(proc.arrivalTime <= currentTime){
                    if(p == null || proc.burstTime < p.burstTime){
                        p = proc;
                    }
                }
            }
            if(p != null){
                currentTime += p.burstTime;
                p.completionTime = currentTime;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
                list.remove(p);
                completed++;
            }else{
                currentTime++;
            }
        }

        
        System.out.println("ID\tAT\tBT\tWT\tTAT\tCT");
        for (Process p : listCopy) {
            System.out.println(p.Id + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime + "\t" + p.completionTime);
        }
    }    
}
