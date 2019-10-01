import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;

public class IndexCard
{
	public IndexCard()
	{
		File name = new File("IndexCard.txt");
		ArrayList<ArrayList<Integer>> bigList = new ArrayList<ArrayList<Integer>>();


		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;

			//ArrayList<Integer> list = new ArrayList<Integer>(); error
			int temp;
			while((text=input.readLine())!=null)
			{
				ArrayList<Integer> list = new ArrayList<Integer>();
				String[] assignments = text.split(" ");
				for(int i = 0;i<assignments.length;i++){
					list.add(Integer.parseInt(assignments[i]));
				}
				bigList.add(list);


			}

		}
		catch(IOException io)
		{
			System.err.println("File does not exist");
		}
		int firstSize = bigList.size();
		int sum;
		while(bigList.size()>0){
			ArrayList<Integer> storage = bigList.get(0);
			int selection = storage.get(1);
			int num = storage.get(0);
			sum = 0;
			bigList.remove(0);

			if(num<10){
				sum = num;
				//System.out.println(sum);debug
			}
			else if(num<100){
				int first = num%10;
				int second = num/10;
				if(first+second<=selection)
					sum = first+second;

				//System.out.println(sum);


			}
			else if(num<1000){
				int first = num%10;
				int second = (num%100)/10;
				int third = num/100;
				int firstSecond = num%100;
				int secondThird = num/10;
				int firstSum = first+second+third;
				int secondSum = first+secondThird;
				int thirdSum = firstSecond+third;

				if(firstSum<=selection)
					sum = firstSum;
				if(secondSum<=selection){
					if(secondSum>sum)
						sum = secondSum;

				}
				if(thirdSum<=selection){
					if(thirdSum>sum)
						sum = thirdSum;
				}
				//System.out.println(sum);


			}
			else{

				int first = num%10;
				int second = (num%100)/10;
				int third = (num%1000)/100;
				int last = num/1000;
				int lastThree = num/10;
				int firstSet = num%100;
				int secondSet = num/100;
				int firstThree = num%1000;
				int midTwo = (num%1000)/10;

				int firstSum = first+lastThree;
				int secondSum = firstSet+secondSet;
				int thirdSum = firstThree+last;
				int fourthSum  = first+midTwo+last;
				int fifthSum = first + second+secondSet;
				int sixSum = firstSet+third+last;

				if(firstSum<=selection){
					sum = firstSum;
				}
				if(secondSum<=selection){
					if(secondSum>sum)
						sum = secondSum;

				}
				if(thirdSum<=selection){
					if(thirdSum>sum)
						sum = thirdSum;
				}

				if(fourthSum<=selection){
					if(fourthSum>sum)
						sum = fourthSum;
				}
				if(fifthSum<=selection){
					if(fifthSum>sum)
						sum = fifthSum;

				}
				if(sixSum<=selection){
					if(sixSum>sum)
						sum = sixSum;

				}
				//System.out.println(sum);

			}

			System.out.println((firstSize-bigList.size())+ " "+ sum);
			//System.out.println(sum);
		}

	}
	public static void main(String[] args)
	{
		IndexCard app = new IndexCard();
	}
}