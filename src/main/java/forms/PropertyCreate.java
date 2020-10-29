package forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import config.Params;

public class PropertyCreate {

	@NotBlank
	@Pattern(regexp = Params.PropertyDataTypesRegex)
	private String type;

	@NotBlank
	@Length(min = 0, max = 255)
	private String address;

	@NotNull(message = "Latitude cannot be null")
	@Max(value = 180)
	@Min(value = -180)
	private Double latitude;

	@NotNull(message = "Longitude cannot be null")
	@Max(value = 180)
	@Min(value = -180)
	private Double longitude;
	
	private Integer clientId;

	private Integer ownerId;
	
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
