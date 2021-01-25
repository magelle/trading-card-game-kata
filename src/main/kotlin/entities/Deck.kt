package entities

class Deck {
    private val cards: MutableList<Card> = mutableListOf(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8)

    fun draw(randomInt: RandomInt): Card = cards.removeAt(randomInt(cards.size))

    fun size() = cards.size
    fun allCards(): List<Card> = this.cards
}