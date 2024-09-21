package lab3

class Core(private val id: Int, private val queuedBuffer: IBuffer) : Runnable {
    private var currentTime = 0
    private var running = true

    override fun run() {
        while (running) {
            val packet = queuedBuffer.getPacket()
            if (packet != null) {
                processPacket(packet)
            } else {
                Thread.sleep(100) // если пакетов нет, ядро ожидает
            }
        }
    }

    private fun processPacket(packet: Packet) {
        Print.yellow("Core $id STARTED processing packet ${packet.toString()}")
        currentTime += packet.duration
        Thread.sleep(packet.duration.toLong()) // симулируем обработку пакета
        Print.green("Core $id FINISHED processing packet ${packet.toString()} at time $currentTime")
    }

    fun getId(): Int {
        return this.id
    }

    fun stop() {
        running = false
    }
}
