# NotchWar Game

## Overview
NotchWar is a card game similar to War, with a unique rule where a card of lower rank wins if its difference from the higher card is exactly one. This program simulates NotchWar, allowing the computer to play against itself.

## Features
- **Automated Gameplay:** Simulates rounds of NotchWar until a winner is determined.
- **War Mechanism:** Implements the special rule for resolving ties.
- **Thing1 & Thing2 Integration:** Uses modified LinkedList structures for card storage.
- **Console Output:** Displays game progress, including card comparisons and results.

## Installation & Run
```sh
git clone https://github.com/akitaki79/Notch-Wars.git
cd notchwar

javac Main.java
java Main
```

## Game Rules
1. Each player receives half of a shuffled deck.
2. In each round:
   - Players reveal their top cards.
   - The higher card wins, unless the difference is exactly one, in which case the lower card wins.
   - The winner takes both cards and places them at the bottom of their deck.
3. If there is a tie, a War occurs:
   - Each player places three cards face down and one face up.
   - The last face-up cards determine the winner, who takes all the cards played in the war.
   - If a player runs out of cards, their last card is played repeatedly until the war is resolved.
4. The game continues until one player has all 52 cards.

## Example Output
```sh
5H versus 7H
Player 0 has 7, Player 1 has 45
7S versus 6C (Notched!)
Player 0 has 6, Player 1 has 46
2H versus 2D
WAR!
5S versus KH
Player 0 has 1, Player 1 has 51
7D versus 6S (Notched!)
Player 0 has 0, Player 1 has 52
The winner is... Player 1!
```

## Classes Implemented
- `Card.java`: Represents individual playing cards.
- `Deck.java`: Generates and shuffles a deck of 52 cards.
- `Thing1 & Thing2 (Renamed)`: Implements LinkedList-based structures for player hands.
- `PlayerQueue.java`: extends LinkedList to manage players' hands as FIFO queues.
- `Main.java`: Drives the game, handling gameplay logic and output.

## Future Improvements
- Implement a GUI for visualizing gameplay.
- Optimize deck shuffling and storage efficiency.
- Add AI strategies for advanced play analysis.

## License
This project is licensed under the MIT License.

## Contributing
Feel free to submit issues and pull requests to improve the game!

