import org.junit.Assert.assertEquals
import org.junit.Test


class MainKtTest {

    //имена функциий
    //80%  покрытия


    @Test
    fun MastercardDailyLimit() {
        val cardType = "Mastercard"
        val amount = 1_000
        val previousTransfer = 200_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun MastercardMonthlyLimit() {
        val cardType = "Mastercard"
        val amount = 1_000
        val previousTransfer = 1_000_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun MastercardPromotionTrueAmountFalse() {
        val cardType = "Mastercard"
        val amount = 100
        val previousTransfer = 1_000
        val promotion = true


        val result = calculateComission(cardType, amount, previousTransfer, promotion)
        assertEquals(20, result)
    }

    @Test
    fun MastercardPromotionFalseAmountTrue() {
        val cardType = "Mastercard"
        val amount = 300
        val previousTransfer = 1_000
        val promotion = false


        val result = calculateComission(cardType, amount, previousTransfer, promotion)
        assertEquals(21, result)
    }

    @Test
    fun MastercardPromotionTrueAmountTrue() {
        val cardType = "Mastercard"
        val amount = 300
        val previousTransfer = 1_000
        val promotion = true


        val result = calculateComission(cardType, amount, previousTransfer, promotion)
        assertEquals(0, result)
    }

    @Test
    fun MastercardPromotionTrueAmountOutOfRange() {
        val cardType = "Mastercard"
        val amount = 100_000
        val previousTransfer = 1_000
        val promotion = true


        val result = calculateComission(cardType, amount, previousTransfer, promotion)
        assertEquals(ERROR_TYPE, result)
    }

    @Test
    fun MaestroDailyLimit() {
        val cardType = "Maestro"
        val amount = 1_000
        val previousTransfer = 200_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }


    @Test
    fun JCB() {
        val cardType = "JCB"
        val amount = 100_000
        val previousTransfer = 1_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun VisaDailyLimit() {
        val cardType = "Visa"
        val amount = 1_000
        val previousTransfer = 200_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(500, result)
    }

    @Test
    fun VisaMonthlyLimit() {
        val cardType = "Visa"
        val amount = 1_000
        val previousTransfer = 1_000_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun VisaMinComission() {
        val cardType = "Visa"
        val amount = 3000
        val previousTransfer = 0


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(97, result)
    }

    @Test
    fun VisaComission() {
        val cardType = "Visa"
        val amount = 5000
        val previousTransfer = 0


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(37, result)
    }

    @Test
    fun VKPayDailyLimit() {
        val cardType = "VKPay"
        val amount = 1_000
        val previousTransfer = 20_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun VKPayMonthlyLimit() {
        val cardType = "VKPay"
        val amount = 1_000
        val previousTransfer = 50_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(42, result)
    }

    @Test
    fun VKPayMonthlyComission() {
        val cardType = "VKPay"
        val amount = 10_000
        val previousTransfer = 0


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(0, result)
    }

    @Test
    fun MirDailyLimit() {
        val cardType = "Мир"
        val amount = 1_000
        val previousTransfer = 200_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun MirMonthlyLimit() {
        val cardType = "Мир"
        val amount = 1_000
        val previousTransfer = 1_000_000


        val result = calculateComission(cardType, amount, previousTransfer)
        assertEquals(ERROR_LIMIT, result)
    }


}