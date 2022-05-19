package org.example;

import java.util.Random;

// если мы хотим реализовать поиск за постоянное время, т.е. O(1)
public class MemoryServer {
    static final String nums = "0123456789";
    static final String abc = "qwertyuiopasdfghjklzxcvbnm";

    public static void main(String[] args) {
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Насколько у нас была заполнена память ДО добавления объектов: " + memoryBefore);
        System.out.println("Общая память до добавления объектов: " + memoryBefore);

        int numbersN = 18758328;
        String[] stringArrayUserNames = new String[numbersN];

        long start = System.currentTimeMillis();

        createUsers(numbersN, stringArrayUserNames);

        long createUsersTime = System.currentTimeMillis();
        System.out.println("Время создания пользователей: " + (createUsersTime - start)/1000.0);



        for (int i = 0; i < 30000000; i++) {
            String phoneValue = createString(7, nums);
            int phoneValueInt = Integer.parseInt(phoneValue);
        }

        long end = System.currentTimeMillis();
        System.out.println("Время на поиск пользователей: " + (end - createUsersTime)/1000.0);

        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Общая память ПОСЛЕ добавления объектов: " + memoryAfter);
        System.out.println("Разность памяти до и после - тот самый объём пользовательских данных: " + (memoryAfter - memoryBefore));
    }

    public static void createUsers(int n, String[] stringArray) {

        for (int i = 0; i < n; i++) {
            String phoneValue = createString(7, nums);
            int phoneValueInt = Integer.parseInt(phoneValue);
            String nameValue = createString(20, abc);
            stringArray[phoneValueInt] = new String(nameValue);
        }
    }

    public static String createString(int n, String str) {
        Random rnd = new Random();
        String result = "";

        for (int i = 0; i < n; i++) {
            int index = Math.abs(rnd.nextInt(str.length()));
            result += str.charAt(index);
        }
        return result;
    }
    
}
