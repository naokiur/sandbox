package jp.ne.naokiur.sample

import org.junit.Test
import kotlin.test.assertEquals

class ApplePieTest {

    @Test
    fun test1and3() {
        assertEquals(main(1, 3), 3)
    }
}