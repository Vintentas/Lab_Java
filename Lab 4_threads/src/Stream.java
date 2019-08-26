


/*
*Лабораторная работа по програмированию на языке Java №3.
*Задание:
*   Создать приложение с 2 параметрами. 1 параметр задает количество потоков , 2-ой параметр задает целое  положительное число.
*   Каждый поток по очереди уменьшает число на 1 и выводит  уменьшенное число и свое имя . Работа потоков заканчивается, когда число будет равно 0. 
*   Использовать ограничения из задания 3.    
*Выполнила: Ситникова В.А., 07.03.2018
*/

//реализация дополнительного класса
public class Stream implements Runnable {

  private int number; //номер потока
  Sinchoniz sinchroniz;
  
    Stream (int number, Sinchoniz sinchoniz){
        this.number = number+1;
        this.sinchroniz = sinchoniz;
    }
    
    public int getNumber (){
        return number;
    }
    
    public void run(){
        while (Test.kol > 0){
            
             sinchroniz.countAll(number);
           
        }     
    }
   
    


}
