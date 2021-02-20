package co.scuffdesign.beans.payloads;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseWrap {

	private String version;
	private Object data;
	
}
