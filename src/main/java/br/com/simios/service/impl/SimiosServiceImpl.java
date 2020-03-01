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

		foundCount = searchDiagonal(dnaTable, foundCount);

		return foundCount >= 2;
	}

	private int searchDiagonal(char[][] dnaTable, int foundCount) {

		int length = dnaTable.length;
		int diagonalLines = (length + length) - 1;
		int midPoint = (diagonalLines / 2) + 1;

		int itemsInDiagonal = 0;

		List<Character> listLeftRight = new ArrayList<>();
		List<Character> listRightLeft = new ArrayList<>();

		for (int i = 1; i <= diagonalLines; i++) {

			int rowIndexLeftRight;
			int columnIndexLeftRight;

			int rowIndexRightLeft;
			int columnIndexRightLeft;

			if (i <= midPoint) {
				itemsInDiagonal++;
				for (int j = 0; j < itemsInDiagonal; j++) {
					rowIndexLeftRight = (i - j) - 1;
					columnIndexLeftRight = j;

					foundCount = getFoundCount(dnaTable, foundCount, listLeftRight, rowIndexLeftRight, columnIndexLeftRight);

					rowIndexRightLeft = (length - i) + j;
					columnIndexRightLeft = j;

					foundCount = getFoundCount(dnaTable, foundCount, listRightLeft, rowIndexRightLeft, columnIndexRightLeft);

				}
			} else {
				itemsInDiagonal--;
				for (int j = 0; j < itemsInDiagonal; j++) {
					rowIndexLeftRight = (length - 1) - j;
					columnIndexLeftRight = (i - length) + j;

					foundCount = getFoundCount(dnaTable, foundCount, listLeftRight, rowIndexLeftRight, columnIndexLeftRight);

					rowIndexRightLeft = j;
					columnIndexRightLeft = (i - length) + j;

					foundCount = getFoundCount(dnaTable, foundCount, listRightLeft, rowIndexRightLeft, columnIndexRightLeft);
				}
			}
			listLeftRight.clear();
			listRightLeft.clear();

			if (foundCount >= 2)
				return foundCount;
		}
		return foundCount;
	}

	private int getFoundCount(char[][] dnaTable, int foundCount, List<Character> list, int rowIndex, int columnIndex) {
		if (!list.isEmpty() && !list.get(0).equals(dnaTable[rowIndex][columnIndex]))
			list.clear();

		list.add(dnaTable[rowIndex][columnIndex]);

		if (list.size() >= 4)
			foundCount++;

		return foundCount;
	}

	private int searchVertical(char[][] dnaTable, int foundCount) {
		List<Character> list = new ArrayList<>();

		for (int i = 0; i < dnaTable.length; i++) {
			for (int j = 0; j < dnaTable[i].length; j++) {

				if (list.size() + dnaTable.length - j < 4)
					break;

				foundCount = getFoundCount(dnaTable, foundCount, list, j, i);

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
			System.arraycopy(letters, 0, table[i], 0, letters.length);
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
