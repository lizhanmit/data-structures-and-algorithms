package shl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A pizza shop makes serves both vegan pizza and meat pizza. Customers place N orders at the shop. Their order number is printed on their bill. The shop displays K out of N orders (both vegan and meat)on their display screen at any given time. The pizza shop is very famous and they receive many orders. To avoid confusion, vegan pizza orders are represented by positive numbers and meat pizza orders are represented by negative numbers on the screen. The orders are served in the order in which they are displayed on the screen. Each time an order is ready, its number is removed from the display screen and a new order is added to the display at the end of the list.
 * A couple has arrived with their child Billy. Billy is a very naughty child. To keep him occupied, his parents tell him to make a list of the first meat pizza that appear in each set of K orders displayed on the shop's display screen.
 * Write an algorithm to help Billy make a list of the first meat based pizza order numbers displayed on the screen each time an order is delivered to a customer.
 */
public class PizzaOrderNumbers {


    private static List<Integer> findFirstMeatPizzaInEachWindow(int[] orders, int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k cannot be less than 1");
        }

        List<Integer> res = new ArrayList<>();

        if (orders == null || orders.length == 0) {
            res.add(0);
            return res;
        }

        if (orders.length <= k) {
            for (int i = 0; i < orders.length; i++) {
                if (orders[i] < 0) {
                    res.add(orders[i]);
                    return res;
                }
            }

            res.add(0);
            return res;
        }

        boolean hasNeg;
        for (int i = 0; i + k <= orders.length; i++) {
            hasNeg = false;
            for (int j = i; j < i + k; j++) {
                if (orders[j] < 0) {
                    res.add(orders[j]);
                    hasNeg = true;
                    break;
                }
            }
            if (!hasNeg) {
                res.add(0);
            }
        }

        return res;
    }

    @Test
    public void testFindFirstMeatPizzaInEachWindow() {
        int[] orders1 = null;
        assertEquals(List.of(0), findFirstMeatPizzaInEachWindow(orders1, 3));

        int[] orders2 = {};
        assertEquals(List.of(0), findFirstMeatPizzaInEachWindow(orders2, 3));

        int[] orders3 = {-1, -2, 3, 4, -5};
        assertEquals(List.of(-1, -2, -5), findFirstMeatPizzaInEachWindow(orders3, 3));

        int[] orders4 = {1, 2, -3, -4, 5};
        assertEquals(List.of(0, -3, -3, -4), findFirstMeatPizzaInEachWindow(orders4, 2));

        int[] orders5 = {2, -1, -2};
        assertEquals(List.of(-1), findFirstMeatPizzaInEachWindow(orders5, 3));
    }
}
