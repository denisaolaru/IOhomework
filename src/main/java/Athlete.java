import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Athlete implements Comparable<Athlete> {
    int athleteNumber;
    String athleteName;
    String countryCode;
    SkiTimeResult skiTimeResult;
    String firstShootingRange;
    String secondShooting;
    String thirdShootingRange;


    public Athlete () {
    }

    public Athlete ( int athleteNumber , String athleteName , String countryCode , SkiTimeResult skiTimeResult , String firstShootingRange , String secondShooting , String thirdShootingRange ) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShooting = secondShooting;
        this.thirdShootingRange = thirdShootingRange;
    }

    public int getAthleteNumber () {
        return athleteNumber;
    }

    public void setAthleteNumber ( int athleteNumber ) {
        this.athleteNumber = athleteNumber;
    }

    public String getAthleteName () {
        return athleteName;
    }

    public void setAthleteName ( String athleteName ) {
        this.athleteName = athleteName;
    }

    public String getCountryCode () {
        return countryCode;
    }

    public void setCountryCode ( String countryCode ) {
        this.countryCode = countryCode;
    }

    public SkiTimeResult getSkiTimeResult () {
        return skiTimeResult;
    }

    public void setSkiTimeResult ( SkiTimeResult skiTimeResult ) {
        this.skiTimeResult = skiTimeResult;
    }
//    public void String ( SkiTimeResult skiTimeResult ) {
//        this.skiTimeResult = skiTimeResult;
//    }

    public String getFirstShootingRange () {
        return firstShootingRange;
    }

    public void setFirstShootingRange ( String firstShootingRange ) {
        this.firstShootingRange = firstShootingRange;
    }

    public String getSecondShooting () {
        return secondShooting;
    }

    public void setSecondShooting ( String secondShooting ) {
        this.secondShooting = secondShooting;
    }

    public String getThirdShootingRange () {
        return thirdShootingRange;
    }

    public void setThirdShootingRange ( String thirdShootingRange ) {
        this.thirdShootingRange = thirdShootingRange;
    }


    @Override
    public String toString () {
        return "Athlete{" +
                "athleteNumber=" + athleteNumber +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode=" + countryCode +
                ", skiTimeResult=" + skiTimeResult +
                ", firstShootingRange=" + firstShootingRange +
                ", secondShooting=" + secondShooting +
                ", thirdShootingRange=" + thirdShootingRange +
                '}';
    }

    public static List<Athlete> readingFromFile () throws FileNotFoundException {
        List<Athlete> athleteList = new ArrayList<> ( );
        Scanner reader = new Scanner ( new FileReader ( "files/in/biathlonAthlete.csv" ) );
        reader.useDelimiter ( "\\s" );

        while (reader.hasNextLine ( )) {
            String line = reader.nextLine ( ).trim ( );
            String[] words = line.split ( "," );

            int number = Integer.parseInt ( words[0] );
            String name = words[1];
            String code = words[2];
            SkiTimeResult skiTime = new SkiTimeResult ( words[3].substring ( 0 , 2 ) , words[3].substring ( 3 , 5 ) );
            String firstShoot = words[4];
            String secondShoot = words[5];
            String thirdShoot = words[6];
            athleteList.add ( new Athlete ( number , name , code , skiTime , firstShoot , secondShoot , thirdShoot ) );

        }
        reader.close ( );
        return athleteList;

    }

    public static void athletsList ( List<Athlete> list ) throws FileNotFoundException {
        for ( int i = 0; i < list.size ( ); i++ ) {
            System.out.println ( list.get ( i ) );
        }
    }


    public static int calculateTotalShotsForAnAthlete ( List<Athlete> list , int athleteNr ) {
        String xoCalculation = list.get ( athleteNr ).getFirstShootingRange ( ) + list.get ( athleteNr ).getSecondShooting ( ) + list.get ( athleteNr ).getThirdShootingRange ( );
        char xoArray[] = xoCalculation.toCharArray ( );
        int count = 0;
        for ( int i = 0; i < xoArray.length; i++ ) {
            if ( xoArray[i] == 'o' ) {
                count = count + 10;
            }
        }
        return count;

    }

    public static int transformTimeInSeconds ( List<Athlete> list , int athleteNumber ) {
        int min = Integer.parseInt ( list.get ( athleteNumber ).getSkiTimeResult ( ).minutes );
        int sec = Integer.parseInt ( list.get ( athleteNumber ).getSkiTimeResult ( ).seconds );
        min = min * 60;
        int penalties = calculateTotalShotsForAnAthlete ( list , athleteNumber );
        int resultInSeconds = min + sec + penalties;
        return resultInSeconds;
    }

    public static SkiTimeResult finalTime ( List<Athlete> list , int athleteNumber ) {
        int resultInSeconds = transformTimeInSeconds ( list , athleteNumber );
        int seconds = resultInSeconds % 60;
        int minutes = (resultInSeconds - seconds) / 60;

        SkiTimeResult time = new SkiTimeResult ( String.valueOf ( minutes ) , String.valueOf ( seconds ) );
        //list.get ( athleteNumber ).setSkiTimeResult ( time );
        list.get ( athleteNumber ).setSkiTimeResult ( time );

        return time;
    }


    @Override
    public int compareTo ( Athlete o ) {

        if ( Integer.parseInt ( this.skiTimeResult.seconds ) + Integer.parseInt ( this.skiTimeResult.minutes ) * 60 < Integer.parseInt ( o.skiTimeResult.seconds ) + Integer.parseInt ( o.skiTimeResult.minutes ) * 60  ) {
            return -1;
        } else if ( Integer.parseInt ( this.skiTimeResult.seconds ) + Integer.parseInt ( this.skiTimeResult.minutes ) * 60 > Integer.parseInt ( o.skiTimeResult.seconds ) + Integer.parseInt ( o.skiTimeResult.minutes ) * 60 ) {


            return 1;
        } else {
            return 0;
        }
    }
}

