import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

    @Test
    public void add() {
        Company company = new Company();
        Date date = new Date("12/12/2012");
        Profile profile = new Profile("bob", "cs", date);
        Fulltime management = new Management(profile, 5000.0, 3);
        assertTrue(company.add(management));
    }

    @Test
    public void remove() {
        Company company = new Company();
        Date date = new Date("12/12/2012");
        Profile profile = new Profile("bob", "cs", date);
        Fulltime management = new Management(profile, 5000.0, 3);
        company.add(management);
    }

    @Test
    public void setHours() {
    }
}