/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import model.Transformer;
import model.Imagem;
import view.Main;

/**
 *
 * @author eduardo
 */
public class MainController {
    // private File arqImagem;
    private Main view;
    private Imagem imagem;
    private Transformer transformer;
    
    public MainController(Main view, File arqImagem)
    {
        this.view   = view;
        this.imagem = new Imagem(arqImagem);
        this.transformer = new Transformer(this.imagem);

        view.fieldImagePath.setText(arqImagem.getAbsolutePath());

        setValues();
        
        setOriginalImage();
        
        setPBImage();
    }

    private void setValues() 
    {        
        view.lblModa.setText(String.valueOf(imagem.getModa()));
        view.lblVariancia.setText(String.valueOf(imagem.getVariancia()));
        view.lblMedia.setText(String.valueOf(imagem.getMedia()));
        view.lblMediana.setText(String.valueOf(imagem.getMediana()));
    }

    private void setOriginalImage() 
    {
        BufferedImage bf = transformer.getResizedImage(imagem.getBufferedImage(), view.lblResizebleImage.getWidth(), view.lblResizebleImage.getHeight());

        bf = transformer.getResizedImage(imagem.getBufferedImage(), view.lblResizebleImage.getWidth(), view.lblResizebleImage.getHeight());
        view.lblResizebleImage.setIcon( new ImageIcon(bf) );
    }
    
    
    private void setPBImage() 
    {
        setProcessedImage(transformer.getPBImage());
    }
    
    public void transformTrabalhoUm( int option )
    {
        setProcessedImage(transformer.getBufferedTrabalhoUm(option));
    }
    
    public void transformEspelhada()
    {
        setProcessedImage(transformer.getEspelhaImagem());
    }
    
    public void transformZoom(double fator)
    {
        if( fator == 0 )
        {
           setProcessedImage(imagem.getBufferedImage());
           return;
        }
        System.out.println(fator);
        BufferedImage bf = transformer.getZoomImagem(fator);
        view.lblProcessedImage.setIcon(new ImageIcon(bf));
    }
    
    public void transformTrabalhoDois(float value)
    {
        setProcessedImage(transformer.getRotatedImage(value));
    }    
    
    private void setProcessedImage(BufferedImage processedImage)
    {
        view.lblProcessedImage.setIcon(new ImageIcon(transformer.getResizedImage( processedImage, view.panelProcessedImage.getWidth() - 23, view.panelProcessedImage.getHeight() - 23) ));
    }
    
    public Imagem getImagem()
    {
        return imagem;
    }
    
}
