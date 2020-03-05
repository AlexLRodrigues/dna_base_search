package br.com.simios.repository;

import br.com.simios.entities.Dna;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DnaRepository extends CrudRepository<Dna, Long> {

    List<Dna> findAll();

    Dna save(Dna dna);
}
