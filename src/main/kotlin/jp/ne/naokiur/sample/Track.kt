package jp.ne.naokiur.sample

class GasolineStand(val point: Int, val volume: Int, var isNeed: Boolean = false)
class GasolineStands(val gasolineStandMap: Map<Int, GasolineStand>) {
    fun judge(road: Int, volume: Int) {
        var currentVolume = volume
//        road < volume
        // always road < currentVolume
        //
        var currentRoad = 0
        gasolineStandMap.map {
        }
        // 総パターンになる方法
        // どうなれば最小がわかるか
        // 適切なガソリン補給タイミング

    }
}

class Track(var gasoline: Int) {
    fun run() {
        this.gasoline--
    }
    fun supply(volume: Int) {
        this.gasoline += volume
    }
}

fun main(args: Array<String>) {
//    val N = 4
//    val N = 3
    val N = 1
//    val L = 25
//    val L = 80
    val L = 25
//    val P =10
//    val P =50
    val P = 100
//    val A = listOf(10, 14, 20, 21)
//    val A = listOf(10, 50, 70)
    val A = listOf(20)
//    val B = listOf(10, 5, 2, 4)
//    val B = listOf(200, 10, 5)
    val B = listOf(50)


    val gasolineStands = A.mapIndexed { index, i -> i to GasolineStand(i, B[index]) }.toMap()
    val track = Track(P)

    runningByTrack(gasolineStands, L, track)
}

fun runningByTrack(gasolineStands: Map<Int, GasolineStand>, road: Int, track: Track) {
    var currentRoad = 0

    do {

        track.run()
        currentRoad++

        if (road == currentRoad) {
            break
        }

        if (track.gasoline == 0) {
            val alreadyStands = gasolineStands.filter { it.key <= currentRoad && !it.value.isNeed }

            val comparator = Comparator<Map.Entry<Int, GasolineStand>> { a, b -> a.value.volume.compareTo(b.value.volume) }
            val maxAlreadyStand = alreadyStands.maxWith(comparator)
            val maxAlreadyStandIndex = maxAlreadyStand?.key ?:0

            track.gasoline += maxAlreadyStand?.value!!.volume
            gasolineStands[maxAlreadyStandIndex]?.isNeed = true

            if (track.gasoline <= 0) {
                println(-1)
                return
            }
        }

    } while (road > currentRoad)

    println(gasolineStands.filter { it.value.isNeed }.size)
}

