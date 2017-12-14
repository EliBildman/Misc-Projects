package textExcel2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCell extends Cell
{
    Date date;
    
    public DateCell (String contents) throws ParseException
    {
        super(contents);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        date = format.parse(contents);
    }
    
    public String getValue()
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return format.format(date);
    }
}