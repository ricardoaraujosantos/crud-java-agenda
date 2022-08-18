package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Conexao;
import modelo.Contato;

public class ContatoDao {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Contato contato) {

		String sql = "INSERT INTO contato(id, nome, telefone)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, contato.getId());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, contato.getNome());
			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setString(3, contato.getTelefone());

			// Executa a sql para inserção dos dados
			pstm.execute();

			System.out.println("CADASTRO REALIZADO COM SUCESSO! \n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Contato> obterContatos() {

		String sql = "SELECT * FROM contato";

		List<Contato> contatosList = new ArrayList<Contato>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Contato contato = new Contato();

				// Recupera o id do banco e atribui ele ao objeto
				contato.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				contato.setNome(rset.getString("nome"));

				// Recupera a idade do banco e atribui ele ao objeto
				contato.setTelefone(rset.getString("telefone"));

				// Adiciono o contato recuperado, a lista de contatos
				contatosList.add(contato);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return contatosList;
	}

	public void upDate(Contato contato) {

		String sql = "UPDATE contato SET nome = ?, telefone = ?" 
				+ " WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			pstm.setInt(3, contato.getId());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Fecha as conexões
			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
