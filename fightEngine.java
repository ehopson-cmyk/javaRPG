
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.HashMap; 

public class fightEngine {
  
      static int[] enemyFight /* output an int array for the fight rewards */ (int enemyType, int[] playerInfo, int currentLevel) {
          //enemy setup
          String[][] weakEnemyList = {{"Test Enemy", "t", "10", "2", /* stats: HP, STR */ "Dun dun dun! A test enemy approaches!", "The test enemy is chilling.", "Text", "50", "0", "The test enemy is preparing something...", "And nothing happened!" /* Special ability stuff: Whether they have one/type, what type of effect (in this case nothing happens), a chance to occur, & prepare + execute texts.*/}};
           String[][] strongEnemyList = {{"Test STRONG Enemy", "T", "20", "3", /* stats: HP, STR */ "Dun dun dun! A strong test enemy approaches!", "The test enemy is looking like they're ready to rumble.", "Attack", "40", "6", "The test enemy is preparing something substanal...", "They detonate a nuclear warhead! Dealing 6 damage!" /* Special ability stuff: Whether they have one/type, what type of effect (in this case an attack), a chance to occur, & prepare + execute texts.*/}};
          //pick enemy type (make better later) 
          int enemyNumber = 0;
          //setup enemy stats
          int enemyHealth;
          String enemyIcon;
          
          if (enemyType == 0) {
                enemyHealth = Integer.parseInt(weakEnemyList[enemyNumber][3]);
                enemyIcon = weakEnemyList[enemyNumber][1];
          } else {
                enemyHealth = Integer.parseInt(strongEnemyList[enemyNumber][3]);
                enemyIcon = strongEnemyList[enemyNumber][1];
            }
          
          int playerHealth = playerInfo[5];
          //get fighting!
          System.out.println(weakEnemyList[enemyNumber][4]);
          
          while ((playerInfo[5] > 1)||(enemyHealth > 1)) {
            //draw screen
            System.out.println("b/..........." + enemyIcon);
            System.out.println("Lvl " + playerLevel + " " + playerName + " - HP " + playerHealth + "/" + maxHealth);

            String playerAction = imputCheck.nextLine();
            //wait 'till the player types (old bug from E.T.H.)
            final String blank = "";
            while (playerAction.equals(blank)) {
                playerAction = imputCheck.nextLine();
                
             }
          }
          
          //fight's over
          
          int[] fightRewards = {0,0};
          
          return fightRewards;
        }
}
