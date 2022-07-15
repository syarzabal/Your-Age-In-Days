

public class Main {

    public static void main(String[] args){
        Date currentDate = new Date(15, 7, 2022);
        Date birthDate = new Date(25, 4, 2002);

        System.out.println("You have lived "+daysLived(currentDate, birthDate)+" days.");
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    private static int daysLived(Date currentDate, Date birthDate){
        int daysLived = 0;

        //Adding the days in each year
        for(int auxYear = birthDate.getYear(); auxYear < currentDate.getYear() ; auxYear++){
            if(isLeapYear(auxYear))
                daysLived += 366;
            else
                daysLived += 365;
        }

        int[] currentYearMonthDays;
        if(isLeapYear(currentDate.getYear()))
            currentYearMonthDays = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        else
            currentYearMonthDays = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int auxMonth;
        for(auxMonth = 1 ; auxMonth < currentDate.getMonth() ; auxMonth++){
            daysLived += currentYearMonthDays[auxMonth];
        }

        daysLived += currentDate.getDay();

        return daysLived;
    }

}


