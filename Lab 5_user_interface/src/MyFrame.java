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

//Класс для рисования рабочего окна, интерфейс ActionListener - обрабатывает события
public class MyFrame implements ActionListener  {

     JButton button1 = new JButton("Программа 1"); //переменные для кномок
     JButton button2 = new JButton("Программа 2");
     JButton button3 = new JButton("Программа 3");
     JButton button4 = new JButton("Программа 4");
     static JTextArea textOut = new JTextArea(25,40);//окно для вывода
    JTextField textInto1 = new JTextField(20);//поле для ввода текста
    JTextField textInto2 = new JTextField(20);//поле для ввода текста
     
     JFrame frame;//переменная хранит фрейм
     
     
    //рисуем главный экран
    public void battons (){
        
        //Создаем фрейм
        frame = new JFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //закрытие программы по нажатию на крестик
          frame.setSize(530,600); // ризмер экрана
          frame.setVisible(true); //фрейм видим
     
        //создаем панель и добавляем в нее кнопки  
        JPanel panelButtons = new JPanel();
          panelButtons.add(button1);
          panelButtons.add(button2);
          panelButtons.add(button3);
          panelButtons.add(button4);
        
        //добавляем панель во фрейм  
          frame.getContentPane().add(BorderLayout.NORTH,panelButtons); 
  
        //создаем рабочюу панель
        JPanel panel = new JPanel();
         
        //для ввода текста
        panel.add(textInto1);
        panel.add(textInto2);

        //для вывода текста 
        panel.add(textOut);

        //textOut.setText("Задайте количество студентов и месяц. программа сгенерирует список студентов и выведет его на экран, после чего выберет из него студентов с заданным месяцем.");
        textOut.setLineWrap(true);
        textOut.setWrapStyleWord(true);
        
        JScrollPane scrollBar = new JScrollPane(textOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.add(scrollBar);
        
        frame.getContentPane().add(BorderLayout.CENTER,panel);    
        
        
         //Полоса прокрутки
      //  frame.getContentPane().add(scrollBar, BorderLayout.WEST);
        

          
        //кнопки прослушивают события.
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
    }
    
    //Метод обработки, если события произлшли
    public void actionPerformed(ActionEvent event){
        JButton eventButton=(JButton)event.getSource();//создаем вспомагательный элемент кнопки
        
        //Сравниваем полученные отклики кнопок
        if (eventButton.equals(button1)) program1();
        if (eventButton.equals(button2)) program2();
        if (eventButton.equals(button3)) program3();
        if (eventButton.equals(button4)) program4();
    }
    
    void program1 (){
        Program1 pr = new Program1();
        pr.begin(textInto1.getText(), textInto2.getText());
    }
    
    void program2 (){
        Program2 pr = new Program2();
        pr.begin();        
    }
    void program3 (){
        Program3 pr = new Program3();
        pr.begin(textInto1.getText());
    }
    void program4 (){
        Program4 pr = new Program4();
        pr.begin(textInto1.getText(), textInto2.getText());        
    }
   
    
    
    
    
    
}
