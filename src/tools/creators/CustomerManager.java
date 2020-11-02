package tools.creators;

import java.util.List;
import java.util.Scanner;
import models.Customer;
import tools.savers.StorageManager;

public class CustomerManager {
  Scanner scanner = new Scanner(System.in);
  
  private StorageManager storageManager = new StorageManager();
  
  public Customer createCustomer() {
    System.out.println("\nРегистрация - заполните данные");
    Customer customer = new Customer();
    System.out.print("Имя: ");
    customer.setFirstName(scanner.nextLine());
    System.out.print("Фамилию: ");
    Scanner scannerLastName = new Scanner(System.in);
    customer.setLastName(scannerLastName.nextLine());
    System.out.print("Номер телефона: ");
    Scanner scannerPhoneNumber = new Scanner(System.in);
    customer.setPhoneNumber(scannerPhoneNumber.nextLine());
    int cashInt;
    do {
      System.out.print("Количество наличных: ");
      String scannerCashString = scanner.nextLine();
      try {
        cashInt = Integer.parseInt(scannerCashString);
        break;
      } catch (NumberFormatException ex) {
        System.out.println("\nВведите цифры\n");
      }
    } while (true);
    customer.setCash(cashInt);
    return customer;
  }
  
  public void addCustomerToDB(Customer customer, List<Customer> customerList) {
    customerList.add(customer);
    storageManager.save(customerList, StorageManager.fileToStorage.CUSTOMERS.toString());
  }
  
  public void printCustomerList(List<Customer> customerList) {
     System.out.println("\nСписок клиентов\n");
     int i = 0;
     for (Customer customer : customerList) {
       if (customer != null) {
         System.out.println(i + 1 + ". " + customer.toString());
         i++;
       }
     }
  }
}
