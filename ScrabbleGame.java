import java.io.*;
import java.util.*;

/*
 * Improvements:
 * Scoring depends on both word length and how many challenge letters are used.
 * Each player may exchange one letter before submitting a word, if they so choose to.
 * The game supports two players who compete for the best word based on score.
 * Game can support multiple rounds (default is 3 but can be changed)
 * Final winner is determined by total score added up from all the rounds.
 */

public class ScrabbleGame {

    private ArrayList<Word> wordList = new ArrayList<>(); // Stores all valid dictionary words
    private Random rand = new Random(); // For generating random letters

    public static void main(String[] args) {
        ScrabbleGame game = new ScrabbleGame();
        game.loadWords("CollinsScrabbleWords_2019.txt"); // Loads dictionary
        game.playGame(); // Starts game
    }

    // :Loads words from file into a sorted ArrayList

    public void loadWords(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    wordList.add(new Word(line));
                }
            }
            Collections.sort(wordList); // sort dictionary for binary search
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // Main game logic with 2 players

    public void playGame () {
        Scanner input = new Scanner(System.in);
        int numRounds = 3; // You can change this to any amount of rounds
        int totalScore1 = 0;
        int totalScore2 = 0;

        // loop over number of rounds
        for (int round = 1; round <= numRounds; round++) {
            System.out.println("\n===== ROUND " + round + " =====");

            // Generates 4 random letters for the round (can be adjusted)

            char[] letters = generateRandomLetters(4);
            System.out.print("Challenge letters: ");
            for (char c : letters) {
                System.out.print(c + " ");
            }
            System.out.println();

            // Exchange for player 1
            System.out.println("\nPlayer 1's Turn:");
            char[] player1Letters = Arrays.copyOf(letters, letters.length);
            player1Letters = exchangeLetter(player1Letters, input);
            System.out.print("Enter your word: ");
            String word1 = input.nextLine().toLowerCase();

            // Exchange for player 2
            System.out.println("\nPlayer 2's Turn:");
            char[] player2Letters = Arrays.copyOf(letters, letters.length);
            player2Letters = exchangeLetter(player2Letters, input);
            System.out.print("Enter your word: ");
            String word2 = input.nextLine().toLowerCase();
        
            // Validate and Score
            int score1 = 0, score2 = 0;

            if (binarySearch(word1)) {
                score1 = calculateScore(word1, player1Letters); // Calculate player1's score
                System.out.println("Player 1 scored: " + score1);
            } else {
                System.out.println("Player 1's word not in dictionary.");
            }

            if (binarySearch(word2)) {
                score2 = calculateScore(word2, player2Letters); // Calculate player2's score
                System.out.println("Player 2 scored: " + score2);
            } else {
                System.out.println("Player 2's word not in dictionary");
            }

            totalScore1 += score1; // Adds score totals from all rounds
            totalScore2 += score2;

            // Announce round winners

            if (score1 > score2) {
                System.out.println("\n Player 1 wins Round " + round + "!");
            } else if (score2 > score1) {
                System.out.println("\n Player 2 wins Round " + round + "!");
            } else {
                System.out.println(" Round " + round + " It's a tie!");
            }
        }

        // Final winner
        System.out.println("\n===== FINAL SCORES =====");
        System.out.println("Player 1 Total Score: " + totalScore1);
        System.out.println("Player 2 Total Score: " + totalScore2);

        if (totalScore1 > totalScore2) {
            System.out.println("Player 1 is the overall winner!");
        } else if (totalScore2 > totalScore1) {
            System.out.println("Player 2 is the overall winner!");
        } else {
            System.out.println("It's a tie overall!");
        }

        input.close();
    }

    // generates random lowercase letters

    private char[] generateRandomLetters(int count) {
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = (char) ('a' + rand.nextInt(26));
        }
        return result;
    }

    // Binary search to check if a word is in the sorted dictionary

    private boolean binarySearch(String target) {
        int low = 0, high = wordList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Word midWord = wordList.get(mid);
            int cmp = midWord.getText().compareTo(target);
            if (cmp == 0) return true;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    // Calculates score

    private int calculateScore(String word, char[] challengeLetters) {
        Set<Character> used = new HashSet<>();
        for (char c : word.toCharArray()) {
            used.add(c);
        }

        int count = 0;
        for (char c : challengeLetters) {
            if (used.contains(c)) {
                count++; // for every challenge letter used in the word, it'll keep count toward the score
            }
        }
        return count + word.length(); // score = number of challenge letters used plus the length of the word
    }

    // Player may exchange one letter; returns the updated char array

    private char[] exchangeLetter(char[] letters, Scanner input) {
        System.out.println("Would you like to exchange on letter? (y/n): ");
        String response = input.nextLine().trim().toLowerCase();

        if (response.equals("y")) {
            System.out.print("Enter the index (1-4) of the letter to exchange: ");
            int index = input.nextInt() - 1;
            input.nextLine(); //consume newLine

            if (index >= 0 && index < letters.length) {
                char newLetter = (char) ('a' + rand.nextInt(26));
                System.out.println("Exchanged '" + letters[index] + newLetter + "'");
                letters[index] = newLetter;
            } else {
                System.out.println("Invalid index. No exchange done.");
            }
        }
        return letters;
    }
}