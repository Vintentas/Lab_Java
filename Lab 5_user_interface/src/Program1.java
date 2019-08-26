/*
*Лабораторная работа по програмированию на языке Java №5.
*Задание:
*      Создать  приложение с пользовательским интерфейсом для заданий 1-4. Для этого приложения должна быть реализована возможность выбора из списка любого приложения и его выполнение. 
*   Модифицировать задания 1-4 так, чтобы весь вывод происходил в текстовых областях . 
*   Т. е это должно быть не приложение командной строки , а полностью  графическое приложение. Не используйте в приложении всплывающие окна.  
*Выполнила: Ситникова В.А., 07.03.2018
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//программа 1
public class Program1 {
      
   
    public void begin(String arg1, String arg2){
        MyFrame.textOut.setText("");
        
        String [] surname = {"Иванов","Петров","Сидоров","Волков","Круглов","Смирнов","Тихонов",
                      "Егоров","Зайцев","Соколов","Михайлов","Антонов","Тихомиров","Пушкин","Светлов"}; 
        int kolStudent=0; //Переменная - хранит кол-во студентов
  
        while (kolStudent <= 0){
            try {
               kolStudent = Integer.parseInt(arg1);
            }
            catch(Exception ex){
               MyFrame.textOut.append("Вы ввели некорректно количество студентов."+ "\n");
               break;
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
            MyFrame.textOut.append (i+1 + ". "+ stud[i].getSurname()+ " "+ stud[i].getMonth() + "\n");
        }
  
  
        int numberMonth=0; //Переменная - хранит месяц
  
        while (numberMonth>12 || numberMonth<1){
            try {
               numberMonth = Integer.parseInt(arg2);
              if (numberMonth>12 || numberMonth<1){
                    MyFrame.textOut.append("Номер месяца - это число от 1 до 12, попробуйте еще раз."+ "\n");
              break;}
            }
            catch(Exception ex){
              MyFrame.textOut.append("Номер месяца должен быть целым числом. "+ "\n");
              break;
            }
        }
  
        //Вывод студентов в соответствии с заданным месяцем
        for (int i=0, k=0; i<kolStudent; i++){
            if (stud[i].getMonth()==numberMonth){
                MyFrame.textOut.append (++k + ". "+ stud[i].getSurname()+ "\n");
            }
        }        
    }
}




//Класс студент, хранит фамилию и месяц.
class student {
  private String surname;
  private int month;
    
  public void setSurname (String ss){
    surname = ss;
  }
  
  public void setMonth (int m){
      month = m;
  }
    
  public String getSurname (){
      return surname;
  }
  
  public int getMonth (){
      return month;
  }
}
