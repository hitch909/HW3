package org.example;



import java.io.IOException;

public interface Game {
    void  startRu(Integer sizeWord, RuGame ruGame) throws IOException;
    void  startEng(Integer maxTry, EngGame engGame) throws IOException;
    Answer  inputValue(String value);


    GameStatus getGameStatus();
}
