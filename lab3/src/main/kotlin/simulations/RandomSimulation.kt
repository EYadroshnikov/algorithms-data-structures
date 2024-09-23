package lab3.simulations

import lab3.buffer.IBuffer
import lab3.Packet
import lab3.logger.Print
import lab3.processor.Processor
import kotlin.random.Random

class RandomSimulation(
    private val buffer: IBuffer,
    private val numberOfCores: Int,
    private val simulationDuration: Long,
): ISimulation {
    private var running = true

    override fun run() {
        val processor = Processor(buffer, numberOfCores)

        val packetGenerator = Thread {
            while (running) {
                val packet = Packet.createRandom();

                Print.white("Packet [${packet.id}] arrived at ${packet.arrivalTime} with duration ${packet.duration} and priority ${packet.priority}")

                if (!buffer.addPacket(packet)) {
                    Print.red("Packet [${packet.id}] DROPPED at ${packet.arrivalTime} due to full buffer")
                }

                // Задержка перед добавлением следующего пакета
                Thread.sleep(Random.nextInt(200, 500).toLong())
            }
        }

        packetGenerator.start()

        // Даем процессору и генератору поработать некоторое время, затем останавливаем их
        try {
            Thread.sleep(simulationDuration * 1000) // время симуляции
            Print.red("SIMULATION STOP")
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
