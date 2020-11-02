package tools.savers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class StorageManager {
  
  public static enum fileToStorage {SHOES, CUSTOMERS, USERS, HISTORIES};
  
  public void save( List arrayList, String fileToStorage ) {
    FileOutputStream FOS = null;
    ObjectOutputStream OOS = null;
    try {
      FOS = new FileOutputStream(fileToStorage);
      OOS = new ObjectOutputStream(FOS);
      OOS.writeObject(arrayList);
      OOS.flush();             
    } catch (FileNotFoundException ex) {
      System.out.println("Нет такого файта");
    } catch (IOException ex) {
      System.out.println("Ошибка ввода");
    }
  }
  
  public List load(String fileToStorage) {
    List arrayList = null;
    FileInputStream FIS = null;
    ObjectInputStream OIS = null;
    try {
      FIS = new FileInputStream(fileToStorage);
      OIS = new ObjectInputStream(FIS);
      return (List) OIS.readObject();
    } catch (FileNotFoundException ex) {
      System.out.println("Нет такого файта");
    } catch (ClassNotFoundException ex) {
      System.out.println("Нет такого класса");
    } catch (IOException ex) {
      System.out.println("Ошибка ввода");
    }
    return arrayList;
  }
}
