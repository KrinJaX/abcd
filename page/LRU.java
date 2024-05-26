import java.util.*;

public class LRU {
    public static void main(String[] args) {
        int[] pageReferences = {2, 3, 2, 1, 5, 2};
        int frameSize = 3; 

        performLRU(pageReferences, frameSize);
    }

    public static void performLRU(int[] pageReferences, int frameSize) {
        List<Integer> frame = new ArrayList<>();
        Map<Integer, Integer> pageLastUsed = new HashMap<>();
        int pageFaults = 0;

        for (int i = 0; i < pageReferences.length; i++) {
            int page = pageReferences[i];

            if (!frame.contains(page)) { 
                if (frame.size() < frameSize) { 
                    frame.add(page);
                } else {
                    int leastRecentlyUsedPage = frame.get(0);
                    int leastRecentlyUsedPageIndex = 0;

                    for (int j = 0; j < frame.size(); j++) {
                        int currentPage = frame.get(j);
                        if (pageLastUsed.get(currentPage) > pageLastUsed.get(leastRecentlyUsedPage)) {
                            leastRecentlyUsedPage = currentPage;
                            leastRecentlyUsedPageIndex = j;
                        }
                    }

                    frame.set(leastRecentlyUsedPageIndex, page); 
                }

                pageFaults++;
            }

            pageLastUsed.put(page, i); 
            System.out.println("Page References: " + Arrays.toString(pageReferences) +
                    " Frame: " + frame + " Page Faults: " + pageFaults);
        }
    }
}
