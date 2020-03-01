package br.com.simios.service.impl;

import br.com.simios.exceptions.ExceptionDefault;
import br.com.simios.service.SimiosService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SimiosServiceImpl implements SimiosService {

    private int sequenceCount = 0;

    @Override
    public boolean isSimian(String[] dna) throws Exception {

        validatesDNA(dna);
        sequenceCount = 0;

        final char[][] dnaTable = buildTable(dna);

        searchHorizontal(dnaTable);

        if (sequenceCount >= 2)
            return true;

        searchVertical(dnaTable);

        if (sequenceCount >= 2)
            return true;

        searchDiagonal(dnaTable);

        return sequenceCount >= 2;
    }

    private void searchDiagonal(char[][] dnaTable) {

        int length = dnaTable.length;
        int diagonalLines = (length + length) - 1;
        int midPoint = (diagonalLines / 2) + 1;

        int itemsInDiagonal = 0;

        List<Character> sequenceLeftRight = new ArrayList<>();
        List<Character> sequenceRightLeft = new ArrayList<>();

        for (int i = 1; i <= diagonalLines; i++) {

            int rowIndexLeftRight;
            int columnIndexLeftRight;

            int rowIndexRightLeft;
            int columnIndexRightLeft;

            if (i <= midPoint) {
                itemsInDiagonal++;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndexLeftRight = (i - j) - 1;
                    columnIndexLeftRight = j;

                    sequenceCount = getCountSequence(dnaTable, sequenceLeftRight, rowIndexLeftRight, columnIndexLeftRight);

                    rowIndexRightLeft = (length - i) + j;
                    columnIndexRightLeft = j;

                    sequenceCount = getCountSequence(dnaTable, sequenceRightLeft, rowIndexRightLeft, columnIndexRightLeft);

                }
            } else {
                itemsInDiagonal--;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndexLeftRight = (length - 1) - j;
                    columnIndexLeftRight = (i - length) + j;

                    sequenceCount = getCountSequence(dnaTable, sequenceLeftRight, rowIndexLeftRight, columnIndexLeftRight);

                    rowIndexRightLeft = j;
                    columnIndexRightLeft = (i - length) + j;

                    sequenceCount = getCountSequence(dnaTable, sequenceRightLeft, rowIndexRightLeft, columnIndexRightLeft);
                }
            }
            sequenceLeftRight.clear();
            sequenceRightLeft.clear();

            if (sequenceCount >= 2)
                return;
        }
    }

    private int getCountSequence(char[][] dnaTable, List<Character> sequence, int rowIndex, int columnIndex) {

        if (!sequence.isEmpty() && !sequence.get(0).equals(dnaTable[rowIndex][columnIndex]))
            sequence.clear();

        sequence.add(dnaTable[rowIndex][columnIndex]);

        if (sequence.size() >= 4) {
            sequenceCount++;
            sequence.clear();
        }

        return sequenceCount;
    }

    private void searchVertical(char[][] dnaTable) {
        List<Character> sequence = new ArrayList<>();

        for (int i = 0; i < dnaTable.length; i++) {
            for (int j = 0; j < dnaTable[i].length; j++) {

                if (sequence.size() + dnaTable.length - j < 4)
                    break;

                sequenceCount = getCountSequence(dnaTable, sequence, j, i);

                if (sequenceCount >= 2)
                    return;
            }
        }
    }

    private void searchHorizontal(char[][] dnaTable) {
        List<Character> sequence = new ArrayList<>();

        for (int i = 0; i < dnaTable.length; i++) {
            for (int j = 0; j < dnaTable[i].length; j++) {

                if (sequence.size() + dnaTable.length - i < 4)
                    break;

                sequenceCount = getCountSequence(dnaTable, sequence, i, j);

                if (sequenceCount >= 2)
                    return;
            }
        }
    }

    private char[][] buildTable(String[] dna) {
        char[][] table = new char[dna.length][dna.length];

        for (int i = 0; i < dna.length; i++) {
            char[] letters = dna[i].toCharArray();
            System.arraycopy(letters, 0, table[i], 0, letters.length);
        }

        return table;
    }

    private void validatesDNA(String[] dna) throws Exception {
        validatesSizeDNA(dna);
        validatesLettersDNA(dna);
    }

    private void validatesLettersDNA(String[] dna) throws Exception {
        for (String line : dna) {
            if (!Pattern.matches(".*[ACTG]", line))
                throw new ExceptionDefault();
        }
    }

    private void validatesSizeDNA(String[] dna) throws Exception {
        if (dna.length < 4) throw new Exception();

        for (String line : dna) {
            if (line.length() != dna.length)
                throw new ExceptionDefault();
        }
    }

}
