import java.util.*;

public class ObservedPin {

    private static final Map<Character, char[]> map = new HashMap<>();

    static {
        map.put('1', new char[]{'1', '2', '4'});
        map.put('2', new char[]{'1', '2', '3', '5'});
        map.put('3', new char[]{'2', '3', '6'});
        map.put('4', new char[]{'1', '4', '5', '7'});
        map.put('5', new char[]{'2', '4', '5', '6', '8'});
        map.put('6', new char[]{'3', '5', '6', '9'});
        map.put('7', new char[]{'4', '7', '8'});
        map.put('8', new char[]{'5', '7', '8', '9', '0'});
        map.put('9', new char[]{'6', '8', '9'});
        map.put('0', new char[]{'8', '0'});
    }

    public static List<String> getPINs(String observed) {
        List<String> list = new ArrayList<>();
        int[] indexes = new int[observed.length()];
        int[] lengths = new int[indexes.length];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i] = map.get(observed.charAt(i)).length;
        }
        sortThrough(indexes, lengths, 0, observed, list);
        return list;
    }

    public static void sortThrough(int[] indexes, int[] lengths, int counter, String observed, List<String> list) {
        for (int i = 0; i < lengths[counter]; i++) {
            indexes[counter] = i;
            if (counter == indexes.length-1) {
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < indexes.length; j++) result.append(map.get(observed.charAt(j))[indexes[j]]);
                list.add(String.valueOf(result));
            }
            else sortThrough(indexes, lengths, counter+1, observed, list);
        }
    }
}
