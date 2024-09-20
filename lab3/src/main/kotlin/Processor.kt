package lab3

class Processor(private val id: Int, private val buffer: Buffer) : Runnable {

    private var currentTime = 0

    override fun run() {
        while (true) {
            val packet = buffer.removePacket()
            if (packet != null) {
                processPacket(packet)
            } else {
                Thread.sleep(100) // если пакетов нет, процессор ожидает
            }
        }
    }

    private fun processPacket(packet: Packet) {
        Print.yellow("Processor $id STARTED processing packet ${packet.toString()}")
        currentTime += packet.duration
        Thread.sleep(packet.duration.toLong()) // симулируем обработку пакета
        Print.green("Processor $id FINISHED processing packet ${packet.toString()} at time $currentTime")
    }

    fun getCurrentTime(): Int = currentTime
}
