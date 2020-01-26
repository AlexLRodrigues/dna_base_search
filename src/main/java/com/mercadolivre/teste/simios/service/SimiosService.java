package com.mercadolivre.teste.simios.service;

import org.springframework.stereotype.Service;

import com.mercadolivre.teste.simios.dto.DnaDTO;
import com.mercadolivre.teste.simios.enumeration.CodeBaseDna;
import com.mercadolivre.teste.simios.util.SimiosSequence;

@Service
public class SimiosService {

	public boolean isSimian(DnaDTO dnaDTO) throws Exception {
		
		boolean vertical = false;
		
		boolean horizontal = false;
		
		boolean diagonalLeftToRight = false;
		
		boolean diagonalRightToLeft = false;

		isParametersValid(dnaDTO);

		int[][] dnaTable = buildTable(dnaDTO);

		SimiosSequence sequence = new SimiosSequence();

		horizontal = horizontalSearch(horizontal, dnaTable, sequence);

		vertical = verticalSearch(vertical, dnaTable, sequence);

		diagonalLeftToRight = diagonalLeftToRightSearch(diagonalLeftToRight, dnaTable, sequence);

		diagonalRightToLeft = diagonalRightToLeftSearch(diagonalRightToLeft, dnaTable, sequence);

		return vertical && horizontal && (diagonalLeftToRight || diagonalRightToLeft) ? true : false;
	}

	private boolean diagonalRightToLeftSearch(boolean diagonalRightToLeft, int[][] dnaTable, SimiosSequence sequence) {
		for (int k = dnaTable[0].length - 1; k >= 0; k--) {
			int i = k;
			int j = 0;
			while (i <= dnaTable[0].length - 1) {
				sequence.insert(dnaTable[i][j]);
				i = i+1;
				j = j+1;
			}

			if (sequence.getCodes().size() >= 3) {
				diagonalRightToLeft = true;
				sequence.getCodes().clear();
				break;
			}

			sequence.getCodes().clear();
		}

		//Diagonal left to right pt 2
		for (int k = 1; k <= dnaTable[0].length - 1; k++) {
			int i = 0;
			int j = k;
			while (j < dnaTable[0].length) {
				sequence.insert(dnaTable[i][j]);
				i = i+1;
				j = j+1;
			}

			if (sequence.getCodes().size() >= 3) {
				diagonalRightToLeft = true;
				sequence.getCodes().clear();
				break;
			}

			sequence.getCodes().clear();
		}
		return diagonalRightToLeft;
	}

	private boolean diagonalLeftToRightSearch(boolean diagonalLeftToRight, int[][] dnaTable, SimiosSequence sequence) {
		for (int k = 0; k <= dnaTable.length - 1; k++) {
			int i = k;
			int j = 0;
			while (i >= 0) {
				sequence.insert(dnaTable[i][j]);
				i = i-1;
				j = j+1;
			}

			if (sequence.getCodes().size() >= 3) {
				diagonalLeftToRight = true;
				sequence.getCodes().clear();
				break;
			}

			sequence.getCodes().clear();
		}

		//Diagonal left to right pt 2
		for (int k = 1; k <= dnaTable[0].length - 1; k++) {
			int i = dnaTable.length - 1;
			int j = k;
			while (j <= dnaTable[0].length - 1) {
				sequence.insert(dnaTable[i][j]);
				i = i-1;
				j = j+1;
			}

			if (sequence.getCodes().size() >= 3) {
				diagonalLeftToRight = true;
				sequence.getCodes().clear();
				break;
			}

			sequence.getCodes().clear();
		}
		return diagonalLeftToRight;
	}

	private boolean verticalSearch(boolean vertical, int[][] dnaTable, SimiosSequence sequence) {
		for (int i = 0; i < dnaTable.length; i++) {
			for (int j = 0; j < dnaTable[i].length; j++) {
				sequence.insert(dnaTable[i][j]);
			}

			if (sequence.getCodes().size() >= 3) {
				vertical = true;
				sequence.getCodes().clear();
				break;
			}

			sequence.getCodes().clear();
		}
		return vertical;
	}

	private boolean horizontalSearch(boolean horizontal, int[][] dnaTable, SimiosSequence sequence) {
		for (int i = 0; i < dnaTable.length; i++) {
			for (int j = 0; j < dnaTable[i].length; j++) {
				sequence.insert(dnaTable[i][j]);
			}

			if (sequence.getCodes().size() >= 3) {
				horizontal = true;
				sequence.getCodes().clear();
				break;
			}

			sequence.getCodes().clear();
		}
		return horizontal;
	}

	private int[][] buildTable(DnaDTO dnaDTO) throws Exception {
		int[][] dnaTable = new int[dnaDTO.getDna().length][dnaDTO.getDna()[0].length()];

		for (int i = 0; i < dnaDTO.getDna().length; i++) {

			char[] ch = dnaDTO.getDna()[i].toCharArray();

			for (int j = 0; j < ch.length; j++) {
				int codeBaseDNA = CodeBaseDna.getCodeByBaseDna(ch[j]);

				if (codeBaseDNA == 0) {
					throw new Exception("Invalid DNA");
				}
				dnaTable[i][j] = codeBaseDNA;
			}
		}
		return dnaTable;
	}

	private void isParametersValid(DnaDTO dnaDTO) throws Exception {
		if (dnaDTO == null || dnaDTO.getDna().length < 4 || dnaDTO.getDna()[0].length() < 4) {
			throw new Exception("Parameters invalid");
		}
	}

}
