package udemy.java_multithreading_concurrency.section4.Optimization;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Optimizing latency (time to perform a task).
 *
 * In this example we optimize the time it takes to perform a task, in this case image processing, by rendering
 *  different sectors of an image in parallel.
 *
 *  Remember that this only makes sense if the task is big enough that offsets the overhead of having multi-threads
 *  (in this case if the image is big enough, otherwise we might notice the single threaded runs are more effective)
 *   and if the number of threads is at most the number of cores we have available so that they run effectively in parallel.
 */
public class ImgProcessing
{
    public static final String SOURCE = "./rsc/img/in3.jpg";
    public static final String DEST   = "./rsc/img/out3-neg.jpg";

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedImage original = ImageIO.read(new File(SOURCE));
        BufferedImage result = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);

        long start = System.currentTimeMillis();
        //paintSingleThreaded(original, result);
        paintMultiThreaded(original, result,4);
        long end = System.currentTimeMillis();

        File file = new File(DEST);
        ImageIO.write(result, "jpg", file);

        System.out.println("Processing time: "+(end-start));
    }

    public static void paintSingleThreaded(BufferedImage orig, BufferedImage res){
        paint(orig, res, 0, 0, orig.getWidth(), orig.getHeight(),true);
    }

    public static void paintMultiThreaded(BufferedImage orig, BufferedImage res, int number_of_threads) throws InterruptedException{
        List<Thread> threads = new ArrayList<>();
        int width = orig.getWidth();
        int height = orig.getHeight() / number_of_threads;

        for(int i=0; i < number_of_threads; i++){
            final int thread_multiplier = i;        //vars used in lambdas should be final
            //final boolean flag = i%2 == 0;

            Thread thread = new Thread(()->{
                int left = 0;
                int top = height * thread_multiplier;

                paint(orig, res, left, top, width, height, true);
            });

            threads.add(thread);
        }

        for(Thread t : threads){
            t.start();
            t.join();
        }
    }


    public static void paint(BufferedImage orig, BufferedImage res, int left, int top, int width, int height, boolean flag)
    {
        for(int x = left; x < left+width && x < orig.getWidth(); x++){
            for(int y = top; y < top+height && y < orig.getHeight(); y++){
                recolorPixel(orig.getRGB(x,y), res, x, y,flag);
            }
        }
    }

    public static void recolorPixel(int pixel, BufferedImage result, int x, int y, boolean flag)
    {
        int red = getRed(pixel);
        int green = getGreen(pixel);
        int blue = getBlue(pixel);

        int resRed, resGreen, resBlue;

        if(/*isShadeOfGray(red,green,blue,66)*/flag){
            /*//yellow
            resRed = Math.min(255, red+25);
            resGreen = Math.min(255, green+10);
            resBlue = Math.max(0, blue-20);*/
            //lila
            /*resRed = Math.min(255, red+10);
            resGreen = Math.max(0, green-80);
            resBlue = Math.max(0, blue-20);*/
            //black&white
            /*int avg = (red+green+blue) / 3;
            resRed = avg;
            resGreen = avg;
            resBlue = avg;*/
            //negative
            resRed = 255-red;
            resGreen = 255-red;
            resBlue = 255-red;
        } else {
            resRed = red;
            resGreen = green;
            resBlue = blue;
        }

        result.getRaster().setDataElements(x,y,result.getColorModel().getDataElements( createRGB(resRed,resGreen,resBlue), null ));
    }

    public static boolean isShadeOfGray(int r, int g, int b, int range)
    {
        return Math.abs(r-g) < range  &&  Math.abs(r-b) < range  &&  Math.abs(g-b) < range;
    }

    public static int createRGB(int r, int g, int b)
    {
        int rgb = 0;

        rgb |= b;
        rgb |= g << 8;
        rgb |= r << 16;

        rgb |= 0xFF000000;

        return rgb;
    }

    public static int getRed(int rgb)
    {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb)
    {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb)
    {
        return rgb & 0x000000FF;
    }
}
