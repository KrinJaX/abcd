import java.util.*;

public class Optimal{
    public static void main(String[] args){
        int[] pageReferences = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        int frameSize = 3;

        performOptimal(pageReferences, frameSize);
    }

    public static void performOptimal(int[] pageReferences, int frameSize){
        List<Integer> frame = new ArrayList<>();
        int pageFaults = 0;

        for (int i = 0; i < pageReferences.length; i++){
            int page = pageReferences[i];
            if (!frame.contains(page)){
                if(frame.size() < frameSize){
                    frame.add(page);
                } 
                else{ 
                    int indexToReplace = -1;
                    int farthest = i;
                    for (int j = 0; j < frame.size(); j++) {
                        int framePage = frame.get(j);
                        int nextUse = Integer.MAX_VALUE;
                        for (int k = i + 1; k < pageReferences.length; k++) {
                            if (pageReferences[k] == framePage) {
                                nextUse = k;
                                break;
                            }
                        }
                        if (nextUse > farthest) {
                            farthest = nextUse;
                            indexToReplace = j;
                        }
                    }
                    frame.set(indexToReplace, page);
                }
                pageFaults++;
            }
            System.out.println("Page References: " + Arrays.toString(pageReferences) + " Frame: " + frame + " Page Faults: " + pageFaults);
        }
    }
}
