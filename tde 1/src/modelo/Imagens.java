package modelo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public final class Imagens {
    private Imagens(){}

    public static BufferedImage ler(String caminho) throws Exception {
        return ImageIO.read(new File(caminho));
    }

    public static void salvar(BufferedImage img, String caminho) throws Exception {
        File f = new File(caminho);
        File dir = f.getParentFile();
        if (dir != null) dir.mkdirs();
        ImageIO.write(img, "png", f);
    }

    public static boolean dentro(BufferedImage img, int x, int y){
        return x >= 0 && y >= 0 && x < img.getWidth() && y < img.getHeight();
    }
}
