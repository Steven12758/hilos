package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author steven
 */
public class Hilo extends Thread {

    private final JPanel panel;
    private Color color;
    private final int time;
    private final int y;
    private final String[] instructions;
    private final String processor;

    public Hilo(int time, JPanel panel, int y, String[] instructions, String processor) {
        this.time = time;
        this.panel = panel;
        this.instructions = instructions;
        this.processor = processor;
        this.y = y;
    }

    public void run() {
        int x = 50;
        for (int i = 0; i < instructions.length; i++) {
            try {
                Thread.sleep(time);
                if (i <= 4) {
                    color = Color.ORANGE;
                } else if (i == 5 & i <= 7) {
                    color = Color.GRAY;
                } else if (i == 8) {
                    color = Color.GREEN;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            graficar_ciclos(panel.getGraphics(), x, y, instructions[i], color, processor);
            x += 100;
        }
    }

    public void graficar_ciclos(Graphics g, int x, int y, String name, Color color, String processor) {
        Font title = new Font("Serif", Font.BOLD, 11);
        g.setColor(color);
        g.fillRect(x, y, 90, 40);
        g.setColor(Color.white);
        g.drawLine(30, 10, 30, 250);
        g.drawLine(0, 210, x + 90, 210);
        g.drawString(name, x + 4, y + 25);
        g.setFont(title);
        g.drawString(processor, x + 5, y - 5);
    }
}
