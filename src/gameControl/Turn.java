package gameControl;

public interface Turn {
    /**
     *
     * @param inputIndex index for next insertion
     * @param player number of the player
     * @return 0 no winner and game continues, 1 game is won, 2 game over with draw, -1 for false input
     */
    int setInput(int inputIndex, int player);

}
