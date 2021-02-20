package co.scuffdesign.beans.payloads;

import java.time.Instant;
import java.util.HashMap;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ApiErrorResponse {

	private String message;
	
	@Builder.Default
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	
	@Builder.Default
	private HashMap<String, String> validationMessages = new HashMap<String, String>();
	
	@Builder.Default
	private long timestamp = Instant.now().toEpochMilli();
	
}
