class LazyProperty(val initializer: () -> Int) {
    var valueForCheckingFirstAccess: Int? = null
    val lazy: Int
        get() {
            if (valueForCheckingFirstAccess == null) {
                valueForCheckingFirstAccess = initializer()
            }
            return requireNotNull(valueForCheckingFirstAccess)
        }
}
