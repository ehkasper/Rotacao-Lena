package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import javax.imageio.ImageIO;

public class Imagem {

    private File image;
    
    private BufferedImage bufferedImage;
    private double imagePixel[][];
    private int imagePixelRGB[];
    private double histograma[] = new double[256];
    private double imagePixelInline[];
    private int media;
    private double mediana;
    private int moda;
    private int variancia;
    private boolean grayScale;
    
    public Imagem(File image)
    {
        this.image = image;
        
        setBufferedImage();
        
        grayScale = grayScale();
        
        build();
        
    }

    private boolean grayScale() 
    {
        
        for (int w = 0; w < bufferedImage.getWidth(); w++) 
        {
            for (int h = 0; h < bufferedImage.getHeight(); h++) 
            {
                Color c = new Color(bufferedImage.getRGB(w, h));
                if( (c.getRed() == c.getBlue() && c.getRed() == c.getGreen()) == false) 
                {
                    return false;
                }
            }
        }
        
        return true;
    }

    private void setBufferedImage()
    {
        BufferedImage buffered = null;
        try 
        {
            buffered = ImageIO.read(this.image);
        } catch( IOException e ) {
            System.out.println(e.getMessage());
        }
        
        imagePixelRGB      = buffered.getRGB(0, 0, buffered.getWidth(), buffered.getHeight(), null, 0, buffered.getWidth());
        this.bufferedImage = buffered;
    }	
    
    private void build()
    {
        imagePixelInline = new double[bufferedImage.getWidth() * bufferedImage.getHeight()];
        imagePixel       = new double[bufferedImage.getWidth()][bufferedImage.getHeight()];
        int i = 0;

        try 
        {
            Raster raster = bufferedImage.getRaster();

            for (int w = 0; w < bufferedImage.getWidth(); w++) 
            {
                for (int h = 0; h < bufferedImage.getHeight(); h++) 
                {
                    if( grayScale == false )
                    {
                        int[] pixel = new int[3];
                        for (int k = 0; k < 3; k++) 
                        {
                            pixel[k] = raster.getSample(w, h, k);
                        }
                        imagePixel[w][h] = getPixelPB(pixel);
                    }
                    else
                    {
                        imagePixel[w][h] = raster.getSample(w, h, 0);
                    }
                    
                    imagePixelInline[i++] = imagePixel[w][h];				
                }
            }

        } catch( Exception e )
        {
            System.out.println(e.getMessage());
        }
        
        makeHistograma();
        makeMedia();
        makeMediana();
        makeModa();
        makeVariancia();
    }

    private void makeHistograma() 
    {
        for (int w = 0; w < bufferedImage.getWidth(); w++) 
        {
            for (int h = 0; h < bufferedImage.getHeight(); h++) 
            {
                histograma[(int)imagePixel[w][h]]++;
            }
        }

    }


    private void makeMedia() 
    {
        int somaPixels = 0;

        for (int w = 0; w < bufferedImage.getWidth(); w++) 
        {
            for (int h = 0; h < bufferedImage.getHeight(); h++) 
            {
                somaPixels += imagePixel[w][h];
            }
        }

        media = somaPixels/( bufferedImage.getWidth() * bufferedImage.getHeight() );
    }


    private void makeMediana() 
    {
        double arrAux[] = imagePixelInline;

        Arrays.sort( arrAux );
        mediana = arrAux[arrAux.length / 2];
    }


    private void makeModa() 
    {
        double aux = 0;
        for (int i = 0; i < this.histograma.length; i++) 
        {
            if (this.histograma[i] > aux)
            {
                aux = this.histograma[i];
                this.moda = i;
            }
        }
    }

    private void makeVariancia() 
    {
        int s = 0;

        for (int i = 0; i < imagePixelInline.length; i++) 
        {
            s += (imagePixelInline[i] - media) * (imagePixelInline[i] - media);
        }

        variancia = s / (bufferedImage.getWidth() * bufferedImage.getWidth());
    }	

    public int getCountPixelsLessThan(int pixelValue) 
    {
        int s = 0;

        for (int i = 0; i < imagePixelInline.length; i++) 
        {
            if( imagePixelInline[i] < pixelValue )
            {
                s++;
            }
        }

        return s;
    }	


    public int getCountPixelsGreaterThan(int pixelValue) 
    {
        int s = 0;

        for (int i = 0; i < imagePixelInline.length; i++) 
        {
            if( imagePixelInline[i] > pixelValue )
            {
                s++;
            }
        }

        return s;
    }	


    public int getMedia()
    {
        return media;
    }


    public int getModa()
    {
        return moda;
    }

    public int getMediana()
    {
        return (int)mediana;
    }

    public int getVariancia()
    {
        return variancia;
    }	


    public double getPixel(int x, int y)
    {
        return imagePixel[x][y];
    }

    public double[] getImagePixelInline()
    {
        return imagePixelInline;
    }

    public double[] getHistograma()
    {
        return histograma;
    }

    public BufferedImage getBufferedImage()
    {
        return bufferedImage;
    }
    
    public boolean getGrayScale()
    {
        return grayScale;
    }
    
    public int getPixelRGB(int index)
    {
        return imagePixelRGB[index];
    }
    	
    public static int getPixelPB(int[] vetRGB)
    {
        long px;
    
        px = Math.round((0.3 * vetRGB[0]) + (0.59 * vetRGB[1]) + (0.11 * vetRGB[2]));
        
        return (int) px;
    }


}
