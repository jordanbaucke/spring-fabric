package foo.api.endpoint;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import foo.messages.ScheduleProcessCommandMsg;
import foo.messages.ScheduleProcessResponse;
import foo.process.ScheduleProcessGateway;

@Controller
@RequestMapping("/schedule")
public class SchedulerController {
	Logger logger = LoggerFactory.getLogger(SchedulerController.class);

	@Autowired
	ScheduleProcessGateway scheduleProcessGateway;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String scheduleMethod() throws JsonGenerationException, JsonMappingException, IOException {
		ScheduleProcessCommandMsg scheduleProcessMsg = new ScheduleProcessCommandMsg.Builder()
				.methodName("testingSpringIntegration").build();
		ScheduleProcessResponse resp = scheduleProcessGateway
				.scheduleProcess(scheduleProcessMsg);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(resp);
	}
}
