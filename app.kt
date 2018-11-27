import kotlin.math.abs

val trainingX  = listOf(1,2,2,3,3,4,5,6,6,6,8,10)   //carbon atom
val trainingY = listOf(-890,-1411,-1560,-2220,-2091,-2878,-3537,-3268,-3920,-4163,-5471,-5157) //heat
val learningLate = 0.05 //initial alpha (Learning late)

var theta0 = 0.0  //Start at J(0,0)
var theta1 = 0.0  //Start at J(0,0)

var thetaDifferent = 0.0
var targetThetaDifferent = 0.000005  // if gradient is very close to zero and abs(newTheta-Theta) is very close to zero

fun main(args: Array<String>) {
    while (true){
        gradient()
        if (thetaDifferent < targetThetaDifferent)
            break
    }
    println("h(x) = $theta0 + $theta1 X ")
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

    thetaDifferent = abs(theta0 - tempTheta0)
    theta0 = tempTheta0
    theta1 = tempTheta1

    println("theta0 = $theta0 : theta1 = $theta1")
}

fun hypothesisLine(trainingX: Double) : Double{
    return theta0+(theta1*trainingX)  // h(x) = predict y    theta0 = start point of y     theta1 = increase rate
    //    if theta0 = 0  theta1 = 2
    //    h(5) point =   0  +  2(5)
    //    h(5) point = (5,10)
}