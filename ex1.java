public class ex1 {
    public static void main(String[] args) {
        String n = "aabaaac";
        String m = "ac";

        int teste = ex(n, m);
        System.out.println(teste);

    }

    public static int ex(String n, String m) {
        for (int i = 0; i <= n.length() - m.length(); i++) {
            int j;
            for (j = 0; j < m.length(); j++) {
                if (n.charAt(i + j) != m.charAt(j)) {
                    break;
                }
            }
            if (j == m.length()) {
                return i;
            }
        }
        return -1;
    }

}
