import java.util.HashSet;
public class longestSubstring {
    /*
    ЗАДАНИЕ 2
    Алгоритм:
    Начинаем с начала строки, идем вправо пока не встретим повторяющийся элемент.
    Если встретили сдвигаем начало подстроки вправо (очищая set), чтобы повторяющийся элемент стал единственным.
     */
    public static void main(String[] args) {
        String s = "abcabcb";

        int n = s.length();
        int maxLen = 0;
        int left = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int right = 0; right < n; right++) {
            // Когда встретился повторяющийся элемент, сдвигаем левый указатель пока не удалим повторящийся)
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println(maxLen);
    }
}
