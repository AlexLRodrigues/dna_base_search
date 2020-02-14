package br.com.simios.enumeration;

public enum CodeBaseDna {

	A('A', 1), T('T', 2), C('C', 3), G('G', 4), X(' ', 0);

	private final Character baseDna;

	private final int baseDnaCode;

	private CodeBaseDna(Character baseDna, int baseDnaCode) {
		this.baseDna = baseDna;
		this.baseDnaCode = baseDnaCode;
	}

	public static int getCodeByBaseDna(char base) {
		for (CodeBaseDna e : values()) {
			if (e.baseDna.equals(base))
				return e.getBaseDnaCode();
		}
		return CodeBaseDna.X.getBaseDnaCode();
	}

	public Character getBaseDna() {
		return baseDna;
	}

	public int getBaseDnaCode() {
		return baseDnaCode;
	}

}
