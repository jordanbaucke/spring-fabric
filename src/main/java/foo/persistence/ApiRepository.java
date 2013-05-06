/**
 * 
 */
package foo.persistence;

import java.util.Collection;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foo.api.ApiMethod;
/**
 * @author jordanbaucke
 *
 */
@Repository
@Transactional(readOnly = true)
public class ApiRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(ApiMethod apimethod) {
		entityManager.persist(apimethod);
	}
	
	public Collection<ApiMethod> findAllMethods() {
		try {
			return entityManager.createNamedQuery(ApiMethod.FIND_ALL_METHODS, ApiMethod.class).getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}
}