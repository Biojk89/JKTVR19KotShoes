package models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
  private String login, password, role;
  private Customer customer;

  public User() {}

  public User(String login, String password, String role, Customer customer) {
    this.login = login;
    this.password = password;
    this.role = role;
    this.customer = customer;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Пользователь" + "\n" +
         "Логин: " + login + "\n" +
         "Пароль: " + password + "\n" +
         "Роль: " + role + "\n" +
         "Клиент: " + customer + "\n";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.login);
    hash = 67 * hash + Objects.hashCode(this.password);
    hash = 67 * hash + Objects.hashCode(this.role);
    hash = 67 * hash + Objects.hashCode(this.customer);
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
    final User other = (User) obj;
    if (!Objects.equals(this.login, other.login)) {
      return false;
    }
    if (!Objects.equals(this.password, other.password)) {
      return false;
    }
    if (!Objects.equals(this.role, other.role)) {
      return false;
    }
    if (!Objects.equals(this.customer, other.customer)) {
      return false;
    }
    return true;
  }
  
  
  
}
