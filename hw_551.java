package seminar_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hw_551 {
   /*
    * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    * человек может иметь несколько телефонов.
    * Добавить функции 1) Добавление номера
    * 2) Вывод всего
    * Пример:
    * Я ввожу: 1
    * К: Введите фамилию
    * Я: Иванов
    * К: Введите номер
    * Я: 1242353
    * К: Введите 1) Добавление номера
    * 2) Вывод всего
    * Я ввожу: 1
    * К: Введите фамилию
    * Я: Иванов
    * К: Введите номер
    * Я: 547568
    * К: Введите 1) Добавление номера
    * 2) Вывод всего
    * Я: 2
    * Иванов: 1242353, 547568
    */

   public static void main(String[] args) {
      Map<String, ArrayList<Integer>> phoneNotes = new HashMap<String, ArrayList<Integer>>();
      Scanner in = new Scanner(System.in, "cp866");

      while (true) {

         System.out.println(" ");
         System.out.println("***********************************************************");
         System.out.println("Для того, чтобы добавить абонента в справочник, нажмите '1',");
         System.out.println("чтобы удалить - '2', \nчтобы вывести справочник на экран - '3'");
         System.out.print("чтобы выйти из справочника - '0'\nВведите команду: ");
         Integer n = in.nextInt();

         if (n == 1) {
            System.out.print("Введите фамилию, имя, отчество: ");

            String fio = in.next();
            System.out.print("Введите номер телефона: ");

            Integer number = in.nextInt();

            addHM(phoneNotes, fio, number);
         } else if (n == 2) {
            System.out.print("Введите фамилию, имя, отчество: ");
            String fio = in.next();
            del(phoneNotes, fio);
         } else if (n == 3) {
            print(phoneNotes);
         } else if (n == 0) {
            break;
         } else {
            System.out.println("Вы ввели несуществующую команду. Попробуйте снова");
            continue;
         }
      }
      in.close();
   }
   
   public static void addHM(Map<String, ArrayList<Integer>> hm, String name, Integer phone) {
      if (hm.containsKey(name)) {
         hm.get(name).add(phone);
      } else {
         ArrayList<Integer> newArray = new ArrayList<>();
         newArray.add(phone);
         hm.put(name, newArray);
      }
   }

   public static void print(Map<String, ArrayList<Integer>> hm) {
      for (String key : hm.keySet()) {
         System.out.println("ФИО: " + key + ", Телефон(ы) = " + hm.get(key));
      }
   }

   public static void del(Map<String, ArrayList<Integer>> hm, String name) {
      if (hm.containsKey(name)) {
         hm.remove(name);
      } else {
         System.out.println("Такого имени нет в спарвочнике");
      }
   }
}
