package org.sid.lightecom.dao;

import org.sid.lightecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product ,Long> {
  @RestResource(path = "/selectedProducts")
  public List<Product> findBySelectedIsTrue();
  @RestResource(path = "/productsBykeyword")
  /*@Query("select p from Product p where p.name like :x")
  public List<Product> chercher(@Param("x" String mc));*/
  public List<Product> findByNameNotContains(String mc);
}

