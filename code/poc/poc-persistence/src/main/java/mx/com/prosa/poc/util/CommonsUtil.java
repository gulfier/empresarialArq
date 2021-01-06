package mx.com.prosa.poc.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonsUtil {
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * To timestamp.
	 *
	 * @param dateString the date string
	 * @return the timestamp
	 */
	public static Timestamp toTimestamp(String dateString) {
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat(
                "MM-dd-yyyy HH:mm:ss");
		Date date = null;
		try {
			date = datetimeFormatter.parse(dateString);
//			logger.info(date.toString());
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
//			logger.error("Error al parsear la fecha: "+dateString);
			return null;
		}
	}
}
