package entities

class Player {
    val health: Health = 30
    var mana: Mana = 0
    var manaSlot: ManaSlot = 0
    val deck: Deck = Deck()
    val hand: Hand = Hand()

    fun draw(randomInt: RandomInt, numberToDraw: Int) =
        repeat(numberToDraw) { drawCard(randomInt) }

    private fun drawCard(randomInt: RandomInt) =
        deck.draw(randomInt).let(hand::add)

    fun getDeckSize(): Int = deck.size()
    fun getHandSize(): Int = hand.size()
    fun receiveManaSlot() {
        manaSlot++
        mana = manaSlot
    }
}