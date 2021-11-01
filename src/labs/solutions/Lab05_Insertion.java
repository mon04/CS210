package labs.solutions;

import java.util.Scanner;

public class Lab05_Insertion {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); scan.nextLine();
        String[] words = new String[n];
        for(int i=0; i<n; i++) {
            words[i] = scan.nextLine();
        }

        insertionSort(words);

        for(String w: words) {
            System.out.println(w);
        }
    }

    public static void insertionSort(String[] words) {

        int[] scores = new int[words.length];
        for(int i = 0; i < scores.length; i++) {
            scores[i] = scrabbleScore(words[i]);
        }

        for(int i=1; i<words.length; i++) {

            String temp = words[i];
            int tempScore = scores[i];

            int j = i;
            while(j>0 && (scores[j-1]>tempScore || (scores[j-1]==tempScore && words[j-1].compareTo(temp)>=0))) {
                words[j] = words[j-1];
                scores[j] = scores[j-1];
                j--;
            }

            words[j] = temp;
            scores[j] = tempScore;
        }

    }

    public static int scrabbleScore(String word) {
        String w = word.toUpperCase();
        int score = 0;
        for(int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            //System.out.printf("%s: ",c);
            if(c >= 65 && c <= 90) {
                switch(c) {
                    case 'Q': case 'Z':
                        score += 10;
                        break;
                    case 'J': case 'X':
                        score += 8;
                        break;
                    case 'K':
                        score += 5;
                        break;
                    case 'F': case 'H': case 'V': case 'W': case 'Y':
                        score += 4;
                        break;
                    case 'B': case 'C': case 'M': case 'P':
                        score += 3;
                        break;
                    case 'D': case 'G':
                        score += 2;
                        break;
                    default: score++;
                }
            }
            //System.out.println(score);
        }
        return score;
    }
}
