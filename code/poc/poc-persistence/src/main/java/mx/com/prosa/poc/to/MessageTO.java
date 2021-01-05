package mx.com.prosa.poc.to;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the message.
 *
 * @return the message
 */
@Getter

/**
 * Sets the message.
 *
 * @param message the new message
 */
@Setter
public class MessageTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 267815343861808871L;
	
	/** The message. */
	private String message;
}
