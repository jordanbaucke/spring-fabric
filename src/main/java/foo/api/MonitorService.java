package foo.api;

import java.lang.instrument.Instrumentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService implements iMonitorService {
	
	@Autowired
	UsageMonitorRepository usageMonitorRepository;
	
	private Instrumentation instrumentation;

	private long getObjectSize(Object o) {
		return instrumentation.getObjectSize(o);
	}

	@Override
	public Long calculateObjectSize(Object o) {
		return getObjectSize(o);
	}

	@Override
	public void logUsage(UsageMonitor usage) {
		usageMonitorRepository.save(usage);
	}
	
	
}
