import java.util.*;

class ClaimMerger {

    static List<Integer> merge(
            List<Integer> region1,
            List<Integer> region2) {

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < region1.size() && j < region2.size()) {

            if (region1.get(i) <= region2.get(j)) {
                result.add(region1.get(i));
                i++;
            } else {
                result.add(region2.get(j));
                j++;
            }
        }

        // Remaining elements from region 1
        while (i < region1.size()) {
            result.add(region1.get(i));
            i++;
        }

        // Remaining elements from region 2
        while (j < region2.size()) {
            result.add(region2.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("\n===== TASK 5: TWO POINTERS =====");

        List<Integer> region1 =
                Arrays.asList(101, 103, 105, 109);

        List<Integer> region2 =
                Arrays.asList(102, 104, 106, 108);

        System.out.println("Merged claims: " +
                ClaimMerger.merge(region1, region2));
    }
}

