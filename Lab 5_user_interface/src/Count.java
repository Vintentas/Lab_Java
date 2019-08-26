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

//notify, wait 
//Класс - счетчик упражнений
public class Count {
   
  static private int count;  //общее кол-во упражнений
  static public int countTrainer; //счетчик тренера
  static public int countSportsman; // счетчик спортсмена
  
  //Метод, запрашивает имя и количество выполненных заданий
  //        возвращает либо кол-во выполненных заданий, либо 0;
    static public synchronized int counterExercise (int a, String name){
        
        //тут сравнивается имя, номер задания и проверяется выполненно оно или нет
        if(name=="trainer" & a<countTrainer & countTrainer<=countSportsman){    
            MyFrame.textOut.append("Я тренер. Я даю задание " + countTrainer + ".\n");  
            return  countTrainer++;
        }
        if(name=="sportsman" & a<countSportsman & countSportsman<countTrainer){  
            MyFrame.textOut.append("Я спортсмен. Я выполняю задание " + countSportsman + ".\n"); 
            return countSportsman++;
        }
        else return 0;
         
    }
    
   
    static public synchronized void setCount(int a){
        count= a;
    }
    
    static public synchronized int getCount(){
        return count;
    }
}
