package com.mercadolivre.teste.simios.util;

import java.util.LinkedList;
import java.util.List;

public class SimiosSequence {

	private List<Integer> codes = new LinkedList<Integer>();

	public void insert(int codeBaseDNA) {

		if (codes.size() != 0 && codes.get(0) != codeBaseDNA && codes.size() < 4) {
			codes.clear();
		}

		if (codes.size() != 4)
			this.codes.add(codeBaseDNA);

	}

	public List<Integer> getCodes() {
		return codes;
	}

}
