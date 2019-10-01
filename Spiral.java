import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;

public class Spiral
{



	public Spiral()
	{

		File name = new File("Spiral.txt");

		try
		{


			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			ArrayList<String> holder = new ArrayList<String>();
			//filling arraylist and converting strings to integers
			while((text=input.readLine())!=null){

				//System.out.println(text);
				holder.add(text);


			}
			ArrayList<Integer> intHolder = new ArrayList<Integer>();
			for(int i = 0;i<holder.size();i++){
				int temp = Integer.parseInt(holder.get(i));
				intHolder.add(temp);
			}

			//System.out.println(intHolder);
			//done filling   now enters and sends each int to the method to print spiral
			for(int i = 0;i<intHolder.size();i++){
				ReturnSpiral(intHolder.get(i));
				System.out.println();
			}




		}
		catch(IOException io){


			System.err.println("File does not exist");

		}
	}
		public void ReturnSpiral(int num){
			String[][]grid = new String[num][num];
			//fills a grid with dashes
			for(int i = 0;i<num;i++){
				for(int j = 0;j<num;j++){
					grid[i][j]="-";
				}
			}
			int startRow = 0;
			int startCol = 0;
			int endRow = num;
			int endCol= num;
			int currentRow = 0;
			int currentCol = 0;
			int counter = 0;

			while(counter<num){
				//right
				while(currentCol<endCol){
					grid[currentRow][currentCol] = "*";
					currentCol++;
				}
				counter++;
				if(counter==num)
					break;
				//down
				while(currentRow<endRow){
					grid[currentRow][currentCol-1]="*";
					currentRow++;
				}

				counter++;
				if(counter==num)
					break;
				//left
				while(currentCol>startCol){
					currentCol--;
					grid[currentRow-1][currentCol]="*";
				}
				startRow+=2;
				endCol-=2;
				counter++;
				if(counter==num)
					break;
					//up
				while(currentRow>startRow){
					currentRow--;
					grid[currentRow][currentCol]="*";
				}
				counter++;
				startCol+=2;
				endRow-=2;
				if(counter==num)
					break;

			}//end while loop

			//print
			for(int i = 0;i<num;i++){
				for(int j = 0;j<num;j++){
					System.out.print(grid[i][j]+" ");
				}
				System.out.println();
			}

		}

		public static void main(String[] args){

			Spiral app = new Spiral();

		}

	}