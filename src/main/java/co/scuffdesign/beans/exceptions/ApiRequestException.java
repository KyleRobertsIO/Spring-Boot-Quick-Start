package co.scuffdesign.beans.exceptions;

import java.time.Instant;
import java.util.HashMap;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	
	private HashMap<String, String> validationMessage = new HashMap<String, String>();
	
	private long timestamp = Instant.now().toEpochMilli();
	
	public ApiRequestException(String message) {
		super(message);
	}
	
}
