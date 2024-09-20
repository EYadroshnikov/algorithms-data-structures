package lab3

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class Simulation(
    bufferSize: Int,
    private val numberOfProcessors: Int
) : Runnable {
    private val buffer = Buffer(bufferSize)
    private val processorPool = Executors.newFixedThreadPool(numberOfProcessors)
    private var running = true

    override fun run() {
        // Запуск процессоров
        for (i in 1..numberOfProcessors) {
            processorPool.execute(Processor(i, buffer))
        }

        // Завершение пула процессоров
        processorPool.shutdown()

        // Добавление пакетов в буфер с постоянным интервалом
        val packetGenerator = Thread {
            while (running) {
                val packet = Packet.createRandom();

                Print.white("Packet arrived at ${packet.arrivalTime} with duration ${packet.duration}")

                if (!buffer.addPacket(packet)) {
                    Print.red("Packet DROPPED at ${packet.arrivalTime} due to full buffer")
                }

                // Задержка перед добавлением следующего пакета
                Thread.sleep(Random.nextInt(200, 1000).toLong())
            }
        }

        packetGenerator.start()

        // Даем процессорам поработать некоторое время, затем останавливаем их
        // Ожидание 10 секунд
        try {
            Thread.sleep(3000) // время симуляции
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            // Остановка генерации пакетов
            running = false
            // Завершение пула процессоров
            processorPool.shutdown()
            try {
                // Ждем завершения всех потоков
                if (!processorPool.awaitTermination(60, TimeUnit.SECONDS)) {
                    processorPool.shutdownNow() // принудительная остановка
                }
            } catch (e: InterruptedException) {
                processorPool.shutdownNow()
            }
        }
    }
}


