package lab3

interface IBuffer {
    fun addPacket(packet: Packet): Boolean
    fun getPacket(): Packet?

    fun isEmpty(): Boolean
    fun getCapacity(): Int
    fun getNumberOfPackets(): Int
}