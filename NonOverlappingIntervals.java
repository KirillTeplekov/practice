import java.util.*;
public class NonOverlappingIntervals {
    /*
    ЗАДАНИЕ 3
    Алгоритм:
    Сортируем интервалы по начальной точке
    Последовательно выбираем интервалы с самым ранним концом,
    которые не пересекаются с последним выбранным
    */
    public static int nonOverlappingIntervals(int[][] intervals) {
        int count = 1;


        Arrays.sort(intervals,  Comparator.comparingInt(a -> a[1]));

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {6, 7}};
        System.out.println(nonOverlappingIntervals(intervals));
    }
}


