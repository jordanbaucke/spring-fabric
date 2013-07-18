package foo.process;

import foo.messages.ScheduleProcessCommandMsg;
import foo.messages.ScheduleProcessResponse;

public interface ScheduleProcessGateway {

	ScheduleProcessResponse scheduleProcess(ScheduleProcessCommandMsg scheduleProcessMsg);
}
