package ranked_choice_voting;

import java.util.*;
import java.io.*;

public class TallyVotes2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("vote.txt"));
        ArrayList<Ballot> ballots = readFile(input);
        int round = 1;
        boolean done = false;
        while (!done) {
            System.out.println("Round #" + round);
            Collections.sort(ballots);
            done = oneRound(ballots);
            System.out.println("------------------------------");
            round++;
        }
    }

    public static ArrayList<Ballot> readFile(Scanner input) {
        ArrayList<Ballot> result = new ArrayList<>();
        while (input.hasNextLine()) {
            String text = input.nextLine().trim();
            if (!text.isEmpty()) { 
                result.add(new Ballot(text.split("\t")));
            }
        }
        return result;
    }

    public static boolean oneRound(ArrayList<Ballot> ballots) {
        String top = null;
        String bottom = null;
        int topCount = 0;
        int bottomCount = ballots.size() + 1;
        int index = 0;
        while (index < ballots.size()) {
            Ballot currentBallot = ballots.get(index);
            String next = currentBallot.getCandidate();
            int count = processVotes(next, index, ballots);
            if (!currentBallot.isEmpty()) { 
                if (count > topCount) {
                    topCount = count;
                    top = next;
                }
                if (count < bottomCount) {
                    bottomCount = count;
                    bottom = next;
                }
                index += count;
            } else {
                ballots.remove(index); // Eliminar la boleta vacía
            }
        }
        if (topCount == bottomCount) {
            System.out.println("Election has no winner");
            return true;
        } else if (topCount > ballots.size() / 2.0) {
            System.out.println("Winner is " + top);
            return true;
        } else {
            System.out.println("no winner, eliminating " + bottom);
            eliminate(bottom, ballots);
            return false;
        }
    }

    public static int processVotes(String name, int index, ArrayList<Ballot> ballots) {
        int count = 0;
        while (index < ballots.size() && ballots.get(index).getCandidate().equals(name)) {
            index++;
            count++;
        }
        double percent = 100.0 * count / ballots.size();
        System.out.printf("%d votes for %s (%4.1f%%)\n", count, name, percent);
        return count;
    }

    public static void eliminate(String candidate, ArrayList<Ballot> ballots) {
        for (Iterator<Ballot> iterator = ballots.iterator(); iterator.hasNext();) {
            Ballot b = iterator.next();
            b.eliminate(candidate);
            if (b.isEmpty()) {
                iterator.remove(); 
            }
        }
    }
}