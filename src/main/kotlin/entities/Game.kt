package entities

class Game(private val randomInt: RandomInt) {

    val player2: Player = Player()
    val player1: Player = Player()
    private var activePlayer: Player? = null
    fun start() {
        allPlayersDraw(3)
    }

    private fun allPlayersDraw(numberToDraw: Int) {
        player1.draw(randomInt, numberToDraw)
        player2.draw(randomInt, numberToDraw)
    }

    fun turn() {
        activePlayer = nextPlayer()
        activePlayer?.receiveManaSlot()
        activePlayer?.draw(randomInt, 1)
    }

    private fun nextPlayer(): Player = if(activePlayer === player1) player2 else player1

    fun getActivePlayer(): Player? = activePlayer
}