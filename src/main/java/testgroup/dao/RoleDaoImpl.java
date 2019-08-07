package testgroup.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testgroup.model.Role;
import testgroup.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional("transactionManager")
@DependsOn("transactionManager")
@Repository
public class RoleDaoImpl implements RoleDao {
//	@Qualifier(value = "managerEntityManagerFactory")
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addRole(Role userRole) {
		entityManager.persist(userRole);
	}


	@Override

	public Role getRole(String name) {
		TypedQuery<Role> query =
				entityManager.createQuery("SELECT c FROM Role c where c.type=:name", Role.class);
		query.setParameter("name", name);
		if (!query.getResultList().isEmpty()) {
			Role role1 = query.getSingleResult();
			return role1;
		}
		return null;
	}

	@Override
	public List<Role> getAllUsers() {
		TypedQuery<Role> query =
				entityManager.createQuery("SELECT c FROM Role c", Role.class);
		List<Role> results = query.getResultList();
		return results;

	}
}

