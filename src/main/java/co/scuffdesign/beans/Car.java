package co.scuffdesign.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Make required")
    @Size(min=1, max=25, message="Make must 1-25 characters.")
	private String make;
	
	@NotNull(message="Model required.")
    @Size(min=1, max=25, message="Model must 1-25 characters.")
	private String model;

	@Min(value=1950, message="Minimum year allowed is 1950.")
    @Max(value=2030, message="Maximum year allowed is 2030.")
	private int year;
	
}
