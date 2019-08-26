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

public class Test {
    public static void main(String[] args){
        
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
        
        //2 цикл - вывод объектов, которые реализуют Present       
        for (Product product : myProduct){
            if (product instanceof Present){ //в строке происходит сравнени с нужным интерфейсом
                Present present = (Present) product; //в этой строке расширяем объект до нужного интерфейса
                System.out.println (present.it_can_be_presented());
            }
        }
    }
}

