package entities

class Game(private val randomInt: RandomInt) {
    val player2: Player = Player()
    val player1: Player = Player()

    fun start() {
        allPlayersDraw(3)
    }

    private fun allPlayersDraw(numberToDraw: Int) {
        player1.draw(randomInt, numberToDraw)
        player2.draw(randomInt, numberToDraw)
    }

    fun turn() {
        player1.receiveManaSlot()
        player1.draw(randomInt, 1)
    }

}