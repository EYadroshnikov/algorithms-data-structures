package lab3

import java.util.PriorityQueue

class PriorityBuffer(private val capacity: Int): IBuffer {
    private val packets = PriorityQueue<Packet>(compareBy({ -it.priority }, { it.arrivalTime }))

    @Synchronized
    override fun addPacket(packet: Packet): Boolean {
        return if (packets.size < capacity) {
            packets.add(packet)
            true
        } else {
            false
        }
    }

    @Synchronized
    override fun getPacket(): Packet? = packets.poll()

    @Synchronized
    override fun isEmpty(): Boolean = packets.isEmpty()

    @Synchronized
    override fun getCapacity(): Int = capacity

    @Synchronized
    override fun getNumberOfPackets(): Int = packets.size
}