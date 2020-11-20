//package Schedule;

import java.util.*;
//professor may want the code to base schedule on interconnected jobs to 0
public class Schedule {
	public Job tempJob = new Job();
	public ArrayList<Job> schedList = new ArrayList<Job>();
	public Schedule() {}
	
	public Job insert(int time)
	{
		Job jobs = new Job();
		jobs.time = time;
		schedList.add(jobs);
		return jobs;
	}
	
	public Job get(int index)
	{
		return schedList.get(index);
	}
	
	public int finish()
	{
		int timeToFin = 0;
		for(int i = 0; i < schedList.size(); i++)
		{
			if(schedList.get(i).start() == -1)
				return -1;
			int temp = schedList.get(i).start() + schedList.get(i).time;
			if(timeToFin < temp)
				timeToFin = temp;
			
		}
		return timeToFin;
	}
	

	class Job{
		private ArrayList<Job> prereq = new ArrayList<Job>();
		private ArrayList<Job> inList = new ArrayList<Job>();
		private int time;
		public void requires(Job j)
		{
			prereq.add(j);
			j.inList.add(this);
		}
		
		public int start(){
			int maxTime = 0;
			if(this.prereq.isEmpty() == true)
			{
				return 0;
			}
			for(int i = 0; i < inList.size(); i++)
			{
				if(prereq.contains(inList.get(i)))
					return -1;
			}
			for(int i = 0; i < prereq.size(); i++)
			{
				int reqTime = prereq.get(i).time;
				int temp = prereq.get(i).start()+ reqTime;
				if(temp > maxTime)
				{
					maxTime = temp;
				}
				
			}
			return maxTime;
		}
	}
}
