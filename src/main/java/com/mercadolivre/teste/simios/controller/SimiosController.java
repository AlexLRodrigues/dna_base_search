package com.mercadolivre.teste.simios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.teste.simios.dto.DnaDTO;
import com.mercadolivre.teste.simios.service.SimiosService;

@RestController
public class SimiosController {

	@Autowired
	private SimiosService simiosService;

	@PostMapping("/simios/")
	public ResponseEntity<String> isSimios(@RequestBody DnaDTO dnaDTO) {
		
		try {
			if (simiosService.isSimian(dnaDTO))
				return new ResponseEntity<String>("is simios ", HttpStatus.OK);
			
			return new ResponseEntity<String>("not is simios ", HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}

}
