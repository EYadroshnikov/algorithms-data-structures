package lab3.buffer

import lab3.Packet
import java.util.PriorityQueue

class PriorityBuffer(private val capacity: Int) : IBuffer {
    private val packets = PriorityQueue<Packet>(compareBy({ it.priority }, { it.arrivalTime }))
    private var processingPackets: Int = 0

    @Synchronized
    override fun addPacket(packet: Packet): Boolean {
        return if (packets.size + processingPackets < capacity) {
            packets.add(packet)
            true
        } else {
            false
        }
    }

    @Synchronized
    override fun getPacket(): Packet? {
        return packets.poll()?.also {
            processingPackets++
        }
    }

    @Synchronized
    override fun removePacket(packet: Packet): Int {
        return processingPackets--
    }
}