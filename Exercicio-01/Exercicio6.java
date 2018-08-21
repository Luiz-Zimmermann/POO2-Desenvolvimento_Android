import java.util.Scanner;

public class Exercicio6{
	
	public static void main(String args[]){
			
			
			int[] num= new int[10];
			
			float x=0;
			int most=0;
			int less=0;
			
			Scanner scan=new Scanner(System.in);
			
			System.out.println("Digite 10 numeros:");
			
			
			for(int i=0;i<10;i++){
				num[i]=scan.nextInt();
				x=x+num[i];
				
				if(num[i]>most){
					most=num[i];
				}
				if(num[i]<less){
					less=num[i];
				}
			}
			
			float averag=x/10;
			
			
			System.out.print("Soma: ");
			System.out.println(x);
			
			System.out.print("Media: ");
			System.out.println(averag);
			
			System.out.print("Maior: ");
			System.out.println(most);
			
			System.out.print("Menor: ");
			System.out.println(less);
			
			
	}
}

	
	