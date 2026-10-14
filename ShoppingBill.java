public class ShoppingBill {
    public static double calculateElectronicsGST(double a, double b) {
        double sum = a + b;
        return sum + (sum * 0.18);
    }

    public static double calculateFashionGST(double c, double d) {
        double sum = c + d;
        return sum + (sum * 0.13);
    }

    public static double calculateFoodGST(double e) {
        return e + (e * 0.07);
    }

    public static double totalBill(double a, double b, double c, double d, double e) {
        return calculateElectronicsGST(a, b) +
               calculateFashionGST(c, d) +
               calculateFoodGST(e);
    }

    public static double calculateDiscountedBill(double a, double b, double c, double d, double e) {
        double total = totalBill(a, b, c, d, e);
        double discount = total * 0.20;
        return total - discount;
    }

    public static void main(String[] args) {
        double a = 100, b = 100, c = 100, d = 100, e = 100;
        double total = totalBill(a, b, c, d, e);
        double discount = total * 0.20;
        double finalAmount = calculateDiscountedBill(a, b, c, d, e);

        System.out.println("Total after GST =" + total);
        System.out.println("Discount = " + discount);
        System.out.println("Final payable amount = " + finalAmount);
    }
}
