package foo.api;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.aspectj.lang.Signature;

@Entity
@Table(name = "usagemonitor")
public class UsageMonitor {
	@Id
	@GeneratedValue
	private Long id;
	
	public Long userId;
	public Integer responseStatus;
	public String method;
	public Long start;
	public Long end;
	public Long runningTime;
	public String exception;
	public String requestingIp;

	/**
	 * @return the requestingIp
	 */
	public String getRequestingIp() {
		return requestingIp;
	}

	/**
	 * @param requestingIp the requestingIp to set
	 */
	public void setRequestingIp(String requestingIp) {
		this.requestingIp = requestingIp;
	}

	public UsageMonitor(Long userid, String requestingIp, Integer responseStatus,
			String method, Long start, Long end, Long runningTime,
			String exception) {
		super();
		this.userId = userid;
		this.requestingIp = requestingIp;
		this.responseStatus = responseStatus;
		this.method = method;
		this.start = start;
		this.end = end;
		this.runningTime = runningTime;
		this.exception = exception;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userid
	 */
	public Long getUserid() {
		return userId;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Long userid) {
		this.userId = userid;
	}

	/**
	 * @return the responseStatus
	 */
	public Integer getResponseStatus() {
		return responseStatus;
	}

	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the start
	 */
	public Long getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Long start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Long getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Long end) {
		this.end = end;
	}

	/**
	 * @return the runningTime
	 */
	public Long getRunningTime() {
		return runningTime;
	}

	/**
	 * @param runningTime the runningTime to set
	 */
	public void setRunningTime(Long runningTime) {
		this.runningTime = runningTime;
	}

	/**
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(String exception) {
		this.exception = exception;
	}
	
}
