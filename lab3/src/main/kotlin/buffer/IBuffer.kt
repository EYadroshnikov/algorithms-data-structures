package lab3.buffer

import lab3.Packet

interface IBuffer {
    fun addPacket(packet: Packet): Boolean
    fun getPacket(): Packet?
    fun removePacket(packet: Packet): Int

    fun isEmpty(): Boolean
    fun getCapacity(): Int
    fun getNumberOfPackets(): Int
}