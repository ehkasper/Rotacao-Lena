/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author eduardo
 */
public class OriginalImage extends JFrame {
    
    public OriginalImage(BufferedImage imagem)
    {
        int width  = imagem.getWidth();
        int height = imagem.getHeight();

        setTitle("Imagem Original");
        setBounds(0, 0, width, height);

        Container content = getContentPane();
        JLabel lblImagem = new JLabel(new ImageIcon(imagem));
        lblImagem.setBounds(0, 0, width, height);
        content.add(lblImagem);

        
        setLayout(null);

        setLocationRelativeTo(null);
        
        setResizable( false );
        setVisible( true );
        setDefaultCloseOperation( HIDE_ON_CLOSE );

    }
    
}
