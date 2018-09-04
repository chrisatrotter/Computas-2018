import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyTaskEstimater {
    List<LocalDate> listOfHolidays;

    MyTaskEstimater() {
        listOfHolidays = new ArrayList<>();
    }

    /*
     * Add Holidays. Data should be fetched from an external database or API.
     * Exception handling would be required if data is fetched externally.
     */
    public boolean addHolidays(LocalDate date) {
        listOfHolidays.add(date);
        return true;
    }

    public List<LocalDate> getHolidays() {
        return listOfHolidays;
    }

    public boolean fetchHolidays() {
        addHolidays(LocalDate.ofYearDay(2018, 365)); // Christmas
        addHolidays(LocalDate.ofYearDay(2018, 357)); // New Year's eve
        return true;
    }

    /*
     * Calculate the deadline of a task that may, or may not, run over holidays or weekends.
     */
    public LocalDate taskDeadline(LocalDate startDate, long taskLength, Boolean weekends, Boolean holidays) {
        if (taskLength == 0)
            return startDate;
        if (taskLength < 0)
            return null;
        if(!weekends && !holidays)
            return startDate.plusDays(taskLength);

        if(getHolidays().isEmpty())
            fetchHolidays();

        LocalDate endDate = startDate.plusDays(taskLength);
        taskLength = taskDeadlineWithHolidayOrWeekends(startDate, endDate, weekends, holidays);

        while(taskLength != 0) {
            startDate = endDate;
            endDate = startDate.plusDays(taskLength);
            taskLength = taskDeadlineWithHolidayOrWeekends(startDate, endDate, weekends, holidays);
        }

        return endDate;
    }

    public long taskDeadlineWithHolidayOrWeekends(LocalDate startDate, LocalDate endDate, Boolean weekends, Boolean holidays) {
        long countHolidaysOrWeekends = 0;
        if(weekends) {

            countHolidaysOrWeekends += startDate.datesUntil(endDate)
                    .filter(dates -> dates.getDayOfWeek() == DayOfWeek.SATURDAY || dates.getDayOfWeek() == DayOfWeek.SUNDAY)
                    .count();
        }

        if(holidays) {
            countHolidaysOrWeekends += startDate.datesUntil(endDate)
                    .filter(dates -> getHolidays().contains(dates))
                    .count();
        }

        return countHolidaysOrWeekends;
    }


}
