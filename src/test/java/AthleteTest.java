import org.junit.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AthleteTest {
    private Athlete athlete;


    @BeforeClass
    public static void beforeClass () {
        System.out.println ( "Before Class" );
    }

    @AfterClass
    public static void afterClass () {
        System.out.println ( "after class" );
    }

    @Before
    public void setup () {
        System.out.println ( "in setup" );
        athlete = new Athlete ( );
    }

    @After
    public void after () {
        System.out.println ( "after" );
    }

    @Test
    public void testCalculateTotalShotsForAnAthlete () throws IOException {
        Athlete athlete=new Athlete (1,"Jimmy Smiles","UK",new SkiTimeResult ( "29","15" ),"xxoox","xooxo","xxxxo" );
        List <Athlete> list=new ArrayList<> (  );
        list.add ( athlete );
        assertEquals(60, Athlete.calculateTotalShotsForAnAthlete ( list,0 ));
    }




}