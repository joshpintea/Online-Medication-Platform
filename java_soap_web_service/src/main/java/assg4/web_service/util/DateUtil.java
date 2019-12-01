package assg4.web_service.util;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public static XMLGregorianCalendar convertDateToXmlGregorianCalendar(Date date) {
        XMLGregorianCalendar xmlDate = null;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);

        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return xmlDate;
    }

    public static Date convertXmlGregorianCalendarToDate(XMLGregorianCalendar gc) {
        return new Date(gc.toGregorianCalendar().getTime().getTime());
    }
}
