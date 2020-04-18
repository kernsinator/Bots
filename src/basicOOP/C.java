/*
 * Tyler Kerns
 */

package basicOOP;

public class C  extends B {
    private String cString;
    private int cInt;

    public C(String toAString, int toAInt, String cString, int cInt) {
        super(toAString, toAInt);
        this.cString = cString;
        this.cInt = cInt;
    }

    public String getcString() {
        return cString;
    }

    public void setcString(String cString) {
        this.cString = cString;
    }

    public int getcInt() {
        return cInt;
    }

    public void setcInt(int cInt) {
        this.cInt = cInt;
    }

    @Override
    public String toString() {
        return "C{" +
                "cString='" + cString + '\'' +
                ", cInt=" + cInt +
                '}';
    }
}

