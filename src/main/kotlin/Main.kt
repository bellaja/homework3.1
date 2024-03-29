fun main() {

}

const val ERROR_LIMIT: Int = -1
const val ERROR_TYPE: Int = -2

fun calculateComission(
    cardType: String,
    amount: Int,
    previousTransfer: Int = 0,
    promotion: Boolean = false
): Int {

    return when (cardType) {
        "Mastercard", "Maestro" ->
            when {
                (amount + previousTransfer <= 600_000) && (amount + previousTransfer <= 150_000) ->
                    if (amount in 300..75_000 && promotion === true) {
                        0
                    } else {
                        (amount * 0.006 + 20).toInt()
                    }

                else -> ERROR_LIMIT
            }

        "Visa", "Мир" ->
            when {
                (amount + previousTransfer <= 600_000) && (amount + previousTransfer <= 150_000) ->
                    if ((amount * 0.0075).toInt() > 35) {
                        (amount * 0.0075).toInt()
                    } else {
                        35
                    }

                else -> ERROR_LIMIT
            }

        "VKPay" -> if ((amount + previousTransfer <= 40_000) && (amount + previousTransfer <= 15_000)) {
            return 0
        } else ERROR_LIMIT

        else -> ERROR_TYPE
    }
}





