import java.awt.event.*;

public class Keyboard implements KeyListener {

    public boolean left, right, up, down = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }
    
}