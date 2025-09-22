// codigo para compilar javac -encoding UTF-8 -d out src/app/*.java src/modelo/*.java src/estruturas/*.java src/pinturas/*.java
//codigo para executar java -cp out app.Main
//codigo para limpar o out rmdir /s /q out mkdir out





package app;

import modelo.Imagens;
import modelo.Frames;
import pinturas.FloodFill;
import pinturas.FloodFillFila;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) throws Exception {
        String entrada = "in/mapa.png";
        String saida   = "out/final.png";

        int x = 12, y = 12; 
        
        int novaCor = 0xFFFF0000; //outras cores para poder testar na hora da autoria 0xFF00FF00; verde 0xFF0000FF; azul  0xFFFFFF00; amarelo0xFFFF00FF; magenta  0xFF00FFFF; ciano

        BufferedImage img = Imagens.ler(entrada);

        

Frames.configTargetFrames("out/anim", img, 20);

        FloodFill f = new FloodFillFila(); 
        f.preencher(img, x, y, novaCor);

     
        Imagens.salvar(img, saida);
        Frames.finish(img);

        System.out.println("ok: " + saida + "  | frames em out/anim/");
    }
}
