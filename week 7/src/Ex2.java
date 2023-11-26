//Analyze sales order of an e-commerce company
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex2 {
    public static int convertTimeToSeconds(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int mi = Integer.parseInt(time.substring(3, 5));
        int se = Integer.parseInt(time.substring(6));

        if (h == 23 && mi == 59 && se == 60) {
            return 0;
        }

        return h * 3600 + mi * 60 + se;
    }

    public static class Order {
        private final String customerId;
        private final int price;
        private final String shopId;
        private final int timePoint;

        public Order(String customerId, String productId, int price, String shopId, int timePoint) {
            this.customerId = customerId;
            this.price = price;
            this.shopId = shopId;
            this.timePoint = timePoint;
        }

        public String getCustomerId() {
            return customerId;
        }

        public int getPrice() {
            return price;
        }

        public String getShopId() {
            return shopId;
        }

        public int getTimePoint() {
            return timePoint;
        }
    }

    public static class OrderList {
        private ArrayList<Order> orders;
        private final HashMap<String, ArrayList<Order>> shopOrderMap = new HashMap<>(100000);
        private final HashMap<String, Integer> shopRevenueMap = new HashMap<>(100000);
        private int totalOrders;
        private int totalRevenue;
        private int[] numberOrderInTime;

        public OrderList() {
            this.orders = new ArrayList<>();
            this.totalOrders = 0;
            this.totalRevenue = 0;
            this.numberOrderInTime = new int[86400];
        }

        public ArrayList<Order> getOrders() {
            return orders;
        }

        public void setOrders(ArrayList<Order> orders) {
            this.orders = orders;
        }

        public int getTotalOrders() {
            return totalOrders;
        }

        public void setTotalOrders(int totalOrders) {
            this.totalOrders = totalOrders;
        }

        public int getTotalRevenue() {
            return totalRevenue;
        }

        public void setTotalRevenue(int totalRevenue) {
            this.totalRevenue = totalRevenue;
        }

        public int[] getNumberOrderInTime() {
            return numberOrderInTime;
        }

        public void setNumberOrderInTime(int[] numberOrderInTime) {
            this.numberOrderInTime = numberOrderInTime;
        }

        public void addOrder(Order order) {
            orders.add(order);
            ArrayList<Order> shopOrders = shopOrderMap.getOrDefault(order.getShopId(), new ArrayList<>());
            shopOrders.add(order);
            shopOrderMap.put(order.getShopId(), shopOrders);
            totalRevenue += order.getPrice();
            totalOrders++;
            numberOrderInTime[order.getTimePoint()] += order.getPrice();
            shopRevenueMap.merge(order.getShopId(), order.getPrice(), Integer::sum);
        }

        public int getShopRevenue(String shopId) {
            return shopRevenueMap.getOrDefault(shopId, 0);
        }

        public int getTotalCustomerShopConsumption(String customerId, String shopId) {
            ArrayList<Order> shopOrders = shopOrderMap.get(shopId);

            if (shopOrders == null) {
                return 0;
            }
            int total = 0;

            for (Order order : shopOrders) {
                if (order.getCustomerId().equals(customerId)) {
                    total += order.getPrice();
                }
            }

            return total;
        }

        public int getTotalRevenueInPeriod(String fromTime, String toTime) {
            int total = 0;
            int start = convertTimeToSeconds(fromTime);
            int finish = convertTimeToSeconds(toTime);
            int[] list = numberOrderInTime;

            for (int i = start; i <= finish; i++) {
                total += list[i];
            }

            return total;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OrderList ol = new OrderList();
        StringBuilder output = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String customerId = st.nextToken();

            if (customerId.equals("#")) {
                break;
            }

            String productId = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            String shopId = st.nextToken();
            String time = st.nextToken();

            ol.addOrder(new Order(customerId, productId, price, shopId, convertTimeToSeconds(time)));
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cm = st.nextToken();
            if (cm.equals("#")) {
                break;
            }

            switch (cm) {

                case "?total_number_orders":
                    output.append(ol.getTotalOrders()).append("\n");
                    break;

                case "?total_revenue":
                    output.append(ol.getTotalRevenue()).append("\n");
                    break;

                case "?revenue_of_shop":
                    String shopId = st.nextToken();
                    output.append(ol.getShopRevenue(shopId)).append("\n");
                    break;

                case "?total_consume_of_customer_shop":
                    String customerId = st.nextToken();
                    shopId = st.nextToken();
                    output.append(ol.getTotalCustomerShopConsumption(customerId, shopId)).append("\n");
                    break;

                case "?total_revenue_in_period":
                    String fromTime = st.nextToken();
                    String toTime = st.nextToken();
                    output.append(ol.getTotalRevenueInPeriod(fromTime, toTime)).append("\n");
                    break;

            }
        }
        System.out.println(output);
        br.close();
    }
}
