package mx.com.prosa.poc.to;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsoleResponseTO<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = 1119272018217831326L;
	@JsonInclude(Include.NON_NULL)
	private T changes;
	private String graph;
}
