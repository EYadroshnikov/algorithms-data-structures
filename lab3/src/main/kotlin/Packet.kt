package lab3

import kotlin.random.Random

class Packet private constructor(
    val id: Int,
    val arrivalTime: Int,
    val duration: Int,
    val priority: Int
) {
    companion object Factory {
        private var idCounter = 0

        fun create(arrivalTime: Int, duration: Int, priority: Int): Packet {
            val id = idCounter++
            return Packet(id, arrivalTime, duration, priority)
        }

        fun createRandom(): Packet {
            val arrivalTime = System.currentTimeMillis().toInt()
            val duration = Random.nextInt(1, 4) * 1000
            val priority = Random.nextInt(1, 4)
            return create(arrivalTime, duration, priority)
        }
    }

    override fun toString(): String {
        return "Packet [${this.id}] (arrived at ${this.arrivalTime} with duration ${this.duration} and priority ${this.priority})"
    }
}