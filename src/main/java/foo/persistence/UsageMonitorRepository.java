package foo.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class UsageMonitorRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(UsageMonitor usage) {
		entityManager.persist(usage);
	}

}
