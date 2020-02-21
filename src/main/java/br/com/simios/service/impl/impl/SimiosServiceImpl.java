package br.com.simios.service.impl.impl;

import br.com.simios.service.impl.SimiosService;

import java.util.regex.Pattern;

public class SimiosServiceImpl implements SimiosService {

	@Override
	public boolean isSimian(String[] dna) throws Exception {
		validatesDNA(dna);
		return false;
	}

	private void validatesDNA(String[] dna) throws Exception {
		validatesSizeDNA(dna);
		validatesLettersDNA(dna);
	}

	private void validatesLettersDNA(String[] dna) throws Exception {
		for (String line : dna) {
			if (!Pattern.matches(".*[ACTG]",line))
				throw new Exception();
		}
	}

	private void validatesSizeDNA(String[] dna) throws Exception {
		if (dna.length < 4) throw new Exception();

		for (String line : dna) {
			if (line.length() != dna.length)
				throw new Exception();
		}
	}

}
