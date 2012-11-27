fractal
=======

Renderiza "floco de neve" de Koch (fractal recursivo).
Baseado no exemplo encontrado no site: http://www.horstmann.com/ccj/labs/ccj_ch11.html

algoritmo
=========

O desenho é feito recursivamente, seguindo uma linguagem de script
primitiva, que consiste de comandos:

 * F: move a "pena" para frente
 * -: vira a "pena" 60 graus no sentido anti-horário
 * +: vira a "pena" 60 graus no sentido horário

Esse é um script que desenha triângulo, que serve de base para o fractal:

    String path = "F--F--F--";

Cada aresta do triângulo será substituida pelo código que desenha outro triângulo:

    String replacementRule = "F+F--F+F";

compilando/executando
=====================

    $ javac fractal.java
    $ java fractal
