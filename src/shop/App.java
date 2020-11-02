package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Customer;
import models.History;
import models.Shoes;
import models.User;
import security.SecureManager;
import tools.savers.StorageManager;
import ui.UserInterface;

public class App {
  
  private List<Customer> customerList = new ArrayList<>();
  private List<User> userList = new ArrayList<>();
  private List<Shoes> shoesList = new ArrayList<>();
  private List<History> historyList = new ArrayList<>();
  private StorageManager storageManager = new StorageManager();
  private UserInterface userInterface = new UserInterface();
  private SecureManager secureManager = new SecureManager();
  
  public static User loggedUser;
  
  public App() {
    List<Customer> loadedCustomer = storageManager.load(StorageManager.fileToStorage.CUSTOMERS.toString());
    if (loadedCustomer != null) customerList = loadedCustomer;
    List<Shoes> loadedShoes = storageManager.load(StorageManager.fileToStorage.SHOES.toString());
    if (loadedShoes != null) shoesList = loadedShoes;
    List<History> loadedHistory = storageManager.load(StorageManager.fileToStorage.HISTORIES.toString());
    if (loadedHistory != null) historyList = loadedHistory;
    List<User> loadedUser = storageManager.load(StorageManager.fileToStorage.USERS.toString());
    if (loadedUser != null) userList = loadedUser;
  }
    
  public void run() {
    do {
      this.loggedUser = userInterface.guestInterface(userList, customerList);

      if (SecureManager.role.MANAGER.toString().equals(App.loggedUser.getRole())) {
        userInterface.managerInterface(customerList, userList, shoesList, historyList);
      } else if (SecureManager.role.CUSTOMER.toString().equals(App.loggedUser.getRole())) {
        userInterface.customerInterface(customerList, userList, shoesList, historyList);
      }
    } while (true);
  }
  
}
