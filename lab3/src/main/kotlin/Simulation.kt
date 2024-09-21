package lab3

import kotlin.random.Random

class Simulation(
    private val buffer: IBuffer,
    private val numberOfCores: Int,
    private val simulationDuration: Long,
) {
    private var running = true

    fun run() {
        val processor = Processor(buffer, numberOfCores)

        val packetGenerator = Thread {
            while (running) {
                val packet = Packet.createRandom();

                Print.white("Packet [${packet.id}] arrived at ${packet.arrivalTime} with duration ${packet.duration}")

                if (!buffer.addPacket(packet)) {
                    Print.red("Packet [${packet.id}] DROPPED at ${packet.arrivalTime} due to full buffer")
                }

                // Задержка перед добавлением следующего пакета
                Thread.sleep(Random.nextInt(200, 1000).toLong())
            }
        }

        packetGenerator.start()

        // Даем процессору поработать некоторое время, затем останавливаем их
        try {
            Thread.sleep(simulationDuration * 1000) // время симуляции
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            // Остановка генерации пакетов
            running = false
            // Завершение работы процессора
            processor.shutdown()
        }
    }
}


