package lab3

fun main() {
    val simulation = Simulation(buffer = PriorityBuffer(capacity = 2), numberOfCores = 2, simulationDuration = 10)
    simulation.run()
}

