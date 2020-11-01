package gameData;

class GameDataImpl implements GameData{

    private long timestamp;
    private int index;
    private int round;
    private String playerName;

    GameDataImpl(long timestamp, int index, int round, String playerName){
        this.timestamp = timestamp;
        this.index = index;
        this.round = round;
        this.playerName = playerName;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override
    public int getInputIndex() {
        return this.index;
    }

    @Override
    public int getRound() {
        return this.round;
    }

    @Override
    public String getPlayername() {
        return this.playerName;
    }
}
