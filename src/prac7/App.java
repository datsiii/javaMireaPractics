package prac7;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class App {

    public static void endOfGame(String winner, String message) {}

    public static void useStack(Scanner scanner) {
        String[] nums1 = scanner.nextLine().split(" ");
        String[] nums2 = scanner.nextLine().split(" ");
        scanner.close();

        Stack<Integer> deck1 = new Stack<Integer>();
        Stack<Integer> deck2 = new Stack<Integer>();
        Stack<Integer> extraDeck1 = new Stack<Integer>();
        Stack<Integer> extraDeck2 = new Stack<Integer>();

        for (int i = nums1.length - 1; i >= 0; i--) {
            deck1.push(Integer.valueOf(nums1[i]));
        }
        for (int i = nums2.length - 1; i >= 0; i--) {
            deck2.push(Integer.valueOf(nums2[i]));
        }

        int card1, card2;
        for (int moves = 1; moves <= 106; moves++) {
            card1 = deck1.pop();
            card2 = deck2.pop();
            if (
                    (card1 > card2 || (card1 == 0 && card2 == 9)) &&
                            !(card1 == 9 && card2 == 0)
            ) {
                extraDeck1.push(card1);
                extraDeck1.push(card2);
            } else {
                extraDeck2.push(card2);
                extraDeck2.push(card1);
            }

            System.out.println("Decks: " + deck1 + " . " + deck2);
            System.out.println("Extra: " + extraDeck1 + " . " + extraDeck2);

            if (deck1.size() == 0) {
                if (extraDeck1.size() != 0) {
                    deck1 = Functions.reverse((Stack<Integer>) extraDeck1.clone());
                    extraDeck1.clear();
                } else {
                    System.out.println("second" + " " + String.valueOf(moves));
                    return;
                }
            }

            if (deck2.size() == 0) {
                if (extraDeck2.size() != 0) {
                    deck2 = Functions.reverse((Stack<Integer>) extraDeck2.clone());
                    extraDeck2.clear();
                } else {
                    System.out.println("first" + " " + String.valueOf(moves));
                    return;
                }
            }
        }

        System.out.println("botva");
    }

    public static void useDeque(Scanner scanner, int cardsAmount) {
        Deque<Integer> deck1 = new ArrayDeque<Integer>();
        Deque<Integer> deck2 = new ArrayDeque<Integer>();

        for (int i = 0; i < cardsAmount; i++) {
            deck1.addLast(scanner.nextInt());
        }

        for (int i = 0; i < cardsAmount; i++) {
            deck2.addLast(scanner.nextInt());
        }

        int card1, card2;
        for (int moves = 1; moves <= 106; moves++) {
            card1 = deck1.pop();
            card2 = deck2.pop();
            if (
                    (card1 > card2 || (card1 == 0 && card2 == 9)) &&
                            !(card1 == 9 && card2 == 0)
            ) {
                deck1.addLast(card1);
                deck1.addLast(card2);
            } else {
                deck2.addLast(card2);
                deck2.addLast(card1);
            }

            System.out.println(deck1 + " . " + deck2);

            if (deck1.size() == 0) {
                System.out.println("second" + " " + String.valueOf(moves));
                return;
            }

            if (deck2.size() == 0) {
                System.out.println("first" + " " + String.valueOf(moves));
                return;
            }
        }

        System.out.println("botva");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // useStack(scanner);
        useDeque(scanner, 5);
    }
}
// Test for input
// 1 3 5 9 0
// 2 4 7 8 6
