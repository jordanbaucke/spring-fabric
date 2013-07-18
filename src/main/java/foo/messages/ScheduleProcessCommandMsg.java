package foo.messages;

import java.io.Serializable;

public class ScheduleProcessCommandMsg implements Serializable {

	String methodName;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ScheduleProcessCommandMsg(){
		
	}
	
	public String getMethodName(){
		return methodName;
	}
	
	public static class Builder {
		ScheduleProcessCommandMsg internal;

		public Builder() {
			internal = new ScheduleProcessCommandMsg();
		}
		
	    public ScheduleProcessCommandMsg build() {
	        if (internal.getMethodName() == null) {
	        }
	        return internal;
	      }
		
	    public Builder methodName(String methodName) {
	        internal.methodName = methodName;
	        return this;
      }
	}
}
