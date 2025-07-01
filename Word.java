// Represents a single word in the dictionary
public class Word implements Comparable<Word> {
    private String text;

    //This constructor initialized the word text, converted to lowercase as well
    public Word(String text) {
        this.text = text.toLowerCase();
    }

    // Getter method to access the word text
    public String getText() {
        return text;
    }

    // Enables sorting of Word objects based on order
    
    @Override
    public int compareTo(Word other) {
        return this.text.compareTo(other.text);
    }
}