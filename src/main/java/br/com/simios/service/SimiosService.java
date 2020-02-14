package br.com.simios.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import br.com.simios.dto.DnaDTO;
import br.com.simios.enumeration.CodeBaseDna;

@Service
public class SimiosService {

	public boolean isSimian(String[] dna) {
		
		if(validatesDNA(dna)) {
			return true;
		}
	
		return false;
	}
	
	private boolean validatesDNA(String[] dna){
		return validatesSize(dna) && validatesDimensions(dna) && validatesLetters(dna);
	}
	
	private boolean validatesSize(String[] dna) {
		return dna.length >= 4;
	}
	
	private boolean validatesDimensions(String[] dna) {
		return dna.length == dna[0].length();
	}
	
	private boolean validatesLetters(String[] dna) {
		for (String line : dna) {
			if (!Pattern.matches("ˆ[ACTG]?", line)) {
				return false;
			}
		}
		return true;
	}

//	private boolean diagonalRightToLeftSearch(boolean diagonalRightToLeft, int[][] dnaTable, SimiosSequence sequence) {
//		for (int k = dnaTable[0].length - 1; k >= 0; k--) {
//			int i = k;
//			int j = 0;
//			while (i <= dnaTable[0].length - 1) {
//				sequence.insert(dnaTable[i][j]);
//				i = i+1;
//				j = j+1;
//			}
//
//			if (sequence.getCodes().size() >= 3) {
//				diagonalRightToLeft = true;
//				sequence.getCodes().clear();
//				break;
//			}
//
//			sequence.getCodes().clear();
//		}
//
//		//Diagonal left to right pt 2
//		for (int k = 1; k <= dnaTable[0].length - 1; k++) {
//			int i = 0;
//			int j = k;
//			while (j < dnaTable[0].length) {
//				sequence.insert(dnaTable[i][j]);
//				i = i+1;
//				j = j+1;
//			}
//
//			if (sequence.getCodes().size() >= 3) {
//				diagonalRightToLeft = true;
//				sequence.getCodes().clear();
//				break;
//			}
//
//			sequence.getCodes().clear();
//		}
//		return diagonalRightToLeft;
//	}
//
//	private boolean diagonalLeftToRightSearch(boolean diagonalLeftToRight, int[][] dnaTable, SimiosSequence sequence) {
//		for (int k = 0; k <= dnaTable.length - 1; k++) {
//			int i = k;
//			int j = 0;
//			while (i >= 0) {
//				sequence.insert(dnaTable[i][j]);
//				i = i-1;
//				j = j+1;
//			}
//
//			if (sequence.getCodes().size() >= 3) {
//				diagonalLeftToRight = true;
//				sequence.getCodes().clear();
//				break;
//			}
//
//			sequence.getCodes().clear();
//		}
//
//		//Diagonal left to right pt 2
//		for (int k = 1; k <= dnaTable[0].length - 1; k++) {
//			int i = dnaTable.length - 1;
//			int j = k;
//			while (j <= dnaTable[0].length - 1) {
//				sequence.insert(dnaTable[i][j]);
//				i = i-1;
//				j = j+1;
//			}
//
//			if (sequence.getCodes().size() >= 3) {
//				diagonalLeftToRight = true;
//				sequence.getCodes().clear();
//				break;
//			}
//
//			sequence.getCodes().clear();
//		}
//		return diagonalLeftToRight;
//	}
//
//	private boolean verticalSearch(boolean vertical, int[][] dnaTable, SimiosSequence sequence) {
//		for (int i = 0; i < dnaTable.length; i++) {
//			for (int j = 0; j < dnaTable[i].length; j++) {
//				sequence.insert(dnaTable[i][j]);
//			}
//
//			if (sequence.getCodes().size() >= 3) {
//				vertical = true;
//				sequence.getCodes().clear();
//				break;
//			}
//
//			sequence.getCodes().clear();
//		}
//		return vertical;
//	}
//
//	private boolean horizontalSearch(boolean horizontal, int[][] dnaTable, SimiosSequence sequence) {
//		for (int i = 0; i < dnaTable.length; i++) {
//			for (int j = 0; j < dnaTable[i].length; j++) {
//				sequence.insert(dnaTable[i][j]);
//			}
//
//			if (sequence.getCodes().size() >= 3) {
//				horizontal = true;
//				sequence.getCodes().clear();
//				break;
//			}
//
//			sequence.getCodes().clear();
//		}
//		return horizontal;
//	}
//
//	private int[][] buildTable(DnaDTO dnaDTO) throws Exception {
//		int[][] dnaTable = new int[dnaDTO.getDna().length][dnaDTO.getDna()[0].length()];
//
//		for (int i = 0; i < dnaDTO.getDna().length; i++) {
//
//			char[] ch = dnaDTO.getDna()[i].toCharArray();
//
//			for (int j = 0; j < ch.length; j++) {
//				int codeBaseDNA = CodeBaseDna.getCodeByBaseDna(ch[j]);
//
//				if (codeBaseDNA == 0) {
//					throw new Exception("Invalid DNA");
//				}
//				dnaTable[i][j] = codeBaseDNA;
//			}
//		}
//		return dnaTable;
//	}
//
//	private void isParametersValid(DnaDTO dnaDTO) throws Exception {
//		if (dnaDTO == null || dnaDTO.getDna().length < 4 || dnaDTO.getDna()[0].length() < 4) {
//			throw new Exception("Parameters invalid");
//		}
//	}

}
