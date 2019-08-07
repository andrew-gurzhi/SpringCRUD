//package testgroup.dbService;
//
//import com.mysql.jdbc.Driver;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;
//import testgroup.factories.ReadProperties;
//import testgroup.model.User;
//
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class DbHelper {
//	private static SessionFactory sessionFactory;
//	private static DbHelper instance;
//
//	private DbHelper() {
//	}
//
//	public static DbHelper getInstance() {
//		if (instance == null) {
//			instance = new DbHelper();
//		}
//		return instance;
//	}
//
//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory == null) {
//			FileInputStream fis;
//			try {
//				Configuration configuration = new Configuration();
//				// Hibernate settings equivalent to hibernate.cfg.xml's properties
//				Properties settings = new Properties();
////				Properties property = new Properties();
////				String propFileName = "database.properties";
////				InputStream inputStream = DbHelper.class.getClassLoader().getResourceAsStream(propFileName);
////				property.load(inputStream);
//				Properties property =  ReadProperties.getProperties();
//				settings.put(Environment.DRIVER, property.getProperty("db.name"));
//				settings.put(Environment.URL, property.getProperty("db.url"));
//				settings.put(Environment.USER, property.getProperty("db.username"));
//				settings.put(Environment.PASS, property.getProperty("db.userpass"));
//				settings.put(Environment.DIALECT, property.getProperty("db.dialect"));
//				settings.put(Environment.SHOW_SQL, property.getProperty("db.show_mysql"));
//				settings.put(Environment.HBM2DDL_AUTO, property.getProperty("db.hbm2ddl_auto"));
//				configuration.setProperties(settings);
//				configuration.addAnnotatedClass(User.class);
//				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//								.applySettings(configuration.getProperties()).build();
//				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return sessionFactory;
//	}
//
//
//	public static Connection getConnection() {
//    Properties property =  ReadProperties.getProperties();
////		Properties property = new Properties();
////		String propFileName = "database.properties";
////
////		try {
////			InputStream inputStream = DbHelper.class.getClassLoader().getResourceAsStream(propFileName);
////
//////      fis = new FileInputStream("D:\\Linux\\IdeaProjects\\PredProjects\\src\\main\\resources\\database.properties");
////			property.load(inputStream);
//			String dbname = property.getProperty("db.name");
//			try{
//			DriverManager.registerDriver((Driver) Class.forName(dbname).newInstance());
//			String url = property.getProperty("db.url");
//			String name = property.getProperty("db.username");
//			String pass = property.getProperty("db.userpass");
//			Connection connection = DriverManager.getConnection(url, name, pass);
//			return connection;
//		} catch (SQLException |  InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//			e.printStackTrace();
//
//			return null;
//
//		}
//
//
//	}
//
//
////    try {
////      DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
////      String url = "jdbc:mysql://localhost:3306/first_predproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
////      String name = "root";
////      String pass = "test";
////      Connection connection = DriverManager.getConnection(url, name, pass);
////      stmt = connection.createStatement();
////      return connection;
////    } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
////      e.printStackTrace();
////    }
////    return null;
////
////  }
//}
