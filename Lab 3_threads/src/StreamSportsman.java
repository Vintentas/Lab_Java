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

//import java.lang.Thread; //класс для работы с потоками

//Класс для работы с потоком "Спортсмен"
public class StreamSportsman implements Runnable {
    
    private int count;
    private String name = "sportsman";
    
    public void run(){
        
        //Счетчик по кол-ву заданий. Постепенно увиличивает свое значение и сравнивает с общим значением заданий
        while (count < Count.getCount()){
            int a=Count.counterExercise(count, name);
            if (a!=0) count=a;
        }
    }
       
}
