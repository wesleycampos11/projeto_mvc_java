package model;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	
		Connection conn = null;
		PreparedStatement pstm = null;

		public void save(Contato contato) {

			String sql = "INSERT INTO CONTATO(NOME, EMAIL, TELEFONE, ASSUNTO, COMENTARIO, DATACADASTRO) VALUES(?,?,?,?,?,?)";

			try {

				conn = ConnectionFactory.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getEmail());
				pstm.setString(3, contato.getTelefone());
				pstm.setString(4, contato.getAssunto());
				pstm.setString(5, contato.getComentario());
				pstm.setDate(6, new Date(contato.getDataCadastro().getTime()));

				pstm.execute();

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

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
		
		public List<Contato> getContatos() {

			String sql = "SELECT * FROM CONTATO";

			List<Contato> contatos = new ArrayList<Contato>();

			ResultSet rset = null;

			try {
				conn = ConnectionFactory.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {

					Contato contato = new Contato();

					contato.setNome(rset.getString("NOME"));
					contato.setTelefone(rset.getString("TELEFONE"));
					contato.setEmail(rset.getString("EMAIL"));
					contato.setAssunto(rset.getString("ASSUNTO"));
					contato.setComentario(rset.getString("COMENTARIO"));
					contato.setDataCadastro(rset.getDate("DATACADASTRO"));
					

					contatos.add(contato);
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

			return contatos;
		}
}
