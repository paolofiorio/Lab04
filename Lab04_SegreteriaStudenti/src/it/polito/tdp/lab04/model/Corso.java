package it.polito.tdp.lab04.model;

public class Corso {

	
	private String codins;
	private String nome;
	private int crediti;
	private int pd;
	public Corso() {
		}
	public Corso(String codins) {
		super();
		this.codins = codins;
	}
	public Corso(String codins, String nome, int crediti, int pd) {
		super();
		this.codins = codins;
		this.nome = nome;
		this.crediti = crediti;
		this.pd = pd;
	}
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCrediti() {
		return crediti;
	}
	
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public int getPd() {
		return pd;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}
	@Override
	public String toString() {
		return nome;
}
	
}
