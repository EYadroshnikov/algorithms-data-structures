package lab3.simulations

import lab3.buffer.IBuffer
import lab3.Packet
import lab3.logger.Print
import lab3.processor.Processor
import java.io.BufferedReader
import java.io.InputStreamReader

class InputSimulation(private val buffer: IBuffer, private val numberOfCores: Int): ISimulation {
    override fun run() {
        val processor = Processor(buffer, numberOfCores)

        val reader = BufferedReader(InputStreamReader(System.`in`))

        val n = reader.readLine().toInt()

        for (i in 0 until n) {
            val (arrival, duration) = reader.readLine().split(" ").map { it.toInt() }
            val priority = 1
            val packet = Packet.create(arrival, duration, priority)

            Print.white("Packet [${packet.id}] arrived at ${packet.arrivalTime} with duration ${packet.duration} and priority ${packet.priority}")

            if (!buffer.addPacket(packet)) {
                Print.red("Packet [${packet.id}] DROPPED at ${packet.arrivalTime} due to full buffer")
            }
        }
    }
}
