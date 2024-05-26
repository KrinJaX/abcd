import java.util.*;

public class FIFO{
    public static void main(String[] args){
        int[] pageReferences = {2, 3, 2, 1, 5};
        int frameSize = 3;

        performFIFO(pageReferences, frameSize);
    }

    public static void performFIFO(int[] pageReferences, int frameSize){
        List<Integer> frame = new ArrayList<>();
        int pageFaults = 0;

        for (int page : pageReferences){
            if (!frame.contains(page)){
                if(frame.size() < frameSize){
                    frame.add(page);
                } 
                else{ 
                    frame.remove(0);
                    frame.add(page);
                }
                pageFaults++;
            }
            System.out.println("Page References: " + Arrays.toString(pageReferences) + " Frame: " + frame + " Page Faults: " + pageFaults);
        }
    }
}
