/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealornodeal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class DealOrNoDeal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int caseSelected;
        int numberOfCasesInRound = 5;
        double roundNumber = 1.00;
        //List<Case> board = new ArrayList<>();
        Game game = new Game();

        printWelcome();
        System.out.println("================================================================");
        System.out.println("There are 26 cases with various dollar amounts.");
        System.out.println("Choose one case that you keep until the end of the game (1-26): ");
        caseSelected = sc.nextInt(); //todo - error handling
        System.out.println("You selected case " + caseSelected);

        Case playerCase = game.getCases().get(caseSelected);
        Player player = new Player(playerCase);
        game.cases.remove(playerCase.getId());
        //game.getCases().get(caseSelected - 1);
        //board.remove(caseSelected);
        boolean keepGoing = true;

        while (keepGoing) {

            keepGoing = playRound(numberOfCasesInRound, game, player.getSelectedCase());

            if (roundNumber == 1) {
                //don't decrement numberOfCasesInRound
            } else {
                if (numberOfCasesInRound == 1) {

                } else {
                    numberOfCasesInRound--;
                }
            }
            roundNumber++;
        }
        System.out.println("\nThanks for playing.");
        // you selected this amount
        // your case had this much
    }

    private static boolean playRound(int numberOfCasesInRound, Game game, Case selectedCase) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean offerAccepted = false;

        System.out.println("You will select " + numberOfCasesInRound + " during this round.");

        for (int i = 0; i < numberOfCasesInRound; i++) {
            System.out.println("Choose an unopened case:");
            game.getCases().keySet().forEach(c -> System.out.print(c + " "));
//            System.out.println(game.getCases().toString());
            System.out.println("");
            int caseToOpen = sc.nextInt(); //todo - limit the list of what's available
            System.out.println("Case " + caseToOpen + " has a value of $"
                    + game.getCases().get(caseToOpen).getValue().getCashValue()); //todo - format like a dollar amount
            game.getCases().get(caseToOpen).setOpen(true);
            game.getCases().remove(caseToOpen);
        }
        if (game.getCases().size() == 1) {
            System.out.print("There are only two cases left: " + "your case (" + selectedCase.getId() + ")" + " and ");
            game.getCases().keySet().forEach(c -> System.out.println(c));

//            System.out.println("The values of the final two cases are: " + selectedCase.getValue().getCashValue() +
//                    " and " + game.getCases());
            System.out.println("Choose 1 to select your case or 2 to open the last case");
            int lastChoice = sc.nextInt();
            if (lastChoice == 1) {
                System.out.println("You chose to open your case and won $" + selectedCase.getValue().getCashValue());
                System.out.print("The case you didn't open contained $");
                game.getCases().values().forEach(c -> System.out.print(c.getValue().getCashValue()));
                return false;
            } else {
                System.out.print("You swapped cases and won $");
                game.getCases().values().forEach(c -> System.out.println(c.getValue().getCashValue()));
                System.out.println("The case you didn't open contained $" + selectedCase.getValue().getCashValue());
                return false;
            }
        }
        if (makeOffer(game, selectedCase)) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean makeOffer(Game game, Case selectedCase) throws Exception {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        //@todo insert algorithm
        BigDecimal offer = new BigDecimal(0);
        System.out.println("The banker will make an offer, if you accept, the game will end.");
        System.out.println("The banker is willing to offer you $"
                + game.makeOffer().setScale(2, RoundingMode.HALF_UP)
                + ", do you accept (y/n)?");
        answer = sc.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
            System.out.println("You have accepted the offer of $"
                    + game.makeOffer().setScale(2, RoundingMode.HALF_UP));
            System.out.println("The case you selected at the beginning contained $" + selectedCase.getValue().getCashValue());
            return false;
        } else {
            return true;
        }
    }

    public static void printWelcome(){
        System.out.println(" _______                       __                           \n" +
"|       \\                     |  \\                          \n" +
"| $$$$$$$\\  ______    ______  | $$                          \n" +
"| $$  | $$ /      \\  |      \\ | $$                          \n" +
"| $$  | $$|  $$$$$$\\  \\$$$$$$\\| $$                          \n" +
"| $$  | $$| $$    $$ /      $$| $$                          \n" +
"| $$__/ $$| $$$$$$$$|  $$$$$$$| $$                          \n" +
"| $$    $$ \\$$     \\ \\$$    $$| $$                          \n" +
" \\$$$$$$$   \\$$$$$$$  \\$$$$$$$ \\$$                          \n" +
"  ______    ______                                          \n" +
" /      \\  /      \\                                         \n" +
"|  $$$$$$\\|  $$$$$$\\                                        \n" +
"| $$  | $$| $$   \\$$                                        \n" +
"| $$__/ $$| $$                                              \n" +
" \\$$    $$| $$                                              \n" +
"  \\$$$$$$  \\$$                                              \n" +
" __    __                  _______                       __ \n" +
"|  \\  |  \\                |       \\                     |  \\\n" +
"| $$\\ | $$  ______        | $$$$$$$\\  ______    ______  | $$\n" +
"| $$$\\| $$ /      \\       | $$  | $$ /      \\  |      \\ | $$\n" +
"| $$$$\\ $$|  $$$$$$\\      | $$  | $$|  $$$$$$\\  \\$$$$$$\\| $$\n" +
"| $$\\$$ $$| $$  | $$      | $$  | $$| $$    $$ /      $$| $$\n" +
"| $$ \\$$$$| $$__/ $$      | $$__/ $$| $$$$$$$$|  $$$$$$$| $$\n" +
"| $$  \\$$$ \\$$    $$      | $$    $$ \\$$     \\ \\$$    $$| $$\n" +
" \\$$   \\$$  \\$$$$$$        \\$$$$$$$   \\$$$$$$$  \\$$$$$$$ \\$$");
    }
}
