package java_util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat inSDF = new SimpleDateFormat("dd/mm/yyyy G");
        SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-dd-mm G");

        Date date = inSDF.parse("32/01/2017 AD");
        System.out.println(date);

        String formatDate = outSDF.format(date);
        System.out.println(formatDate); // but if "32/01/2017 AD", then will be "Wed Feb 01 00:01:00 EET 2017", but
//"2017-01-01 н.э."; and when "33/01/2017 AD", will be "2017-02-01 н.э."; and "34/01/2017 AD" will be "2017-03-01 н.э." etc
    }
}


