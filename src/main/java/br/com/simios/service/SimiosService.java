package br.com.simios.service;

import br.com.simios.dto.StatsDTO;

public interface SimiosService {
	
	boolean isSimian(String[] dna) throws Exception;

	StatsDTO getStatus();

}
