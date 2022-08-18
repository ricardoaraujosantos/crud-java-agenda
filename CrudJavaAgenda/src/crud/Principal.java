package crud;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ContatoDao;
import modelo.Contato;

public class Principal {

	public static void main(String[] args) {
		
		int opcao = 0;
		int id = 0;
		String nome = "";
		String telefone = "";
		Scanner entrada =  new Scanner(System.in);
		ContatoDao dao = new ContatoDao();

		do {

			// Menu
			System.out.println("========== AGENDA ==========");
			System.out.println("      ESCOLHA UMA OPÇÃO   \n");
			System.out.println("1 - CADASTRAR CONTATO");
			System.out.println("2 - MOSTRAR CONTATO");
			System.out.println("3 - ATUALIZAR CONTATO");
			System.out.println("4 - DELETAR CONTATO");
			System.out.println("5 - BUSCAR CONTATO POR ID");
			System.out.println("6 - PARA SAIR \n");
			System.out.println("============================ \n");

			Scanner inputOpcao = new Scanner(System.in);
			opcao = inputOpcao.nextInt();

			switch (opcao) {
			case 1:
				// Create
				System.out.println("--------CADASTRAR---------/n");
				System.out.println("Digite o nome do Contato");
				nome = entrada.next();
				System.out.println("Digite o telefone com DDD");
				telefone = entrada.next();
				
				Contato contato1 = new Contato(nome, telefone);
				dao.save(contato1);
				
				break;

			case 2:
				//Read 

				
				break;

			case 3:
				//Update 

				
				
				break;

			case 4:
				// Delete

				

				break;

			case 5:
				// Search By Id

				

				break;

			case 6:
				// Sair

				System.out.println("Você saiu da agenda!");
				break;

			default:
				System.out.println("Erro, digite uma opção valida \n");
				break;
			}

		} while (opcao != 6);

	}
}
