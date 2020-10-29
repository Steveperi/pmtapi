package services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sipios.springsearch.anotation.SearchSpec;

import entities.Property;
import entities.PropertyData;
import forms.PropertyCreate;
import repositories.PropertyDataRepository;
import repositories.PropertyRepository;

@Service
@Transactional
public class PropertyService {

	@Autowired
	private PropertyRepository repoProperty;

	@Autowired
	private PropertyDataRepository repoPropertyData;

	public Page<PropertyData> getAllProperties(@SearchSpec Specification<PropertyData> search, Integer page) {
		Pageable paging = PageRequest.of(page, 25);
		return repoPropertyData.findAll(Specification.where(search), paging);
	}
	

	public Property createProperty(PropertyCreate newProperty) {
		Property property = new Property();
		property.setAddress(newProperty.getAddress());
		property.setLatitude(newProperty.getLatitude());
		property.setLongitude(newProperty.getLatitude());
		repoProperty.save(property);

		PropertyData data = new PropertyData();
		data.setProperty(property);
		data.setType(newProperty.getType());
		repoPropertyData.save(data);

		return property;

//		PropertyData data = new PropertyData();
//		data.setProperty(property);
//		data.setType(newProperty.getType());
//		if(newProperty.getClientId() != null) {
//			Player client = this.findPlayer(newProperty.getClientId());
//			data.setClient(client);
//		}
//		if(newProperty.getOwnerId() != null) {
//			Player owner = this.findPlayer(newProperty.getOwnerId());
//			data.setOwner(owner);
//		}
//		dataRepo.save(data);
//		return property;
	}

}
