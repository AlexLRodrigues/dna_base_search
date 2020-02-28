package br.com.simios.service.impl;

import br.com.simios.builder.DnaBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SimiosServiceImplTest {

    @InjectMocks
    private SimiosServiceImpl simiosServiceImpl;

    private String[] dna;

    private DnaBuilder dnaBuilder = new DnaBuilder();


    @Test(expected=Exception.class)
    public void invalidSize() throws Exception {
        simiosServiceImpl.isSimian(dnaBuilder.getInvalidSizeDNA());
    }

    @Test(expected=Exception.class)
    public void invalidDNALetters() throws Exception {
        simiosServiceImpl.isSimian(dnaBuilder.getInvalidLettersDNA());
    }

    @Test
    public void isSimianHorizontal() throws Exception {
        dna = dnaBuilder.getSimianHorizontal();
        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
    }

    @Test
    public void isSimianVertical() throws Exception {
        dna = dnaBuilder.getSimianVertical();
        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
    }

    @Test
    public void isSimianHorizontalAndVertical() throws Exception {
        dna = dnaBuilder.getSimianHorizontalAndVertical();
        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
    }

//    @Test
//    public void isSimianDiagonal() throws Exception {
//        dna = dnaBuilder.getSimianDiagonal();
//        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
//    }
//
//    @Test
//    public void isSimianVerticalAndDiagonal() throws Exception {
//        dna = dnaBuilder.getSimianVerticalAndDiagonal();
//        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
//    }
//
//    @Test
//    public void isSimianHorizontalAndDiagonal() throws Exception {
//        dna = dnaBuilder.getSimianHorizontalAndDiagonal();
//        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
//    }
//
//    @Test
//    public void isSimian() throws Exception {
//        dna = dnaBuilder.getSimian();
//        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
//    }
//
//    @Test
//    public void notIsSimian() throws Exception {
//        dna = dnaBuilder.getNotSimian();
//        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
//    }

}
