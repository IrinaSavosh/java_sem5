package seminar_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class hw_52 {
   /*
    * Пусть дан список сотрудников:
    * Иван Иванов
    * Светлана Петрова
    * Кристина Белова
    * Анна Мусина
    * Анна Крутова
    * Иван Юрин
    * Петр Лыков
    * Павел Чернов
    * Петр Чернышов
    * Мария Федорова
    * Марина Светлова
    * Мария Савина
    * Мария Рыкова
    * Марина Лугова
    * Анна Владимирова
    * Иван Мечников
    * Петр Петин
    * Иван Ежов
    * Написать программу, которая найдет и выведет повторяющиеся имена с
    * количеством повторений.
    * Отсортировать по убыванию популярности Имени.
    */
   public static void main(String[] args) {
      Map<String, String> listOfNames = new HashMap<String, String>();
      listOfNames.put("Иванов", "Иван");
      listOfNames.put("Петрова", "Светлана");
      listOfNames.put("Белова", "Кристина");
      listOfNames.put("Мусина", "Анна");
      listOfNames.put("Крутова", "Анна");
      listOfNames.put("Юрин", "Иван");
      listOfNames.put("Лыков", "Петр");
      listOfNames.put("Чернов", "Павел");
      listOfNames.put("Чернышов", "Петр");
      listOfNames.put("Федорова", "Мария");
      listOfNames.put("Светлова", "Марина");
      listOfNames.put("Савина", "Мария");
      listOfNames.put("Рыкова", "Мария");
      listOfNames.put("Лугова", "Марина");
      listOfNames.put("Владимирова", "Анна");
      listOfNames.put("Мечников", "Иван");
      listOfNames.put("Петин", "Петр");
      listOfNames.put("Ежов", "Иван");

      Map<String, Integer> newList = counts(listOfNames);
      Integer[] array = sortInt(newList);
      System.out.println(Arrays.toString(array));
      ArrayList<String> newArray = addedNames(newList, array);
      System.out.println(newArray);
   }

   public static void print(Map<String, Integer> hm) {
      for (String key : hm.keySet()) {
         System.out.println("Фамилия: " + key + ". Имя: " + hm.get(key));
      }
   }

   public static Map<String, Integer> counts(Map<String, String> one) {
      Map<String, Integer> two = new HashMap<String, Integer>();
      // int count = 1;
      for (String val : one.values()) {

         if (two.containsKey(val)) {

            two.put(val, two.get(val) + 1);
         } else {
            two.put(val, 1);
         }
      }
      return two;
   }

   public static Integer[] sortInt(Map<String, Integer> one) {

      Integer[] array = one.values().toArray(new Integer[0]); // переносим one в array

      System.out.println(Arrays.toString(array));

      for (int i = 0; i < array.length - 1; i++) { // сортировка от большего к меньшему
         for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j + 1] > array[j]) {
               int swap = array[j];
               array[j] = array[j + 1];
               array[j + 1] = swap;
            }
         }
      }
      return array;
   }

   public static ArrayList<String> addedNames(Map<String, Integer> one, Integer[] array) {
      ArrayList<String> newArr = new ArrayList<>();
      System.out.println(one);

      for (int j = 0; j < array.length; j++) {
         newArr.add(getKey(one, array[j]));
         one.remove(getKey(one, array[j]));
         System.out.println(newArr);
      }
      return newArr;
   }

// Я не понимаю, что за аргументы вложены в следующий метод. Что такое <K, V> К ? Это уже ООП?

   public static <K, V> K getKey(Map<K, V> map, V value) {// достаем ключ по гениальному методу
      for (Map.Entry<K, V> entry : map.entrySet()) {
         if (value.equals(entry.getValue())) {
            return entry.getKey();
         }
      }
      return null;
   }

}
