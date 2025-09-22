package pinturas;

import estruturas.FilaSimples;
import modelo.Imagens;
import modelo.Point;
import modelo.Frames;

import java.awt.image.BufferedImage;

public class FloodFillFila implements FloodFill {
    @Override
    public void preencher(BufferedImage img, int x0, int y0, int novaCor) {
        if (!Imagens.dentro(img, x0, y0)) return;

        int alvo = img.getRGB(x0, y0);
        if (alvo == novaCor) return;

        FilaSimples<Point> f = new FilaSimples<>();
        f.entra(new Point(x0, y0));

        while (!f.vazia()) {
            Point p = f.sai();
            int x = p.x(), y = p.y();

            if (!Imagens.dentro(img, x, y)) continue;
            if (img.getRGB(x, y) != alvo) continue;

            img.setRGB(x, y, novaCor);
            Frames.onPaint(img); // <<< registra frame de tempos em tempos

            // 4-vizinhos
            f.entra(new Point(x+1, y));
            f.entra(new Point(x-1, y));
            f.entra(new Point(x, y+1));
            f.entra(new Point(x, y-1));
        }
    }
}
