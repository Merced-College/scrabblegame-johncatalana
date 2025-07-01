[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19874789)
# scrabbleGame

By: John Catalana
7/1/2025

Scrabble Game 

For this assignment use your OOD and ArrayList skills and binary search algorithm to make a simple Scrabble-like game.  This game will give the user 4 random letters.  

* Create a Word object class and a ScrabbleGame class to read in the Word objects into a sorted ArrayList of Words. Read in the words and make the Word objects using the text file called "CollinsScarbbleWords_2019.txt".
* Have your game then choose 4 random characters, and output these to the user.
* Ask the user for a word made form those 4 letters.
* Use binary search to search for that word in the Words ArrayList to see if the word is valid. Output it if it is a valid word.
* Then make at least one improvement to the game.  Write your improvement as comments at the top of your game, and also comment the code that you inserted into the game to make this improvement.  It should be at least 20 lines of quality code. Some examples of an improvement would be:

* Give the user different amounts of points for different size words.
* Allow the user to exchange one of their letters.
* Have 2 players competing for the biggest word.
* Any other improvement.
* Use the given list of words to make your Word objects for the Arraylist and verify that the user typed in a real word.

** Add comments throughout your code, especially where you made changes or additions. If you're working in a group, ensure that your comments clearly indicate the sections you personally contributed to.

Turn in a copy of your code and the reflection response.

TODO Turn in: Turn in your 2 files (The Word and ScrabbleGame java files) to the github classroom assignment.

TODO: Each student must respond to the reflection question individually, providing a unique answer. This part of the assignment should not be done collaboratively. Submit your reflection as a document either on Canvas or in the GitHub repository.

Reflect on your personal problem-solving process. How did your understanding of object-oriented programming (e.g., classes, constructors, and data structures like ArrayLists) evolve as you worked on this task? What challenges did you encounter and how did you go about fixing them? Explain which LLM, your prompts, or internet help and how debugged your code?

Working on this Scrabble-like word game helped with my understanding of object-oriented progamming and reinforced the idea of breaking a larger problem into smaller componenets where I can work at in increments. early in the task, I just focused on designing clear classed like Word.java and ScrabbleGame.java. Understand how to use constructors and the comparable interface helped me see how Java allows objects to be sorted and searched.

At first, I found it challenging to structure the game logic, especially between multiple rounds and the fact that there was two players. When i implemented the feature for letter exchange for each player, it required me to track the orginal random letters and made sure each player had a copy of its own so when they wanted to exchange any letter they wanted, it was from their own copy. It also took some time to understand how to score points based on multiple conditions. I took into account the word length used and the amount of letters they used for their challenge letters - without making the code super complex.

I used OpenAI's ChatGPT to help debug my game logic. The feedback I received helped me rethinking my approach to my design, especially when separating responsibilities for my game.
