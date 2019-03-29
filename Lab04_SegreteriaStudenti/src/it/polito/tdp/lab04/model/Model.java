package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	public Model() {
		corsoDao= new CorsoDAO();
		studenteDao= new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi() {
		return corsoDao.getTuttiICorsi();
	}
	
	public Studente getStudente(int matricola) {
		return studenteDao.getStudente(matricola);
	}

	public List<Studente> studentiIscrittiAlCorso(Corso corso) {
		return corsoDao.getStudentiIscrittiAlCorso(corso);
	}

	public List<Corso> cercaCorsiDatoStudente(Studente studente) {
		return studenteDao.getCorsiFromStudente(studente);
		}

	public boolean isStudenteIscrittoACorso(Studente studente, Corso corso) {

		return studenteDao.isStudenteIscrittoACorso(studente,corso);
	}

	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		
		return corsoDao.inscriviStudenteACorso(studente, corso);
	}
}
