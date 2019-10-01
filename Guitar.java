import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.lang.Object;
import javax.swing.text.Utilities.*;
import javax.swing.text.*;


 class Utilities{
 	Utilities(){}

 	public void print2dArray(String[][]s){
	for (int row = 0; row < s.length; row++) {
		for (int col = 0; col < s[0].length; col++) {
			System.out.print(s[row][col] + " ");
		}
		System.out.println();
	}
    }
    public String[][] fill2DArray(String s, int row,int col){
		String[][] output = new String[row][col];
        for (int i = 0; i< output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                output[i][j] = s;
            }
        }

        return output;

	}

}
public class Guitar {


	public Guitar(){
		ArrayList<String[]> note = new ArrayList<String[]>();
		File name = new File("Guitar.txt");

		Utilities utility = new Utilities();

		String[] holder = new String[1];


		String [] eLow = { "E", "F", "F#", "G", "G#" };
		String[] a = { "A", "A#", "B", "C", "C#" };
		String[] d = { "D", "D#", "E", "F", "F#" };
		String[] g = { "G", "G#", "A", "A#", "B" };
		String[] b = { "B", "C", "C#", "D", "D#" };
        String[] eHigh = { "E", "F", "F#", "G", "G#" };

        ArrayList<String[]> strings = new ArrayList<>();
        strings.add(eHigh);
		strings.add(b);
		strings.add(g);
		strings.add(d);
		strings.add(a);
        strings.add(eLow);
        try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			while((text=input.readLine())!=null){
				note.add(text.split(","));
			}
			input.close();
			holder = note.remove(0);
		}
		catch(IOException io){
			System.err.println("File does not exist");
		}
		String [][] output = utility.fill2DArray("\t",30,holder.length+1);

		System.out.print("Measure\t");
		for (int i = 0; i < note.get(0).length; i++) {
			System.out.print("\t" + (i + 1));
		}
        System.out.println();

        int count = 0;
		for (String[] s : strings) {
			for (int i = s.length - 1; i >= 0; i--) {
				output[count][0] = s[i] + "\t\t";
				count++;
			}
        }

		for (int measure = 0; measure < note.get(0).length; measure++) {
			String string = holder[measure];
			String fret1 = note.get(0)[measure];
			String fret2 = note.get(1)[measure];
			String fret3 = note.get(2)[measure];
			String fret4 = note.get(3)[measure];

			for (int i = string.length() - 1; i >= 0; i--) {
				if (string.substring(i, i + 1).equals("o"))
					output[(5 * (string.length() - i)) - 1][measure + 1] = "O\t";
			}
			for (int i = fret1.length() - 1; i >= 0; i--) {
				if (fret1.substring(i, i + 1).equals("*"))
					output[(5 * (fret1.length() - i)) - 2][measure + 1] = "O\t";
			}
			for (int i = fret2.length() - 1; i >= 0; i--) {
				if (fret2.substring(i, i + 1).equals("*"))
					output[(5 * (fret2.length() - i)) - 3][measure + 1] = "O\t";
			}
			for (int i = fret3.length() - 1; i >= 0; i--) {
				if (fret3.substring(i, i + 1).equals("*"))
					output[(5 * (fret3.length() - i)) - 4][measure + 1] = "O\t";
			}
			for (int i = fret4.length() - 1; i >= 0; i--) {
				if (fret4.substring(i, i + 1).equals("*"))
					output[(5 * (fret4.length() - i)) - 5][measure + 1] = "O\t";
			}
		}

        utility.print2dArray(output);

}
	public static void main(String [] args){
		Guitar app = new Guitar();
	}
}

