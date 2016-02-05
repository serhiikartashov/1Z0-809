#Eastern Standard Time (EST) is 5 hours behind Coordinated Universal Time (UTC). 
This time zone is a standard time zone and is used in: 
North America, Caribbean, Central America.

When working with dates and times, the fi rst thing to do is decide 
how much information you need. The exam gives you three choices:

- LocalDate  Contains just a date—no time and no time zone.
- LocalTime   Contains just a time—no date and no time zone.
- LocalDateTime  Contains both a date and time but no time zone.

#The date and time classes are immutable!

                            LocalDate   LocalTime   LocalDateTime
plusYears/minusYears        Yes         No          Yes
plusMonths/minusMonths      Yes         No          Yes
plusWeeks/minusWeeks        Yes         No          Yes
plusDays/minusDays          Yes         No          Yes
plusHours/minusHours        No          Yes         Yes
plusMinutes/minusMinutes    No          Yes         Yes
plusSeconds/minusSeconds    No          Yes         Yes
plusNanos/minusNanos        No          Yes         Yes

- LocalDate has toEpochDay(), 
        which is the number of days since January 1, 1970
- LocalDateTime has toEpochSecond(), 
        Converts this date-time to the number of seconds from the epoch
        of 1970-01-01T00:00:00Z.
- LocalTime does not have an epoch method. 
        Since it represents a time that occurs on any date, 
        it doesn’t make sense to compare it in 1970.

Locale specific format  localDate           localDateTime       localTime
ofLocalizedDate         Legal(whole object) Legal(date part)    runtime excep
ofLocalizedDateTime     runtime excep       Legal(whole object) runtime excep
ofLocalizedTime         runtime excep       Legal(time part)    Legal(whole object)
