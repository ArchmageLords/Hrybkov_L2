fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer
        .orders
        .filter(Order::isDelivered)
        .flatMap(Order::products)
        .maxBy(Product::price)
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
        .flatMap(Customer::getOrderedProducts)
        .count { it.equals(product) }
}

fun Customer.getOrderedProducts(): List<Product> =
    orders
        .flatMap(Order::products)
