

public class Main {

    public static void main(String[] args){
        Date currentDate = new Date(15, 7, 2022);
        Date birthDate = new Date(25, 4, 2002);

        int daysLived = daysLived(currentDate, birthDate);
        System.out.println("You have lived "+daysLived+" days.");
        System.out.println("That's the equivalent of "+(double) daysLived/365+" years.");
    }


    private static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    private static int daysLived(Date currentDate, Date birthDate){
        int daysLived = 0;
        int[] regularYearMonthDays = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYearMonthDays = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] birthYearMonthDays = isLeapYear(birthDate.getYear())? leapYearMonthDays : regularYearMonthDays;
        int[] currentYearMonthDays = isLeapYear(currentDate.getYear())? leapYearMonthDays : regularYearMonthDays;

        //Calculating days lived until end of birth year
        daysLived += birthYearMonthDays[birthDate.getMonth()] - birthDate.getDay();
        for(int month = birthDate.getMonth() + 1 ;  month <= 12 ; month++){
            daysLived += birthYearMonthDays[month];
        }

        //Calculating days lived in the years in between birth and current year
        for(int year = birthDate.getYear() + 1 ; year < currentDate.getYear() ; year++){
            if(isLeapYear(year))
                daysLived += 366;
            else
                daysLived += 365;
        }

        //Calculating days lived in the current year
        for(int month = 1 ; month < currentDate.getMonth() ; month++){
            daysLived += currentYearMonthDays[month];
        }
        daysLived += currentDate.getDay();

        return daysLived;
    }



}


