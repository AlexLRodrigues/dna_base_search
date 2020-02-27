package br.com.simios.service.impl;

import br.com.simios.exceptions.ExceptionDefault;
import br.com.simios.service.SimiosService;

import java.util.regex.Pattern;

public class SimiosServiceImpl implements SimiosService {

	@Override
	public boolean isSimian(String[] dna) throws Exception {
		validatesDNA(dna);
		final char[][] dnaTable = buildTable(dna);
		//search horizontal
		return false;
	}

	private char[][] buildTable(String[] dna) {
		char[][] table = new char[dna.length][dna.length];

		for (int i = 0; i < dna.length; i++) {
			char[] letters = dna[i].toCharArray();
			for (int j = 0; j < letters.length; j++) {
				table[i][j] = letters[j];
			}
		}

		return table;
	}

	private void validatesDNA(String[] dna) throws Exception {
		validatesSizeDNA(dna);
		validatesLettersDNA(dna);
	}

	private void validatesLettersDNA(String[] dna) throws Exception {
		for (String line : dna) {
			if (!Pattern.matches(".*[ACTG]",line))
				throw new ExceptionDefault();
		}
	}

	private void validatesSizeDNA(String[] dna) throws Exception {
		if (dna.length < 4) throw new Exception();

		for (String line : dna) {
			if (line.length() != dna.length)
				throw new ExceptionDefault();
		}
	}

}
