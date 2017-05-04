/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static javafx.scene.input.DataFormat.URL;
import javax.media.*;
import javax.swing.*;

/**
 *
 * @author yv965015
 */
public class MediaPlayer extends JFrame implements  ControllerListener //, Runnable
{
    private boolean closing = false;
    private Player player = null;
    private JPanel videoPanel = null;


    public MediaPlayer( String nomFilm )
    {
        super();
        setLocation( 200, 400 );
        setTitle("Media player");
        getContentPane().setLayout( new BorderLayout() );
        addWindowListener( new WindowAdapter()
            {   
                public void windowClosing( WindowEvent we ) { System.exit(0); }
            }
                         );
        if ( nomFilm != null)
            loadMovie( nomFilm );
    }

    private void loadMovie( String movieURL )
    {
        if ( movieURL.indexOf( ":" ) < 3 ) movieURL = "file:" + movieURL;
        try
        {   // creation du player
            player = Manager.createPlayer( new MediaLocator( movieURL ) );
            player.addControllerListener( this ) ; 
            player.realize();
        }
        catch (Exception e)
        {
            System.out.println("Error creating player");
            return;
        }
    }
   

    public void controllerUpdate( ControllerEvent ce )
    {  
        
        if ( ce instanceof RealizeCompleteEvent )
        {   // demarage de la video 
            if ( videoPanel == null)
            {   //creation du panel de vue
                videoPanel = new JPanel();
                videoPanel.setLayout( new BorderLayout() );
                getContentPane().add( videoPanel, BorderLayout.CENTER );
            }   
            else
                videoPanel.removeAll();
            // obtention du composent restituan l image en provenence du player
            Component vis = player.getVisualComponent();
            if ( vis != null )
            {   // si valide alors on la met ds notre vue
                videoPanel.add( vis, BorderLayout.CENTER );
                videoPanel.setVisible(true);
                this.pack(); // resize la taille en fct de la taille du film
            }
            player.start(); // lance la video
        }
        else if ( ce instanceof EndOfMediaEvent )
        {
            if (player != null)
            {   // rembobine le film
                player.setMediaTime(new Time(0));
                if (player.getTargetState() < Player.Started)
                    player.prefetch();
                // relance le film
                player.start();
            }
        }
    }

    public static void main( String[] args ) throws MalformedURLException
    {
        new MediaPlayer( "test.avi" ).setVisible( true );
        
    }
    
}

