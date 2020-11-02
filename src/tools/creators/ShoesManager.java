package tools.creators;

import java.util.List;
import java.util.Scanner;
import models.History;
import java.util.Calendar;
import java.util.GregorianCalendar;
import models.Customer;
import models.Shoes;
import shop.App;
import tools.savers.StorageManager;

public class ShoesManager {
  Scanner scanner = new Scanner(System.in);
  
  private StorageManager storageManager = new StorageManager();
  
  private int checkInt( String str ) {
    int result = 0;
    do {
      System.out.print(str + ": ");
      String scannerLine = scanner.nextLine();
      try {
        result = Integer.parseInt(scannerLine);
      } catch (NumberFormatException numEx) {
        System.out.println("\nВведите цифры\n");
      }
        return result;
    } while (true);
  }
  
  public void addShoesModelToDB(List<Shoes> shoesList) {
    Shoes shoes = new Shoes();
    System.out.println("\nДобавить пару обуви");
    System.out.print("Введите название: ");
    shoes.setName(scanner.nextLine());
    System.out.print("Введите бренд: ");
    shoes.setBrand(scanner.nextLine());   
    shoes.setPrice(checkInt("Введите стоимость"));
    shoes.setAmount(checkInt("Введите количество"));
    shoes.setCreatedYear(checkInt("Введите год выпуска модели"));
    shoesList.add(shoes);
    storageManager.save(shoesList, StorageManager.fileToStorage.SHOES.toString());
  }
  
  public boolean printShoesList(List<Shoes> shoesList) {
    if (shoesList == null || shoesList.size() < 1) {
      System.out.println("\nВся обувь раскуплена, извините!\n");
      return false;
    }
    System.out.println("Список обуви\n");
    int i = 0;
    int totalAmount = 0;
    for (Shoes shoes : shoesList) {
      if (shoes != null) {
        totalAmount += shoes.getAmount();
        System.out.println( i + 1 + ". " + shoes.toString() );
        i++;
      }
    }
    if (totalAmount == 0) {
      System.out.println("Все пары обуви раскуплены");
    }
    return true;
  }
  
    public History buyShoes(List<Shoes> shoesList, List<History> historyList) {
      System.out.println("Купить пару обуви");
      boolean chosed = false;
      int chosenShoes;
      do {
        chosenShoes = checkInt("Выберите пару обуви");
        System.out.println(chosenShoes > 0 && chosenShoes <= shoesList.size());
        if ( chosenShoes > 0 && chosenShoes <= shoesList.size()) {
          chosed = true;
        }
      } while ( !chosed );
      
      shoesList.get(chosenShoes - 1).setAmount(shoesList.get(chosenShoes - 1).getAmount() - 1);
      App.loggedUser.getCustomer().setCash(App.loggedUser.getCustomer().getCash() - shoesList.get(chosenShoes - 1).getPrice());
      Shoes shoes = shoesList.get(chosenShoes - 1);
      Customer customer = App.loggedUser.getCustomer();
      Calendar calendar = new GregorianCalendar();
      return new History(shoes, customer, calendar.getTime());
    }
  
}
