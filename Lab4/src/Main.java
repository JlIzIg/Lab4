import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /**демонстрация класса Worker**/
        Worker[] work = new Worker[5];
        work[0] = new Worker(0, "Bob", "Jacobs", "John", Worker.Post.master.toString(), 50000, LocalDate.of(1972, Month.AUGUST, 30));
        work[1] = new Worker(1, "Sam", "Potter", "Phillip", Worker.Post.counter.toString(), 45000, LocalDate.of(1979, Month.OCTOBER, 5));
        work[2] = new Worker(2, "Diana", "Clark", "Josephine", Worker.Post.seller.toString(), 46000, LocalDate.of(1990, Month.DECEMBER, 3));
        work[3] = new Worker(3, "Sara", "James", "Mary", Worker.Post.programmer.toString(), 44000, LocalDate.of(2002, Month.OCTOBER, 1));
        work[4] = new Worker(4, "Tom", "Coder", "Smith", Worker.Post.worker.toString(), 44000, LocalDate.of(2003, Month.APRIL, 4));
        WorkersInfo info1 = new WorkersInfo(work);
        System.out.println(info1.getInfo(info1.getMinAge(work.length)));


/**демонстрация класса Market**/
        Market[] market = new Market[10];
        market[0] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 1));
        market[1] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 2));
        market[2] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.КОМПЬЮТЕР.toString(), 1, 10000, LocalDate.of(2022, Month.APRIL, 3));
        market[3] = new Market(Market.Name_sal.ЧАЙКОВСКИЙ.toString(), Market.Product_NAME.ЖУРНАЛ.toString(), 5, 50, LocalDate.of(2022, Month.APRIL, 4));
        market[4] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.ПРИНТЕР.toString(), 5, 2000, LocalDate.of(2022, Month.APRIL, 5));
        market[5] = new Market(Market.Name_sal.ПЕТРОВ.toString(), Market.Product_NAME.КНИГА.toString(), 4, 250, LocalDate.of(2022, Month.APRIL, 6));
        market[6] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.МЫШЬ.toString(), 5, 250, LocalDate.of(2022, Month.APRIL, 7));
        market[7] = new Market(Market.Name_sal.ПЕТРОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 8));
        market[8] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.ПУЗЫРИ.toString(), 2, 20, LocalDate.of(2022, Month.APRIL, 9));
        market[9] = new Market(Market.Name_sal.ЛЕРМОНТОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 10));

        InfoMarket market1 = new InfoMarket(market);
        String nameSeller = Market.Name_sal.ЧАЙКОВСКИЙ.toString();
        int quantitySold = market1.getInfoNumberOfSellingProducts(nameSeller)[0];
        System.out.println("Продавец " + nameSeller + " продал " + quantitySold + " продуктов.");
        int varProducts = market1.getInfoNumberOfSellingProducts(nameSeller)[1];
        System.out.println("Продавец " + nameSeller + " продал " + varProducts + " типов продуктов.");
        System.out.println("Информация о самом дорогом продукте проданым данным продавцом");
        System.out.println(market1.getExpensiveProd(nameSeller));
        System.out.println("Информация продуках проданым данным продавцом");
        String [] arr  = market1.getInfoProd(nameSeller);
        System.out.println(Arrays.toString(arr));


    }
}

