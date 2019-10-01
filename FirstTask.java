import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;


public class FirstTask
{


		public FirstTask()
		{

			File name = new File("FirstTask.txt");
			try
			{

				BufferedReader input = new BufferedReader(new FileReader(name));
				String text,output = "";

				ArrayList<ArrayList<String>> holder = new ArrayList<ArrayList<String>>();
				ArrayList<String> eachLine = new ArrayList<String>();
				while((text=input.readLine())!= null)
				{
					output+=text;
					eachLine.add(text);




				}


				for(int i = 0;i<eachLine.size();i+=3){

						intersect(eachLine.get(i),eachLine.get(i+1),eachLine.get(i+2));

				}




				}


			catch (IOException io)
			{
				//System.err.println("File does not exist");
			}
		}

		public static void intersect(String a, String b, String c){

			String[] list1 = a.split(" ");


			String[] list2 = b.split(" ");


			String[] list3 = c.split(" ");

			ArrayList<String> intersection1 = new ArrayList<String>();
			ArrayList<String> intersection2 = new ArrayList<String>();

			int common = 0;
			ArrayList<String> intersectionOutput = new ArrayList<String>();

			//checks first two sets and adds common numbers to ArrayList
			for(int i = 0;i<list1.length;i++){
				for(int j = 0;j<list2.length;j++){
					//System.out.println(list2[j]+" "+list1[i]);
					if(list2[j].equals(list1[i])){
						intersection1.add(list2[j]);
					}
				}
			}

			//checks second two sets and adds common numbers to ArrayList
			for(int i = 0;i<list2.length;i++){
				for(int j = 0;j<list3.length;j++){
					if(list3[j].equals(list2[i]))
						intersection2.add(list3[j]);
				}
			}

			//checks intersections sets and adds common numbers to ArrayList
			for(int i = 0;i<intersection1.size();i++){
				for(int j = 0;j<intersection2.size();j++){
					if(intersection2.get(j).equals(intersection1.get(i)))
						intersectionOutput.add(intersection1.get(i));
				}
			}

			//outputting final intersection

				System.out.println("Intersection:"+intersectionOutput);



		}

		public static void main(String[] args)
		{
			FirstTask app = new FirstTask();
		}

	}