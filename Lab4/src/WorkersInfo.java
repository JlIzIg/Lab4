import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class WorkersInfo {

    private Worker[] workers;
    public WorkersInfo() {

    }
    public WorkersInfo(Worker[] workers) {
        this.workers = workers;

    }
    /**
     * метод возвращающий индекс работника с наименьшим возрастом
     **/
    public int getMinAge(int N) {
        int[] age = new int[N];
        for (int i = 0; i < N; i++) {
            age[i] = Period.between(workers[i].getBirthday(), LocalDate.now()).getYears();
        }
        int min_index = 0;
        for (int i = 0; i < workers.length - 1; i++) {
            if (age[min_index] > age[i + 1]) min_index = (i + 1);
        }
        return min_index;
    }

    /**
     * метод возвращающий строку информации о сотруднике по id
     **/
    public String getInfo(int id) {
        return "Worker is " + workers[id].getName() + " " + workers[id].getSurname() + " " + workers[id].getFather_name() + ". Post is " + workers[id].getPost() + ". Salaries is " + workers[id].getSalaries() + ". Date of birthday is " + workers[id].getBirthday();
    }

}
