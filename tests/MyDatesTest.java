import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyDatesTest {

    @Test
    void testGetDatesBetweenEquals() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();

        ArrayList<LocalDate> listOfDates = new ArrayList<>();

        MyDates dates = new MyDates();

        assertEquals(listOfDates, dates.getDatesBetween(startDate, endDate), "Same date must return this date.");
    }

    @Test
    void testGetDatesBetweenStartDateAfter() {
        LocalDate startDate = LocalDate.now().plusDays(1);
        LocalDate endDate = LocalDate.now();

        ArrayList<LocalDate> listOfDates = new ArrayList<>();

        MyDates dates = new MyDates();

        assertEquals(listOfDates, dates.getDatesBetween(startDate, endDate), "When startDate is after endDate, return empty list.");
    }

    @Test
    void testGetDatesBetween() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(5);

        ArrayList<LocalDate> listOfDates = new ArrayList<>();

        MyDates dates = new MyDates();

        listOfDates.add(startDate.plusDays(1));
        listOfDates.add(startDate.plusDays(2));
        listOfDates.add(startDate.plusDays(3));
        listOfDates.add(startDate.plusDays(4));

        assertEquals(listOfDates, dates.getDatesBetween(startDate, endDate), "Return a list with dates between today's date and the date in five days.");
    }


}