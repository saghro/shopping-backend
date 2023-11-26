package org.sid.lightecom;

import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Category;
import org.apache.commons.lang3.RandomStringUtils;
import org.sid.lightecom.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class LightEcomApplication implements CommandLineRunner {
   @Autowired
   private ProductRepository productRepository;
   @Autowired
   private CategoryRepository categoryRepository;
   @Autowired
   private RepositoryRestConfiguration repositoryRestConfiguration;
  public static void main(String[] args) {
    SpringApplication.run(LightEcomApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
    categoryRepository.save(new Category(null,"Ordinateur",null,null,null));
    categoryRepository.save(new Category(null,"Printers",null,null,null));
    categoryRepository.save(new Category(null,"Smart Phones",null,null,null));
    Random rnd = new Random();
    categoryRepository.findAll().forEach(c->{
      for (int i = 0; i < 10 ; i++) {
        Product p=new Product();
        String randomProductName = RandomStringUtils.randomAlphanumeric(18);
        p.setName(randomProductName);
        p.setCuurentPrice(100+rnd.nextInt(10000));
        p.setAvailable(rnd.nextBoolean());
        p.setPromotion(rnd.nextBoolean());
        p.setSelected(rnd.nextBoolean());
        p.setCategory(c);
        p.setPhotoName("unknown.png");
        productRepository.save(p);

      }

    });

  }
}
