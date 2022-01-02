package labs.solutions;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = new String[scan.nextInt()]; scan.nextLine();
        String[] hash = new String[input.length];
        for(int i=0; i < input.length; i++) {
            input[i] = scan.nextLine();
            hash[i] = sha256(input[i]);
        }
        scan.close();

        int index1 = -1;
        int maxSim = Integer.MIN_VALUE;
        for(int i=0; i < input.length -1; i++) {
            for(int j=i+1; j < input.length; j++) {
                int sim = similarity(hash[i], hash[j]);
                if(sim > maxSim) {
                    index1 = i;
                    maxSim = sim;
                }
            }
        }
        System.out.println(input[index1]);
    }

    public static int similarity(String a, String b) {
        int i=0;
        int sim=0;
        while(i < a.length() && i < b.length()) {
            if(a.charAt(i) == b.charAt(i)) sim++;
            i++;
        }
        return sim;
    }

    public static String sha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update("CS210+".getBytes(StandardCharsets.UTF_8)); // salt
            byte[] data = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte datum : data) {
                sb.append(Integer.toString((datum & 0xff) +0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch (Exception e) {
            return e.toString();
        }
    }
}
