package br.com.simios.service.impl;

import br.com.simios.builder.DnaBuilder;
import br.com.simios.dto.StatsDTO;
import br.com.simios.entities.Dna;
import br.com.simios.repository.DnaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SimiosServiceImplTest {

    @Mock
    private DnaRepository dnaRepository;

    @InjectMocks
    private SimiosServiceImpl simiosServiceImpl;

    private String[] dna;

    private DnaBuilder dnaBuilder = new DnaBuilder();

    @Before
    public void setUp(){
        when(dnaRepository.save(Mockito.any())).thenReturn(new Dna());
    }


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

    @Test
    public void isSimianDiagonal() throws Exception {
        dna = dnaBuilder.getSimianDiagonal();
        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
    }

    @Test
    public void isSimianVerticalAndDiagonal() throws Exception {
        dna = dnaBuilder.getSimianVerticalAndDiagonal();
        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
    }

    @Test
    public void isSimianHorizontalAndDiagonal() throws Exception {
        dna = dnaBuilder.getSimianHorizontalAndDiagonal();
        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
    }

    @Test
    public void isSimian() throws Exception {
        dna = dnaBuilder.getSimian();
        Assert.assertTrue(simiosServiceImpl.isSimian(dna));
    }

    @Test
    public void notIsSimian() throws Exception {
        dna = dnaBuilder.getNotSimian();
        Assert.assertFalse(simiosServiceImpl.isSimian(dna));
    }

    @Test
    public void getStatus() {
        Dna dna1 = new Dna();
        Dna dna2 = new Dna();
        dna1.setSimian(true);
        dna2.setSimian(false);
        when(dnaRepository.findAll()).thenReturn(Arrays.asList(dna1,dna2));
        StatsDTO status = simiosServiceImpl.getStatus();
        Assert.assertEquals("Expected 1",1,status.getCount_human_dna());
        Assert.assertEquals("Expected 1",1,status.getCount_mutant_dna());
        Assert.assertEquals("Expected 1.0",1.0,status.getRatio(),0);
    }

}
