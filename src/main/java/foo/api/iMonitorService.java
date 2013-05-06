package foo.api;

public interface iMonitorService {
	public Long calculateObjectSize(Object o);
	public void logUsage(UsageMonitor usage);
}
