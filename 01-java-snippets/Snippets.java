/*
 * Блок 1. Java: что выведет код.
 *
 * Запуск (Java 11+, из папки 01-java-snippets):
 *     java Snippets.java        список задач
 *     java Snippets.java 1.9    запустить сниппет задачи 1.9
 *
 * В Windows-терминале перед запуском: chcp 65001
 *
 * Сначала ответь сам, потом запускай и сверяйся.
 * 1.1 не компилируется, 1.4 написана на JavaScript, их код только в комментариях.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snippets {

    /* 1.1 · Нестатический метод из main (не компилируется)
     *
     *     public class Hello {
     *         public static void main(String[] args) {
     *             sayHello();
     *         }
     *
     *         public void sayHello() {
     *             System.out.println("Привет, мир!");
     *         }
     *     }
     */

    // 1.2 · Двойной инкремент в цикле
    static class LoopError {
        public static void main(String[] args) {
            for (int i = 1; i <= 5; ++i) {
                System.out.println(i);
                i++;
            }
        }
    }

    // 1.3 · Выход за границы списка
    static class ListError {
        public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>();

            numbers.add(1);
            numbers.add(2);
            numbers.add(3);

            for (int i = 0; i <= numbers.size(); i++) {
                System.out.println(numbers.get(i));
            }
        }
    }

    /* 1.4 · Сравнение объектов (JavaScript)
     *
     *     let a = { a: 1 }
     *     let b = { a: 1 }
     *     let c = a
     *
     *     console.log(a === b)
     *     console.log(a === c)
     */

    // 1.5 · Сравнение строк
    static class StringConcatenationDemo {
        public static void main(String[] args) {
            String s1 = "Hello" + " World";
            String s2 = "Hello World";

            String part = " World";
            String s3 = "Hello" + part;

            System.out.println(s1 == s2);
            System.out.println(s2 == s3);
        }
    }

    // 1.6 · Сравнение enum
    static class EnumComparisonDemo {
        enum Color { RED, GREEN, BLUE }

        public static void main(String[] args) {
            Color a = Color.RED;
            Color b = Color.RED;

            System.out.println(a == b);
            System.out.println(a.equals(b));
        }
    }

    // 1.7 · Ковариантность массивов
    static class ArrayCovariance {
        public static void main(String[] args) {
            Object[] objects = new String[3];
            objects[0] = "hello";
            objects[1] = 42;
        }
    }

    // 1.8 · Статический метод и наследование
    static class Parent {
        public static String getEnv() {
            return "PROD";
        }

        public String getDynamicEnv() {
            return getEnv();
        }
    }

    static class Child extends Parent {
        public static String getEnv() {
            return "TEST";
        }
    }

    static class Inheritance {
        public static void main(String[] args) {
            Parent p = new Child();

            System.out.println(p.getEnv());
            System.out.println(p.getDynamicEnv());
            System.out.println(Child.getEnv());
        }
    }

    // 1.9 · Удаление во время итерации
    static class CollectionTrap {
        public static void main(String[] args) {
            List<String> list = Arrays.asList("a", "b", "c", "d");
            for (String s : list) {
                if (s.equals("c")) {
                    list.remove(s);
                    System.out.println(list);
                }
            }
        }
    }


    // ---------------------------------------------------------------------
    //  Запускалка. Ниже задач нет.
    // ---------------------------------------------------------------------

    private static final String[] NO_ARGS = new String[0];

    public static void main(String[] args) {
        if (args.length == 0) {
            printMenu();
            return;
        }

        String task = args[0];
        System.out.println("=== Задача " + task + " ===");
        try {
            switch (task) {
                case "1.2": LoopError.main(NO_ARGS); break;
                case "1.3": ListError.main(NO_ARGS); break;
                case "1.5": StringConcatenationDemo.main(NO_ARGS); break;
                case "1.6": EnumComparisonDemo.main(NO_ARGS); break;
                case "1.7": ArrayCovariance.main(NO_ARGS); break;
                case "1.8": Inheritance.main(NO_ARGS); break;
                case "1.9": CollectionTrap.main(NO_ARGS); break;
                case "1.1":
                case "1.4":
                    System.out.println("Эта задача не запускается, читай код в комментарии.");
                    break;
                default:
                    System.out.println("Нет такой задачи.");
                    printMenu();
            }
        } catch (Throwable t) {
            System.out.println();
            System.out.println(">>> Код упал: " + t.getClass().getName()
                    + (t.getMessage() == null ? "" : ": " + t.getMessage()));
        }
        System.out.println("=== Конец ===");
    }

    private static void printMenu() {
        System.out.println("Блок 1. Java: что выведет код");
        System.out.println("Запуск: java Snippets.java <номер>");
        System.out.println();
        System.out.println("  1.1  Нестатический метод из main          (только чтение)");
        System.out.println("  1.2  Двойной инкремент в цикле");
        System.out.println("  1.3  Выход за границы списка");
        System.out.println("  1.4  Сравнение объектов, JavaScript       (только чтение)");
        System.out.println("  1.5  Сравнение строк");
        System.out.println("  1.6  Сравнение enum");
        System.out.println("  1.7  Ковариантность массивов");
        System.out.println("  1.8  Статический метод и наследование");
        System.out.println("  1.9  Удаление во время итерации");
    }
}
