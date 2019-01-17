
public class FCFS 
{
	/*
	 * calculateWaitingTime method is use to calculate waiting time of each process
	 * @param arrival time as an array which holds the arrival time of each process
	 *        burst time as an array which holds the burst time of each process 
	 *        number_of_process which holds the total number of processes
	 * @return return an array which holds the waiting time of each process
	 */
	
	public int[] calculateWaitingTime(int arrival_time[] ,int burst_time[] , int number_of_process)
	{

		int loop1,loop2;
		int working_time[]=new int[number_of_process];
		int waiting_time[]=new int[number_of_process];
		waiting_time[0]=0;
		working_time[0]=0;
		
		for(loop1=1 ; loop1<number_of_process ; loop1++)
		{
			working_time[loop1]=working_time[loop1-1]+burst_time[loop1-1];
			waiting_time[loop1]=working_time[loop1]-arrival_time[loop1];
			
			if(waiting_time[loop1]<0)
			{
				waiting_time[loop1]=0;
			}
		}
		return waiting_time;
	}
	
	/*
	 * calculateTurnAroundTime method is use to calculate turn around time of  each process
	 * @param arrival time as an array which holds the arrival time of each process
	 *        burst time as an array which holds the burst time of each process 
	 *        number_of_process which holds the total number of processes
	 * @return return an array which holds the turn around  time of each process
	 */
	
	public int[] calculateTurnAroundTime(int waiting_time[], int burst_time[] , int number_of_process)
	{
		int turnaroundtime[]=new int[number_of_process];
		int loop1;
		for(loop1=0 ; loop1<number_of_process ; loop1++)
		{
			turnaroundtime[loop1]=waiting_time[loop1]+burst_time[loop1];
		}
		return turnaroundtime;
	}
	
	/*
	 * calculateAverageWaitingTime method is use to calculate waiting time of each process
	 * @param waiting time as an array which holds the waiting time of each process
	 *        number_of_process which holds the total number of processes
	 * @return return a variable which holds the average waiting time of each process
	 */
	
	public float calculateAverageWaitingTime(int waiting_time[] , int number_of_process)
	{
		int loop1,sum_of_waitingtime=0;
		float avg_waiting_time=0.0f;
		for(loop1=0 ; loop1<number_of_process ; loop1++)
		{
			sum_of_waitingtime=sum_of_waitingtime+waiting_time[loop1];
		}
		avg_waiting_time=sum_of_waitingtime/number_of_process;
		return avg_waiting_time;
	}
	
	/*
	 * findMaximumWaitingTime method is used to find maximum waiting time of process
	 * @param waiting time as an array which holds the waiting time of each process
	 *        number_of_process which holds the total number of processes
	 * @return return a variable which holds the maximum waiting time of each process      
	 */
	
	public int findMaximumWaitingTime(int waiting_time[] , int number_of_process)
	{
		int loop1,max=0;
		for(loop1=0 ; loop1<number_of_process ; loop1++)
		{
			if(max<waiting_time[loop1])
			{
				max=waiting_time[loop1];
			}
		}
		return max;
	}
	
	/*
	 * calculateCompletionTime method is used to calculate completion time of each process
	 * @param arrival time as an array which holds the arrival time of each process
	 *        number_of_process which holds the total number of processes
	 *        turn around time as an array which holds the turn around time of each process
	 * @return return an array which holds the completion time of each process
	 */
	
	public int[] calculateCompletionTime(int turn_around_time[] , int arrival_time[] , int number_of_process)
	{
		int loop1;
		int completion_time[]=new int[number_of_process];
		for(loop1=0 ; loop1<number_of_process ; loop1++)
		{
			completion_time[loop1]=turn_around_time[loop1]+arrival_time[loop1];
		}
		return completion_time;
	}
	
	
}
