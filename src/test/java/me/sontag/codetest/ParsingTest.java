package me.sontag.codetest;

import me.sontag.codetest.logic.FileParser;
import me.sontag.codetest.model.Mortgage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 *  Tests related to the parsing of lines to mortgages
 */
@SpringBootTest
public class ParsingTest {
    private static final double DELTA = 1e-12;

    /**
     *  Test for line parsing
     */
    @Test
    void lineParseTest() {
        FileParser parser = new FileParser();
        String line = "Juha,1000,5,2";

        List<Mortgage> mortgages = parser.parseLine(line);
        assertEquals(1, mortgages.size());
        assertMortgageCorrect(mortgages.get(0), "Juha", 0.05, 1000.0, 24, 72.47090075268697);

        line = "\"Clarencé,Andersson\",2000,6,4";
        mortgages = parser.parseLine(line);
        assertEquals(2, mortgages.size());
        assertMortgageCorrect(mortgages.get(0), "Clarencé", 0.06, 2000.0, 48, 127.79530985515127);
        assertMortgageCorrect(mortgages.get(1), "Andersson", 0.06, 2000.0, 48, 127.79530985515127);
    }

    /**
     *  Utility method for assertion of a mortgage
     *  @param m mortgage
     *  @param name customer name
     *  @param interest interest in decimal form
     *  @param total total loan in euros
     *  @param payments number of payments/months
     *  @param amount amount to pay per month
     */
    private void assertMortgageCorrect(Mortgage m, String name, double interest, double total, int payments, double amount) {
        assertEquals(name, m.getName());
        assertEquals(interest, m.getMonthlyInterest(), DELTA);
        assertEquals(total, m.getTotalLoan(), DELTA);
        assertEquals(payments, m.getPayments());
        assertEquals(amount, m.getMonthlyPayment(), DELTA);
    }
}
