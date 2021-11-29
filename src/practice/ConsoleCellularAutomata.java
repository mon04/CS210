// This does not work properly - 29/11/2021
package practice;

import java.util.Scanner;

public class ConsoleCellularAutomata {
    public static void main(String[] args) {

        boolean[] rule50  = {false, false, true, true, false, false, true, false};
        boolean[] rule126 = {false, true, true, true, true, true, true, false};

        CA ca = new CA(256, rule126);

        Scanner scan = new Scanner(System.in);
        int n;
        while((n=scan.nextInt()) > -1) {
            boolean[] rule = intToRule(n);
            ca.rule = rule;
            System.out.println("Running rule "+n+":");
            ca.printRuleChart();
            ca.resetToGenZero(256);
            ca.run(50);
        }

    }

    public static boolean[] intToRule(int n) {
        String binary = "";

        while(n > 0) {
            binary = n%2+binary;
            n/=2;
        }

        int pads = 8-binary.length();
        while(pads-- > 0) {
            binary = '0'+binary;
        }

        boolean[] out = new boolean[8];
        for(int i=0; i < 8; i++) {
            out[i] = (binary.charAt(i) == '1');
        }
        return out;
    }
}

class CA {
    public boolean[] currentGen;
    public boolean[] nextGen;
    boolean[] rule;
    public char aliveChar;
    public char deadChar;

    public static boolean[] defaultRule = {false, false, false, true, true, true, true, false}; //Rule 30
    public static char defaultAliveChar = '#';
    public static char defaultDeadChar = '_';

    public CA(int genSize, boolean[] rule) {

        aliveChar  = defaultAliveChar;
        deadChar   = defaultDeadChar;
        nextGen    = new boolean[genSize];
        resetToGenZero(genSize);
        this.rule = rule;
    }

    public CA(int genSize) {
        this(genSize, defaultRule);
    }

    public CA() {
        this(32, defaultRule);
    }


    public void run(int iterations) {
        while(iterations-- > 0) {
            printCurrentGen();
            System.out.println();
            generate();
        }
    }

    public void generate() {
        for(int i=1; i < currentGen.length-1; i++) {
            nextGen[i] = nextState(i);
            //System.out.print(i+" next state: "+nextGen[i]);
        }
        currentGen = nextGen;
    }

    public void printCurrentGen() {
        for(boolean cell: currentGen) {
            System.out.print((cell) ?aliveChar :deadChar);
        }
    }

    public void printRuleChart() {
        String conditions = "111 110 101 100 011 010 001 000";
        for(char c: conditions.toCharArray()) {
            if(c == '1') System.out.print(aliveChar);
            else if(c == '0') System.out.print(deadChar);
            else System.out.print(" ");
        }
        System.out.println();

        System.out.print(" ");
        for(int i = 0; i < 8; i++) {
            System.out.print((rule[i]) ?aliveChar :deadChar);
            System.out.print("   ");
        }
        System.out.println();
    }

    public boolean nextState(int index) {

        boolean middle = currentGen[index];

        boolean left = (index == 0)
                ?currentGen[currentGen.length-1] // wrap-around neighbours
                :currentGen[index-1];

        boolean right = (index == currentGen.length-1)
                ?currentGen[0] // wrap-around neighbours
                :currentGen[index+1];

        if( left &&  middle &&  right) return rule[7];
        if( left &&  middle && !right) return rule[6];
        if( left && !middle &&  right) return rule[5];
        if( left && !middle && !right) return rule[4];
        if(!left &&  middle &&  right) return rule[3];
        if(!left &&  middle && !right) return rule[2];
        if(!left && !middle &&  right) return rule[1];
        if(!left && !middle && !right) return rule[0];

        return false;
    }

    public void resetToGenZero(int size) {
        boolean[] out = new boolean[size];
        for(int i=0; i < size; i++) {
            out[i] = (i == size/2);
        }
        currentGen = out;
        nextGen = new boolean[size];
    }
}
