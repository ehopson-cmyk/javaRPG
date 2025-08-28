/* Online Java Compiler and Editor */
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.HashMap; 

/* -- Game Concepts -- 

Plot:

() Lowercase b must save the kingdom by talking with the king! 

Mechanics:

() Turn-based combat with “attacking” and “defending” turns
() Magic system with mana
() 5 levels (Woods, City, Castle Walls, Dungeon, Throne Room) each ending with a boss
	() Level enemy ideas:
		() General: Spider, Snake, Orc, Goblin, Slime, Kobalt
		() Forest: Bear, Rabid Squirrel, Wild Acorn. Boss: Giant Slime.	
() City: Mugger, Thief, Cop, Kingdom Guard. 
() Castle Walls: Guard, Gargoyle, Knight
() Dungeon:  
*/ 


public class main
{
        //put reusable scripts/timesavers here!
  	static void gameOver (String deathCause, String name) {
  	    System.out.println();
  	     System.out.println();
  	    System.out.println("-- GAME OVER --");
  	    System.out.println("Bleh. " + name + " has died.");
  	    System.out.println(name + " was killed by" + deathCause);
  	    return;
  	}

  	static void newLine(){
  	    System.out.println();
  	}
	
	static int[] findCoordinates(int x, int y) {
		Random randWorker = new Random();
		int a = randWorker.nextInt(x);
		int b = randWorker.nextInt(y);
		int[] coordinates = {a,b};
		System.out.println("Size: " + x + " & " + y);
		System.out.println("Output: " + coordinates[0] + " & " + coordinates[1]);
return coordinates; 	
      }
      
