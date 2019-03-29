package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		//punto1
		
		StringBuilder sb = new StringBuilder();
		for (Corso corso : model.getTuttiICorsi()) {
			sb.append(String.format("%-8s ", corso.getCodins()));
			sb.append(String.format("%-2s ", corso.getCrediti()));
			sb.append(String.format("%-50s ", corso.getNome()));
			sb.append(String.format("%-4s ", corso.getPd()));
			sb.append("\n");
		}
		System.out.println(sb.toString());
		// Punto 2
				Studente studente = model.getStudente(161245);
				System.out.println("Nome della matricola selezionata: "+studente.getNome()+ "\n");
		//Punto 3	
		sb = new StringBuilder();
		for (Studente s : model.studentiIscrittiAlCorso(new Corso("02AQJPG"))) {
				sb.append(String.format("%-10s ", s.getMatricola()));
				sb.append(String.format("%-20s ", s.getCognome()));
				sb.append(String.format("%-20s ", s.getNome()));
				sb.append(String.format("%-10s ", s.getCds()));
		sb.append("\n");
}
		System.out.println(sb.toString());
		}
	
	
	
	
}
