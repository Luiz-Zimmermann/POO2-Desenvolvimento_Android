import java.util.Scanner;


public class Exercicio7{
	
	public static void main(String args[]){

		float[] vet= new float[3];
		 Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite o nome do aluno:");
		String name=scan.nextLine();
		
		
		
		for(int i=0;i<3;i++){
			vet[i]=scan.nextFloat();
		}
		
		float averag;
		averag= (vet[0]+vet[1]+vet[2])/3;
		
		System.out.println("Nome do aluno:"+name);
		
		System.out.println("Media:"+averag);
		
		if(averag>=6){
			System.out.println("Situacao: Aprovado");
		}else{
			System.out.println("Situacao: Reprovado");
		}
		
	
	}
}

		
	