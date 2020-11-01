package gameData;

import java.sql.Timestamp;
import java.util.Date;

public class GameDataImpl implements GameData{

    private long timestamp;
    private int index;
    private int round;
    private int playerName;

    public GameDataImpl(int index, int round, int playerName){
        Date date = new Date();
        this.timestamp = date.getTime();
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
    public int getPlayername() {
        return this.playerName;
    }
}
