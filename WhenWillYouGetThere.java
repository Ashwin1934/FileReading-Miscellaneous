import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;





public class WhenWillYouGetThere
{

	static ArrayList<String> list = new ArrayList<String>();

	public WhenWillYouGetThere()
	{

		File name = new File("WhenWillYouGetThere.txt");





		try{
			BufferedReader input = new BufferedReader(new FileReader(name));


			String text;
			while((text = input.readLine())!=null){
				System.out.println(text);
				list.add(text);

			}

		}

		catch(IOException io)
		{
			System.err.println("File does not exist");

		}

	}

	public static void getOutput(String time){

				DateFormat hour = new SimpleDateFormat("hh");
				DateFormat hmin = new SimpleDateFormat(":mm a");
				DateFormat monDaYear = new SimpleDateFormat("MM/dd/yyy");

				Calendar calendar = Calendar.getInstance();

				String [] addList = time.split(" ");
				int [] addedTime = {Integer.parseInt(addList[0]),Integer.parseInt(addList[1]),Integer.parseInt(addList[2])};
				String output= ("\tDeparture Date and Time: ");
				int hourOutput = Integer.parseInt(hour.format(calendar.getTime()));


				output += hourOutput+hmin.format(calendar.getTime()) + " on " + monDaYear.format(calendar.getTime())+"\n\tArrival Date and Time: ";
				calendar.add(Calendar.MINUTE,addedTime[2]);
				calendar.add(Calendar.HOUR,addedTime[1]);
				calendar.add(Calendar.DAY_OF_MONTH,addedTime[0]);
				hourOutput = Integer.parseInt(hour.format(calendar.getTime()));

				System.out.println(output+=hourOutput+hmin.format(calendar.getTime())+" on " + monDaYear.format(calendar.getTime()));
	}


	public static void main(String[] args)
	{

		WhenWillYouGetThere app = new WhenWillYouGetThere();
		for(int i = 0;i<list.size();i++)
			getOutput(list.get(i));
	}
}







