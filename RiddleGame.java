import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Riddle
{
    private String question;
    private String answer;

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public Riddle(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }
}

class RiddleGame {

    static void playGame(List<Riddle> riddlePool)
    {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        Collections.shuffle(riddlePool);

        for (int i = 0; i < 5; i++)
        {
            Riddle myRiddle = riddlePool.get(i);
            System.out.println("Here's riddle " + (i+1) + ":");
            System.out.println(myRiddle.getQuestion());
            boolean correct = false;

            for(int attempts = 1; attempts <= 4; attempts++)
            {
                String answer = scanner.nextLine();

                if(answer.equalsIgnoreCase(myRiddle.getAnswer()))
                {
                    System.out.println("Correct!");
                    score++;
                    correct = true;
                    break;
                }
                else
                {
                    if(attempts < 4)
                    {
                        System.out.println("Incorrect! Try again.");
                        System.out.println("Attempts remaining: " + (4 - attempts));
                        System.out.println(myRiddle.getQuestion());
                    }
                }
            }

            if(!correct)
            {
                System.out.println("Out of attempts!");
                System.out.println("Correct answer: " + myRiddle.getAnswer());
            }
        }
        System.out.println("You got " + score + " out of 5 correct.");
        System.out.println("MAX SCORE: 100");
        System.out.println("YOUR SCORE: " + (score*20));
    }
    public static void main(String[] args) {

        List<Riddle> easyPool = new ArrayList<>();
        List<Riddle> mediumPool = new ArrayList<>();
        List<Riddle> hardPool = new ArrayList<>();

        easyPool.add(new Riddle("I run all around the yard, but I never move. What am I?", "fence"));
        easyPool.add(new Riddle("What gets wet while it is drying?", "towel"));
        easyPool.add(new Riddle("What has hands but cannot clap?", "clock"));
        easyPool.add(new Riddle("What has a head and a tail but no body?", "coin"));
        easyPool.add(new Riddle("What is full of holes but still holds water?", "sponge"));
        easyPool.add(new Riddle("What goes up but never comes down?", "your age"));

        mediumPool.add(new Riddle("What is so fragile that saying its name breaks it?", "silence"));
        mediumPool.add(new Riddle("I am an odd number. Take away a letter and I become even. What number am I?", "seven"));
        mediumPool.add(new Riddle("The person who makes it has no need of it; the person who buys it does not use it for themselves. The person who uses it will never know it. What is it?", "coffin"));
        mediumPool.add(new Riddle("I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?", "map"));
        mediumPool.add(new Riddle("What can travel around the world while staying in a corner?", "stamp"));
        mediumPool.add(new Riddle("What builds up castles, tears down mountains, makes some blind, helps others see?", "sand"));

        hardPool.add(new Riddle("I destroy what I touch, yet I create nothing new. I have no legs, but I run rapidly. I have no lungs, but I require air to live. What am I?", "fire"));
        hardPool.add(new Riddle("I am a word of six letters. If you remove my first letter, I become a form of energy. If you remove my first two letters, I am needed to live. What am I?", "warmth"));
        hardPool.add(new Riddle("What loses its head in the morning but gets it back at night?", "pillow"));
        hardPool.add(new Riddle("I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?", "echo"));
        hardPool.add(new Riddle("What disappears the moment you make it?", "mistake"));
        hardPool.add(new Riddle("What is always in front of you but cannot be seen?", "future"));

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Would you like to try solving a riddle?");
        String question1 = scanner2.nextLine();
        if (question1.equalsIgnoreCase("no"))
            System.out.println("Okay! Bye!");
        else
        {
            while(true){
            System.out.println("Choose Difficulty Level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            String level = scanner2.nextLine();

            if(level.equalsIgnoreCase("easy"))
                playGame(easyPool);
            if(level.equalsIgnoreCase("medium"))
                playGame(mediumPool);
            if(level.equalsIgnoreCase("hard"))
                playGame(hardPool);

            System.out.println("Would you like to play again? (Yes/No)");
            String replay = scanner2.nextLine();

            if (replay.equalsIgnoreCase("no"))
            {
                System.out.println("Okay! Bubye! Thanks for playing!!");
                break;
            }
            }
        }
    }
}