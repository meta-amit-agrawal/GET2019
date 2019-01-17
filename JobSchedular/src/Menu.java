import java.util.Scanner;


public class Menu 
{
	/*Show Menu will display the menu as follows
	 * 
	 * 
	 */
	public void showMenu()
	{
		System.out.println("\nChoose from the option below..");
		System.out.println("1. Calculate Completion Time");
		System.out.println("2. Calculate Waiting Time");
		System.out.println("3. Calculate Turn Around Time");
		System.out.println("4. Calculate Average Waiting Time");
		System.out.println("5. Find Maximum Waiting Time");
		System.out.println("6. Exit");
	}
	/*
	 * burstTime method will extract the burst time from the 2-D array
	 * @param processnumber  is the total number of process and process is the array 
	 * which holds the arrival time and the burst time.
	 * @return burst time of the given process will be return as an array
	 */
	public int[] burstTime(int processnumber , int process[][])
	{
		int loop1,loop2;
		int burst_time[] = new int[processnumber];
		for(loop1=0 ; loop1<processnumber ; loop1++)
		{
			for(loop2=0 ; loop2<1 ; loop2++)
			{
				burst_time[loop1]=process[loop1][loop2+1];
			}
		}
		return burst_time;
	}
	/*
	 * arrival time will extract the arrival time from the 2-D array
	 * @param processnumber is the number of process and the process the the 2-D array 
	 * which holds the arrival time and burst time given by the user
	 * @return arrival time of the given process will be returned as an array
	 */
	public int[] arrivalTime(int processnumber , int process[][] )
	{
		int loop1,loop2;
		int arrival_time[] = new int[processnumber];
		for(loop1=0 ; loop1<processnumber ; loop1++)
		{
			for(loop2=0 ; loop2<1 ; loop2++)
			{
				arrival_time[loop1]=process[loop1][loop2];
			}
		}
		return arrival_time;
	}
	public static void main(String args[])
	{
		
		Menu m=new Menu();
		int number_of_process,loop1,loop2,choice,num_of_columns=2;
		
		System.out.println("Enter the number of process...");
		Scanner sc = new Scanner(System.in);
		number_of_process=sc.nextInt();
		FCFS newProcess= new FCFS();
		int process[][] =new int[number_of_process][num_of_columns];
		
		System.out.println("Enter the arrival time and burst time of the process..."+number_of_process+"...");
		
		for(loop1=0 ; loop1<number_of_process ; loop1++)
		{
			for(loop2=0 ; loop2<num_of_columns ; loop2++)
			{
				process[loop1][loop2]=sc.nextInt();
			}
		}
		int waiting_time[] = new int[number_of_process];
		int arrival_time[] = new int[number_of_process];
		int burst_time[] = new int[number_of_process];
		int completion_time[] = new int[number_of_process];
		int turn_around_time[] = new int[number_of_process];
		float averageWaitingTime=0.0f;
		int maximumWaitingTime=0;
		arrival_time=m.arrivalTime(number_of_process, process);
		burst_time=m.burstTime(number_of_process, process);
		m.showMenu();
		choice=sc.nextInt();
		while(choice!=6)
		{
			/*
			 * switch case is used to make the choice as given by the user
			 */
			switch(choice)
			{
			case 1:
				completion_time=newProcess.calculateCompletionTime(turn_around_time, arrival_time, number_of_process);
				for(loop1=0 ; loop1<number_of_process ; loop1++)
				{
					System.out.println(completion_time[loop1]);
				}
				break;
			case 2:
				waiting_time=newProcess.calculateWaitingTime(arrival_time , burst_time , number_of_process);
				for(loop1=0 ; loop1<number_of_process ; loop1++)
				{
					System.out.println(waiting_time[loop1]);
				}
				break;
			case 3:
				turn_around_time=newProcess.calculateTurnAroundTime(waiting_time, burst_time , number_of_process);
				for(loop1=0 ; loop1<number_of_process ; loop1++)
				{
					System.out.println(turn_around_time[loop1]);
				}
				break;
			case 4:
				averageWaitingTime=newProcess.calculateAverageWaitingTime(waiting_time, number_of_process);
				System.out.println("Average Waiting Time is..."+averageWaitingTime);
				break;
			case 5:
				maximumWaitingTime=newProcess.findMaximumWaitingTime(waiting_time, number_of_process);
				System.out.println("Maximum Waiting Time is...."+maximumWaitingTime);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice!!");
			}
		m.showMenu();
		choice=sc.nextInt();
		}
		System.out.println("Thank You!!!");
	}
}
