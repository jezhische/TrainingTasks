package java_util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarTest {
    public CalendarTest() {
    }
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2002);
        cal.set(Calendar.MONTH,Calendar.AUGUST);
        cal.set(Calendar.DAY_OF_MONTH,31);
        System.out.println(" Initialy set date: " + sdf.format(cal.getTime()));
        cal.set(Calendar.MONTH,Calendar.SEPTEMBER); // было установлено 31 августа. Поскольку 31 сентября не быввает,
        // дата автоматически сдвинута на 1 октября
        System.out.println(" Date with month changed : " + sdf.format(cal.getTime()));
        cal.set(Calendar.DAY_OF_MONTH,30);
        System.out.println(" Date with day changed : " + sdf.format(cal.getTime()));

        System.out.println();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR,2002);
        cal2.set(Calendar.MONTH,Calendar.AUGUST);
        cal2.set(Calendar.DAY_OF_MONTH,31);
        System.out.println(" Initialy set date: " + sdf.format(cal2.getTime()));
        cal2.set(Calendar.MONTH,Calendar.SEPTEMBER);
        cal2.set(Calendar.DAY_OF_MONTH,30);
        System.out.println(" Date with day and month changed : " + sdf.format(cal2.getTime()));

        System.out.println();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.UK);
        System.out.println(df.format(new Date()));
        System.out.println(df.format(System.currentTimeMillis()));
        System.out.println(df.format(-7987798798L));
//        try {
//            System.out.println(df.parse("2010:05:14 08:53:13"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        SimpleDateFormat simple = (SimpleDateFormat) SimpleDateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL,
                Locale.ENGLISH);
        System.out.println(simple.format(new Date()));

        DateFormat simple2 = SimpleDateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
        System.out.println(simple2.format(System.currentTimeMillis()));

    }
}
