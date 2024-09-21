package lab3.processor

import lab3.buffer.IBuffer
import lab3.Packet
import lab3.logger.Print

class Core(private val id: Int, private val buffer: IBuffer) : Runnable {
    private var running = true

    override fun run() {
        while (running) {
            val packet = buffer.getPacket()
            if (packet != null) {
                processPacket(packet)
            } else {
                Thread.sleep(100) // если пакетов нет, ядро ожидает
            }
        }
    }

    private fun processPacket(packet: Packet) {
        Print.yellow("Core $id STARTED processing packet $packet")
        Thread.sleep(packet.duration.toLong()) // симулируем обработку пакета
        Print.green("Core $id FINISHED processing packet $packet at time ${System.currentTimeMillis().toInt()}")
        buffer.removePacket(packet)
    }

    fun getId(): Int {
        return this.id
    }

    fun stop() {
        running = false
    }
}
