import java.time.LocalDate;
import java.time.Month;

/**
 * Базовый уровень.
 * Вариант 1
 * Поля класса:
 * Продавец
 * Наименование
 * Количество
 * Цена
 * Дата продажи
 **/
public class Market {
    /**
     * поле продавец
     **/
    private String salesman;
    /**
     * поле наименование
     **/
    private String name_product;
    /**
     * поле количество
     **/
    private int quantity;
    /**
     * поле цена
     **/
    private int price;
    /**
     * поле дата продажи
     **/
    private LocalDate date_seller = LocalDate.now();

    /**
     * геттед для salesman
     **/
    public String getSalesman() {
        return salesman;
    }

    /**
     * сеттер для salesman
     **/
    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    /**
     * геттер для name_product
     **/
    public String getName_product() {
        return name_product;
    }

    /**
     * сеттер для name_product
     **/

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    /**
     * геттер для quantity
     **/

    public int getQuantity() {
        return quantity;
    }

    /**
     * сеттер для quantity
     **/

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /***геттер для price*/

    public int getPrice() {
        return price;
    }

    /**
     * сеттер для price
     **/

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * геттер для date_seller
     **/

    public LocalDate getDate_seller() {
        return date_seller;
    }

    /**
     * сеттер для date_seller
     **/

    public void setDate_seller(LocalDate date_seller) {
        this.date_seller = date_seller;
    }

    /**
     * конструктор класса
     **/
    public Market() {
    }

    /**
     * параметризированный конструктор класса
     **/

    public Market(String salesman, String name_product, int quantity, int price, LocalDate date_seller) {
        this.salesman = salesman;
        this.name_product = name_product;
        this.quantity = quantity;
        this.price = price;
        this.date_seller = date_seller;
    }

    /**
     * метод который выводит количество товаров, проданных конкретным продавцом, выводит сведенья о них, определяет из них товар с максимальной стоимостью
     **/
    public static void getNumberOfSellingProducts(Market[] markets, String salesman) {
        int quantity = 0;
        int max_index = 0;
        for (int i = 0; i < markets.length; i++) {
            if (markets[i].getSalesman() == salesman) {
                quantity += markets[i].getQuantity();
                System.out.printf("\nThe product is %s, it's quantity is %d, it's price is %d.", markets[i].getName_product(), markets[i].getQuantity(), markets[i].getPrice());
                System.out.print("The date of sold is " + markets[i].getDate_seller() + ".");
            }
            for (int j = i; j < markets.length - 1; j++) {
                if (markets[i].getSalesman() == salesman && markets[max_index].getPrice() < markets[j + 1].getPrice()) {
                    max_index = i;
                }
            }
        }
        System.out.printf("\nThe quantity of products sold by %s is %d.", salesman, quantity);
        System.out.printf("\nThe highest price is %d of product %s.", markets[max_index].getPrice(), markets[max_index].getName_product());
    }

    /**
     * enum для поля salesman, то есть возможные значения имён продавцов
     **/

    enum Name_sal {
        ИВАНОВ,
        ПЕТРОВ,
        СИДОРОВ,
        ПУШКИН,
        ЛЕРМОНТОВ,
        ЧАЙКОВСКИЙ
    }

    /**
     * enum для поля name_product, то есть возможные значения названий товаров
     **/
    enum Product_NAME {
        ТЕЛЕФОН,
        КОМПЬЮТЕР,
        ТЕЛЕВИЗОР,
        ХОЛОДИЛЬНИК,
        МЫШЬ,
        ПРИНТЕР,
        ПОДСТАВКА,
        КНИГА,
        ЖУРНАЛ,
        ТАБЛЕТКИ,
        ТЕРМОПАСТА,
        ЛУЧ,
        ПУЗЫРИ
    }
}
