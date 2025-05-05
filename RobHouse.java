public class RobHouse {
    /*
    ЗАДАНИЕ 5
    Алгоритм:
    Разбиваем на два случая: 1. не грабим первый 2. не грабим последний
    prev2 - максимальная сумма до i-2 дома
    prev1 - максимальная сумма до i-1 дома
    На каждом шаге выбираем максимум между:
    - текущий элемент + максимум до предпредыдущего
    - максимум до предыдущего (пропускаем текущий)
    */
    static int maxRob(int x, int y, int[] arr) {
        int n = arr.length;
        // Для первого дома в подмассиве берем только его значение
        int prev2 = arr[x];

        // Для второго дома выбираем с максимальной добычей из первого и второго
        int prev1 = Math.max(arr[x], arr[x + 1]);

        // Проходим по остальным домам (начиная с третьего)
        for (int j = x + 2; j <= y; j++) {
            // Грабим текущий дом + сумму до j-2
            int rob = arr[j] + prev2;
            // Не грабим текущий дом
            int noRob = prev1;

            int curr = Math.max(rob, noRob);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    static int maxValue(int[] arr) {
        int n = arr.length;

        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int val = 0;

        // Грабим с 0 до n-2
        val = Math.max(val, maxRob(0, n - 2, arr));

        // Грабим с 1 до n-1
        val = Math.max(val, maxRob(1, n - 1, arr));

        return val;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2};
        System.out.println(maxValue(arr));
    }
}
