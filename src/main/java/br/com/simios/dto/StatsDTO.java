package br.com.simios.dto;

public class StatsDTO {

    int count_mutant_dna;
    int count_human_dna;
    double ratio;

    public StatsDTO(int countSimian, int countNotSimian, double ratio) {
        this.count_mutant_dna = countSimian;
        this.count_human_dna = countNotSimian;
        this.ratio = ratio;
    }

    public int getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(int count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public int getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(int count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