	public static void main(String[] args) {
	    
//setup

    //utils
    Scanner imputCheck = new Scanner(System.in);
    Random rand = new Random();
    HashMap<String,Integer> itemCaller = new HashMap<String,Integer>();
    //variables
    int maxHealth = 30; //!base! health
    int playerHealth = 30; 
    int playerXP = 0;
    int playerLevel = 1;
    //arrays
    int[] playerStats = {0,0,0,0,0}; //STR, CON, DEX, INT, MGC
    int[] xpNeededForLevelup = {40, 150, 300, 400, 500, 750, 1000};
    int[][] enemyInfo = new int[25][4]; //Rows for X, Y, Type (Weak, Strong, Etc) and Status (Alive, Dead, etc)
    String[][] items = {{"Item Name","There's some description text: THIS IS A TEST", "You used the test item, helping no one!", "t", /* use: just text */ "0" /* no extra value */ }, {"Health Potion", "A middle-ages medical marvel that heals 10 hit points", "You drank the health potion, healing 10 hit points.", "h", "10"}};
    int[] playerInventory = {0, 0, 0, 0, 0, 0}; //tracks how much of the corresponding item the player has
    //other stuff
    String title = """
................................................................   
.                    ##### #    # ######                       . 
.                      #   #    # #                            . 
.                      #   ###### #####                        . 
.                      #   #    # #                            . 
.                      #   #    # #                            .
.                      #   #    # ######                       . 
.                                                              . 
.                                                              . 
.  #      ######  ####  ###### #    # #####      ####  ######  . 
.  #      #      #    # #      ##   # #    #    #    # #       . 
.  #      #####  #      #####  # #  # #    #    #    # #####   . 
.  #      #      #  ### #      #  # # #    #    #    # #       . 
.  #      #      #    # #      #   ## #    #    #    # #       . 
.  ###### ######  ####  ###### #    # #####      ####  #       .
.                                                              .
.                                                              .
.#       ####  #    # ###### #####   ####    ##    ####  ######.
.#      #    # #    # #      #    # #    #  #  #  #      #     .
.#      #    # #    # #####  #    # #      #    #  ####  ##### .
.#      #    # # ## # #      #####  #      ######      # #     .
.#      #    # ##  ## #      #   #  #    # #    # #    # #     .
.######  ####  #    # ###### #    #  ####  #    #  ####  ######.
.                                                              .
.                ### ###              ### ###                  .
.                ### ###    #####     ### ###                  .
.                 #   #     #    #     #   #                   .
.                           #####                              .
.                           #    #                             .
.                           #    #                             .
.                           #####                              .
................................................................  
""";

//set up inventory

for (int i = 0; i < (items.length); i++) {
itemCaller.put(items[i][0],i);
System.out.println("Callname " + items[i][0] + " has been assigned to item " + i);
}

                           
                         
//let's get started!

		System.out.println("Welcome, buddy to:");
	    System.out.println(title);
		System.out.println("Press (1) to start!");
    int playerMove = imputCheck.nextInt();

      System.out.println("Creating Character...");
System.out.println("What shall your character's name be?");
String playerName = imputCheck.nextLine();
while (!imputCheck.hasNextLine()) {
}
playerName = imputCheck.nextLine();
System.out.println("Great! Now let's give attributes to our lonely hero, "+ playerName + ".");
    newLine();
int diceRoll = 0;
newLine();
    for (int i = 0; i < 5; i++) {
System.out.println("Rolling dice...");
diceRoll = rand.nextInt(5) + 1;
System.out.println("The Dice Gods have given you a number of... " + diceRoll + "! Would you like to assign this value to: (1) Strength; (2) Constitution; (3) Dexterity; (4) Intelligence; and (5) Magic. Press the number of your choice.");
int playerChoice = imputCheck.nextInt();
    if (playerStats[playerChoice - 1] == 0) {
        playerStats[playerChoice - 1] = diceRoll; 
    } else {
        System.out.println("You already have a value in that slot! Try again.");
System.out.println("The Dice Gods have given you a number of... " + diceRoll + "! Would you like to assign this value to: (1) Strength; (2) Constitution; (3) Dexterity; (4) Intelligence; and (5) Magic. Press the number of your choice.");
playerChoice = imputCheck.nextInt();
    if (playerStats[playerChoice - 1] == 0) {
        playerStats[playerChoice - 1] = diceRoll;
    } else {
        System.out.println("You already have a value in that slot as well! Mess up one more time and I will yeet your character into the sun.");
        newLine();
System.out.println("The Dice Gods have given you a number of... " + diceRoll + "! Would you like to assign this value to: (1) Strength; (2) Constitution; (3) Dexterity; (4) Intelligence; and (5) Magic. Press the number of your choice.");
playerChoice = imputCheck.nextInt();
    if (playerStats[playerChoice - 1] == 0) {
        playerStats[playerChoice - 1] = diceRoll;
    } else {
        System.out.println("You already have a value in that slot as well! That's it. I said I would do it, so yeah: your character is dead. They have been yeeted into the sun.");
        gameOver(" the raging fire of the Sun.", playerName);
        return;
    }
}

    }

    }
    
    System.out.println("Nice! We're nearly done with setting up your character. But first, let's catch up on your character's stats.");
    newLine();

    //tell HP effects of CON stat
if (playerStats[1] != 1) {
	maxHealth = 28 + (playerStats[1] * 2);
	playerHealth = maxHealth;
		System.out.println("Wowza! Your constitution stat of " + playerStats[1] + " has given you an increased max health of " + maxHealth + "! Nice job.");
		newLine();
}

    System.out.println("Name: " + playerName);
    System.out.println("HP: " + playerHealth + "/" + maxHealth);
    System.out.println("Strength: " + playerStats[0]);
    System.out.println("Constitution: " + playerStats[1]);
    System.out.println("Dexterity " + playerStats[2]);
    System.out.println("Intelligence: " + playerStats[3]);
    System.out.println("Magic: " + playerStats[4]);
    newLine();
    System.out.println("Press (1) to continue.");
    playerMove = imputCheck.nextInt();
    
   		
    //special ability!
    System.out.println("Now it's time to select your character's starting special ability. (ooh!)");
    System.out.println("Your options are:");
    newLine();
    System.out.println("1. Dodge");
    System.out.println("Type - DEFENSIVE");
    System.out.println("Evade an enemy's attack with slightly better odds than normally blocking!");
    System.out.println("Stats that increase effectiveness: DEX");
    System.out.println("Recharge time: 3");
    newLine();
    System.out.println("2. Piercing Jab");
    System.out.println("Type - OFFENSIVE");
    System.out.println("Give yourself a chance to say, \"Oh, that can't be blocked!\"");
    System.out.println("Stats that increase damage: STR");
    System.out.println("Recharge time: 4");
    newLine();
    System.out.println("3. Parry");
    System.out.println("Type - DEFENSIVE");
    System.out.println("Counter an enemy's attack if you can anticipate it.");
    System.out.println("Stats that increase damage: INT");
    System.out.println("Recharge time: 3");
    
int specialAbility = imputCheck.nextInt();

    newLine();
    System.out.println("Great! Now on to the story...");
    newLine();
    System.out.println("In a long, long time ago, in a computer terminal far, far away, the kingdom was in disarray. The king, capital A, had long stopped caring about his subjects. Our lonely hero, " + playerName + ", was determined to change that. After getting in a lot of shenanigans a few java games ago, he decided to find the king and let him know how bad the kingdom had gotten, in order to hopefully change the king's heart. But he lived far away from the capital city, and there was a forest to get through...");


// !! code copied from the maze game !! (Fix/conform later) Done!


/* level one - woods
XXXXXXXXXXXXXXXXXX.XXXXXXXXXXXXXXXXXX
X...................................X
X...........................X.......X
X......................xXxXXX.......X
X........xxXxx......................X
X........x..........X...............X
X........X..........X...............X
X........X..........X....xxxXxX.....X
X...X.........................X.....X
X...X.........................x.....X
X...X..........XXxXXxXXxXX....X.....X
X...x.........................x.....X
X...x...............................X
X...................xXxXx...........X
X......XxX..........X...............X
X........x..........X...............X
X...................x...............X
X...................X...............X
X............X......................X
X............X............Xx........X
X............x............xX........X
X..........XXXXxXxx.................X
X...................................X
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

level two - city
+-------------------------------------------------------------+
|.............................................................|
|  +--+                                                       |
|  |...                                                       |
|  +--+                                                       |
|                                                             |
|                                                             |
|  +---+-----+                                                |
|  |   |     |                                                |
|  +---+-----+                                                |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
|                                                             |
+-------------------------------------------------------------+
*/

String[] maze = {" ", "XXXXXXXXXXXXXXXXXX.XXXXXXXXXXXXXXXXXX", "X...................................X","X...........................X.......X","X......................xXxXXX.......X","X........xxXxx......................X","X........x..........X...............X","X........X..........X...............X", "X........X..........X....xxxXxX.....X","X...X.........................X.....X","X...X.........................x.....X","X...X..........XXxXXxXXxXX....X.....X","X...x.........................x.....X","X...x...............................X","X...................xXxXx...........X","X......XxX..........X...............X","X........x..........X...............X","X...................x...............X","X...................X...............X","X............X......................X","X............X............Xx........X","X............x............xX........X","X..........XXXXxXxx.................X", "X...................................X","XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"};

 int mazePosition = maze.length - 2;
  int mazeX = (maze[maze.length - 1]).length() - 2;
    

  int enemyCount = 5;
  int enemyCountStrong = 1;
  int moveCount = 0;
  int headHits = 0;
  boolean bossWarned = false;
//map key  
  final char path = '.';
  final char weakEnemy = 'e';
  final char strongEnemy = 'E';
//cardinal directions 
   final String north = "n";
   final String south = "s";
   final String east = "e";
   final String west = "w";
//other commands
   final String inventory = "int";
   final String key = "key";
   final String stats = "stats";
//on with the show!

//place enemies/items

//place enemies
    int[] enemyPos = new int[2];
    int enemyRemainingCount = enemyCount;
    for (int i = 0; i < enemyCount;) {
        System.out.println(i);
        enemyPos = findCoordinates((maze[maze.length - 1]).length(), maze.length);
        StringBuilder updatePos = new StringBuilder(maze[enemyPos[1]]);
        if (maze[enemyPos[1]].charAt(enemyPos[0]) == path) {
            i++;
            //place enemy!
            enemyInfo[i][0] = enemyPos[0];
            enemyInfo[i][1] = enemyPos[1];
            //determine enemy type 
            if (rand.nextInt(enemyRemainingCount) == (enemyCountStrong - 1)) {
                enemyInfo[i][2] = 1; //strong
                enemyCountStrong--;
                updatePos.setCharAt(enemyPos[0], 'E');
            } else {
                enemyInfo[i][2] = 2;
                updatePos.setCharAt(enemyPos[0], 'e');
            }
            enemyRemainingCount--;
            enemyInfo[i][3] = 1; //alive!
            maze[enemyPos[1]] = updatePos.toString();
        } else {
            //don’t update counter
            //enemyInfo[i][3] = -1; //aborted
        }
    } 


  while (mazePosition != 1) {
  //create a "player info" array with stats, HP, etc for loading into battles
    int[] playerInfo = {playerStats[0], playerStats[1], playerStats[2], playerStats[3], playerStats[4], playerHealth};  
  // update position
    StringBuilder updatePos = new StringBuilder(maze[mazePosition]);
  updatePos.setCharAt(mazeX, 'b');
  maze[mazePosition] = updatePos.toString();
  //print screen
   System.out.println(maze[mazePosition - 1]);
   System.out.println(maze[mazePosition]);
  System.out.println(maze[mazePosition + 1]);
  System.out.println("Lvl " + playerLevel + " " + playerName + " - HP " + playerHealth + "/" + maxHealth);
  //ask for move
 String playerAction = imputCheck.nextLine();
 //wait 'till the player types (old bug from E.T.H.)
 final String blank = "";
 while (playerAction.equals(blank)) {
 playerAction = imputCheck.nextLine();
 }
 //check move
if (playerAction.equals(north)) {
  if (maze[mazePosition - 1].charAt(mazeX) == path) {
        updatePos.setCharAt(mazeX, '.');
  maze[mazePosition] = updatePos.toString();
    mazePosition = mazePosition - 1;
  }
  else {
    System.out.println("Bang! You ram your head into a wall. You should have seen that coming.");
  headHits = headHits + 1;    
  }
}
else if (playerAction.equals(south)) {
  if (maze[mazePosition + 1].charAt(mazeX) == path) {
      updatePos.setCharAt(mazeX, '.');
  maze[mazePosition] = updatePos.toString();
    mazePosition = mazePosition + 1;
  }
  else {
    System.out.println("Bang! You ram your head into a wall. You should have seen that coming.");
    headHits = headHits + 1;
  }
}
else if (playerAction.equals(west)) {
  if (maze[mazePosition].charAt(mazeX - 1) == path) {
        updatePos.setCharAt(mazeX, '.');
  maze[mazePosition] = updatePos.toString();
    mazeX = mazeX - 1;
  } else if (maze[mazePosition].charAt(mazeX - 1) == weakEnemy) {
    //ooh, an enemy
    int[] fightRewards = enemyFight(0, playerInfo, 1);
  }
  else {
    System.out.println("Bang! You ram your head into a wall. You should have seen that coming.");
    headHits = headHits + 1;
  }
}
else if (playerAction.equals(east)) {
  if (maze[mazePosition].charAt(mazeX + 1) == path) {
        updatePos.setCharAt(mazeX, '.');
  maze[mazePosition] = updatePos.toString();
    mazeX = mazeX + 1;
  }
  else {
    System.out.println("Bang! You ram your head into a wall. You should have seen that coming.");
    headHits = headHits + 1;
  }
}
else if (playerAction.equals(stats)) {
    newLine();
    System.out.println("Strength: " + playerStats[0]);
    System.out.println("Constitution: " + playerStats[1]);
    System.out.println("Dexterity " + playerStats[2]);
    System.out.println("Intelligence: " + playerStats[3]);
    System.out.println("Magic: " + playerStats[4]);
    //System.out.println("Experience needed to reach next level (" + (playerLevel + 1) 
    newLine();
} else if (playerAction.equals(key)) {
    newLine();
    System.out.println("-- MAP KEY --"); 
    System.out.println("b = Your player character. Move this little goober around to the exit using n (north), e (east), w (west), and s (south) commands.");
    System.out.println(". = The path. The player character can walk on this and pretty much nothing else.");
    System.out.println("X, x, |, etc. = Barrier. Don't walk into this unless you want a concussion.");
    System.out.println("e = A weak-ish enemy. Walk up to these guys (or let them walk into you) and shake their hand to initiate a fight.");
    System.out.println("E = A strong enemy. They are harder to defeat but will give greater rewards.");
    System.out.println("i = An item. May be something passable like some food or a one-use spell, but don't get your hopes up...");
    System.out.println("I = A significantly cooler item. Make sure to grab these, they make good souvenirs and/or battle tools.");
    //System.out.println("Experience needed to reach next level (" + (playerLevel + 1) 
    newLine();
} else {
    System.out.println("You can't do that. You typed \"" + playerAction + "\". Type n, s, e, or w to move. Type \"help\" for a full list of commands.");
}
moveCount = moveCount + 1;

/* if (timeLimit < 1) {
    System.out.println("Out of time!");
    System.out.println(loseMessage[levelNumber - 1]);
    System.out.println("GAME OVER.");
    return;
} */

    //have enemies move randomly
   /* if (rand.nextInt(10) <= 4) {
        //pick a living enemy
        int movingEnemy = rand.nextInt(enemyCount);
        int randDirection = rand.nextInt(4); 
        if (enemyInfo[movingEnemy][3] == 1) {
            if ((mazeX == ((((enemyInfo[movingEnemy][1]) + 1) ||((enemyInfo[movingEnemy][1]) - 1))) && ((enemyInfo[movingEnemy][0]) == mazePosition)
            //move!
             StringBuilder updatePos = new StringBuilder(maze[enemyInfo[movingEnemy][1]]);
        }
    } */
    

if (mazePosition == 2 && bossWarned == false) {
	bossWarned = true;
	System.out.println("You are (almost) at the end of this level! When you pass this point, you'll have to challenge this level's boss! If there's anything you've missed in this level that might help you defeat the boss, please return to it, as once you pass there's no going back...");
}
 
}
//got out of maze!
//System.out.println("Congrats! " + winMessage[levelNumber - 1]);
System.out.println("It took you " + moveCount + " moves and " + headHits + " concussions.");
    }  
  }

