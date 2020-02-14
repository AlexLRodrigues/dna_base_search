package br.com.simios.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;


public class SimiosServiceTests {
	
	private SimiosService simiosService;
	
	private String[] dna;
	

	@Test
	private void invalid_size() {
		dna = new String[]{"AAAA"};
		assertFalse(simiosService.isSimian(dna));
	}


}
