import java.awt.*;

public class Apple extends Entity {
    
    public Apple() {
        super();
    }

    public Apple(int x, int y, int size) {
        super(x, y, size);
    }

    public void DrawApple(Graphics g) {
        g.setColor(Color.RED);
        int radius = 15;
        g.fillOval((int)getRectangle().x, (int)getRectangle().y, radius, radius);
        DrawLeaf(g, (int)getRectangle().x + (radius/4), (int)getRectangle().y - (radius/4));
        // System.out.println("Apple x " + getRectangle().x + " y " + getRectangle().y);
    }

    private void DrawLeaf(Graphics g, int x, int y) {
        g.setColor(Color.green);
        g.fillOval(x, y, 10, 10);
    }

}