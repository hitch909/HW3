package org.example;




import java.io.IOException;
import java.util.List;

public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;
    String word;
    GameStatus gameStatus = GameStatus.INIT;


    public void startRu(Integer maxTry, RuGame ruGame ) throws IOException {
        this.maxTry = maxTry;
        this.word = ruGame.readFile() ;
        gameStatus = GameStatus.START;

        System.out.println("подсказка: длинна слова:  "+ word.length()+ " ,  подсказка для нетерпеливых:  " +word);
    }

    public void startEng(Integer maxTry, EngGame engGame) throws IOException {
        this.maxTry = maxTry;
        this.word = engGame.readFile() ;
        gameStatus = GameStatus.START;
        System.out.println("подсказка: длинна слова:  "+ word.length()+ " ,  подсказка для нетерпеливых:  " +word);
    }
    @Override
    public Answer inputValue(String value) {
        maxTry--;
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i <word.length()-1; i++){
           if(word.charAt(i) == value.charAt(i)){
               bulls++;
               cows++;
           } else{
               for (int j = 0; j < word.length(); j++){
                   if(word.charAt(j) == value.charAt(i)){
                       cows++;
                   }
               }
           }
        }
        if(word.length()-1 == bulls){
            gameStatus = GameStatus.WINNER;
        }
        if(maxTry == 0 && !gameStatus.equals(GameStatus.WINNER)){
            gameStatus = GameStatus.LOSE;
        }
        return new Answer(value,bulls, cows);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    protected abstract List<String> generateCharList();


}
