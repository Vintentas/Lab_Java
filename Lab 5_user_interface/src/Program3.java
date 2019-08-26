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

//программа 3
public class Program3 {
    
  
    public void begin (String arg1){
        MyFrame.textOut.setText("");
        
        //Запрос с клавиатуры кол-ва заданий
        //System.out.print ("Введите количество заданий: ");
          int exercise=0; //Переменная - хранит кол-во упражнение
        while (exercise == 0){
            try {

                exercise = Integer.parseInt(arg1); //Запроскол-ва заданий
            }
            catch(Exception ex){
                MyFrame.textOut.append ("Вы ввели что-то не то, попробуйте еще раз. \n");
                break;
            }
        }
        
        MyFrame.textOut.append("На сегодня необходимо выполнить " + exercise + " задание(ия,ий).\n"); 
        Count.setCount(exercise);
        Count.countTrainer=1;
        Count.countSportsman=1;
        
        //Создаем объекты классов, расширяющих Runnable, в которых находятся методы run()
        StreamTrainer runTrainer = new StreamTrainer();
        StreamSportsman runSportsman = new StreamSportsman();

        //Создаем объекты потоков
        Thread trainer = new Thread(runTrainer);
        Thread sportsman = new Thread(runSportsman);
        
        //Запускаем потоки
        trainer.start();
        sportsman.start();
       
       
       // System.out.println("Ура! Тренеровка завершина!.");
    } 
  
}
