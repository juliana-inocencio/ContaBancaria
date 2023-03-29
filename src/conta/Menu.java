package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;


public class Menu {
    public static void main(String[] args) {
    	
    	ContaController contas = new ContaController(); 
    	    	
        Scanner leia = new Scanner(System.in);
        
        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite;

				
		while(true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND
					+ "-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("                   BANCO JUBA                        ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Número              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
				
			if (opcao == 9) {
				System.out.println(Cores.TEXT_PURPLE + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);
			}
				
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_PURPLE + "Criar Conta\n\n");
					
					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R");
					titular = leia.nextLine();
					
					do {
						System.out.println("Digite o tipo de conta (1 - CC ou 2 - CP): ");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
					
					System.out.println("Digite o saldo da conta (R$): ");
					saldo = leia.nextFloat();
			
					switch(tipo) {
					case 1 ->{
					System.out.println("Digite o limite de crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia, tipo,titular,saldo,limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo,titular,saldo,aniversario));
					}
			}
					
					keyPress();
                    break;
                    
				case 2:
					System.out.println(Cores.TEXT_PURPLE + "Listar todas as Contas\n\n");
					contas.listarTodas();
					keyPress();
					
                    break;
				case 3:
					System.out.println(Cores.TEXT_PURPLE + "Consultar dados da Conta - por número\n\n");
	
                    break;
				case 4:
					System.out.println(Cores.TEXT_PURPLE + "Atualizar dados da Conta\n\n");
					
                    break;
				case 5:
					System.out.println(Cores.TEXT_PURPLE + "Apagar a Conta\n\n");
		
                    break;
				case 6:
					System.out.println(Cores.TEXT_PURPLE + "Saque\n\n");

                    break;
				case 7:
					System.out.println(Cores.TEXT_PURPLE + "Depósito\n\n");
					
                    break;
				case 8:
					System.out.println(Cores.TEXT_PURPLE + "Transferência entre Contas\n\n");
					
                    break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
                    break;
			}
    }
    }
    

	private static void keyPress() {
		// TODO Auto-generated method stub
		
	}

}