/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author eduardo
 */
public class Resize {
    
    public static BufferedImage resize(BufferedImage imagem, Integer imgLargura, Integer imgAltura) 
    {  
          
        Double novaImgLargura = (double) imagem.getWidth();  
        Double novaImgAltura = (double) imagem.getHeight();  
  
        Double imgProporcao;  
        if (novaImgLargura >= imgLargura) 
        { 
            imgProporcao = (novaImgAltura / novaImgLargura);  
            novaImgLargura = (double) imgLargura;  
            novaImgAltura = (novaImgLargura * imgProporcao);  
            while (novaImgAltura > imgAltura) 
            {  
                novaImgLargura = (double) (--imgLargura);  
                novaImgAltura = (novaImgLargura * imgProporcao);  
            }  
        } 
        else if (novaImgAltura >= imgAltura) 
        {  
            imgProporcao = (novaImgLargura / novaImgAltura);  
            novaImgAltura = (double) imgAltura;  
            while (novaImgLargura > imgLargura) {  
                novaImgAltura = (double) (--imgAltura);  
                novaImgLargura = (novaImgAltura * imgProporcao);  
            }  
        }  
        
        BufferedImage novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), imagem.getType());  
        
        Graphics g = novaImagem.getGraphics();  
        g.drawImage(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), Image.SCALE_SMOOTH), 0, 0, null);  
        g.dispose();  

        return novaImagem;  
    }  
    
}
