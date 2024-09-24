package lab3

import lab3.buffer.PriorityBuffer
import lab3.buffer.QueuedBuffer
import lab3.simulations.InputSimulation
import lab3.simulations.RandomSimulation
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val bufferCapacity = reader.readLine().toInt()
//    val bufferCapacity = 1
    val cores = 2
    val randomSimulationDuration = 10.toLong()

    val randomSimulation = RandomSimulation(
        buffer = PriorityBuffer(capacity = bufferCapacity),
        numberOfCores = cores,
        simulationDuration = randomSimulationDuration
    )
    randomSimulation.run()

//    val inputSimulation = InputSimulation(buffer = PriorityBuffer(capacity = bufferCapacity), numberOfCores = cores)
//    inputSimulation.run()

}

