package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 *
 * @author eduardo
 */
public class Transformer {

    private BufferedImage bufferImage;
    private Imagem imagem;
    
    public Transformer(Imagem imagem)
    {
        this.imagem = imagem;
    }

        
    public BufferedImage getPBImage()
    {        
        bufferImage = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_BYTE_GRAY);  
        for( int w = 0; w < imagem.getBufferedImage().getWidth(); w++ )
        {
            for( int h = 0; h < imagem.getBufferedImage().getHeight(); h++ )
            {
                bufferImage.setRGB(w, h, imagem.getBufferedImage().getRGB(w, h));
            }
        }

        
        return bufferImage;
    }
    
    
    public BufferedImage getResizedImage(BufferedImage originalImage, int width, int height)
    {
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, width, height, null);
	g.dispose();
        
        return resizedImage;
    }

    public BufferedImage getBufferedTrabalhoUm(int option)
    {
        Color pixel;
        BufferedImage bf = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_BYTE_GRAY);  

        for( int w = 0; w < imagem.getBufferedImage().getWidth(); w++ )
        {
            for( int h = 0; h < imagem.getBufferedImage().getHeight(); h++ )
            {
                switch(option)
                {
                    case 1:
                        pixel = getImageMoreThanMedia(imagem.getPixel(w, h));
                        break;
                    case 2:
                        pixel = getImageGreaterOrEqualThanModa(imagem.getPixel(w, h));
                        break;
                    case 3:
                        pixel = getImageGreaterOrEqualThanMediana(imagem.getPixel(w, h));
                        break;
                    case 4:
                        pixel = getImageLessThanMedia(imagem.getPixel(w, h));
                        break;
                    case 5:
                        pixel = getImageGreaterThenAndLessThan(imagem.getPixel(w, h));
                        break;
                    default:
                        pixel = new Color((int)imagem.getPixel(w, h),(int)imagem.getPixel(w, h),(int)imagem.getPixel(w, h));

                }
                bf.setRGB(w, h, pixel.getRGB());
            }
        }
        
        return bf;

    }
    
    
    // a) Valores maiores ou iguais a média recebem 200
    private Color getImageMoreThanMedia(double pixelValue)
    {
        if(pixelValue >= imagem.getMedia() )
        {
            return new Color(200, 200, 200);
        }
        else
        {
            return new Color((int)pixelValue, (int)pixelValue, (int)pixelValue);
        }

    }


    // b) Valores maiores ou iguais a moda recebem 200
    private Color getImageGreaterOrEqualThanModa( double pixelValue )
    {
        if(pixelValue >= imagem.getModa() )
        {
            return new Color(200, 200, 200);
        }
        else
        {
            return new Color((int)pixelValue, (int)pixelValue, (int)pixelValue);
        }
    }


    // c) Valores maiores ou iguais a mediana recebem 200.
    private Color getImageGreaterOrEqualThanMediana(double pixelValue)
    {
        if(pixelValue >= imagem.getMediana() )
        {
            return new Color(200,200,200);
        }
        else
        {
            return new Color((int)pixelValue, (int)pixelValue, (int)pixelValue);
        }
    }


    // d) Valores menores que a média recebem 50.
    private Color getImageLessThanMedia(double pixelValue)
    {

        if(pixelValue < imagem.getMedia() )
        {
            return new Color(50, 50, 50);
        }
        else
        {
            return new Color((int)pixelValue, (int)pixelValue, (int)pixelValue);
        }

    }


    // e) Valores maiores que a média recebem 255 e menores que a média recebem 0. 
    private Color getImageGreaterThenAndLessThan(double pixelValue)
    {

        if(pixelValue > imagem.getMedia() )
        {
            return new Color(255, 255, 255);
        }
        else if(pixelValue < imagem.getMedia())
        {
            return new Color(0, 0, 0);
        }
        else
        {
            return new Color((int)pixelValue, (int)pixelValue, (int)pixelValue);
        }

    }


    public BufferedImage getEspelhaImagem() 
    {
        BufferedImage imagemEspelhada = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        int[] invertida = imagem.getBufferedImage().getRGB(0, 0, imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), null, 0, imagem.getBufferedImage().getWidth());
        int aux = 0;
        
        for (int lin = 0; lin < imagem.getBufferedImage().getHeight(); lin++) 
        {
          aux = imagem.getBufferedImage().getWidth();
          for (int col = 0; col < imagem.getBufferedImage().getWidth(); col++) 
          {
              aux --;
              invertida[imagem.getBufferedImage().getWidth() * lin + col] = imagem.getPixelRGB(imagem.getBufferedImage().getWidth() * lin + aux);
          }
        }

        imagemEspelhada.setRGB(0, 0, imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), invertida, 0, imagem.getBufferedImage().getWidth());

        return imagemEspelhada;
    }

    
    public BufferedImage getRotatedImage(float angle) 
    {
        
        int width = imagem.getBufferedImage().getWidth();
        int height = imagem.getBufferedImage().getHeight();
        
    	BufferedImage imageR = new BufferedImage(width, height, imagem.getBufferedImage().getType());
    	int nbands = imageR.getSampleModel().getNumBands();
    	Raster inputRaster = imagem.getBufferedImage().getData();
    	int[] pixels = new int[nbands * width * height];
    	inputRaster.getPixels(0,0,width,height,pixels);
    	
    	double radianos = angle * Math.PI / 180;
    	double senoAngulo = Math.sin(radianos);
    	double cosenoAngulo = Math.cos(radianos);

        int halfWidth  = width / 2;
    	int halfHeight = height / 2;
    	
    	int newLin = 0;
    	int newCol = 0;
    	
    	int linMaisNegativa = 0;
    	int colMaisNegativa = 0;
    	
    	int linOffset = 0;
    	int colOffset = 0;
    	
    	// Verifica limites fora do canvas
    	
    	for(int h=0; h < height; h++)
        {
            for (int w=0; w < width; w++) 
            {
                 newLin = (int) 
                         (
                            ((w - halfWidth) * cosenoAngulo) 
                          + ((h - halfHeight) * senoAngulo)
                         ); 
                 
                 newCol = (int) 
                         (
                            ((h - halfHeight) * cosenoAngulo) 
                          - ((w - halfWidth) * senoAngulo)
                         );
                 
                 if ((newLin < 0) && (linMaisNegativa > newLin)) 
                 {
                    linMaisNegativa = newLin;
                 }
                         
                 if ((newCol < 0) && (colMaisNegativa > newCol)) 
                 {
                    colMaisNegativa = newCol;
                 }
            }
            
        }

    	// Ajusta offset
    	
    	linOffset = linMaisNegativa * -1;
        colOffset = colMaisNegativa * -1;
    	
    	// Multiplica as matrizes para obter a rota��o desejada
    	
    	for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++) 
            {
                int rgb = imagem.getBufferedImage().getRGB(h, w);

                newLin = (int) 
                        (
                             ((w - halfWidth) * cosenoAngulo) 
                           + ((h - halfHeight) * senoAngulo)
                        ); 
                newCol = (int) 
                        (
                            ((h-halfHeight)*cosenoAngulo) 
                          - ((w-halfWidth)*senoAngulo)
                        );
/*
                if (h == 0) 
                { 
                    System.out.println("Lin: " + h + " NewLin: " + newLin + " Col: " + w + " NewCol: " + newCol);
                }   
*/
                newLin = newLin + linOffset;
                newCol = newCol + colOffset;
                    
                if (newLin >= 0 && newLin <= width && newCol >= 0 && newCol <= height) 
                {
                    imageR.setRGB(newLin, newCol, rgb);
                }
            }
        
        }
        
        return imageR;
    }

    
    
    public BufferedImage getZoomImagem(double fator) 
    {
        double w, h;    
        BufferedImage zoomImage;
        
        int width  = imagem.getBufferedImage().getWidth();
        int height = imagem.getBufferedImage().getHeight();
        
        if (fator == 0) 
        {
            w = width;
            h = height;
            
            zoomImage = new BufferedImage((int)w, (int)h, imagem.getBufferedImage().getType());
            for (int y = 0; y < h; ++y)
            {
                for (int x = 0; x < w; ++x)
                {
                    zoomImage.setRGB(x, y, imagem.getBufferedImage().getRGB(x, y));
                }
            }
        } 
        else if (fator > 0) 
        {
            w = (int) (fator * width);
            h = (int) (fator * height);
            
            zoomImage = new BufferedImage((int)w, (int)h, imagem.getBufferedImage().getType());
            for (int y=0; y < h; ++y)
            {
                for (int x=0; x < w; ++x)
                {
                    zoomImage.setRGB(x, y, imagem.getBufferedImage().getRGB((int)(x/fator), (int)(y/fator)));
                }
            }
        } 
        else 
        {
            w = (width / fator) * -1;
            h = (height / fator) * -1 ;
            
            zoomImage = new BufferedImage((int)w, (int)h, imagem.getBufferedImage().getType());
            
            for (int y=0; y < h; ++y)
            {
                for (int x=0; x < w; ++x)
                {
                    zoomImage.setRGB(x, y, imagem.getBufferedImage().getRGB(((int)(x * fator) * -1), ((int)(y * fator) * -1)));
                }
            }
        }
        
        return zoomImage;
    }
    
}
