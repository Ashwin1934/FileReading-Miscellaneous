import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;

public class Calendar
{
	public Calendar()
	{
		File name = new File("Calendar.txt");
		int month,day;
		int [] daysInMonths ={31,28,31,30,31,30,31,31,30,31,30,31};
		String [] days = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
		ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
		int dayOfWeek;

		try
		{
			BufferedReader input= new BufferedReader(new FileReader(name));
			String text,output = "";
			//preSets for the calendar



			while((text=input.readLine())!=null)
			{


				String[] array = text.split(" ");
				ArrayList<Integer> cal = new ArrayList<Integer>();
				for(int i = 0;i<array.length;i++){
					cal.add(Integer.parseInt(array[i]));
				}
				bigList.add(cal);

			}





		}

		catch(IOException io)
		{
			System.err.println("File does not exist");
		}

		while(bigList.size()>0)
		{
			System.out.println("Hello");
			ArrayList<Integer> givenInfo = bigList.get(0);
			bigList.remove(0);
			if(givenInfo.get(0)==1)	//for february
				daysInMonths[1]=29;
			month = 1;
			day = givenInfo.get(3);
			while(month<givenInfo.get(2)){
				day+=daysInMonths[month-1];
				month++;
			}
			dayOfWeek = ((day+(givenInfo.get(1)-1))%7);

			System.out.println(givenInfo+" "+days[dayOfWeek]);



		}

	}
	public static void main(String[] args)
	{
		Calendar app = new Calendar();

	}

}