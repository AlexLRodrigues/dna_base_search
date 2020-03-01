package br.com.simios.builder;

public class DnaBuilder {

    public String[] getSimian() {
        return new String[] {"ACTG","ACTG","ACTG","ACTG"};
    }

    public String[] getNotSimian() {
        return new String[] {"ACTG","CTGA","ACTG","ACTG"};
    }

    public String[] getInvalidLettersDNA() {
        return new String[] {"XXXX","XXXX","XXXX","XXXX"};
    }

    public String[] getInvalidSizeDNA() {
        return new String[] {"XXX","X","XXXX","XX"};
    }

    public String[] getSimianHorizontal() {
        return new String[] {"ACTGAAAA","ACTGAAAA","ACTGAAAA","ACTGAAAA", "ACTGAAAA", "ACTGAAAA", "ACTGAAAA", "ACTGAAAA"};
    }

    public String[] getSimianVertical() {
        return new String[] {"ACTG","ACTG","ACTG","ACTG"};
    }

    public String[] getSimianDiagonal() {
        return new String[] {"AACTG","CAATG","CTAAG","CTGAA","CTGAA"};
    }

    public String[] getSimianHorizontalAndVertical() {
        return new String[] {"AAAA","ACTG","ACTG","ACTG"};
    }

    public String[] getSimianHorizontalAndDiagonal() {
        return new String[] {"AAAAA","CACTG","CTAAG","CTGAA","CTGAA"};
    }

    public String[] getSimianVerticalAndDiagonal() {
        return new String[] {"ACTGG","AACTG","ATAAG","ATGAA","ATGAA"};
    }
}
