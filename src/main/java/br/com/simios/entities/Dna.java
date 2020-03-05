package br.com.simios.entities;

import javax.persistence.*;

@Entity
@Table(name = "dna")
public class Dna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "simian")
    boolean simian;

    public Dna(){
    }

    public Dna(boolean simian){
        this.simian = simian;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSimian() {
        return simian;
    }

    public void setSimian(boolean simian) {
        this.simian = simian;
    }
}
