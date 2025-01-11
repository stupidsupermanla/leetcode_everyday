package mainTime;

public class Main20250111 {

    public static void main(String[] args) {
        System.out.println(generateKey(1000, 2000, 3000));
    }

    public static int generateKey(int num1, int num2, int num3) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            // 取个位数字
            int n1 = num1%10;
            int n2 = num2%10;
            int n3 = num3%10;
           int n = Math.min(Math.min(n1,n2),n3);
            for (int j = 0; j < i; j++) {
                n=n*10;
            }

            result +=n;
            num1/=10;
            num3/=10;
            num2/=10;

        }
        return result;
    }
}
