package repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import entities.Property;
import entities.PropertyData;

@RepositoryRestResource
public interface PropertyDataRepository
		extends JpaRepository<PropertyData, Integer>, JpaSpecificationExecutor<PropertyData> {

}