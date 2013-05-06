package foo.messages;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class ScheduleProcessResponseCreator {
	
	@ServiceActivator
	public ScheduleProcessResponse createScheduleProcessResponse(ScheduleProcessCommandMsg commandMsg){
		ScheduleProcessResponse response = new ScheduleProcessResponse();
		response.setStatus("success");
		return response;
	}
}
