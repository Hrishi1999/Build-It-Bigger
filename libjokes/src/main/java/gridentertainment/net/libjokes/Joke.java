package gridentertainment.net.libjokes;

import java.util.Random;

public class Joke {

    private static final String Joke[] = {"The first computer dates back to Adam and Eve. It was an Apple with limited memory, " +
            "just one byte. And then everything crashed.",
            "Alcohol is a perfect solvent: It dissolves marriages, families and careers.",
            "When everything's coming your way, you're in the wrong lane.",
            "Whenever I find the key to success, someone changes the lock.",
            "Why did the bee get married? Because he found his honey."
    };

    public String getJoke()
    {
        Random random = new Random();
        return Joke[random.nextInt(Joke.length)];
    }

}
