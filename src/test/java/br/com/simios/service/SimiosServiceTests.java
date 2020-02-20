package br.com.simios.service;

import br.com.simios.builder.DnaBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class SimiosServiceTests {

    @InjectMocks
    private SimiosService simiosService;

    private String[] dna;

    private DnaBuilder dnaBuilder = new DnaBuilder();


    @Test
    public void invalidSize() {
        dna = dnaBuilder.getInvalidSizeDNA();
        Assert.assertFalse(simiosService.isSimian(dna));
    }

    @Test
    public void invalidDNALetters() {
        dna = dnaBuilder.getInvalidLettersDNA();
        Assert.assertFalse(simiosService.isSimian(dna));
    }

    @Test
    public void isSimianHorizontal() {
        dna = dnaBuilder.getSimianHorizontal();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

    @Test
    public void isSimianVertical() {
        dna = dnaBuilder.getSimianVertical();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

    @Test
    public void isSimianDiagonal() {
        dna = dnaBuilder.getSimianDiagonal();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

    @Test
    public void isSimianHorizontalAndVertical() {
        dna = dnaBuilder.getSimianHorizontalAndVertical();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

    @Test
    public void isSimianVerticalAndDiagonal() {
        dna = dnaBuilder.getSimianVerticalAndDiagonal();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

    @Test
    public void isSimianHorizontalAndDiagonal() {
        dna = dnaBuilder.getSimianHorizontalAndDiagonal();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

    @Test
    public void isSimian() {
        dna = dnaBuilder.getSimian();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

    @Test
    public void notIsSimian() {
        dna = dnaBuilder.getNotSimian();
        Assert.assertTrue(simiosService.isSimian(dna));
    }

}
