package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int op;
		
		do {
			
			
			System.out.println("||======================================================================||");
			System.out.println("||\t\t\t(: BANCO ALABAKIZ :)\t\t\t\t||");
			System.out.println("||======================================================================||");
			System.out.println("||\n\t\t\t\t\t\t\t\t\t||");
			System.out.println("||\n\t\t\t\t\t\t\t\t\t||");
			System.out.println("||\n\t\t(1) Criar Conta \t\t\t\t\t||");
			System.out.println("||\n\t\t(2) Listar Todas as Contas \t\t\t\t||");
			System.out.println("||\n\t\t(3) Buscar Conta por Número \t\t\t\t||");
			System.out.println("||\n\t\t(4) Atualizar Dados da Conta\t\t\t\t||");
			System.out.println("||\n\t\t(5) Apagar Conta \t\t\t\t\t||");
			System.out.println("||\n\t\t(6) Sacar \t\t\t\t\t\t||");
			System.out.println("||\n\t\t(7) Depositar \t\t\t\t\t\t||");
			System.out.println("||\n\t\t(8) Transferir valores entre Contas \t\t\t||");
			System.out.println("||\n\t\t(0) sair \t\t\t\t\t\t||");
			System.out.println("||======================================================================||");
			System.out.println("\n\nEntre com a opção desejada:  ");
			
			op = leia.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Criar Conta\n\n");

				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println("Saque\n\n");

				break;
			case 7:
				System.out.println("Depósito\n\n");

				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				break;
            case 0:
				
				System.out.println("\n\tMuito obrigado por utilizar o nosso Banco Alabakiz :)");
				System.out.println("\n\t\t    Te desejamos um bom dia :)");
				System.out.println("\n\t\t\t  Volte sempre :)");
				
		
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}while(op !=0);


	}

}
