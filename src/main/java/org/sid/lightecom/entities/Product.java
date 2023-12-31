package org.sid.lightecom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Entity
 @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements Serializable {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private double cuurentPrice;
  private boolean promotion;
  private boolean selected;
  private boolean available;
  private String photoName;
  @ManyToOne
  private Category category;


}
