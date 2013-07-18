package foo.service;

import foo.api.UsageMonitor;

public interface iMonitorService {
	public Long calculateObjectSize(Object o);
	public void logUsage(UsageMonitor usage);
}
