package br.com.simios.controller;

import br.com.simios.dto.DnaDTO;
import br.com.simios.service.SimiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SimiosController {

    @Autowired
    private SimiosService simiosService;

    @PostMapping(value = "/simian")
    public ResponseEntity isSimian(@RequestBody DnaDTO req) {
        try {

            if(simiosService.isSimian(req.getDna()))
                return new ResponseEntity(HttpStatus.OK);

            return new ResponseEntity(HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }
}
