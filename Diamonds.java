import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;


public class Diamonds
{
	public Diamonds()
	{

		File name = new File("Diamonds.txt");


		try
		{

			BufferedReader input = new BufferedReader(new FileReader(name));
			ArrayList<String> eachline = new ArrayList<String>();

			String text,output = "";
			while((text=input.readLine())!=null)
			{
				//adds each line of the text file into an array
				output+=text;
				eachline.add(text);
			}
			//test output of eachline
			for(int i = 0;i<eachline.size();i++){
				//System.out.println(eachline.get(i));
				DiamondMaker(eachline.get(i));

			}

			//temporary calling of Diamondmaker




		}
		catch(IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public static void DiamondMaker(String n){
		//the item from eachline is sent in, each number is stored in an array
		String [] assignments = n.split(" ");

		int rows,columns,sideLength,topPointRow,topPointColumn;
		rows = Integer.parseInt(assignments[0]);
		columns = Integer.parseInt(assignments[1]);
		sideLength = Integer.parseInt(assignments[2]);
		topPointRow = Integer.parseInt(assignments[3]);
		topPointColumn = Integer.parseInt(assignments[4]);
		int startFill = 0;
		int endFill = 0;

		//filling 2d string array with Os
		String[][]output = new String[rows][columns];
		for(int i = 0;i<rows;i++){
			for(int j = 0;j<columns;j++){
				output[i][j]= "-";
			}
			System.out.println();
		}

		//drawing the diamond
		startFill = topPointColumn;
		endFill = topPointColumn;

		for(int i=topPointRow; i<rows; i++){

			for(int j = 0; j<columns; j++){
				if(i >= topPointRow && j >= startFill && j <= endFill ){
					output[i][j]="X";
				}
			}
			if(i < sideLength+topPointRow-1){
				startFill =startFill - 1;
				endFill = endFill + 1;
			}
			else{
				startFill += 1;
				endFill -= 1;
			}
		}






		//outputting the board
		for(int i = 0;i<rows;i++){
			for(int j = 0;j<columns;j++){
				System.out.print(output[i][j]);
			}
			System.out.println();
		}

		System.out.println();

	}

	public static void main(String[] args)
	{
		Diamonds app = new Diamonds();


	}
}