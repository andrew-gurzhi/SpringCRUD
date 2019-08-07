//package testgroup.factories;
//
//import testgroup.dao.UserDAO;
//
//public abstract class UserDAOFactory {
//	static ReadProperties readProperties = ReadProperties.getInstance();
//
//
//	public static UserDAOFactory getFactory() {
//		UserDAOFactory userDAOFactory = null;
////		if (readProperties.getMethod().equals("jdbc")) {
////			userDAOFactory = new UserJDBCDAOFactory();
////		} else if (readProperties.getMethod().equals("hibernate")) {
////			userDAOFactory = new UserHibernateDAOFactory();
////		}
//		userDAOFactory = new UserHibernateDAOFactory();
//		return userDAOFactory;
//	}
//
//	public abstract UserDAO getUserDAO();
//}