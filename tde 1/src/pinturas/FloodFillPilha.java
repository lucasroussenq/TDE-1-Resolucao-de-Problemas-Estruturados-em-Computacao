package pinturas;

import estruturas.PilhaSimples;
import modelo.Imagens;
import modelo.Point;
import modelo.Frames;

import java.awt.image.BufferedImage;

public class FloodFillPilha implements FloodFill {
    @Override
    public void preencher(BufferedImage img, int x0, int y0, int novaCor) {
        if (!Imagens.dentro(img, x0, y0)) return;

        int alvo = img.getRGB(x0, y0);
        if (alvo == novaCor) return;

        PilhaSimples<Point> s = new PilhaSimples<>();
        s.empilha(new Point(x0, y0));

        while (!s.vazia()) {
            Point p = s.desempilha();
            int x = p.x(), y = p.y();

            if (!Imagens.dentro(img, x, y)) continue;
            if (img.getRGB(x, y) != alvo) continue;

            img.setRGB(x, y, novaCor);
            Frames.onPaint(img); // <<< registra frame

            s.empilha(new Point(x+1, y));
            s.empilha(new Point(x-1, y));
            s.empilha(new Point(x, y+1));
            s.empilha(new Point(x, y-1));
        }
    }
}
