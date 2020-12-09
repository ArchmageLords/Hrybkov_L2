fun Shop.getCustomerWithMaxOrders(): Customer? =
        customers.maxBy { it.orders.size }

fun getMostExpensiveProductBy(customer: Customer): Product? =
        customer.orders
                .flatMap(Order::products)
                .maxBy(Product::price)