package models;

import java.io.Serializable;
import java.util.Objects;

public class Shoes implements Serializable {
  private String name, brand;
  private Integer amount, createdYear, price;
  
  public Shoes() {}
  
  public Shoes( String name, String brand, Integer amount, Integer createdYear, Integer price) {
    this.name = name;
    this.brand = brand;
    this.amount = amount;
    this.createdYear = createdYear;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getCreatedYear() {
    return createdYear;
  }

  public void setCreatedYear(Integer createdYear) {
    this.createdYear = createdYear;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
  
  @Override
  public String toString() {
    return "Обувь" + "\n" +
         "Название: " + name + "\n" +
         "Бренд: " + brand + "\n" +
         "Цена: " + price + "\n" +
         "Количество: " + amount + "\n" +
         "Год выпуска: " + createdYear + "\n";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.name);
    hash = 83 * hash + Objects.hashCode(this.brand);
    hash = 83 * hash + Objects.hashCode(this.amount);
    hash = 83 * hash + Objects.hashCode(this.createdYear);
    hash = 83 * hash + Objects.hashCode(this.price);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Shoes other = (Shoes) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.brand, other.brand)) {
      return false;
    }
    if (!Objects.equals(this.amount, other.amount)) {
      return false;
    }
    if (!Objects.equals(this.createdYear, other.createdYear)) {
      return false;
    }
    if (!Objects.equals(this.price, other.price)) {
      return false;
    }
    return true;
  }

  

  
}
