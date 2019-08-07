package testgroup.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import testgroup.dbService.RoleService;
import testgroup.model.Role;
import testgroup.model.User;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional("transactionManager")
@DependsOn("transactionManager")
@Repository

public class UserHibernateDAO implements UserDAO {

//	@Autowired
//	User user;



//	@Qualifier(value = "managerEntityManagerFactory")
	@Autowired
	private EntityManager entityManager;


    @Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public void addUser(User user) {
		user.setPass(passwordEncoder.encode(user.getPassword()));


		entityManager.persist(user);
	}


	@Override
	public boolean checkUser(String name) {
		TypedQuery<User> query =
				entityManager.createQuery("SELECT c FROM User c", User.class);
		List<User> results = query.getResultList();
		for (User result : results) {
			if (result.getLogin().equals(name)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean checkpass(String name, String pass) {
		TypedQuery<User> query =
				entityManager.createQuery("SELECT c FROM User c", User.class);
		List<User> results = query.getResultList();
		for (User result : results) {
			if (result.getName().equals(name)) {
				if (result.getPass().equals(pass)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void updateUser(User user, long id) {
		TypedQuery<User> query =
				entityManager.createQuery("SELECT c FROM User c where c.id=:id", User.class);
		query.setParameter("id", id);
		User user1 = query.getSingleResult();
		user1.setName(user.getName());
		user1.setLogin(user.getName());
		user1.setPass(user.getPass());
		user1.setRoles(user.getRoles());
		entityManager.merge(user1);
	}

	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query =
				entityManager.createQuery("SELECT c FROM User c", User.class);
		List<User> results = query.getResultList();
		return results;

	}



	@Override
	public User getUser(String name) {
		TypedQuery<User> query =
				entityManager.createQuery("SELECT c FROM User c where c.name=:name", User.class);
		query.setParameter("name", name);
		if (!query.getResultList().isEmpty()) {
			User user1 = query.getSingleResult();
			return user1;
		}
		return null;
	}

	//
//
//
	@Override
	public User getUser(long id) {
		TypedQuery<User> query =
				entityManager.createQuery("SELECT c FROM User c", User.class);
		List<User> results = query.getResultList();
		for (User result : results) {
			if (result.getId() == id) {

				return result;
			}
		}
		return null;
	}

	//    return null;
//  }
//
//
	public void deleteUser(long id) {
		TypedQuery<User> query =
				entityManager.createQuery("SELECT c FROM User c", User.class);
		List<User> results = query.getResultList();
		for (User result : results) {
			if (result.getId() == id) {
				entityManager.remove(result);
			}
		}

	}

}