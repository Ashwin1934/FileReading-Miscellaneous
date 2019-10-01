import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;

public class TicTac
{
	public TicTac()
	{
		File name = new File("TicTac.txt");

		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			ArrayList<ArrayList<String>> list = new ArrayList<>();
			//create master list to house
			String text = " ";
			while((text = input.readLine())!=null)
			{
				ArrayList<String> info = new ArrayList<>();

				String[] numbers = text.split(" ");
				for(int i = 0;i<numbers.length;i++){
					info.add(numbers[i]);
				}
				list.add(info);

			}





			while(list.size()>=3){
				ArrayList<String> first = list.get(0);
				ArrayList<String> second = list.get(1);
				ArrayList<String> third = list.get(2);
				boolean x = false;
				boolean o = false;
				if(!x && !o){				// by row
					for(int i = 0;i<3;i++){
						if(((list.get(i).get(0).equals("X"))&&(list.get(i).get(1).equals("X")))&&(list.get(i).get(2).equals("X")))
							x=true;
						if(((list.get(i).get(0).equals("O"))&&(list.get(i).get(1).equals("O")))&&(list.get(i).get(2).equals("O")))
							o=true;
					}
				}
				if(!x && !o){                //by column
					for(int i = 0;i<3;i++){
						if((first.get(i).equals(second.get(i)))&&(first.get(i).equals(third.get(i)))){
							if(first.get(i).equals("X"))
								x= true;
							else
								o = true;
						}
					}
				}
				if(!x && !o){				//diagonally

					if(((first.get(0).equals(second.get(1)))&&(first.get(0).equals(third.get(2))))
					|| ((first.get(2).equals(second.get(1)))&&(first.get(2).equals(third.get(0))))){
						if(second.get(1).equals("X"))
							x = true;
						else
							o = true;

					}
				}
				if(o == true)
					System.out.println("O");
				else if(x==true)
					System.out.println("X");
				else
					System.out.println("-");

				for(int i = 0;i<3;i++)
				{
					list.remove(0);
				}
			}


		}
		catch(IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public static void main(String [] args)
	{
		TicTac app = new TicTac();
	}
}