package br.com.simios.service.impl;

import br.com.simios.exceptions.ExceptionDefault;
import br.com.simios.service.SimiosService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SimiosServiceImpl implements SimiosService {

	@Override
	public boolean isSimian(String[] dna) throws Exception {
		validatesDNA(dna);

		final char[][] dnaTable = buildTable(dna);

		int foundCount  = searchHorizontal(dnaTable);

		if (foundCount >= 2)
			return true;

		foundCount = searchVertical(dnaTable, foundCount);

		if (foundCount >= 2)
			return true;

		return false;
	}

	private int searchVertical(char[][] dnaTable, int foundCount) {
		List<Character> list = new ArrayList<>();

		for (int i = 0; i < dnaTable.length; i++) {
			for (int j = 0; j < dnaTable[i].length; j++) {

				if (list.size() + dnaTable.length - j < 4)
					break;

				if (!list.isEmpty() && !list.get(0).equals(dnaTable[j][i]))
					list.clear();

				list.add(dnaTable[j][i]);

				if (list.size() >= 4)
					foundCount++;

				if (foundCount >= 2)
					return foundCount;
			}
		}
		return foundCount;
	}

	private int searchHorizontal(char[][] dnaTable) {
		int count = 0;
		List<Character> list = new ArrayList<>();

		for (int i = 0; i < dnaTable.length; i++) {
			for (int j = 0; j < dnaTable[i].length; j++) {

				if (list.size() + dnaTable.length - i < 4)
					break;

				if (!list.isEmpty() && !list.get(0).equals(dnaTable[i][j]))
					list.clear();

				list.add(dnaTable[i][j]);

				if (list.size() >= 4) {
					count++;
					list.clear();
				}

				if (count >= 2)
					return count;
			}
		}
		return count;
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
