package tools.creators;

import java.util.List;
import java.util.Scanner;
import models.Customer;
import models.User;
import security.SecureManager;
import tools.savers.StorageManager;

public class UserManager {
  
  Scanner scanner = new Scanner(System.in);
  StorageManager storageManager = new StorageManager();
  
  public User createUser(List<User> userList) {
    CustomerManager customerManager = new CustomerManager();
    Customer customer = customerManager.createCustomer();
    
    User user = new User();
    System.out.println("\nРегистрация - данные для входа");
    System.out.print("Логин: ");
    String scannerLogin = scanner.nextLine();
    boolean loginBool = true;
    if (userList == null) {
      do {
        for( int i = 0; i < userList.size(); i++ ) {
          if(( userList.get(i) != null && userList.get(i).getLogin().equals(scannerLogin)) ) {
            System.out.println("\nДанный логин уже занят\n");
            System.out.print("Логин: ");
            scannerLogin = scanner.nextLine();
          } else {
            user.setLogin(scannerLogin);
            loginBool = false;
          }
        }
      } while (loginBool);
    } else {
      user.setLogin(scannerLogin);
    }
    System.out.print("Пароль: ");
    user.setPassword(scanner.nextLine());
    int roleNumber;
    do {
      System.out.println("Выберите тип пользователя");
      for ( int i = 0; i < SecureManager.role.values().length; i++ ) {
        System.out.printf("%d. %s%n", i + 1, SecureManager.role.values()[i].toString());
      }
      System.out.print("Номер: ");
      String scannerRole = scanner.nextLine();
      try {
        roleNumber = Integer.parseInt(scannerRole);
        break;
      } catch (NumberFormatException ex) {
        System.out.println("Введите целочисленное значение.");
      }
    } while (true);
    user.setRole(SecureManager.role.values()[roleNumber - 1].toString());
    user.setCustomer(customer);
    return user;
  }
  
  public void addUserToDB(User user, List<User> userList) {
    userList.add(user);
    storageManager.save(userList, StorageManager.fileToStorage.USERS.toString());
  }
  
  public void printUserList(List<User> userList) {
    System.out.println("> Список пользователей <");
    int i = 0;
    for( User user : userList ) {
      if( user != null ) {
        System.out.println(i + 1 + ". " + user.toString());
      }
    }
  }
  
  public User getLogIn(List<User> userList) {
    System.out.println("\nВведите данные для входа");
    System.out.print("Логин: ");
    String scannerLogin = scanner.nextLine();
    for( int u = 0; u < 3; u++ ) {
      for( int i = 0; i < userList.size(); i++ ) {
        if( userList.get(i) != null && userList.get(i).getLogin().equals(scannerLogin) ) {
          System.out.print("Пароль: ");
          String scannerPassword = scanner.nextLine();
          for( int j = 0; j < 3; j++ ) {
            if (userList.get(i).getPassword().equals(scannerPassword)) {
              return userList.get(i);
            } else {
              System.out.printf("Пароль не верный, осталось попыток: %d\n", 3 - j);
              System.out.print("Пароль: ");
              scannerPassword = scanner.nextLine();
            }
          }
          return null;
        }
      }
      
      System.out.printf("Имя пользователя не верное, осталось попыток: %d\n", 3 - u);
      System.out.print("Логин: ");
      scannerLogin = scanner.nextLine();
    }
    return null;
  }
}
