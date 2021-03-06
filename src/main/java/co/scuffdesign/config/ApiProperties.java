package co.scuffdesign.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("api")
public class ApiProperties {

	private String versionNumber;
	
}
