package ui;

import java.util.List;
import java.util.Scanner;
import models.Customer;
import models.History;
import models.Shoes;
import models.User;
import shop.App;
import tools.creators.CustomerManager;
import tools.creators.ShoesManager;
import tools.creators.UserCardManager;
import tools.creators.UserManager;

public class UserInterface {
  private Scanner scanner = new Scanner(System.in);
  private UserManager userManager = new UserManager();
  private CustomerManager customerManager = new CustomerManager();
  private ShoesManager shoesManager = new ShoesManager();
  private UserCardManager userCardManager = new UserCardManager();
  
  public User guestInterface(List<User> userList, List<Customer> customerList) {
    System.out.println("\n _________________");
    System.out.println("\n | Магазин обуви |");
    System.out.println("\n -----------------");
    do {
      System.out.println("");
      System.out.println("1. Войти в магазин");
      System.out.println("2. Зарегистрироваться");
      System.out.println("3. Завершить программу");
      System.out.print("Выберите номер действия: ");
      String scannerTask = scanner.nextLine();
      switch (scannerTask) {
        case "1":
          User checkInUser = userManager.getLogIn(userList);
          if (checkInUser == null) break;
          return checkInUser;
        case "2":
          User user = userManager.createUser(userList);
          userManager.addUserToDB(user, userList);
          customerManager.addCustomerToDB(user.getCustomer(), customerList);
        break;
        case "3":
          System.out.println("\nПрощайте!");
          System.exit(0);
        break;
        default:
          System.out.println("Выберите правильный номер действия");
      }
    } while (true);
  }

  public void managerInterface(List<Customer> customerList, List<User> userList, List<Shoes> shoesList, List<History> historyList) {
    boolean block = true;
    do {
      System.out.println("\n--------------------------------------------------");
      System.out.printf("%s, добро пожаловать в магазин обуви!\n", App.loggedUser.getCustomer().getFirstName());
      System.out.printf("Тип пользователя: %s\n", App.loggedUser.getRole());
      System.out.println("--------------------------------------------------\n");
      System.out.println("---Панель управления---");
      System.out.println("1. Добавить обувь");
      System.out.println("2. Добавить клиента");
      System.out.println("------------------");
      System.out.println("3. Список обуви");
      System.out.println("4. Список клиентов");
      System.out.println("------------------");
      System.out.println("5. История продаж");
      System.out.println("-----------------");
      System.out.println("6. Пойти домой");
      System.out.print("Выберите номер действия: ");
      String scannerTask = scanner.nextLine();
      switch (scannerTask) {
        case "1":
          shoesManager.addShoesModelToDB(shoesList);
        break;
        case "2":
          Customer customer = customerManager.createCustomer();
          customerManager.addCustomerToDB(customer, customerList);
        break;
        case "3":
          shoesManager.printShoesList(shoesList);
        break;
        case "4":
          customerManager.printCustomerList(customerList);
        break;
        case "5":
          userCardManager.printListSoldShoes(historyList);
        break;
        case "6":
          System.out.println("\nЯ сюда больше не вернусь!");
          block = false;
        break;
      }
    } while ( block == true );
  }
  
  public void customerInterface(List<Customer> customerList, List<User> userList, List<Shoes> shoesList, List<History> historyList) {
    boolean block = true;
    do {
      System.out.println("\n--------------------------------------------------");
      System.out.printf("%s, добро пожаловать в магазин обуви!\n", App.loggedUser.getCustomer().getFirstName());
      System.out.printf("Тип пользователя: %s\n", App.loggedUser.getRole());
      System.out.printf("Наличные: %s\n", App.loggedUser.getCustomer().getCash());
      System.out.println("--------------------------------------------------\n");
      System.out.println("---Панель управления---");
      System.out.println("1. Купить обувь");
      System.out.println("----------------");
      System.out.println("2. Список обуви");
      System.out.println("----------------");
      System.out.println("3. Купленная обувь");
      System.out.println("-----------------");
      System.out.println("4. Выйти из магазина");
      System.out.print("Выберите номер действия: ");
      String scannerTask = scanner.nextLine();
      switch (scannerTask) {
        case "1":
          shoesManager.printShoesList(shoesList);
          History history = shoesManager.buyShoes(shoesList, historyList);
          userCardManager.addHistoryToDB(history, historyList);
        break;
        case "2":
          shoesManager.printShoesList(shoesList);
        break;
        case "3":
          userCardManager.printListSoldShoes(historyList);
        break;
        case "4":
          System.out.println("\nКакая скрепучая дверь...");
          block = false;
        break;
      }
    } while ( block == true );  
  }
  
}
