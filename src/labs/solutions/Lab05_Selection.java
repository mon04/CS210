package labs.solutions;

import java.util.Scanner;

public class Lab05_Selection {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); scan.nextLine();
        String[] words = new String[n];
        for(int i=0; i<n; i++) {
            words[i] = scan.nextLine();
        }

        selectionSort(words);

        for(String w: words) {
            System.out.println(w);
        }
    }

    public static void selectionSort(String[] words) {
        for(int i=0; i<words.length; i++) {
            int min = i;
            for(int j=i+1; j<words.length; j++) {

                int scoreJ = scrabbleScore(words[j]);
                int scoreMin = scrabbleScore(words[min]);

                if((scoreJ < scoreMin) || (scoreJ == scoreMin && words[j].compareTo(words[min]) < 0)) {
                    min = j;
                }
            }
            swap(i, min, words);
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

    public static void swap(int i, int j, String[] a) {
        if(i != j) {
            String temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
