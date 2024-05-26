import java.util.*;

class Process{
    int pid;
    int at;
    int bt;
    int ct;
    int rt;
    int tat;
    int wt;

    Process(int pid, int at, int bt) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
        this.rt = bt;
    }
}
public class robinCPU {
    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 0, 8));
        processes.add(new Process(2, 1, 4));
        processes.add(new Process(3, 2, 9));
        processes.add(new Process(4, 3, 5));

        int timeSlice = 4;
        int currentTime = 0;
        Queue<Process> readyQueue = new LinkedList<>();
        List<Process>arrivedProcesses = new ArrayList<>(processes);
        int completedProcesses = 0;
        int n = processes.size();

        while(completedProcesses < n){
            for(int i = 0;i<arrivedProcesses.size();i++){
                Process p = arrivedProcesses.get(i);
                if(p.at<=currentTime){
                    readyQueue.add(p);
                    arrivedProcesses.remove(i);
                    i--;
                }
            }

            if(!readyQueue.isEmpty()){
                Process current = readyQueue.poll();
                int executionTime = Math.min(timeSlice, current.rt);
                currentTime+=executionTime;
                current.rt-=executionTime;
                //adding a new process after executing first one in sequence
                for(int i = 0;i<arrivedProcesses.size();i++){
                    Process p = arrivedProcesses.get(i);
                    if(p.at <= currentTime){
                        readyQueue.add(p);
                        arrivedProcesses.remove(i);
                        i--;
                    }

                }
                if(current.rt > 0){ //add to the back of the queue
                    readyQueue.add(current);
                }else{
                    current.ct = currentTime;
                    current.tat = current.ct - current.at;
                    current.wt = current.tat - current.bt;
                    completedProcesses++;
                }
            }else{
                currentTime++;
            }
        }
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for (Process p : processes) {
            System.out.println(p.pid + "\t" + p.at + "\t" + p.bt + "\t" + p.ct + "\t" + p.tat + "\t" + p.wt);
        }
        
        
    }
    
}
