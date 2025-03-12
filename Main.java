import java.util.ArrayList;

public class Main {
    public static int fatorial(int n) {
        //casos de erro
        if(n < 0) {
            throw new IllegalArgumentException("ERRO - Número negativo!");
        }
        //caso de parada
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    public static int somatorio(int n) {
        if (n == 0) {
            return 0;
        }
        if(n > 0) {
            return n + somatorio(n - 1);
        }
        else {
            return n + somatorio(n + 1);
        }
        
    }

    public static int fibonacci(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("ERRO - Número negativo!");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int somatorio2n(int n, int m){
        if(n == m) {
            return m;
        }
        if(n < m) {
            return n + somatorio2n(n + 1, m);
        }
        else {
            return n + somatorio2n(n - 1, m);
        }
    }

    public static boolean isPal(String s) {
        if(s == null) {
            throw new IllegalArgumentException("ERRO - String nula!");
        }
        if(s.length() == 0 || s.length() == 1) {
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPal(s.substring(1, s.length() - 1));
        }
        return false;
    }

    //nao tenho ctz desse
    public static String InttoBoolean(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("ERRO - Número negativo!");
        }
        if(n == 0) {
            return "0";
        }
        if(n == 1) {
            return "1";
        }
        return InttoBoolean(n / 2) + n % 2;
    }

    public static int somatorioArray(int[] array, int i) {
        if(array == null) {
            throw new IllegalArgumentException("ERRO - Array nulo!");
        }
        if(i == array.length - 1) {
            return array[i];
        }
        return array[i] + somatorioArray(array, i + 1);
    }

    public static int findBiggest(int[] array, int i) {
        if(array == null) {
            throw new IllegalArgumentException("ERRO - Array nulo!");
        }
        if(i == array.length - 1) {
            return array[i];
        }
        int x = findBiggest(array, i + 1);
        if(array[i] > x) {
            return array[i];
        }
        return x;
    }

    public static boolean findSubString(String s, String sub) {
        //casos de erro
        if(s == null || sub == null) {
            throw new IllegalArgumentException("ERRO - String nula!");
        }
        //caso de erro e parada
        if(s.length() < sub.length()) {
            return false;
        }
        if(s.substring(0, sub.length()).equals(sub)) {
            return true;
        }
        return findSubString(s.substring(1), sub);
    }

    public static int nroDigit(int n){
        if(n == 0) {
            return 0;
        }
        return 1 + nroDigit(n / 10);
    }

    public static ArrayList<String> permutations(String s) {
        ArrayList<String> result = new ArrayList<>();
        permuteHelper(s, "", result);
        return result;
    }

    private static void permuteHelper(String s, String prefix, ArrayList<String> result) {
        if (s.isEmpty()) {
            result.add(prefix);
        } 
        else {
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                String remaining = s.substring(0, i) + s.substring(i + 1);
                permuteHelper(remaining, prefix + currentChar, result);

                //ex: abc -> bac, cba
                //permuteHelper(BC, A, []);
                //permuteHelper(C, BA, []);
                //permuteHelper("", BAC, []); --> adiciona BAC
            }
        }
    }



    public static void main(String[] args) {
        System.out.printf("Fatorial de %d: %d \n", 5, fatorial(5));
        System.out.printf("Somatório de %d: %d \n", 5, somatorio(5));
        System.out.printf("Fibonacci de %d: %d \n", 6, fibonacci(6));
        System.out.printf("Somatório de %d a %d: %d \n", 5, 10, somatorio2n(5, 10));
        System.out.printf("É palíndromo? %b \n", isPal("arara"));
        System.out.printf("Inteiro para boolean: %s \n", InttoBoolean(9));
        int[] array = {1, 2, 9, 4, 7};
        System.out.printf("Somatório do array: %d \n", somatorioArray(array, 0));
        System.out.printf("Maior número do array: %d \n", findBiggest(array, 0));
        System.out.printf("Substring encontrada? %b \n", findSubString("arara", "ara"));
        System.out.printf("Número de dígitos de %d: %d \n", 2345, nroDigit(2345));

        System.out.printf("Permutações de %s: %s \n", "abc", permutations("abc").toString());
    }
}