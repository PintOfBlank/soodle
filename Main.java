import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

class wordProcessing {


    private static boolean letterInWord(char letter, String word) {

        for (int iteratorLetterToWord = 0; iteratorLetterToWord < word.length(); iteratorLetterToWord++) {
            if (word.charAt(iteratorLetterToWord) == letter) {
                return true;
            }
        }
        return false;

    }

    public static boolean  checkIfWordIsFully(String takenWord) {

        int gAmount = 0;

        for (int gFinder = 0; gFinder < takenWord.length(); gFinder++) {
            if (takenWord.charAt(gFinder) == 'G') {
                gAmount++;
            }
        }
        return gAmount == 6;
    }

    public static String evaluateWord(String word, String wordTarget) {
        StringBuilder returnValue = new StringBuilder();

        for (int wordComparison = 0; wordComparison < word.length(); wordComparison++) { //words should be 5 letters
            if (word.charAt(wordComparison) == wordTarget.charAt(wordComparison)) {
                returnValue.append(word.charAt(wordComparison)).append("G ");
            } else if (letterInWord(word.charAt(wordComparison), wordTarget)) {
                returnValue.append(word.charAt(wordComparison)).append("Y ");
            } else {
                returnValue.append(word.charAt(wordComparison)).append("R ");
            }
        }
        return returnValue.toString();
    }



}

public class Main {
    public static void main(String[] args) {

        String[] words = {
                "apple", "table", "chair", "plant", "stone",
                "grape", "flame", "brick", "crate", "smile",
                "house", "light", "night", "sound", "water",
                "world", "dream", "cloud", "shape", "frame",
                "cover", "river", "piano", "heart", "grass",
                "shade", "flour", "plate", "bread", "drink",
                "field", "sheep", "clock", "frame", "fruit",
                "purse", "paper", "sugar", "peach", "beach",
                "grill", "peace", "pearl", "flint", "plant",
                "round", "sleep", "storm", "flock", "stock",
                "stone", "toast", "float", "gauge", "block",
                "table", "charm", "chart", "track", "crack",
                "stark", "brisk", "crisp", "clash", "flash",
                "grass", "trend", "track", "glass", "bliss",
                "place", "trace", "grasp", "smoke", "share",
                "start", "brave", "spade", "trade", "flame",
                "shark", "snail", "swift", "sharp", "clamp",
                "brick", "trace", "blame", "grape", "spark",
                "crown", "slate", "grind", "quill", "flair",
                "frame", "shock", "snack", "chess", "flint",
                "shard", "whale", "brisk", "cling", "block",
                "stack", "smile", "climb", "crash", "sweep",
                "brush", "pride", "flute", "prism", "plush",
                "bride", "flock", "flair", "price", "wrist",
                "frame", "chart", "grill", "grind", "flood",
                "phase", "smack", "quack", "track", "shove",
                "brink", "shaft", "blend", "flank", "probe",
                "trend", "gauge", "smart", "trace", "prune",
                "stone", "crane", "frost", "stage", "shade",
                "beach", "smile", "proud", "charm", "space",
                "cloud", "share", "plume", "flame", "spare",
                "trail", "shock", "flick", "brave", "tread",
                "grasp", "fleet", "crisp", "track", "cloak",
                "flint", "spike", "block", "smack", "shake",
                "sharp", "stark", "brisk", "grill", "clash"
        };

        while (true) {
            System.out.println(
                    """
                                 _______.  ______     ______    _______   __       _______\s
                                /       | /  __  \\   /  __  \\  |       \\ |  |     |   ____|
                               |   (----`|  |  |  | |  |  |  | |  .--.  ||  |     |  |__  \s
                                \\   \\    |  |  |  | |  |  |  | |  |  |  ||  |     |   __| \s
                            .----)   |   |  `--'  | |  `--'  | |  '--'  ||  `----.|  |____\s
                            |_______/     \\______/   \\______/  |_______/ |_______||_______|
                            a wordle pingspoofer
                            """

            );

            boolean wordFound = false;
            boolean userChoiceValid = false;
            Scanner userChoiceObjectRec = new Scanner(System.in);
            System.out.println("1. Play!\n2. Quit!");

            String userChoice = userChoiceObjectRec.nextLine();

            while (!userChoiceValid) {
                if (Objects.equals(userChoice, "1") ||Objects.equals(userChoice, "2")) {
                    userChoiceValid = true;
                } else {
                    System.out.println("Invalid Choice!");
                    userChoice = userChoiceObjectRec.nextLine();
                }
            }

            if (Objects.equals(userChoice, "2")) {
                System.out.println("Thanks For Playing!");
                break;
            }

            Random randomWordFromListObject = new Random();
            String wordChosen = words[randomWordFromListObject.nextInt(words.length)];

            Scanner takenWordScannerObject = new Scanner(System.in);

            System.out.println("Guess The Word");

            String takenWord = takenWordScannerObject.nextLine();

            while (takenWord.length() != 5) {
                System.out.println("Invalid Length!");
                takenWord = takenWordScannerObject.nextLine();
            }

            for (int eachTurn = 0; eachTurn < 6; eachTurn++) {

                if (Objects.equals(takenWord, wordChosen)) {
                    System.out.println("Word Found! " + wordChosen);
                    break;
                }

                System.out.println(wordProcessing.evaluateWord(takenWord, wordChosen));
                takenWord = takenWordScannerObject.nextLine();

            }

            if (!wordFound) {
                System.out.println("Word Not Found!");
            }
        }
    }
}