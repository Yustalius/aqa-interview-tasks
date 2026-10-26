/*
 * Блок 2. Написать код: эталонные решения.
 *
 * Запуск (Java 11+, из папки 02-live-coding):
 *     java Solution.java 2.1
 *     java Solution.java 2.2
 */

import java.util.Arrays;

public class Solution {

    // 2.1 · Треугольник из нулей: внешний цикл по строкам, внутренний печатает нули
    public static void printTriangle(int size) {
        for (int i = size; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("0");
            }
            System.out.println();
        }
    }

    // 2.2 · Через цикл
    public static String[] transform(String[] input) {
        String[] result = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            String s = input[i]
                    .replace('1', 'a')
                    .toUpperCase();
            result[i] = new StringBuilder(s).reverse().toString();
        }
        return result;
    }

    // 2.2 · Через Stream API
    public static String[] transformWithStream(String[] input) {
        return Arrays.stream(input)
                .map(s -> s.replace('1', 'a'))
                .map(String::toUpperCase)
                .map(s -> new StringBuilder(s).reverse().toString())
                .toArray(String[]::new);
    }


    public static void main(String[] args) {
        String task = args.length == 0 ? "" : args[0];
        switch (task) {
            case "2.1":
                printTriangle(5);
                break;
            case "2.2":
                String[] input = {"he1lo", "java1", "123"};
                System.out.println("цикл     : " + Arrays.toString(transform(input)));
                System.out.println("stream   : " + Arrays.toString(transformWithStream(input)));
                System.out.println("ожидается: [OLAEH, AAVAJ, 32A]");
                System.out.println("исходный : " + Arrays.toString(input));
                break;
            default:
                System.out.println("Запуск: java Solution.java <2.1|2.2>");
        }
    }
}
