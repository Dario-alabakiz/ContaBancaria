package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupança;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);
		int op = 0, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo = 0, limite, valor;
		
		
		do {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("||======================================================================||");
			System.out.println("||\t\t\t(: BANCO ALABAKIZ :)\t\t\t\t||");
			System.out.println("||======================================================================||");
			System.out.println("||\t\t\t\t\t\t\t\t\t||");
			System.out.println("||\t\t\t\t\t\t\t\t\t||");
			System.out.println("||\t\t(1) Criar Conta \t\t\t\t\t||");
			System.out.println("||\t\t(2) Listar Todas as Contas \t\t\t\t||");
			System.out.println("||\t\t(3) Buscar Conta por Número \t\t\t\t||");
			System.out.println("||\t\t(4) Atualizar Dados da Conta\t\t\t\t||");
			System.out.println("||\t\t(5) Apagar Conta \t\t\t\t\t||");
			System.out.println("||\t\t(6) Sacar \t\t\t\t\t\t||");
			System.out.println("||\t\t(7) Depositar \t\t\t\t\t\t||");
			System.out.println("||\t\t(8) Transferir valores entre Contas \t\t\t||");
			System.out.println("||\t\t(0) sair \t\t\t\t\t\t||");
			System.out.println("||\t\t\t\t\t\t\t\t\t||");
			System.out.println("||======================================================================||");
			System.out.println("\n\nEntre com a opção desejada:  ");

			try {
				op = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores Inteiros!!!");
				leia.nextLine();
				op = 0;
			}
			
			

			switch (op) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Criar Conta\n\n");

				System.out.println("Digite o Numero da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo da Conta (1-cc ou 2-cp): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				System.out.println("Digite o Saldo da Conta (R$): ");
				limite = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo,limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupança(contas.gerarNumero(), agencia, tipo, titular, saldo,limite));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Listar todas as Contas\n\n");
				
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				if(contas.buscarNaCollection(numero) != null) {
					
					System.out.println("Digite o Número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Número da Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					tipo = contas.retornaTipo(numero);
					
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero,agencia,tipo,titular,saldo,limite));
					}
					case 2->{
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupança(numero,agencia,tipo,titular, saldo,aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválida!");
					}
					}
					
				}else
					System.out.println("\nConta não encontrada! ");

				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Saque\n\n");
				
				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor do saque (R$): ");
					valor = leia.nextFloat();
				}while(valor<=0);
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Depósito\n\n");
				
				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();
				}while(valor<=0);
				contas.depositar(numero, valor);
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o Numero da Conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
			case 0:

				System.out.println(Cores.TEXT_BLUE_BOLD + "\tMuito obrigado por utilizar o nosso Banco Alabakiz :)");
				System.out.println(Cores.TEXT_BLUE_BOLD + "\t\t    Te desejamos um bom dia :)                ");
				System.out.println(Cores.TEXT_BLUE_BOLD + "\t\t\t  Volte sempre :)                     ");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
			}
			
		} while (op != 0);
	

	}
	
	private static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar....");
			System.in.read();

		} catch (IOException e) {
			System.out.println("VOcê pressionou uma tecla diferente de enter!!");
		}
	}
	

}
		
	

