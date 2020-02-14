package br.com.simios.dto;

import java.io.Serializable;

public class DnaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3399639922321306205L;

	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

}
