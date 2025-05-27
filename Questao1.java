import java.io.*;
import java.util.*;

class KMPTest {

    static int iterationCount = 0;
    static int instructionCount = 0;

    static void constructLps(String pat, int[] lps) {
        int len = 0;
        lps[0] = 0;
        instructionCount++; 

        int i = 1;
        while (i < pat.length()) {
            iterationCount++;
            instructionCount++; 
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
                instructionCount += 3; 
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                    instructionCount++; 
                } else {
                    lps[i] = 0;
                    i++;
                    instructionCount += 2; 
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();

        constructLps(pat, lps);

        int i = 0, j = 0;
        while (i < n) {
            iterationCount++;
            instructionCount++; 
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                instructionCount += 2;

                if (j == m) {
                    res.add(i - j);
                    j = lps[j - 1];
                    instructionCount += 2; 
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                    instructionCount++; 
                } else {
                    i++;
                    instructionCount++; 
                }
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        File folder = new File("testes");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo de teste encontrado.");
            return;
        }

        for (File file : files) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String txt = br.readLine();
            String pat = br.readLine();
            br.close();

            iterationCount = 0;
            instructionCount = 0;

            ArrayList<Integer> res = search(pat, txt);

            System.out.println("Arquivo: " + file.getName());
            System.out.println("Ocorrências encontradas nas posições: " + res);
            System.out.println("Iterações: " + iterationCount);
            System.out.println("Instruções: " + instructionCount);
            System.out.println("--------------------------------------------------");
        }
    }
}
