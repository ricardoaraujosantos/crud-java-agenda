import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

	public static void main(String[] args) {
		ArrayList<String> agenda = new ArrayList<>();
		int opcao = 0;

		do {

			// Menu

			System.out.println("========== Agenda ========== \n");
			System.out.println("Cadastrar contato digite 1");
			System.out.println("Excluir contato digite 2");
			System.out.println("Mostrar contatos digite 3");
			System.out.println("Buscar contato por nome digite 4");
			System.out.println("Atualizar nome do contato digite 5");
			System.out.println("Para sair digite 6 \n");

			Scanner inputOpcao = new Scanner(System.in);
			opcao = inputOpcao.nextInt();

			switch (opcao) {
			case 1:
				// Cadastrar

				System.out.println("Digite o nome do contato que deseja cadastrar \n");
				
				Scanner inputNome = new Scanner(System.in);
				agenda.add(inputNome.next());

				break;

			case 2:
				// Excluir

				System.out.println("Digite o nome que deseja excluir \n");
				
				String nomeExcluir = "";
				Scanner inputExcluir = new Scanner(System.in);
				nomeExcluir = inputExcluir.next();

				if (agenda.contains(nomeExcluir)) {
					agenda.remove(nomeExcluir);
				} else {
					System.out.println("Erro, Nome não existe na agenda \n");
				}

				break;

			case 3:
				// Consultar todos nomes

				System.out.println("Contatos cadastrados \n");

				for (int i = 0; i < agenda.size(); i++) {
					System.out.println("Contato " + (i + 1) + " - " + agenda.get(i));
				}
				System.out.println("\n");
				
				break;

			case 4:
				// consultar por nome

				System.out.println("Digite o nome que deseja Buscar \n");
				
				String buscaNome = "";
				Scanner inputBusca = new Scanner(System.in);
				buscaNome = inputBusca.next();

				if (agenda.contains(buscaNome)) {
					System.out.println("Nome" + " - " + buscaNome + " encontrado \n");
				} else {
					System.out.println("Erro, Nome não existe na agenda \n");
				}

				break;

			case 5:
				// Atualizar

				System.out.println("Digite o nome que deseja atualizar \n");
				
				String nomeAtualizar = "";
				Scanner inputAtualizar = new Scanner(System.in);
				nomeAtualizar = inputAtualizar.next();

				System.out.println("Digite o novo nome \n");
				
				String novoNome = "";
				Scanner inputNovoNome = new Scanner(System.in);
				novoNome = inputNovoNome.next();

				for (int i = 0; i < agenda.size(); i++) {

					if (agenda.get(i).equals(nomeAtualizar)) {

						agenda.set(i, novoNome);
					}
				}

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
