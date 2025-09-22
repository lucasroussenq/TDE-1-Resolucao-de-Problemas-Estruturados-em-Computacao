package modelo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public final class Frames {
    private static String pasta = "out/anim";
    private static int k = 1;          // salva a cada k pixels
    private static int pintados = 0;
    private static int idx = 0;
    private static int maxFrames = 20; // <<< limite de 20 imagens

    private Frames(){}

    // Config por quantidade-alvo (numFrames) baseado no tamanho da imagem
    public static void configTargetFrames(String pastaOut, BufferedImage img, int numFrames){
        pasta = pastaOut;
        int total = img.getWidth() * img.getHeight();
        k = Math.max(1, total / Math.max(1, numFrames));
        maxFrames = numFrames;
        iniciar();
    }

    private static void iniciar(){
        pintados = 0;
        idx = 0;
        new File(pasta).mkdirs();
    }

    public static void onPaint(BufferedImage img){
        pintados++;
        if (pintados % k == 0 && idx < maxFrames){
            try {
                ImageIO.write(img, "png",
                    new File(String.format("%s/frame_%02d.png", pasta, idx++)));
            } catch (Exception ignored) {}
        }
    }

    public static void finish(BufferedImage img){
        try {
            ImageIO.write(img, "png", new File(pasta + "/final.png"));
        } catch (Exception ignored) {}
    }
}
