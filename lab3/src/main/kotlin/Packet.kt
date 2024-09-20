package lab3

import kotlin.random.Random

class Packet private constructor(
    val id: Int,
    val arrivalTime: Int,
    val duration: Int,
    val priority: Int
) {
    companion object {
        fun create(arrivalTime: Int, duration: Int, priority: Int): Packet {
            val id = Random.nextInt(1, 100000)
            return Packet(id, arrivalTime, duration, priority)
        }

        fun createRandom(): Packet {
            val arrivalTime = System.currentTimeMillis().toInt()
            val duration = Random.nextInt(1000, 5000)
            val priority = Random.nextInt(1, 4)
            return Packet.create(arrivalTime, duration, priority)
        }
    }

    override fun toString(): String {
        return "Packet [${this.id}] arrived at ${this.arrivalTime} with duration ${this.duration} and priority ${this.priority}"
    }
}