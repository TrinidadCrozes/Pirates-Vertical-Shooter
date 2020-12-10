package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 * Clase que modela y muestra un splash screen.
 */
@SuppressWarnings("serial")
public class SplashScreen extends JWindow {
    private int duration;
    private JLabel jLabelTitle;
    
    /**
     * Constructor del splash screen.
     * @param d Duración del splash screen.
     */
    public SplashScreen(int d) {
        duration = d;
    }

    /**
     * Modela y muestra el splash screen.
     */
    public void showSplash() {
        this.setLocationByPlatform(true);

        JPanel content = (JPanel)getContentPane();
        content.setBackground(new java.awt.Color(191,191,191));
        content.setLayout(null);
        JLabel label = new JLabel();

         //Definimos las coordenadas de la ventana y la centramos en la pantalla.
         int width = 450;
         int height = 115;
         Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
         int x = (screen.width-width)/2;
         int y = (screen.height-height)/2;
         this.setBounds(x, y, 915, 460);

         //Construye el splash screen.
         jLabelTitle = new JLabel();
         content.add(jLabelTitle, "Center");
         jLabelTitle.setText("Pirate's Vertical Shooter");
         jLabelTitle.setFont(new java.awt.Font("Ubuntu",0,30));
         jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
         jLabelTitle.setForeground(new java.awt.Color(255,165,0));
         jLabelTitle.setBounds(0, 298, 437, 157);
   
         label.setIcon(new ImageIcon(this.getClass().getResource("/IMG/splash.jpg")));
         content.add(label, BorderLayout.WEST);
         label.setBounds(0, 1, 915, 458);

         //Muestra el splash screen.
         setVisible(true);

         //Espera un rato, este tiempo se emplea en cargar recursos.
         try { Thread.sleep(duration); } catch (Exception e) {}

         setVisible(false);
         getContentPane().setBackground(new java.awt.Color(0,0,0));
         this.setOpacity(0.0f);
         content.add(label, "West");
    }
    
    /**
     * Muestra el splash screen.
     */
    public void showSplashAndExit() {
        showSplash();
    }
}
