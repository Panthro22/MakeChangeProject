# Make change Project!



## **Description**
This make change application will take two inputs from user. U+000A
* **First**: will ask the user the cost of the item(s) they are purchasing.
* **Second**: will ask the user for how much they are going to pay with.
* **Third**: will display a message if too little money was given or exact change was given.
* **Fourth**: If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer. 
* **Fifth**: Create a while loop allowing the cashier to continue allowing customer to purchase items.
* **Sixth**: reduce amount of code in main itself.

### **Methods**:
1. **Main Method** which starts and ends the operations, calls the menu option method.

2. **menuOption()** , Handles getting information from cashier about item price and the amount of cash given by the customer.
then gives response as needed. Otherwise calls calculateChange() method.

3. **topAndBottomBorderBuilder()**, adds a little bit of graphics to allow the cashier to see the output of the start and end by the machine vs their input. May be seperated later on.

4. **leftAndRightBorderBuilder()**, builds borders around the string output to make a box of astrik around the it with the help if topAndBottomBorderBuilder().

5. **PrintSpacerAndAstrik()**, creates space from top border and bottom for content to be more readable.

6. **getStringAnswer()**, prompt user to get String response for continue program or terminate and returns the String.

7. **terminateApplications()**, uses the String return from getStringAnswer to run through a switch to give true or false return.

8. **calculateChange()**, goes through determining how much from largest to smallest unit of U.S. dollars to determine the amount of change needed to go back to the customer. Then call a convertChangeToString() method to put it into a string format and returns the String format.

9. **convertChangeToString()**, takes the input of how many of each currency that needs to be given back with correctly display plural or singular, and puts its into a String format, and returns it.

10. **lastStringCorrection()**, fixes anything else besides the penny ending in a "," when it needs to be a "."

#### **Reason for code**
Project for training.
Code should be used as examples.
Future development of this class most unlikely.
