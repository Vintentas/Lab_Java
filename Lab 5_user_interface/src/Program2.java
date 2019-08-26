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

//программа 2
public class Program2 {
    
    
    public void begin (){
        
      MyFrame.textOut.setText("");
     //Реализуем массив Product
        Product[] myProduct = new Product[8];
         Book book = new Book("red_book");
         Shoe shoe = new Shoe("leather_shoe");
         Toy toy = new Toy("plush_toy");
         Picture pict = new Picture("color_picture");
        myProduct[0] = book;
        myProduct[1] = shoe;
        myProduct[2] = toy;
        myProduct[3] = pict;
         book = new Book("blue_book");
         shoe = new Shoe("woven_shoe");
         toy = new Toy("plastic_toy");
         pict = new Picture("black_and_white_picture");
        myProduct[7] = book;
        myProduct[6] = shoe;
        myProduct[5] = toy;
        myProduct[4] = pict;
       
        
        //1 цикл - вывод всего списка
        for(Product product : myProduct) {
            product.whoAmI();
        }
        
        System.out.println();
        MyFrame.textOut.append("\n");
        //2 цикл - вывод объектов, которые реализуют Present       
        for (Product product : myProduct){
            if (product instanceof Present){ //в строке происходит сравнени с нужным интерфейсом
                Present present = (Present) product; //в этой строке расширяем объект до нужного интерфейса
                System.out.println (present.it_can_be_presented());
                 MyFrame.textOut.append(present.it_can_be_presented()+ "\n");
            }
        }

    }
}
