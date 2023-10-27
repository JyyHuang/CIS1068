package assignments.assignment08;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator == 0){
            throw new ArithmeticException();
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public int getNum(){
        return numerator;
    }

    public int getDenom(){
        return denominator;
    }

    public void setNum(int numerator){
        int gcd = gcd(numerator, this.denominator);
        this.numerator = numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    public void setDenom(int denominator){
        if (denominator == 0){
            throw new ArithmeticException();
        }
        int gcd = gcd(this.numerator, denominator);
        this.denominator = denominator / gcd;
        this.numerator = this.numerator / gcd;
    }

    public Fraction add(Fraction a){
        int numerator = this.numerator*a.denominator+this.denominator*a.numerator;
        int denominator = this.denominator*a.denominator;
        return new Fraction(numerator, denominator);
    }

    public boolean equals(Fraction a){
        if (this.numerator == a.numerator && this.denominator == a.denominator){
            return true;
        }
        return false;
    }
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    private int gcd(int a, int b){
        if (a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
}
