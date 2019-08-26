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

//программа 4
public class Program4{
    
  
  static int kolStreams=0; //Переменная - хранит кол-во потоков
  static int kol=0; //Переменная - хранит кол-во потоков
  
 

    
    public void begin (String arg1, String arg2){
    MyFrame.textOut.setText("");
   
    while (kolStreams == 0){
            try {
                kolStreams = Integer.parseInt(arg1); //Запрос кол-ва заданий 
                if (kolStreams>1)  MyFrame.textOut.append  ("Необходимо создать " + kolStreams + " потока(ов) \n");
                else {kolStreams=2;  MyFrame.textOut.append  ("Вы ввели отрицательное число, 0 или 1, необходимо создать хотябы 2 потока." +
                                                        " Будет создано 2 потока \n");}
            }
            catch(Exception ex){
                MyFrame.textOut.append  ("Вы ввели что-то не то, попробуйте еще раз. \n ");
                break;
            }
        }  
        // Записываем переменную kol
        while (kol == 0){
            try {
                kol = Integer.parseInt(arg2); //Запроскол-ва заданий
                if (kol<0){kol=0;  
                    MyFrame.textOut.append  ("Вы ввели отрицательное число или 0, уменьшать нечего!. \n"); 
                    break;}
            }
            catch(Exception ex){
                MyFrame.textOut.append   ("Вы ввели что-то не то, попробуйте еще раз.  \n");
                break;
            }
        }
        
        //создадим объект класса для синхронизации
        Sinchoniz sinhroniz = new Sinchoniz();
        
        //Создаем массив потоков и запускаем
        Thread [] workStream = new Thread[kolStreams];
        //создание массива без 1 элемента
        if (kolStreams > 1){
            for (int i=1; i<kolStreams; i++){
                Stream str = new Stream(i, sinhroniz);
                workStream[i]=new Thread(str);
                MyFrame.textOut.append  ("Я поток №"+ str.getNumber() +". Я создан! \n"); 
                workStream[i].start();            
            }
        }
        //Создание 1ого элемента, стартового
        Stream str = new Stream(0, sinhroniz);
        workStream[0]=new Thread(str);
         MyFrame.textOut.append("Я поток №"+ str.getNumber() +". Я создан! \n"); 
        workStream[0].start();
        
        
        
    }        
    
  
    
    
    
}
