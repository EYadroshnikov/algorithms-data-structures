package lab3.buffer

import lab3.Packet

class QueuedBuffer(private val capacity: Int) : IBuffer {
    private val packets = ArrayDeque<Packet>()
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
        return packets.removeFirstOrNull()?.also {
            processingPackets++
        }
    }

    @Synchronized
    override fun removePacket(packet: Packet): Int {
        return processingPackets--
    }
}
