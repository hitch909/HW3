package org.example;
/*Разработка игры “быки - коровы” (игрок против компьютера)
a) Интерфейс взаимодействий Game (должны быть описаны сигнатуры методов start, inputValue,getGameStatus)
b) Абстрактный класс AbstractGame (который предзаполняет слово компьютера - generateWord(), на основе generateCharList()
- который является абстрактным методом)
c) Статусная модель с помощью перечислений(GameStatus)
d) Класс ответа Answer
e) Классы реализующие AbstractGame(предполагается игра на числах,англ буквах, русских буквах)
F) * реализовать restart().
 */


import java.io.*;
import java.util.Scanner;
public class Main {


    public static  void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Game game = new GameNumber();
        RuGame ruGame = new RuGame() ;
        EngGame engGame = new EngGame();


        System.out.println("hello, вы хотите начать игру на русском языке или на англиском? ");
            System.out.println("для игры на русском нажмите 1 , для анлиского 2 ");
            int temp = scan.nextInt();
            if (temp == 1) {
                game.startRu(7, ruGame);
            }
            if (temp == 2) {
                game.startEng(7, engGame);
            }

            Scanner scanner = new Scanner(System.in);
            while (!game.getGameStatus().equals(GameStatus.WINNER)
                    && !game.getGameStatus().equals(GameStatus.LOSE)) {
                String userWord = scanner.nextLine();
                Answer answer = game.inputValue(userWord);
                //System.out.println("answer:  "+ answer);
                game.inputValue(userWord);
                answer.showAnswer();
            }
            System.out.println(game.getGameStatus());
    }
}