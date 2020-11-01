package gameData;

public interface GameData {
    /**
     *
     * @return timestamp of player input
     */
    long getTimeStamp();

    /**
     *
     * @return inputindex
     */
    int getInputIndex();

    /**
     *
     * @return input round
     */
    int getRound();

    /**
     *
     * @return name of player who made the input
     */
    int getPlayername();
}
