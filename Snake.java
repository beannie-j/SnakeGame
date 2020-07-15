import java.awt.*;

public class Snake extends Entity {

    public Snake() {
        super();
    }

    public Snake(int x, int y, int size) {
        super(x, y, size);
    }

    public void DrawRect(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int)getRectangle().x, (int)getRectangle().y, (int)getRectangle().width, (int)getRectangle().height);
        // System.out.println("Rectangle x " + getRectangle().x + " y " + getRectangle().y);
    }

    
}