package Question4;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Counselling 
{
	
	Queue queue = new QueueImplementation();
	Map<String, Integer> programsMap = new HashMap<String, Integer>();
	Map<String, String> studentPrefernece = new HashMap<String, String>();
	
	/**
	 * Method to read the input file excel sheet which contains list of program with capacity
	 * @param filePath
	 */
	public void readProgramCapacity(String filePath)
	{
		File file = new File(filePath);
		Workbook workbook;
		try 
		{
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(UtilityClass.initialSheetnumber);
			for(int index=1;index<sheet.getRows();index++)
			{
				Cell cell = sheet.getCell(UtilityClass.initialColumn, index);
				
				CellType type = cell.getType();
				if (type == CellType.LABEL)
				{
					String programName = cell.getContents();
					cell = sheet.getCell(UtilityClass.initialColumn+1, index);
					int capacity=Integer.parseInt(cell.getContents());
					programsMap.put(programName, capacity);
				}
			}
		}
		catch (BiffException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * method reads the excel sheet which contains the students sorted according to rank  
	 * @param filePath
	 */
	public void readStudentPrefernece(String filePath)
	{
		File file = new File(filePath);
		Workbook workbook;
		try 
		{
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(UtilityClass.initialSheetnumber);
			for(int index=1;index<sheet.getRows();index++)
			{
				Cell cell = sheet.getCell(UtilityClass.initialColumn, index);
				
				CellType type = cell.getType();
				if (type == CellType.LABEL)
				{
					String studentName = cell.getContents();
					queue.Enqueue(studentName);
					cell = sheet.getCell(UtilityClass.initialColumn+1, index);
					String preference=cell.getContents();
					studentPrefernece.put(studentName, preference);
				}
			}
		}
		catch (BiffException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * method council the students according to rank and allocate the program to student
	 * @param path
	 * @throws WriteException
	 */
	public void studentCouncil(String path) throws WriteException
	{
		WritableWorkbook workbook;		
		try 
		{
			workbook = Workbook.createWorkbook(new File(path+"/output.xls"));
			 WritableSheet sheet = workbook.createSheet("Output", UtilityClass.initialSheetnumber);
			 int count=1;
			while(!queue.isEmpty()) 
			{
				//gets the student name from the queue
		        String student=queue.Dequeue();
		        //gets the student preference given in input
		        String pref = studentPrefernece.get(student);
		        //splits the student preferences 
		        String[] preference = new String[UtilityClass.noOfPreference];
		        
		        preference=pref.split(",");
		        
		        boolean assign=false;
		        
		        //assigns the student to a particular program
		        for(int index=0;index<preference.length;index++)
		        {
		        	if(assign)
		                break;
		        	String subject=preference[index];
		        	int capacity=programsMap.get(subject);
		        	if(capacity>0)
		        	{
		        		Label label = new Label(UtilityClass.initialColumn, count, student);
		        		sheet.addCell(label);
		        		Label label1 = new Label(UtilityClass.initialColumn+1, count, preference[index]);
		        		sheet.addCell(label1);
		        		count++;
		        		assign=true;
		                capacity--;
		                programsMap.put(subject,capacity);
		        	}
		        }
			}
			workbook.write();
			workbook.close();
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
