Entities: Our program consists of User, Card, Deck, Spread, Spreads, and ReadingLog entities. 
User class: stores information about the username of the user.
Card class: card objects which have a name, number, and meaning associated with them. They also have boolean values isReversed and isMajor associated with them.
Spread class: spread objects which have a name, number of cards in the spread, and an optional card position meaning value associated with them.
Spreads class: stores an array list of spread objects
Deck class: stores an array list of card objects 
ReadingLog: reading log object stores past readings for a given user
Use Cases: Our program consists of Shuffler, CardPicker, TarotReader, CardInit, and SpreadInit classes.
Shuffler class: creates a clone of the deck and shuffles it a specified amount of times. Returns the shuffled deck object.
CardPicker class: picks an appropriate amount of cards for the selected spread from a shuffled deck and returns the picked cards in an array list.
TarotReader class: gets the meaning for all cards picked and generates a reading for the user.
CardInit class: reads a cardConstants.txt file and loops through every line to initialize card objects, returns the array list of card to deck.
SpreadInit class: reads a spreadConstants.txt file and loops through every line to initialize spread objects. Returns the array list of spread objects to Spreads.
Controllers: Our program consists of ShuffleManager, SpreadManager, ReferenceManager, ReadingLogManager and UserManager.
ShuffleManager class: tells the Shuffler how many times to shuffle the deck and receives the shuffled deck object after Shuffler is done.
SpreadManager: Lets the program know what spread the user has chosen. This information is sent to CardPicker and TarotReader
ReferenceManager: Gets the meaning for a card that the user has chosen and returns it to the user.
ReadingLogManager: allows the user to log, add or discard a reading from their ReadingLog
UserManager: fetches and returns information regarding the user

