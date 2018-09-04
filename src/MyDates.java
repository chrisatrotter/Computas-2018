import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MyDates {

    public Collection<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate))
            return new ArrayList<>();
        if (startDate.isEqual(endDate))
            return new ArrayList<>();

        return startDate.datesUntil(endDate)
                .filter(date -> !startDate.isEqual(date))
                .collect(Collectors.toList());
    }
}
