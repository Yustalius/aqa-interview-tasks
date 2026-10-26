/*
 * Блок 2. Написать код: заготовки под своё решение.
 *
 * Запуск (Java 11+, из папки 02-live-coding):
 *     java Practice.java 2.1
 *     java Practice.java 2.2
 *
 * В Windows-терминале перед запуском: chcp 65001
 * Эталонные решения лежат в Solution.java, но сначала попробуй сам.
 */

import java.util.Arrays;

public class Practice {

    /* 2.1 · Треугольник из нулей
     *
     *     00000
     *     0000
     *     000
     *     00
     *     0
     */
    public static void printTriangle(int size) {
        // TODO: твоя реализация
        throw new UnsupportedOperationException("2.1 ещё не написана");
    }

    /* 2.2 · Преобразование массива строк
     *
     * Для каждой строки: '1' -> 'a', верхний регистр, развернуть.
     * Исходный массив не менять, вернуть новый.
     *
     *     ["he1lo", "java1", "123"]  ->  ["OLAEH", "AAVAJ", "32A"]
     */
    public static String[] transform(String[] input) {
        // TODO: твоя реализация
        throw new UnsupportedOperationException("2.2 ещё не написана");
    }


    // ---------------------------------------------------------------------
    //  Запускалка. Ниже задач нет.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        String task = args.length == 0 ? "" : args[0];
        try {
            switch (task) {
                case "2.1":
                    printTriangle(5);
                    break;
                case "2.2":
                    String[] input = {"he1lo", "java1", "123"};
                    String[] result = transform(input);
                    System.out.println("input    : " + Arrays.toString(input));
                    System.out.println("result   : " + Arrays.toString(result));
                    System.out.println("ожидается: [OLAEH, AAVAJ, 32A]");
                    System.out.println("исходный массив не тронут: "
                            + Arrays.equals(input, new String[]{"he1lo", "java1", "123"}));
                    break;
                default:
                    System.out.println("Запуск: java Practice.java <2.1|2.2>");
            }
        } catch (Throwable t) {
            System.out.println(">>> Код упал: " + t.getClass().getName()
                    + (t.getMessage() == null ? "" : ": " + t.getMessage()));
        }
    }
}
