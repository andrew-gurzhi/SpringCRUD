//package testgroup.factories;
//
//import testgroup.dbService.DbHelper;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class ReadProperties {
//  private static ReadProperties instanse;
//   private static   Properties properties;
//
//  private  ReadProperties() {
//    properties = new Properties();
//   InputStream inputStream = DbHelper.class.getClassLoader().getResourceAsStream("database.properties");
//    try {
//      properties.load(inputStream);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static Properties getProperties() {
//    return properties;
//  }
//
//  public static ReadProperties getInstance() {
//    if (instanse == null) {
//      instanse = new ReadProperties();
//    }
//    return instanse;
//  }
//
//
//  public  String getMethod() {
//    return properties.getProperty("db.method");
//  }
//}
