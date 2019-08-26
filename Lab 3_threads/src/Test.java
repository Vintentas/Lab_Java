
import java.util.Scanner;

/*
*Лабораторная работа по програмированию на языке Java №3.
*Задание:
*    Есть 2 потока - тренер и спортсмен. тренер ставит задачу перед спортсменом. Когда  спортсмен выполняет задание, тренер ставит следующую задачу и т. д. Число заданий задается параметром
*    На дисплей выводится номер задания и имя тренера или спортсмена.
*    Выполнить задание   с использованием конструкции synchronized . 
*    Не использовать в этом задании флаги для синхронизации потоков, а только методы wait и notify. 
*    Также не использовать любые задержки для потоков после начала их работы в виде методов sleep, yield или wait c параметром.
*Выполнила: Ситникова В.А., 25.02.2018
*/

import java.util.Scanner; //импорт класса для работы с вводом

public class Test {
    
    public static void main (String[] args){
        
        //Запрос с клавиатуры кол-ва заданий
        //System.out.print ("Введите количество заданий: ");
          int exercise=0; //Переменная - хранит кол-во упражнение
        while (exercise == 0){
            try {
                /*Scanner kol = new Scanner(System.in);
                exercise = kol.nextInt();*/
                exercise = Integer.parseInt(args[0]); //Запроскол-ва заданий
                
            }
            catch(Exception ex){
                System.out.println ("Вы ввели что-то не то, попробуйте еще раз. ");
                break;
            }
        }
        
        
        System.out.println("На сегодня необходимо выполнить " + exercise + " задание(ия,ий)."); 
        Count.setCount(exercise);
        
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
