package assignments.assignment08;

public class FractionMain {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(1, 4);

        System.out.println(fraction); // prints 1/4
        System.out.println(fraction.equals(new Fraction(1,4))); // true
        System.out.println(fraction.equals(new Fraction(1,5))); // false
        System.out.println(fraction.getNum()); // 1
        System.out.println(fraction.getDenom()); // 4


        fraction.setNum(2);
        System.out.println(fraction); // 1/2

        fraction.setDenom(6);
        System.out.println(fraction); // 1/6

        fraction.setDenom(3);
        fraction.setNum(2);
        fraction.setDenom(4);
        System.out.println(fraction); // 1/2

        System.out.println((new Fraction(3,4)).add(new Fraction(1,4))); // 1/1
    }
}
