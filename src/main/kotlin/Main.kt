import utils.InterestRateGenerator

fun main(args: Array<String>) {
    println("Hello World!")

    println("Program arguments: ${args.joinToString()}")
    args.forEach {
        InterestRateGenerator.calculateInterest(it)
    }
}