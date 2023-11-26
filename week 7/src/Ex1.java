import java.util.Scanner;

class Time {
    int h;
    int mi;
    int se;
}

class Order {
    String customerId;
    String productId;
    int price;
    String shopId;
    Time timePoint;
}

class Node {
    Order order;
    Node next;
}

public class Ex1 {
    static Node[] head = new Node[1000];

    static int hashString(String str) {
        int hash = 0;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            hash = (hash * 31 + str.charAt(i)) % 1000;
        }

        return hash;
    }

    static void initHashTable() {
        for (int i = 0; i < 1000; i++) {
            head[i] = null;
        }
    }

    static Node createNode(Order order) {
        Node newNode = new Node();
        newNode.order = order;
        newNode.next = null;
        return newNode;
    }

    static Node insert(Node head, Node newNode) {
        if (newNode == null) {
            return head;
        }

        newNode.next = head;
        return newNode;
    }

    static int revenueOfShop(String shopId) {
        int totalRevenue = 0;
        Node current = head[hashString(shopId)];

        while (current != null) {
            if (current.order.shopId.equals(shopId)) {
                totalRevenue += current.order.price;
            }
            current = current.next;
        }
        return totalRevenue;
    }

    static int totalRevenueForShopToCustomer(String shopId, String customerId) {
        int totalRevenue = 0;
        for (int i = 0; i < 1000; i++) {
            Node current = head[i];
            while (current != null) {
                if (current.order.shopId.equals(shopId) && current.order.customerId.equals(customerId)) {
                    totalRevenue += current.order.price;
                }
                current = current.next;
            }
        }
        return totalRevenue;
    }

    static int totalRevenueInPeriod(Time fromTime, Time toTime) {
        int totalRevenue = 0;
        for (int i = 0; i < 1000; i++) {
            Node current = head[i];
            while (current != null) {
                if (compareTimes(current.order.timePoint, fromTime) >= 0
                        && compareTimes(current.order.timePoint, toTime) <= 0) {
                    totalRevenue += current.order.price;
                }
                current = current.next;
            }
        }
        return totalRevenue;
    }

    static Time stringToTime(String timeStr) {
        Time result = new Time();
        String[] parts = timeStr.split(":");
        if (parts.length == 3) {
            result.h = Integer.parseInt(parts[0]);
            result.mi = Integer.parseInt(parts[1]);
            result.se = Integer.parseInt(parts[2]);

            if (result.se == 60) {
                result.se = 0;
                result.mi++;
                if (result.mi == 60) {
                    result.mi = 0;
                    result.h++;
                    if (result.h == 24) {
                        result.h = 0;
                    }
                }
            }
        } else {
            System.out.printf("Invalid time format: %s\n", timeStr);
            result.h = result.mi = result.se = 0; // Default values
        }
        return result;
    }

    static int compareTimes(Time time1, Time time2) {
        if (time1.h < time2.h)
            return -1;
        if (time1.h > time2.h)
            return 1;
        if (time1.mi < time2.mi)
            return -1;
        if (time1.mi > time2.mi)
            return 1;
        if (time1.se < time2.se)
            return -1;
        if (time1.se > time2.se)
            return 1;
        return 0; // The times are equal
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initHashTable();
        int totalNumberOrders = 0;
        int totalRevenue = 0;

        while (true) {
            String customerId = sc.next();
            if (customerId.equals("#")) {
                break;
            }

            String productId, shopId, timeStr;
            int price;

            productId = sc.next();
            price = sc.nextInt();
            shopId = sc.next();
            timeStr = sc.next();

            Time timePoint = stringToTime(timeStr);
            Order newOrder = createOrder(customerId, productId, price, shopId, timePoint);

            head[hashString(shopId)] = insert(head[hashString(shopId)], createNode(newOrder));
            totalNumberOrders++;
            totalRevenue += price;
        }

        while (true) {
            String command = sc.next();
            if (command.equals("#")) {
                break;
            }

            if (command.equals("?total_number_orders")) {
                System.out.println(totalNumberOrders);
                continue;
            }
            if (command.equals("?total_revenue")) {
                System.out.println(totalRevenue);
                continue;
            }
            if (command.equals("?revenue_of_shop")) {
                String shopId = sc.next();
                int shopRevenue = revenueOfShop(shopId);
                System.out.println(shopRevenue);
                continue;
            }
            if (command.equals("?total_consume_of_customer_shop")) {
                String customerId = sc.next();
                String shopId = sc.next();
                int customerShopRevenue = totalRevenueForShopToCustomer(shopId, customerId);
                System.out.println(customerShopRevenue);
                continue;
            }
            if (command.equals("?total_revenue_in_period")) {
                String fromTimeStr = sc.next();
                String toTimeStr = sc.next();
                Time fromTime = stringToTime(fromTimeStr);
                Time toTime = stringToTime(toTimeStr);
                int periodRevenue = totalRevenueInPeriod(fromTime, toTime);
                System.out.println(periodRevenue);
                continue;
            }
        }

        sc.close();
    }

    static Order createOrder(String customerId, String productId, int price, String shopId, Time timePoint) {
        Order newOrder = new Order();
        newOrder.customerId = customerId;
        newOrder.productId = productId;
        newOrder.price = price;
        newOrder.shopId = shopId;
        newOrder.timePoint = timePoint;
        return newOrder;
    }
}
