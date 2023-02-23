import model.Lyrics;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LyricsTest {

    @Test
    void constructor_Z() {
        assertDoesNotThrow(()->new Lyrics());
    }

    @Test
    void constructor_O() {
        //not relevant since the constructors takes no arguments
    }

    @Test
    void contructor_M() {
        //not relevant since the constructors takes no arguments
    }

    @Test
    void contructor_B() {
        //not relevant since the constructors takes no arguments
    }

    @Test
    void contructor_E() {
        //not relevant since the constructors takes no arguments
    }

    @Test
    void getLyrics_Z() {
        Lyrics lyrics = new Lyrics();
        assertDoesNotThrow(()-> lyrics.getLyrics(""));
    }
    @Test
    void getLyrics_O() {
        Lyrics lyrics = new Lyrics();
        try{
        assertEquals(lyrics.getLyrics("billie jean"),"[Verse 1]\n" +
                "She was more like a beauty queen from a movie scene\n" +
                "I said, \"Don't mind, but what do you mean, I am the one\n" +
                "Who will dance on the floor in the round?\"\n" +
                "She said I am the one\n" +
                "Who will dance on the floor in the round\n" +
                "She told me her name was Billie Jean\n" +
                "As she caused a scene\n" +
                "Then every head turned with eyes that dreamed of bein' the one\n" +
                "Who will dance on the floor in the round\n" +
                "\n" +
                "[Pre-Chorus 1]\n" +
                "People always told me, \"Be careful of what you do\n" +
                "Don't go around breakin' young girls' hearts\" (Hee-hee)\n" +
                "And mother always told me, \"Be careful of who you love\n" +
                "And be careful of what you do (Oh-oh)\n" +
                "'Cause the lie becomes the truth\" (Oh-oh)\n" +
                "Hey-ay\n" +
                "\n" +
                "[Chorus]\n" +
                "Billie Jean is not my lover\n" +
                "She's just a girl who claims that I am the one (Oh, baby)\n" +
                "But the kid is not my son, hoo!\n" +
                "She says I am the one (Oh, baby)\n" +
                "But the kid is not my son (Hee-hee-hee, no-no-no, hee-hee-hee)\n" +
                "Hoo!\n" +
                "\n" +
                "[Verse 2]\n" +
                "For forty days and for forty nights, the law was on her side\n" +
                "But who can stand when she's in demand?\n" +
                "Her schemes and plans\n" +
                "'Cause we danced on the floor in the round, hee!\n" +
                "So take my strong advice, just remember to always think twice\n" +
                "(Don't think twice) Do think twice! (A-hoo!)\n" +
                "She told my baby we'd danced 'til three, then she looked at me\n" +
                "Then showed a photo of a baby cryin', his eyes were like mine (Oh, no)\n" +
                "'Cause we danced on the floor in the round, baby\n" +
                "(Ooh, hee-hee-hee)\n" +
                "\n" +
                "[Pre-Chorus 2]\n" +
                "People always told me, \"Be careful of what you do\n" +
                "And don't go around breakin' young girls' hearts\"\n" +
                "(Don't break no hearts!) (Hee-hee)\n" +
                "But she came and stood right by me\n" +
                "Just the smell of sweet perfume (Ha-oh)\n" +
                "This happened much too soon (Ha-oh, ha-ooh)\n" +
                "She called me to her room (Ha-oh, hoo!)\n" +
                "Hey-ay\n" +
                "\n" +
                "[Chorus]\n" +
                "Billie Jean is not my lover (Hoo!)\n" +
                "She's just a girl who claims that I am the one\n" +
                "But the kid is not my son\n" +
                "No-no-no, no-no-no-no-no-no (Hoo!)\n" +
                "Billie Jean is not my lover\n" +
                "She's just a girl who claims that I am the one (Oh, baby)\n" +
                "But the kid is not my son (Oh, no, no)\n" +
                "She says I am the one (Oh, baby)\n" +
                "But the kid is not my son (No, hee-hee!)\n" +
                "\n" +
                "[Break]\n" +
                "Ah, hee-hee-hee!\n" +
                "Hee! Hoo!\n" +
                "\n" +
                "[Chorus]\n" +
                "She says I am the one, but the kid is not my son\n" +
                "No-no-no, hoo! (Ouw!)\n" +
                "Billie Jean is not my lover\n" +
                "She's just a girl who claims that I am the one\n" +
                "(You know what you did to me, baby)\n" +
                "But the kid is not my son\n" +
                "No-no-no, no-no-no-no (No-no-no, no-no-no)\n" +
                "She says I am the one\n" +
                "But the kid is not my son (No-no-no-no)\n" +
                "\n" +
                "[Outro]\n" +
                "She says I am the one\n" +
                "You know what you did\n" +
                "She says he is my son\n" +
                "Breakin' my heart, babe\n" +
                "She says I am the one\n" +
                "Billie Jean is not my lover\n" +
                "Billie Jean is not my lover\n" +
                "Billie Jean is not my lover (She is just a girl)\n" +
                "Billie Jean is not my lover (She is just a girl)\n" +
                "(Don't call me Billie Jean)\n" +
                "Billie Jean is not my lover (She is just a girl)\n" +
                "(Hoo! She's not at the scene)\n" +
                "Billie Jean is not (Hee! Aaow! Ooh!)\n" +
                "Billie Jean is");
    }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void getLyrics_M() {
        //not relevant
    }

    @Test
    void getLyrics_B() {
        //not relevant
    }

    @Test
    void getLyrics_E() {
        //not relevant
    }
}