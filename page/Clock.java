import java.util.*;

public class Clock {
    public static void main(String[] args){
        int[] pageReferences = {2, 3, 2, 1, 5};
        int frameSize = 3;

        performSecondChance(pageReferences, frameSize);
    }

    public static void performSecondChance(int[] pageReferences, int frameSize){
        List<Integer> frame = new ArrayList<>();
        Map<Integer, Boolean> secondChance = new HashMap<>();
        int pageFaults = 0;
        int pointer = 0;

        for (int page : pageReferences){
            if (!frame.contains(page)){
                pageFaults++;

                if (frame.size() < frameSize){
                    frame.add(page);
                    secondChance.put(page, false);
                } else {
                    while (true) {
                        int currentPage = frame.get(pointer);
                        if (secondChance.get(currentPage)) {
                            secondChance.put(currentPage, false);
                            pointer = (pointer + 1) % frameSize;
                        } else {
                            frame.set(pointer, page);
                            secondChance.put(page, false);
                            pointer = (pointer + 1) % frameSize;
                            break;
                        }
                    }
                }
            } else {
                secondChance.put(page, true);
            }
            System.out.println("Page References: " + Arrays.toString(pageReferences) + " Frame: " + frame + " Page Faults: " + pageFaults);
        }
    }
}
