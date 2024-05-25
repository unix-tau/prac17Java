import java.util.List;
import java.time.Year;
import java.util.Comparator;

// Enum to represent genres
 enum Genre { POP, JAZZ, OTHER }

// A record class that represents a CD
public record CD(String artist, String title, int noOfTracks, Year year, Genre genre) implements Comparable<CD> {

    // Additional methods to check the genre of the CD
    public boolean isPop() { return this.genre == Genre.POP; }
    public boolean isJazz() { return this.genre == Genre.JAZZ; }
    public boolean isOther() { return this.genre == Genre.OTHER; }

    // Provide custom implementation of toString() method
    @Override
    public String toString() {
        return String.format("<%s, \"%s\", %d, %s, %s>",
                this.artist, this.title, this.noOfTracks, this.year, this.genre);
    }

    /** Compare CDs by artist, title, number of tracks, year, and genre. */
    @Override
    public int compareTo(CD other) {
        return Comparator.comparing(CD::artist)
                .thenComparing(CD::title)
                .thenComparingInt(CD::noOfTracks)
                .thenComparing(CD::year)
                .thenComparing((CD cd) -> cd.genre)
                .compare(this, other);
    }

    // Some ready-made CDs
    public static final CD cd0 = new CD("Jaav", "Java Jive", 8, Year.of(2017), Genre.POP);
    public static final CD cd1 = new CD("Jaav", "Java Jam", 6, Year.of(2017), Genre.JAZZ);
    public static final CD cd2 = new CD("Funkies", "Lambda Dancing", 10, Year.of(2018), Genre.POP);
    public static final CD cd3 = new CD("Genericos", "Keep on Erasing", 8, Year.of(2018), Genre.JAZZ);
    public static final CD cd4 = new CD("Genericos", "Hot Generics", 10, Year.of(2018), Genre.JAZZ);

}

// A utility class to demonstrate CD operations
 final class CDAdmin {
    public static void main(String[] args) {
        List<CD> cdList = List.of(CD.cd0, CD.cd1, CD.cd2, CD.cd3, CD.cd4);

        System.out.println("Artist      Title           No.   Year  Genre");
        for (int i = 0; i < cdList.size(); ++i) {
            CD cd = cdList.get(i);
            String cdToString = String.format("%-10s%-16s%-4d%-5s%-5s",
                    cd.artist(), cd.title(), cd.noOfTracks(),
                    cd.year(), cd.genre());
            System.out.printf("cd%d: %s%n", i, cdToString);
        }
        
        String artist = "John Doe";
        String formattedString = String.format("Artist: <%s>", artist);
        System.out.println(formattedString);
        
        byte age = -128;
        long max = 3123456789L;
        
        //double notAtStart = _1000.00;
	//double notAtEnd = 1000.00_;
	//double notByDecimal = 1000_.00;
	double annoyingButLegal = 1_00_0.0_0;
	double reallyUgly = 1__________2;
// DOES NOT COMPILE
// DOES NOT COMPILE
// DOES NOT COMPILE
// Ugly, but compiles
// Also compiles

Double apple = Double.valueOf("200.99");
System.out.println(apple.byteValue());  
System.out.println("age = " + age + " " + max);
    }
}

