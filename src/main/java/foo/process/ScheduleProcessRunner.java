package foo.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foo.messages.ScheduleProcessCommandMsg;

@Component
public class ScheduleProcessRunner {
	Logger logger = LoggerFactory.getLogger(ScheduleProcessRunner.class);
	  
	@Transactional
	@ServiceActivator
	public ScheduleProcessCommandMsg process(ScheduleProcessCommandMsg commandMsg){
		return commandMsg;
	}
}
