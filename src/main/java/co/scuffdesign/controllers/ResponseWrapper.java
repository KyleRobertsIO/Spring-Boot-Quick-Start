package co.scuffdesign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import co.scuffdesign.beans.payloads.ResponseWrap;
import co.scuffdesign.config.ApiProperties;

@ControllerAdvice(basePackages="co.scuffdesign.controllers")
public class ResponseWrapper implements ResponseBodyAdvice {

	@Autowired
	private ApiProperties apiProperties;
	
	@Override
    public boolean supports(
        MethodParameter returnType, 
        Class converterType
    ) {
    	return true;
    }
	
	@Override 
	public Object beforeBodyWrite(
		Object body, 
        MethodParameter returnType, 
        MediaType selectedContentType,
        Class selectedConverterType, 
        ServerHttpRequest request, 
        ServerHttpResponse response
	) {
		
		if (body instanceof Object) {
			ResponseWrap wrapper = ResponseWrap.builder()
					.version(apiProperties.getVersionNumber())
					.data(body)
					.build();
			return wrapper;
		}
		
		return body;
	}
	
}
