package lab3

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Processor(private val queuedBuffer: IBuffer, private val numberOfCores: Int) {
    private val cores: List<Core> = List(numberOfCores) { Core(it + 1, queuedBuffer) }
    private val executor = Executors.newFixedThreadPool(numberOfCores)

    init {
        cores.forEach { executor.submit(it) }
    }

    fun shutdown() {
        cores.forEach {it.stop()}
        executor.shutdown()
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow()
                println("Shutting down...")
            }
        } catch (e: InterruptedException) {
            executor.shutdownNow()
        }
    }
}
