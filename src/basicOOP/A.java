package basicOOP;

public class A {
    private String aString;
    private int aInt;

    public A(String aString, int aInt) {
        this.aString = aString;
        this.aInt = aInt;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public int getaInt() {
        return aInt;
    }

    public void setaInt(int aInt) {
        this.aInt = aInt;
    }

    @Override
    public String toString() {
        return "A{" +
                "aString='" + aString + '\'' +
                ", aInt=" + aInt +
                '}';
    }
}
