package gameControl;

public class TurnImpl implements Turn{

    int[][] gamestate;

    public TurnImpl(int[][] gameState){
        this.gamestate = gameState;
    }

    @Override
    public int setInput(int inputIndex, int player) {

        for (int i = gamestate.length - 1; i >= 0; i--) {
            if(gamestate[i][inputIndex] == 0){
                gamestate[i][inputIndex] = player;
                if(checkIfWon()) System.out.println("Won");
                return 1;
            }
        }
        return -1;
    }

    private boolean checkIfWon(){
        if(checkVertical() || checkHorizontal()) return true;
        return false;
    }
    private boolean checkVertical(){
        for (int i = gamestate.length - 1; i >= 0; i--) {
            int counting = 0;
            for(int j = 0; j < gamestate[i].length; j++){
                if(gamestate[j][i] == 1){
                    counting++;
                    if(counting >=3){
                        return true;
                    }
                } else{
                    counting = 0;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal(){
        for (int i = gamestate.length - 1; i >= 0; i--) {
            int counting = 0;
            for(int j = 0; j < gamestate[i].length; j++){
                if(gamestate[i][j] == 1){
                    counting++;
                    if(counting >=3){
                        return true;
                    }
                } else{
                    counting = 0;
                }
            }
        }
        return false;
    }
    private boolean checkForWin(){
        for (int i = 0; i < 5; i++) {

        }
        return false;
    }

}
/*

[    ]
[    ]
[    ]
[    ]
 */