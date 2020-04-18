/*
 * Tyler Kerns
 */

package basicOOP;

public class TestOOP {
    public static void main(String[] args) {
        A a1 = new A("Test A", 12);
        B b1 = new B("Test B", 15);
        C c1 = new C("Going to A", 12, "Going to C", 36);

        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);
    }
}
