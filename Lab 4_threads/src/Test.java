


/*
*Лабораторная работа по програмированию на языке Java №3.
*Задание:
*   Создать приложение с 2 параметрами. 1 параметр задает количество потоков , 2-ой параметр задает целое  положительное число.
*   Каждый поток по очереди уменьшает число на 1 и выводит  уменьшенное число и свое имя . Работа потоков заканчивается, когда число будет равно 0. 
*   Использовать ограничения из задания 3.    
*Выполнила: Ситникова В.А., 07.03.2018

Wait и notify
*/

public class Test {
   
  static int kolStreams=0; //Переменная - хранит кол-во потоков
  static int kol=0; //Переменная - хранит кол-во потоков
    
    public static void main (String[] args){
       // Записываем переменную kolStreams 
       while (kolStreams == 0){
            try {
                kolStreams = Integer.parseInt(args[0]); //Запрос кол-ва заданий 
                if (kolStreams>1) System.out.println ("Необходимо создать " + kolStreams + " потока(ов)");
                else {kolStreams=2; System.out.println ("Вы ввели отрицательное число, 0 или 1, необходимо создать хотябы 2 потока." +
                                                        " Будет создано 2 потока");}
            }
            catch(Exception ex){
                System.out.println ("Вы ввели что-то не то, попробуйте еще раз. ");
                break;
            }
        }  
        // Записываем переменную kol
        while (kol == 0){
            try {
                kol = Integer.parseInt(args[1]); //Запроскол-ва заданий
                if (kol<0){kol=0;  
                    System.out.println ("Вы ввели отрицательное число или 0, уменьшать нечего!."); 
                    break;}
            }
            catch(Exception ex){
                System.out.println ("Вы ввели что-то не то, попробуйте еще раз. ");
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
                System.out.println("Я поток №"+ str.getNumber() +". Я создан!"); 
                workStream[i].start();            
            }
        }
        //Создание 1ого элемента, стартового
        Stream str = new Stream(0, sinhroniz);
        workStream[0]=new Thread(str);
        System.out.println("Я поток №"+ str.getNumber() +". Я создан!"); 
        workStream[0].start();
        
        
        
    }    
}
