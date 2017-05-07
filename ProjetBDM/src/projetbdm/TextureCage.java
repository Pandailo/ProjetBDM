/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

/**
 *
 * @author Monsieur Blu
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class TextureCage extends JPanel {
 
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    File img = new File("Cage.png");
    try { 
        BufferedImage bi = ImageIO.read(img);
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 50, 62.5);
        g2d.setPaint(new TexturePaint(bi, rect));
        Rectangle2D rect2 = new  Rectangle2D.Double(0, 0, 3500, 3000);
        g2d.fill(rect2);

    } catch (IOException ex)
    {
          Logger.getLogger(TextureCage.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  public static void main(String args[]) {

  }
}
