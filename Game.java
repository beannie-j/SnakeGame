import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Application m_Application;
    private Apple apple;
    private Snake head;
    
    private Font font;

    private List<Snake> tails;
    private final int length = 4;
    private static int points = 0;

    public Game() {
        apple = new Apple(0, 0, 15);
        apple.setRandomPosition();
        
        head = new Snake(Application.width / 2, Application.height / 2, 10);

        float posX = head.getX() - 12;
        float posY = head.getY();

        tails = new ArrayList<Snake>();  
        tails.add(head);

        for(int i = 1; i < length; i++) {
            Snake e = new Snake((int)posX, (int)posY, 10);
            posX -= 12;
            tails.add(e);
            System.out.println("tails # "  + i + " " + (int)tails.get(i).getX() +  ", " + (int)tails.get(i).getY());
        }
    }

    public void render(Graphics g) {
        apple.DrawApple(g);
        head.DrawRect(g);
        head.checkBounds();


        font = new Font("Verdana", Font.BOLD, 12);
        g.setColor(Color.YELLOW);
        g.setFont(font);
        String score = "APPLES: " + points;
        g.drawString(score, Application.width/2, 20);
       
        for(Snake e : tails) {
            e.DrawRect(g);
        }
    }

    public void update(float ts) {
        Keyboard keyboard = m_Application.GetKeyboard();
        // float speed = 100 * ts;

        float speed = 12.0f;
        float tempX = head.getX();
        float tempY = head.getY();

        System.out.println("head # " + (int)head.getX() + " , " + (int)head.getY());
        System.out.println("speed " + speed);

        if(keyboard.right) {
            head.move(speed, 0);
        }

        if(keyboard.left) {
            head.move(-speed, 0);
        }

        if(keyboard.up) {
            head.move(0, -speed);

        }

        if(keyboard.down) {
            head.move(0, speed);
        }

        if(head.collision(apple)) {
            apple.setRandomPosition();
            points++;
        }
        if(head.getX() != tempX || head.getY() != tempY) {
            System.out.println("Head has moved x : " + head.getX() + " , " + tempX + " y: " + head.getY() + " , " + tempY);

            for(int i = tails.size() - 1; i > 1; i--) {
                System.out.println("tails # "  + i + " " + tails.get(i).getX() + " --> " + tails.get(i-1).getX() + ", " + tails.get(i).getY() + " --> " + tails.get(i-1).getY());

                tails.get(i).setPosition(tails.get(i - 1).getX(), tails.get(i - 1).getY());
            }
            tails.get(1).setPosition(tempX, tempY);
        }
       
    }

    public void setApplication(Application app) {
		m_Application = app;
	}

}