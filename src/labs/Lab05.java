package labs;

import java.util.Scanner;

public class Lab05 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); scan.nextLine();
        String[] words = new String[n];
        for(int i=0; i<n; i++) {
            words[i] = scan.nextLine();
        }

        for(int i=0; i<words.length; i++) {
            for(int j=1; j<words.length-i; j++) {
                int s1 = scrabbleScore(words[j-1]);
                int s2 = scrabbleScore(words[j]);
                if(s2<s1) {
                    String swap = words[j-1];
                    words[j-1] = words[j];
                    words[j] = swap;
                }
            }
        }

        for(String word: words) {
            System.out.println(word);
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
