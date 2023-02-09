package utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Utilidades {
	public static LocalDate convertirTextoFecha(String fecha) {
		DateTimeFormatter format=new DateTimeFormatterBuilder()
				.appendPattern("YYYY-ww")
				.parseDefaulting(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue())
				.toFormatter();
		return LocalDate.parse(fecha, format);
	}
}
