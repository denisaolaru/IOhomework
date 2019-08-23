import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main ( String[] args ) throws FileNotFoundException {

        System.out.println ( "The initial list of Athlets is: " );

        List<Athlete> athleteListt = Athlete.readingFromFile ( );
        Athlete.athletsList ( athleteListt );
        System.out.println ( );

        for ( int i = 0; i < athleteListt.size ( ); i++ ) {
            Athlete.finalTime ( athleteListt , i );

        }
        System.out.println ( );
        System.out.println ( "After sorting" );

        Collections.sort ( athleteListt );

        for ( int i = 0; i < athleteListt.size ( ); i++ ) {

            System.out.println ( athleteListt.get ( i ).getAthleteName ( ) + " " + athleteListt.get ( i ).getSkiTimeResult ( ) );
        }


    }


}