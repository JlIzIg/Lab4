import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class WorkersInfo {

    private Worker[] workers;
    private int N;


    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }


    public WorkersInfo() {

    }

    public WorkersInfo(Worker[] workers, int n) {
        this.workers = workers;
        N = n;
    }

    /**
     * метод возвращающий индекс работника с наименьшим возрастом
     **/
    public static int getMinAge(Worker[] workers, int N) {
        int[] age = new int[N];
        for (int i = 0; i < N; i++) {
            age[i] = Period.between(workers[i].getBirthday(), LocalDate.now()).getYears();
        }
        System.out.println(Arrays.toString(age));
        int min_index = 0;
        for (int i = 0; i < workers.length - 1; i++) {
            if (age[min_index] > age[i + 1]) min_index = (i + 1);
        }
        return min_index;
    }

    /**
     * метод возвращающий строку информации о сотруднике из массива сотрудников и id
     **/
    public static String getInfo(Worker[] work, int id) {
        return "Worker is " + work[id].getName() + " " + work[id].getSurname() + " " + work[id].getFather_name() + ". Post is " + work[id].getPost() + ". Salaries is " + work[id].getSalaries() + ". Date of birthday is " + work[id].getBirthday();
    }

}
