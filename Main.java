import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {50, 120, 100};

        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < prices.length; i++) {
            System.out.printf(i + 1 + ".  %s %d руб/шт\n", products[i], prices[i]);
        }
        int[] productCounts = new int[4];

        while (true) {
            System.out.println("Выберите номер товара и количество или введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]);
            int productCount = Integer.parseInt(parts[1]);

            productCounts[productNumber] = productCounts[productNumber] + productCount;
        }
        int sumProducts = 0;
        for (int i = 0; i < prices.length; i++) {
            sumProducts = prices[i] * productCounts[i + 1] + sumProducts;
        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < prices.length; i++) {
            System.out.println(
                    products[i] + " " + productCounts[i + 1] + " шт " + prices[i] + " руб/шт " + productCounts[i + 1] * prices[i] + " в сумме");
        }
        System.out.println("Итого: " + sumProducts);
    }
}
