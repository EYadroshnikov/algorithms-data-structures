package lab3

import java.util.LinkedList

class Buffer(private val size: Int) {
    private val packets = LinkedList<Packet>()

    @Synchronized
    fun addPacket(packet: Packet): Boolean {
        return if (packets.size < size) {
            packets.add(packet)
            true
        } else {
            false
        }
    }

    @Synchronized
    fun removePacket(): Packet? {
        return if (packets.isNotEmpty()) {
            packets.removeFirst()
        } else {
            null
        }
    }

    @Synchronized
    fun isEmpty(): Boolean = packets.isEmpty()
}

