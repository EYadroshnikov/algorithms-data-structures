package lab3

class QueuedBuffer(private val capacity: Int): IBuffer  {
    private val packets = ArrayDeque<Packet>()

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
    override fun getPacket(): Packet? = packets.removeFirstOrNull()

    @Synchronized
    override fun isEmpty(): Boolean = packets.isEmpty()

    @Synchronized
    override fun getCapacity(): Int = capacity

    @Synchronized
    override fun getNumberOfPackets(): Int = packets.size
}

