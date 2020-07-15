import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Application extends Canvas {
	private static final long serialVersionUID = 1L;

    public static final int width = 700;
    public static final int height = width / 16 * 9;
    private JFrame frame;
    private Keyboard keyboard;

    private boolean m_Running = false;
    private Game m_Game;

    public Application(Game game) {
        frame = new JFrame();
        frame.setTitle("Game");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(this);
        frame.pack();
        frame.setSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        m_Game = game;
        m_Game.setApplication(this);
    }

    public Keyboard GetKeyboard() {
        return keyboard;
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();

        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);

        m_Game.render(g);

        g.dispose();
        bs.show();
    }

    public void update(float ts) {
    	m_Game.update(ts);
    }

    public void Run() {
        m_Running = true;
        Long lastTime = System.nanoTime();

        while (m_Running) {
            Long now = System.nanoTime();
            //time step - how much time has passed since last time. 

            // 1 second = 1_000_000_000 nano seconds
            float ts = (now - lastTime) * 0.001f * 0.001f * 0.001f;
            //float ts = (now - lastTime) * 0.000000001f;

            // System.out.println("ts " + ts);
            lastTime = now;

            update(ts);
            render();

            try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }

    
}