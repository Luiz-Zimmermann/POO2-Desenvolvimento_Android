public class Exercicio4{
	
	
	public static void main(String args[]){
		
		String sla ="11";
		
		float height = Float.parseFloat(args[1]);//altura
		float weight= Float.parseFloat(args[0]);//peso
	 
		float imc;
		imc = weight/(height*height);
		 
		System.out.println(imc);
		 
		
		
	}
	
}