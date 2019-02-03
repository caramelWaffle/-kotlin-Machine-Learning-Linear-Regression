import kotlin.math.abs
import kotlin.math.pow

val trainingX = listOf(1, 2, 2, 3, 3, 4, 5, 6, 6, 6, 8, 10)   //carbon atom
val trainingY = listOf(-890, -1411, -1560, -2220, -2091, -2878, -3537, -3268, -3920, -4163, -5471, -5157) //heat
val learningLate = 0.05 //initial alpha (Learning late)

var theta0 = 0.0  //Start at J(0,0)
var theta1 = 0.0  //Start at J(0,0)

var theta0Different = 0.0
var theta1Different = 0.0
var targetThetaDifferent = 0.000005  // if gradient is very close to zero and abs(newTheta-Theta) is very close to zero

var iterator = 0

fun main(args: Array<String>) {
    while (true) {
        iterator++
        gradient()
        if (theta0Different < targetThetaDifferent && theta1Different < targetThetaDifferent)
            break
    }
    println("h(x) = $theta0 + $theta1 X | $iterator times")
}

fun gradient() {
    var sum = 0.0
    var tempTheta0 = 0.0
    var tempTheta1 = 0.0

    for (i in 0..trainingX.size - 1) {
        sum += (hypothesisLine(trainingX[i].toDouble()) - trainingY[i].toDouble())
    }

    tempTheta0 = theta0 - ((learningLate * sum) / trainingX.size)

    sum = 0.0
    for (i in 0..trainingX.size - 1) {
        sum += (hypothesisLine(trainingX[i].toDouble()) - trainingY[i].toDouble()) * trainingX[i]
    }
    tempTheta1 = theta1 - ((learningLate * sum) / trainingX.size)

    theta0Different = abs(theta0 - tempTheta0)
    theta1Different = abs(theta1 - tempTheta1)

    theta0 = tempTheta0
    theta1 = tempTheta1

    println("theta0 = $theta0 : theta1 = $theta1 : cost = ${costFunction()}")
}

fun hypothesisLine(trainingX: Double): Double {
    return theta0 + (theta1 * trainingX)  // h(x) = predict y    theta0 = start point of y     theta1 = increase rate
    //    if theta0 = 0  theta1 = 2
    //    h(5) point =   0  +  2(5)
    //    h(5) point = (5,10)
}

fun costFunction(): Double {
    var sum: Double = 0.0

    for (i in 0..trainingX.size-1){
        sum += (hypothesisLine(trainingX[i].toDouble()) - trainingY[i]).pow(2)
    }
    return sum / (2*trainingX.size)
}



