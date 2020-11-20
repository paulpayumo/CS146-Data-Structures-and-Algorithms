//package Schedule;

import static org.junit.Assert.*;
import org.junit.Test;

public class ScheduleTest {
	
	@Test
	public void SchedTest()
	{
		Schedule schedule = new Schedule();
		schedule.insert(8); //adds job 0 with time 8
		Schedule.Job j1 = schedule.insert(3); //adds job 1 with time 3
		schedule.insert(5); //adds job 2 with time 5
		System.out.println(schedule.finish()); //should return 8, since job 0 takes time 8 to complete.
		/* Note it is not the earliest completion time of any job, but the earliest the entire set can complete. */
		schedule.get(0).requires(schedule.get(2)); //job 2 must precede job 0
		System.out.println(schedule.get(0).start());
		System.out.println(schedule.finish()); //should return 13 (job 0 cannot start until time 5)
		schedule.get(0).requires(j1); //job 1 must precede job 0
		assertEquals(13, schedule.finish()); //should return 13
		System.out.println(schedule.get(0).start()); //should return 5
		System.out.println(j1.start()); //should return 0
		System.out.println(schedule.get(2).start()); //should return 0
		j1.requires(schedule.get(2)); //job 2 must precede job 1
		System.out.println(schedule.finish()); //should return 16
		assertEquals(8, schedule.get(0).start()); //should return 8
		assertEquals(5, schedule.get(1).start()); //should return 5
		System.out.println(schedule.get(2).start()); //should return 0
		schedule.get(1).requires(schedule.get(0)); //job 0 must precede job 1 (creates loop)
		System.out.println( schedule.finish()); //should return -1
		assertEquals(-1 , schedule.get(0).start()); //should return -1
		assertEquals(-1, schedule.get(1).start()); //should return -1
		assertEquals(0, schedule.get(2).start()); //should return 0 (no loops in prerequisites)
	}
}
