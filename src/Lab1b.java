/*
 * Code by Jens Nilsson, created 2017-11-10
 */

import javax.swing.*;

public class Lab1b {
	
	public static void main(String args[]){
		Dag dag;
		String pre;
		while(true){
			String year = JOptionPane.showInputDialog("Write a date on the form: yyyy-mm-dd");
			if(year == null){
				System.exit(0);
			}
			dag = new Dag(year);
			if(dag.skottAr){
				pre = " and it is a leap year.";
			}else{
				pre = " and it is NOT a leap year.";
			}
			if(dag.fel == false){
				JOptionPane.showMessageDialog(null, "The number of the day is " + dag.dagNr() + " and it is \n" + "a " + dag.veckoDag() + pre);
			}
		}
	}
	
}

class Dag{
	
	int y;	//Year, month, day and boolean fields
	int m;
	int d;
	boolean skottAr;
	boolean fel = false;
	SkottÅr ar;
	int dagar = 0;
	
	public Dag(){	//Default date
		this.y = 1754;
		this.m = 1;
		this.d = 1;
	}
	
	public Dag(String year){
		this.y = Integer.parseInt(year.substring(0,4));
		this.m = Integer.parseInt(year.substring(5,7));
		this.d = Integer.parseInt(year.substring(8));
		if(this.y < 1754){		//Checks
			System.out.println(this.y);
			JOptionPane.showMessageDialog(null, "Wrong date format!");
			this.fel = true;
		}
		ar = new SkottÅr(Integer.toString(y));
		skottAr = ar.year();
		if(this.m < 1 || this.m >12){
			System.out.println(1);
			JOptionPane.showMessageDialog(null, "Wrong date format!");
			this.fel = true;
		}
		if((this.m == 1) || (this.m == 3) || (this.m == 5) || (this.m == 7) || (this.m == 8) || (this.m == 10) || (this.m == 12)){
			if(this.d < 1 || this.d > 31){
				JOptionPane.showMessageDialog(null, "Wrong date format!");
				this.fel = true;
				System.out.println(2);
			}
		}
		if((this.m == 4) || (this.m == 6) || (this.m == 9) || (this.m == 11)){
			if(this.d < 1 || this.d > 31){
				JOptionPane.showMessageDialog(null, "Wrong date format!");
				this.fel = true;
				System.out.println(3);
			}
		}
		if(this.m == 2 && skottAr == true){
			if(this.d <1 && this.d > 29){
				JOptionPane.showMessageDialog(null, "Wrong date format!");
				this.fel = true;
				System.out.println(4);
			}
		}
		if(this.m == 2 && skottAr == false){
			if(this.d <1 && this.d > 28){
				JOptionPane.showMessageDialog(null, "Wrong date format!");
				this.fel = true;
				System.out.println(5);
			}
		}
	}
	
	public int dagNr(){
		for(int i = 1; i < this.m; i++){
			if(i == 2){
				if(this.skottAr){
					this.dagar += 29;
				}else{
					this.dagar += 28;
				}
			}else if(i < 8){
				if(i % 2 == 0){
				this.dagar += 30;
				}else{
				this.dagar += 31;
				}
			}else{
				if(i % 2 == 0){
					this.dagar += 31;
				}else{
					this.dagar += 30;
				}
			}
		}
		this.dagar += this.d;
		return this.dagar;
	}
	
	public String veckoDag(){
		int dagar = 0;
		SkottÅr  ar1;
		for(int i = 1754; i < this.y; i++){
			ar1 = new SkottÅr(Integer.toString(i));
			if(ar1.year()){
				dagar += 366;
			}else{
				dagar += 365;
			}
		}
		dagar += this.dagar;
		if(dagar % 7 == 0){
			return "Monday";
		}else if(dagar % 7 == 1){
			return "Tuesday";
		}else if(dagar % 7 == 2){
			return "Wednesday";
		}else if(dagar % 7 == 3){
			return "Thursday";
		}else if(dagar % 7 == 4){
			return "Friday";
		}else if(dagar % 7 == 5){
			return "Saturday";
		}else if(dagar % 7 == 6){
			return "Sunday";
		}
		return "Error";
	}
}

class SkottÅr{
	int y;
	
	public SkottÅr(){
		this.y = 1754;
	}
	
	public SkottÅr(String year){
		if(year == null){
			System.exit(0);
		}
		this.y = Integer.parseInt(year);
	}
	
	public boolean year(){
		if((this.y%4 == 0 && this.y%100 != 0) || (this.y%400 == 0)){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return Integer.toString(y);
	}
}