# Computas-2018
A task done as part of a technical interview for a job at Computas. Below is a description of the task that had to be solved.

# Task
Oppgave til forberedelse 
1) 
I metoden under har det lurt seg inn tre feil. Kan du identifisere alle og si noe om hva som er feil? Kan du også skrive om metoden slik at den fungerer som tiltenkt? Noter antagelser og forutsetninger du gjør underveis.

```
 public static LocalDate[] getDatesBetween(LocalDate startDate, LocalDate endDate) {
        LocalDate[] dates = new LocalDate[];
        LocalDate currentDate = startDate.plusDays(1);
        while (currentDate != endDate) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return dates;
    }
```


2)
Du skal lage logikk for å beregne hvilken dag en frist går ut. En frist kan skulle gå i helger og ferier, eller ikke gjøre det.
Brukeren kan selv bestemme når fristen starter, hvor lang den skal være og om den skal gå i helger og ferier eller ikke.

Gjør de forutsetningene du mener er rimelige, og bruk de verktøyene du ønsker. Du kan velge å løse oppgaven i en IDE, i en ren teksteditor eller på tavle. Under intervjuet ønsker vi at du går gjennom løsningen din, og så diskuterer vi valg og antakelser som er gjort.



