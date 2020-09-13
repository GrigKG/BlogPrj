package telran.ashkelon2020.dto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2201156176766386581L;

	public ObjectNotFoundException(Object object) {
		super("Object "+object+" not found");
	}
}
