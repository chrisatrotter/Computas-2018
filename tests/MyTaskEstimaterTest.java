import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyTaskEstimaterTest extends MyDates {

    @Test
    void addHolidays() {
        MyTaskEstimater taskEstimater = new MyTaskEstimater();

        /* Assuming there is always 365 days in a year. Disregarding leap years. */
        LocalDate christmas = LocalDate.ofYearDay(2018, 357);
        LocalDate newYear = LocalDate.ofYearDay(2018, 365);

        List<LocalDate> listOfHolidays = new ArrayList<>();
        listOfHolidays.add(christmas);
        listOfHolidays.add(newYear);

        taskEstimater.addHolidays(christmas);
        taskEstimater.addHolidays(newYear);

        assertEquals(listOfHolidays, taskEstimater.getHolidays(), "Christmas and New Year's eve should be added.");
    }

    @Test
    void taskDeadline() {
        MyTaskEstimater taskEstimater = new MyTaskEstimater();
        LocalDate deadline = taskEstimater.taskDeadline(LocalDate.now(), 8, true, true);

        assertEquals(LocalDate.now().plusDays(10), deadline, "Dates do not match");
    }

}