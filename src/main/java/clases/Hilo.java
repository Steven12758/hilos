package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Hilo implements Runnable {

    private JPanel panel;
    private Color color;
    private int time;
    private int pos_eje_y;
    private int pos_eje_x;
    private String[] instructions;

    public Hilo(JPanel panel, int time, String[] instructions, int position) {
        this.panel = panel;
        this.time = time;
        this.instructions = instructions;
        this.pos_eje_x = 50;
        this.pos_eje_y = position;
    }

    @Override
    public void run() {
        for (int i = 0; i < instructions.length; i++) {
            try {
                Thread.sleep(time);
                if (i <= 4) {
                    color = Color.ORANGE;
                } else if (i >= 5 & i <= 7) {
                    color = Color.GRAY;
                } else {
                    color = Color.GREEN;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            draw_line(panel.getGraphics());
            draw_processes(panel.getGraphics(), pos_eje_x, pos_eje_y, instructions[i], color);
            pos_eje_x += 100;
        }
    }

    public void draw_line(Graphics g) {
        int pos_x = 90;
        g.setColor(Color.BLACK);
        //eje X
        g.drawLine(0, 210, 1340, 210);
        int i = 0;
        while (i < 13) {
            g.drawString("" + (i + 1), (pos_x), 230);
            pos_x += 100;
            i++;
        }
        //eje Y
        g.drawLine(30, 10, 30, 250);
        g.drawString("1", 15, 40);
        g.drawString("2", 15, 110);
        g.drawString("3", 15, 180);
    }

    public void draw_processes(Graphics g, int x, int y, String inst, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 95, 40);
        g.setColor(Color.BLACK);
        g.drawString(inst, x + 4, y + 25);
    }
}
