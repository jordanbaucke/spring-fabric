/**
 * 
 */
package foo.api;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
}
