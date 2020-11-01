package gameControl;

public class TurnImpl implements Turn{

    int[][] gamestate;

    public TurnImpl(int[][] gameState){
        this.gamestate = gameState;
    }

    @Override
    public int setInput(int inputIndex, int player) {

        if(inputIndex < 0 || inputIndex >= gamestate[0].length || gamestate[0][inputIndex] != 0){
            return -1;
        }
        for (int i = gamestate.length - 1; i >= 0; i--) {
            if(gamestate[i][inputIndex] == 0){
                gamestate[i][inputIndex] = player;
                if(checkIfWon(player)){
                    return 1;
                }
                if(!checkIfMoreMovesPossible()){
                    return 2;
                }
                return 0;
            }
        }
        return -1;
    }

    //todo overhaul of these methods
    private boolean checkIfWon(int player){
        if(checkVertical(player) || checkHorizontal(player)) return true;
        if(checkForDiagonal(player)) return true;
        return false;
    }
    private boolean checkVertical(int player){
        for (int i = 0; i < gamestate[0].length; i++) {
            int counting = 0;
            for(int j = 0; j < gamestate.length; j++){
                if(gamestate[j][i] == player){
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
    /*
    private boolean checkVertical(int player){
        for (int i = gamestate.length - 1; i >= 0; i--) {
            int counting = 0;
            for(int j = 0; j < gamestate[i].length; j++){
                if(gamestate[j][i] == player){
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

     */

    private boolean checkHorizontal(int player){
        for (int i = 0; i < gamestate.length; i++) {
            int counting = 0;
            for(int j = 0; j < gamestate[0].length; j++){
                if(gamestate[i][j] == player){
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
    private boolean checkForDiagonal(int player){
        //geh alle felder durch
        //--, -+, +-, ++
        for (int i = 0; i < gamestate.length; i++) {
            for(int j = 0; j < gamestate[0].length; j++) {
                int counting = 0;
                int currentX = j;
                int currentY = i;
                while(currentX >= 0 && currentX < gamestate[0].length && currentY >= 0 && currentY < gamestate.length){
                    if(gamestate[currentY][currentX] == player){
                        counting++;
                        if(counting >=3){
                            return true;
                        }
                    } else{
                        counting = 0;
                    }
                    currentX--;
                    currentY--;
                }
                counting = 0;
                currentX = j;
                currentY = i;
                while(currentX >= 0 && currentX < gamestate[0].length && currentY >= 0 && currentY < gamestate.length){
                    if(gamestate[currentY][currentX] == 1){
                        counting++;
                        if(counting >=3){
                            return true;
                        }
                    } else{
                        counting = 0;
                    }
                    currentX++;
                    currentY--;
                }
                counting = 0;
                currentX = j;
                currentY = i;
                while(currentX >= 0 && currentX < gamestate[0].length && currentY >= 0 && currentY < gamestate.length){
                    if(gamestate[currentY][currentX] == 1){
                        counting++;
                        if(counting >=3){
                            return true;
                        }
                    } else{
                        counting = 0;
                    }
                    currentX--;
                    currentY++;
                }
                counting = 0;
                currentX = j;
                currentY = i;
                while(currentX >= 0 && currentX < gamestate[0].length && currentY >= 0 && currentY < gamestate.length){
                    if(gamestate[currentY][currentX] == 1){
                        counting++;
                        if(counting >=3){
                            return true;
                        }
                    } else{
                        counting = 0;
                    }
                    currentX++;
                    currentY++;
                }
            }

        }
        return false;
    }
    private boolean checkIfMoreMovesPossible(){
        for (int i = gamestate.length - 1; i >= 0; i--) {
            for (int j = 0; j < gamestate[0].length; j++) {
                if(gamestate[i][j] == 0) return true;
            }
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