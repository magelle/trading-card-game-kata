package entities

class Game {
    val player2: Player = Player()
    val player1: Player = Player()

    fun start() {
        allPlayersDraw(3)
    }

    private fun allPlayersDraw(numberToDraw: Int) {
        player1.draw(numberToDraw)
        player2.draw(numberToDraw)
    }
}