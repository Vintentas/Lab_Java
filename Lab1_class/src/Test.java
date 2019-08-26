/*
*Лабораторная работа по програмированию на языке Java №1.
*Задание:
*    В приложении задано параметром количество студентов. Приложение генерирует   фамилии студентов и   месяцы их рождения. Приложение имеет еще 1 параметр- число от 1 до 12 .
*    Задачей приложения является вывод всех фамилий студентов, которые родились в месяц, заданный параметром. Необходимо также выводить вначале список всех студентов с датами рождения.
*Выполнила: Ситникова В.А., 23.02.2018
*/

import java.util.Scanner; //импорт класса для работы с вводом

public class Test {
    
  public static void main (String[] args){
    String [] surname = {"Иванов","Петров","Сидоров","Волков","Круглов","Смирнов","Тихонов",
                      "Егоров","Зайцев","Соколов","Михайлов","Антонов","Тихомиров","Пушкин","Светлов"};  


    int kolStudent=0; //Переменная - хранит кол-во студентов
  
    
    
  while (kolStudent == 0){
    try {
        //Scanner kol = new Scanner(System.in);
       // kolStudent = kol.nextInt();
              
        kolStudent = Integer.parseInt(args[0]);
    }
    catch(Exception ex){
        System.out.println ("Вы ввели что-то не то, попробуйте еще раз. ");
    }
  }
                                
  student[] stud = new student[kolStudent]; //Массив, который хранит всех студентов
  
  //Цикл заполняется случайным образом
  for (int i=0; i<kolStudent; i++){
    int randomSurname = (int) (Math.random()*surname.length);
    int randomMonth = (int) (Math.random()*12+1);
                                                  
    student s = new student(); //Вспомогательный объект типа Студент
    s.setSurname(surname[randomSurname]);
    s.setMonth(randomMonth);
    stud[i]=s;
   
    
    System.out.println (i+1 + ". "+ stud[i].getSurname()+ " "+ stud[i].getMonth());
    }
  
  //Ввод с клавиатуры месяца
  //System.out.print ("Введите месяц (число от 1 до 12): ");
    int numberMonth=0; //Переменная - хранит месяц
  
  while (numberMonth>12 || numberMonth<1){
    try {
       // Scanner nm = new Scanner(System.in);
       // numberMonth = nm.nextInt();
      
       numberMonth = Integer.parseInt(args[1]);
       
        if (numberMonth>12 || numberMonth<1){
            System.out.println ("Номер месяца - это число от 1 до 12, попробуйте еще раз.");
            break;
        }
    }
    catch(Exception ex){
        System.out.println ("Вы ввели что-то не то, попробуйте еще раз. ");
         break;
    }
  }
  
  //Вывод студентов в соответствии с заданным месяцем
  for (int i=0, k=0; i<kolStudent; i++){
    if (stud[i].getMonth()==numberMonth){
            System.out.println (++k + ". "+ stud[i].getSurname());
    }
  }

 }
}
