package jp.co.internous.action;

public class Main {

	public static void main(String[]args){
	System.out.println("Hello World");
	System.out.println(hikizan(10,10));
	System.out.println(kakezan(10,10));
	System.out.println(warizan(10,10));
	}
	public static double hikizan(int number1,int number2 ){
		return number1-number2;
	}
		public static double kakezan(int number1,int number2 ){
			return number1*number2;
		}
			public static double warizan(int number1,int number2 ){
				return number1/number2;
}
}