/*
*Лабораторная работа по програмированию на языке Java №2.
*Задание:
* Создать приложение с 2 классами- Book, Shoe  и  интерфейсом Product. Интерфейс содержит метод whoAmI, который будет реализован в имплементирующих классах. Определить новый интерфейс  Present,
*    расширяющий интерфейс Product и содержащий  метод it_can_be_presented(), который может возвращать строку.
* Объявить 2 новых класса (например Toy, Picture), реализующих  интерфейс Present.
* В приложении создать массив объектов Product-(Book, Shoe,Toy, Picture) , состоящий из количества элементов заданного параметром.
* Перебирая в цикле элементы массива Product, находить  c помощью оператора  instanceof  те объекты, которые реализуют  интерфейс Present.
* Для каждого найденного элемента массива Product, реализующего новый интерфейс Present, 
*    выполнить метод нового интерфейса it_can_be_presented(). Вывод должен содержать названия всех продуктов из массива, затем тех продуктов, которые реализуют интерфейс Present.

*Выполнила: Ситникова В.А., 07.03.2018
*/

//Реализация класса Book
public class Book implements Product {
    String name;
    
    public Book(String n){
    name = n;
    }
    
    public void whoAmI(){
        System.out.println ("I'am " + name + "!");    
    }
}
