package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipios.springsearch.anotation.SearchSpec;
import entities.Property;
import entities.PropertyData;
import forms.PropertyCreate;
import services.PropertyService;

@RestController
@RequestMapping("property")
public class PropertyController {

	@Autowired
	private PropertyService serviceProperty;

	@GetMapping("")
	Page<PropertyData> all(@SearchSpec Specification<PropertyData> search, @RequestParam("page") Integer page) {
		return (Page<PropertyData>) serviceProperty.getAllProperties(search, page);
	}

	@PostMapping("")
	Property create(@Valid @RequestBody PropertyCreate property) {
		return serviceProperty.createProperty(property);
	}

}
