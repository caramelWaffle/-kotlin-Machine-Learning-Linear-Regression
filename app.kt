val trainingX  = listOf(1,2,2,3,3,4,5,6,6,6,8,10)
val trainingY = listOf(-890,-1411,-1560,-2220,-2091,-2878,-3537,-3268,-3920,-4163,-5471,-5157)
val learningLate = 0.05

var theta0 = 0.0
var theta1 = 0.0

fun main(args: Array<String>) {
    for (i in 0..999){
        gradient()
    }

    println("\n==================")
    println("h(x) = $theta1 X + $theta0")
}

fun gradient() {
    var sum = 0.0
    var tempTheta0 = 0.0
    var tempTheta1 = 0.0

    for (i in 0..trainingX.size-1){
        sum += ( hypothesisLine(trainingX[i].toDouble()) - trainingY[i].toDouble())
    }
    tempTheta0 = theta0 - ((learningLate * sum) / trainingX.size)

    sum = 0.0
    for (i in 0..trainingX.size-1){
        sum += ( hypothesisLine(trainingX[i].toDouble()) - trainingY[i].toDouble()) * trainingX[i]
    }
    tempTheta1 = theta1 - ((learningLate * sum) / trainingX.size)

    theta0 = tempTheta0
    theta1 = tempTheta1

    println("theta0 = $theta0 : theta1 = $theta1")
}

fun hypothesisLine(trainingX: Double) : Double{
    return theta0+(theta1*trainingX)  // h(x) = predict y
}



