package noob_00;
/**
 * 打印二进制
 * */
public class PrintBinaryString {
    public static void main(String[] args) {
        int num = 1111122222;
        print(num);
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    // 除符号位之外 剩余的位取反再+1就是该二进制的值
    // n的相反数为 对n取反+1
}
