public class RefactorReceipt {

    private static double tax(double subtotal, double tax_rate) {
        return subtotal * tax_rate;
    }

    private static double tip(double subtotal, double tip_rate) {
        return subtotal * tip_rate;
    }

    private static String receipt(double subtotal, double tax, double tip, double total) {
        return String.format("Subtotal: %s%nTax: %s%nTip: %s%nTotal: %s", subtotal, tax, tip, total);
    }

    private static double total(double subtotal, double tax, double tip) {
        return subtotal + tip + tax;
    }
    
    public static void main(String[] args) {
        double subtotal = 38 + 40 + 30;
        double tax = tax(subtotal, 0.08);
        double tip = tip(subtotal, 0.2);
        double total = total(subtotal, tax, tip);
        System.out.println(receipt(subtotal, tax, tip, total));
        
    }
}
