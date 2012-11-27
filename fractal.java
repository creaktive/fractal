/*
    baseado no exemplo encontrado no site:
    http://www.horstmann.com/ccj/labs/ccj_ch11.html
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fractal extends JFrame 
{
    public fractal()
    {
        super("Floco de neve de Koch (fractal recursivo)");
        setSize(640, 480);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        /*
            O desenho é feito recursivamente, seguindo uma linguagem de script
            primitiva, que consiste de comandos:

            F: move a "pena" para frente
            -: vira a "pena" 60 graus no sentido anti-horário
            +: vira a "pena" 60 graus no sentido horário
        */

        // esse é um triângulo, que serve de base para o fractal
        String path = "F--F--F--";
        // cada aresta do triângulo será substituida pelo código que desenha outro triângulo
        String replacementRule = "F+F--F+F";
        // ângulo de rotação da "pena"; 60 graus
        double turnAngle = Math.PI / 3;
        // quão fundo a recursão procede
        int degree = 3;

        // coordenadas iniciais da "pena"
        double start_x = 200;
        double start_y = 200;
        // rotação inicial da "pena"
        double direction = 0;
        // quantos pixels a "pena" anda
        double stepLength = 10;

        // variáveis internas
        int r;
        int i;
        String sub;

        // primeiro, cria um "script" com comandos para a "pena"
        for (r = 1; r <= degree; r++)
        {
            String newPath = "";
            for (i = 0; i < path.length(); i++)
            {
                sub = path.substring(i, i + 1);

                // conforme descrito acima, cada "F" será uma "subrotina"
                if (sub.equals("F"))
                    newPath = newPath + replacementRule;
                else 
                    newPath = newPath + sub; 
            }
            path = newPath;
        }

        // inicializa a "pena"
        super.paint(g);
        g.setColor(Color.black);

        // agora, interpreta o "script" e desenha o fractal com a "pena"
        for (i = 0; i < path.length(); i++)
        {
            sub = path.substring(i, i + 1);

            // desenha
            if (sub.equals("F"))
            {
                double x = start_x + Math.cos(direction) * stepLength;
                double y = start_y + Math.sin(direction) * stepLength;

                g.drawLine((int) (start_x), (int) (start_y), (int) (x), (int) (y));

                start_x = x;
                start_y = y;
            }
            // vira no sentido anti-horário
            else if (sub.equals("-"))
                direction += turnAngle;
            // vira no sentido horário
            else if (sub.equals("+"))
                direction -= turnAngle;
        }
    }

    public static void main(String args[]) 
    {
        fractal application = new fractal();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
