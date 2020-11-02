package models;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
  
  private String firstName, lastName, phoneNumber;
  private int cash;
  
  public Customer() {}

  public Customer(String firstName, String lastName, String phoneNumber) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.phoneNumber = phoneNumber;
  this.cash = cash;
  }

  public String getFirstName() {
  return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getCash() {
    return cash;
  }

  public void setCash(int cash) {
    this.cash = cash;
  }

  
  
  @Override
  public String toString() {
    return "Клиент" + "\n" +
         "Имя: " + firstName + "\n" +
         "Фамилия: " + lastName + "\n" +
         "Номер телефона: " + phoneNumber + "\n" +
         "Наличные: " + cash + "\n";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.firstName);
    hash = 67 * hash + Objects.hashCode(this.lastName);
    hash = 67 * hash + Objects.hashCode(this.phoneNumber);
    hash = 67 * hash + this.cash;
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
    final Customer other = (Customer) obj;
    if (this.cash != other.cash) {
      return false;
    }
    if (!Objects.equals(this.firstName, other.firstName)) {
      return false;
    }
    if (!Objects.equals(this.lastName, other.lastName)) {
      return false;
    }
    if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
      return false;
    }
    return true;
  }

  
  
  
}
