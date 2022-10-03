import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;

/**
 * Средний уровень.
 * Вариант 1
 * Поля класса:
 * Фамилия
 * Имя
 * Отчество
 * Должность
 * Зарплата
 * Дата рождения
 **/

public class Workers {
    /**
     * поле id ведено для удобства
     **/
    private int id;
    /**
     * поле имя
     **/
    private String name;
    /**
     * поле фамилия
     **/
    private String surname;
    /**
     * поле отчество
     **/
    private String father_name;
    /**
     * поле должность
     **/
    private String post;
    /**
     * поле з/п
     **/

    private int salaries;
    /**
     * поле день рождения. по умолчанию будет текущая дата
     **/
    private LocalDate birthday = LocalDate.now();
    /**константы класса**/
    public static  final LocalDate MAX_DATA = LocalDate.of(LocalDate.now().getYear()-18, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    public static  final LocalDate MIN_DATA = LocalDate.of(LocalDate.now().getYear()-90, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    public static int MIN_SALARIES = 10000;

    /**
     * геттер для id
     **/

    public int getId() {
        return id;
    }

    /**
     * сеттер для id
     **/

    public void setId(int id) {
        this.id = id;
    }

    /**
     * геттер для name
     **/
    public String getName() {
        return name;
    }

    /**
     * сеттер для name
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * геттер для surname
     **/
    public String getSurname() {
        return surname;
    }

    /**
     * сеттер для surname
     **/
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * геттер для father_name
     **/
    public String getFather_name() {
        return father_name;
    }

    /**
     * сеттер для father_name
     **/
    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    /**
     * геттер для post
     **/
    public String getPost() {
        return post;
    }

    /**
     * сеттер для post
     **/
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * геттер для salaries
     **/
    public int getSalaries() {
        return salaries;
    }

    /**
     * сеттер для salaries
     **/
    public void setSalaries(int salaries) {
        if (salaries<MIN_SALARIES)
            this.salaries = MIN_SALARIES;
        else this.salaries = salaries;
    }

    /**
     * геттер для birthday
     **/
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * сеттер для birthday
     **/
    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(MAX_DATA))
            this.birthday = MAX_DATA;
        else if (birthday.isBefore(MIN_DATA))
            this.birthday = MIN_DATA;
        else
            this.birthday = birthday;
    }

    /**
     * конструктор класса
     **/
    public Workers() {
    }

    /**
     * параметризированный конструктор класса
     **/
    public Workers(int id, String name, String surname, String father_name, String post, int salaries, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.father_name = father_name;
        this.post = post;
        if (salaries<MIN_SALARIES)
            this.salaries = MIN_SALARIES;
        else this.salaries = salaries;
        if (birthday.isAfter(MAX_DATA))
            this.birthday = MAX_DATA;
        else if (birthday.isBefore(MIN_DATA))
            this.birthday = MIN_DATA;
        else
            this.birthday = birthday;
    }


    /**
     * метод возвращающий индекс работника с наименьшим возрастом
     **/
    public static int getMinAge(Workers[] work, int N) {
        int[] age = new int[N];
        for (int i = 0; i < N; i++) {
            age[i] = Period.between(work[i].getBirthday(), LocalDate.now()).getYears();
        }
        System.out.println(Arrays.toString(age));
        int min_index = 0;
        for (int i = 0; i < work.length - 1; i++) {
            if (age[min_index] > age[i + 1]) min_index = (i + 1);
        }
        return min_index;
    }

    /**
     * метод возвращающий строку информации о сотруднике из массива сотрудников и id
     **/
    public static String getInfo(Workers[] work, int id) {
        return "Worker is " + work[id].getName() + " " + work[id].getSurname() + " " + work[id].getFather_name() + ". Post is " + work[id].getPost() + ". Salaries is " + work[id].getSalaries() + ". Date of birthday is " + work[id].getBirthday();
    }

    /**
     * enum для поля пост, то есть возможные значения для должности
     **/
    enum Post {
        master,
        counter,
        seller,
        programmer,
        worker

    }
}
