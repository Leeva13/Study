This Java project consists of two classes: Decoder and Main.

In the Decoder class:

The decodeWord method takes an encoded word as input and determines whether it contains numbers using regular expressions.
If numbers are found, it decodes the word using vowel replacement (1->a, 2->e, etc.).
If no numbers are found, it decodes the word using consonant replacement, shifting each consonant to its previous one in the alphabet.
In the Main class:

It takes input for an encoded message from the user.
Splits the encoded message into individual words.
Uses the Decoder class to decode each word, considering whether it needs vowel or consonant replacement.
Prints the original encoded message and the decoded message word by word.
In summary, the project decodes an encoded message by replacing vowels or consonants based on certain rules and then prints the original and decoded messages.
