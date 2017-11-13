import javax.swing.*;
import java.awt.*;

public class Lab1a {
	
	public static void main(String args[]){
		SkottÅr y;
		while(true){
			String year = JOptionPane.showInputDialog("Skriv ett årtal.");
			y = new SkottÅr(year);
			if(y.year() == true){
				JOptionPane.showMessageDialog(null, y + " är ett skottår!");
			}else{
				JOptionPane.showMessageDialog(null, y + " är INTE ett skottår.");
			}
		}
	}
	
}


