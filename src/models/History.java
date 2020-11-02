package models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class History implements Serializable {
  private Shoes shoes;
  private Customer customer;
  private Date purchaseDate;

  public History() {}

  public History(Shoes shoes, Customer customer, Date purchaseDate) {
    this.shoes = shoes;
    this.customer = customer;
    this.purchaseDate = purchaseDate;
  }

  public Shoes getShoes() {
    return shoes;
  }

  public void setShoes(Shoes shoes) {
    this.shoes = shoes;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  @Override
  public String toString() {
    return "История покупок" + "\n" +
         "Обувь: " + shoes + "\n" +
         "Клиент: " + customer + "\n" +
         "Дата покупки: " + purchaseDate + "\n";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.shoes);
    hash = 67 * hash + Objects.hashCode(this.customer);
    hash = 67 * hash + Objects.hashCode(this.purchaseDate);
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
    final History other = (History) obj;
    if (!Objects.equals(this.shoes, other.shoes)) {
      return false;
    }
    if (!Objects.equals(this.customer, other.customer)) {
      return false;
    }
    if (!Objects.equals(this.purchaseDate, other.purchaseDate)) {
      return false;
    }
    return true;
  }
  
  
}
