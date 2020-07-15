import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Entity {
    private Rectangle2D.Float rectangle;
    private Random rand = new Random();


    public Entity() {
        rectangle = new Rectangle2D.Float(0, 0, 0, 0);
    }

    public Entity(int x, int y, int size) {
        rectangle = new Rectangle2D.Float(x, y, size, size);
    }

    public void setX(int x) { rectangle.x = x;}
    public void setY(int y) { rectangle.y = y;}

    public float getX() { return rectangle.x; };
    public float getY() { return rectangle.y; };


    public void setRandomPosition() {
    	setX(rand.nextInt(Application.width - 20));
    	setY(rand.nextInt(Application.height - 20));
    }

    public void setPosition(float x, float y) {
        rectangle.x = x;
        rectangle.y = y;
    }

    public void move(float dx, float dy) {
        rectangle.x += dx;
        rectangle.y += dy;
    }

    public boolean collision(Entity e) {
        return rectangle.intersects(e.rectangle);
    }

    public Rectangle2D.Float getRectangle() {
        return rectangle;
    }

    public void checkBounds() {
        if(rectangle.x > 680) {
            rectangle.x -= rectangle.width;
        }

        if(rectangle.y  > 343) {
            rectangle.y -= rectangle.width;
        }

        if(rectangle.x <= 0) {
            rectangle.x += rectangle.width;
        }

        if(rectangle.y <= 0) {
            rectangle.y += rectangle.width;
        }
    }
    
}