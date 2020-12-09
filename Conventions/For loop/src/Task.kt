class DateRange(val startDate: MyDate, val endDate: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var currentDate: MyDate = startDate

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = currentDate
                currentDate = currentDate.followingDate()
                return result
            }

            override fun hasNext(): Boolean = currentDate <= endDate
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}