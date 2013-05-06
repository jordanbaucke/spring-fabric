package foo.messages;

import java.io.Serializable;

public class ScheduleProcessResponse extends ScheduleProcessCommandMsg implements Serializable{

	private String status;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScheduleProcessResponse(){
		
	}
	
	public ScheduleProcessResponse(ScheduleProcessCommandMsg message){
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
