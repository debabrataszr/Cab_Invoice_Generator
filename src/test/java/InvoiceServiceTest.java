import org.example.InvoiceGenerator;
import org.example.InvoiceSummary;
import org.example.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedinvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedinvoiceSummary, summary);
    }

    @Test
    public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
        String userID = "Debabrata_Priyadarshi_Sahoo";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        invoiceGenerator.addRides(userID, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userID);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}