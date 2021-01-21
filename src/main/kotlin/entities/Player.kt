package entities

class Player {
    val health: Health = 30
    val mana: Mana = 0
    val deck: Deck = Deck()
    val hand: Hand = Hand()

    fun draw(numberToDraw: Int) = repeat(numberToDraw) { drawCard() }

    private fun drawCard() = deck.draw().let(hand::add)

    fun getDeckSize(): Int = deck.size()
    fun getHandSize(): Int = hand.size()
}