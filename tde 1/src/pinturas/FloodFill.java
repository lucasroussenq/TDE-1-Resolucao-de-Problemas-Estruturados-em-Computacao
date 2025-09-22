package pinturas;

import java.awt.image.BufferedImage;

public interface FloodFill {
    void preencher(BufferedImage img, int x0, int y0, int novaCor);
}
