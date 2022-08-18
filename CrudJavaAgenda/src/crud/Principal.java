package crud;

import java.util.Scanner;
import dao.ContatoDao;
import modelo.Contato;

public class Principal {

	public static void main(String[] args) {

		int opcao = 0;
		int id = 0;
		String nome = "";
		String telefone = "";
		Scanner entrada = new Scanner(System.in);
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
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Create
				System.out.println("--------CADASTRAR---------/n");
				System.out.println("Digite o nome do Contato");
				nome = entrada.next();
				System.out.println("Digite o telefone com DDD");
				telefone = entrada.next();

				Contato contato = new Contato(nome, telefone);
				dao.save(contato);

				break;

			case 2:
				// Read
				System.out.println("- LISTA TODOS CONTATOS -\n");

				for (Contato contatoList : dao.obterContatos()) {

					System.out.println("ID: " + contatoList.getId());
					System.out.println("NOME: " + contatoList.getNome());
					System.out.println("TELEFONE: " + contatoList.getTelefone());
					System.out.println("----------------------------------- ");
				}
				System.out.println("\n");

				break;

			case 3:
				// Update

				Contato upDateContato = new Contato();

				System.out.println("ATUALIZAR");
				System.out.println("Digite o id do contato que deseja atualizar");
				id = entrada.nextInt();
				upDateContato.setId(id);

				System.out.println("Digite um novo nome");
				nome = entrada.next();
				upDateContato.setNome(nome);
				System.out.println("Nome atualizado!");

				System.out.println("Digite um novo telefone");
				telefone = entrada.next();
				upDateContato.setTelefone(telefone);
				System.out.println("Telefone atualizado!");

				dao.upDate(upDateContato);

				break;

			case 4:
				// Delete
				
				System.out.println("DELETAR");
				System.out.println("Digite o id do contato que deseja deletar");
				id = entrada.nextInt();
				
				System.out.println("Deseja realmente excluir esse contato? \n");
				
				contato = dao.obterContatoPorId(id);
				System.out.println("Id: " + contato.getId());
				System.out.println("Nome: " + contato.getNome());
				
				System.out.println("CONFIRMAR DIGITE 1 \n");
				
				System.out.println("1 - SIM");
				System.out.println("2 - NÃO");
				System.out.println("----------------------------------\n");
				opcao = entrada.nextInt();
				
				if(opcao == 1) {
					dao.delete(id);
					System.out.println("Contato deletado com sucesso \n");
				}else {
					System.out.println("Operação delete cancelada \n");
				}
				break;

			case 5:
				// Search By Id
				System.out.println("Digite o Id do contato que deseja consultar");
				id = entrada.nextInt();
				contato = dao.obterContatoPorId(id);
				
				System.out.println("Id: " + contato.getId());
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Telefone: " + contato.getTelefone());
				
				break;

			case 6:
				// Sair

				System.out.println("VOCÊ SAIU!");
				break;

			default:
				System.out.println("ERRO, ESCOLHA UMA OPÇÃO VALIDA! \n");
				break;
			}

		} while (opcao != 6);

	}
}
