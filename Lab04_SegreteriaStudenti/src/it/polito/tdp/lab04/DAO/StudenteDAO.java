package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;
import it.polito.tdp.lab04.model.Corso;

public class StudenteDAO {
	public Studente getStudente(int matricola) {

		final String sql = "SELECT * FROM studente WHERE matricola = ?";
		Studente studente = null;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				studente = new Studente(matricola, rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

		return studente;
}
	/*
	 * Data una matricola ottengo la lista dei corsi (codins) a cui è iscritto
	 */
	public List<Corso> getCorsiFromStudente(Studente studente) {

		final String sql = "SELECT * FROM iscrizione, corso WHERE iscrizione.codins=corso.codins AND matricola=?";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso corso = new Corso(rs.getString("codins"),  rs.getString("nome"),rs.getInt("crediti"),
						rs.getInt("pd"));
				corsi.add(corso);
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

		return corsi;
	}
	public boolean isStudenteIscrittoACorso(Studente studente, Corso corso) {
		final String sql = "SELECT * FROM iscrizione where codins=? and matricola=?";
		boolean iscritto = false;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());
			st.setInt(2, studente.getMatricola());

			ResultSet rs = st.executeQuery();

			if (rs.next())
				iscritto = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

		return iscritto;
	}


}
