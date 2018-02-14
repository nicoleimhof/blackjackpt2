import java.text.DecimalFormat;
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        int gameNumber = 1;
        int playerHand = 0;
        int dealerHand = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;
        double percentWins = 0;
        boolean keepPlaying = true;
        boolean isNewGame = true;
        boolean noNewCard = false;

        P1Random rng = new P1Random();
        int playerCard;

        Scanner scnr = new Scanner(System.in);
        int userInput;


        while (keepPlaying) {
            if (isNewGame) {
                playerHand = 0;
                dealerHand = 0;
                System.out.println("START GAME #" + gameNumber);
                gameNumber += 1;
                isNewGame = false;
            }

            if (!noNewCard) {
                playerCard = rng.nextInt(13) + 1;
                System.out.println();
                switch (playerCard) {
                    case 1:
                        System.out.println("Your card is a ACE!");
                        playerHand += 1;
                        System.out.println("Your hand is: " + playerHand);
                        break;
                    case 11:
                        System.out.println("Your card is a JACK!");
                        playerHand += 10;
                        System.out.println("Your hand is: " + playerHand);
                        break;
                    case 12:
                        System.out.println("Your card is a QUEEN!");
                        playerHand += 10;
                        System.out.println("Your hand is: " + playerHand);
                        break;
                    case 13:
                        System.out.println("Your card is a KING!");
                        playerHand += 10;
                        System.out.println("Your hand is: " + playerHand);
                        break;
                    default:
                        System.out.println("Your card is a " + playerCard + "!");
                        playerHand += playerCard;
                        System.out.println("Your hand is: " + playerHand);
                        break;
                }
                System.out.println();
            } else {
                noNewCard = false;
            }
            // comment!
            // comment 2

            if (playerHand > 21) {
                System.out.println("You exceeded 21! You lose.");
                System.out.println();
                dealerWins += 1;
                isNewGame = true;
            } else if (playerHand == 21) {
                System.out.println("BLACKJACK! You win!");
                System.out.println();
                playerWins += 1;
                isNewGame = true;
            } else {
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Choose an option: ");
                userInput = scnr.nextInt();

                switch (userInput) {
                    case 1:
                        break;
                    case 2:
                        dealerHand = rng.nextInt(11) + 16;
                        System.out.println();
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + playerHand);
                        System.out.println();
                        if (dealerHand > 21) {
                            System.out.println("You win!");
                            playerWins += 1;
                        } else if (dealerHand == 21) {
                            System.out.println("Dealer wins!");
                            dealerWins += 1;
                        } else if (dealerHand > playerHand) {
                            System.out.println("Dealer wins!");
                            dealerWins += 1;
                        } else if (dealerHand < playerHand) {
                            System.out.println("You win!");
                            playerWins += 1;
                        } else if (dealerHand == playerHand) {
                            System.out.println("It's a tie! No one wins!");
                            tieGames += 1;
                        }
                        System.out.println();
                        isNewGame = true;
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Number of Player wins: " + playerWins);
                        System.out.println("Number of Dealer wins: " + dealerWins);
                        System.out.println("Number of tie games: " + tieGames);
                        System.out.println("Total # of games played is: " + (playerWins + dealerWins + tieGames));
                        if (playerWins + dealerWins + tieGames > 0) {
                            DecimalFormat df = new DecimalFormat("##0.0%");
                            df.format(percentWins = (double) playerWins / (playerWins + dealerWins + tieGames));
                            System.out.println("Percentage of Player wins: " + df.format(percentWins));
                        } else {
                            System.out.println("Percentage of Player wins: 0.0%");
                        } /* get help from stackoverflow to figure out decimal format https://stackoverflow.com/questions/16583604/formatting-numbers-using-decimalformat */
                        System.out.println();
                        noNewCard = true;
                        break;
                    case 4:
                        keepPlaying = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                        System.out.println();
                        noNewCard = true;
                        break;
                }
            }
        }

    }
}



