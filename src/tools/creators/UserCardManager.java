package tools.creators;

import java.util.List;
import models.History;
import security.SecureManager;
import shop.App;
import tools.savers.StorageManager;

public class UserCardManager {
  StorageManager storageManager = new StorageManager();
    
  public void printListSoldShoes(List<History> historyList) {
    boolean notSoldAnyShoes = true;
    if( SecureManager.role.MANAGER.toString().equals(App.loggedUser.getRole()) ) {
      System.out.println("\nИстория продаж");
      for( int i = 0; i < historyList.size(); i++ ) {
        if( historyList.get(i) != null ) {
          System.out.println("-------------");
          System.out.println("Имя модели: " + historyList.get(i).getShoes().getName());
          System.out.println("Бренд: " + historyList.get(i).getShoes().getBrand());
          System.out.println("Цена: " + historyList.get(i).getShoes().getPrice());
          System.out.println("Дата продажи: " + historyList.get(i).getPurchaseDate());
          System.out.println("-------------");
          notSoldAnyShoes = false;
        }
      }
      if (notSoldAnyShoes) {
        System.out.println("Магазин новый, продаж не было!\n");
      }
    }
    
    if( SecureManager.role.CUSTOMER.toString().equals(App.loggedUser.getRole()) ) {
      System.out.println("\nИстория покупок");
      for( int i = 0; i < historyList.size(); i++ ) {
        if( historyList.get(i) != null && historyList.get(i).getCustomer().equals(App.loggedUser.getCustomer())) {
          System.out.println("-------------");
          System.out.println("Имя модели: " + historyList.get(i).getShoes().getName());
          System.out.println("Бренд: " + historyList.get(i).getShoes().getBrand());
          System.out.println("Цена: " + historyList.get(i).getShoes().getPrice());
          System.out.println("Дата покупки: " + historyList.get(i).getPurchaseDate());
          System.out.println("-------------");
          notSoldAnyShoes = false;
        }
      }
      if (notSoldAnyShoes) {
        System.out.println("Вы ещё не сделали ни одной покупки!\n");
      }
    }
  }
  
  public void addHistoryToDB(History history, List<History> historyList) {
     historyList.add(history);
     storageManager.save(historyList, StorageManager.fileToStorage.HISTORIES.toString());
  }
  
}
