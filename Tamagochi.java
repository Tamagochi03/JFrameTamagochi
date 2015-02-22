 /*
 *Este es el JFrame de Tamagochi 
 */

package tamagochi; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*; 
import com.sun.j3d.utils.geometry.*; 
import com.sun.j3d.utils.universe.*; 
import com.sun.j3d.utils.image.*; 
import javax.media.j3d.*; 
import javax.vecmath.*;


/* *
@author Yareli Avilés 
*/ 

public class Tamagochi extends Frame {

  private Canvas3D canvas3D;
  private Appearance ap;
  private Texture feliz, enfermo;
  private static Texture texture;
  private TextureLoader loader;
  
  
  /**Declaración de Paneles*/
  
  private JPanel jpB;
  private JPanel jpL;
  private JPanel jpPb;
  private JPanel jpL1;
  private JPanel jpE;

  
  /**Declaración de Botones y etiquetas*/
  
  private JButton bcomer; //Boton de comer
  private JLabel lhambre; 
  private JButton bdormir; //Boton de dormir
  private JLabel lsueno;
  private JButton bjugar; //Boton de jugar
  private JLabel lAburrimiento;
  private JLabel lEnergia;
  private JLabel mensaje;
  
  
  /**Declaración de Barras de progreso*/
  
  private JProgressBar PbSuenio; 
  private JProgressBar PbHambre; 
  private JProgressBar PbAburrimiento; 
  private JProgressBar PbEnergia; 


  static Sphere sphere;


  public Tamagochi() {

      super("Tamagochi 3D");


      setResizable(false); 
      setSize(900, 600);
      setLocationRelativeTo(null);
      GraphicsConfiguration config =     
      SimpleUniverse.getPreferredConfiguration();
      


      /**Inicialización de Variables*/
      
      canvas3D = new Canvas3D(config);
      canvas3D.setSize(500, 00);
      
      bcomer=new JButton("Comer");
      lhambre=new JLabel("Hambre");

      bdormir=new JButton("Dormir");
      lsueno=new JLabel("Sueno");

      bjugar=new JButton("Jugar");
      lAburrimiento = new JLabel("Aburrimiento");
      lEnergia=new JLabel("Energía");

      mensaje = new JLabel("Hola, soy Rayman");
                  
      PbSuenio = new JProgressBar();
      PbHambre = new JProgressBar();
      PbAburrimiento = new JProgressBar();
      PbEnergia = new JProgressBar();

      

      jpB = new JPanel();
      jpL = new JPanel();
      jpL1 = new JPanel();
      jpE = new JPanel();

      jpL.add(lhambre); jpL.add(PbSuenio);
      jpB.add(bcomer);

      jpL.add(lsueno); jpL.add(PbHambre);
      jpB.add(bdormir);

      jpL.add(lAburrimiento); jpL.add(PbAburrimiento);
      jpB.add(bjugar);
      jpE.add(lEnergia);
      jpE.add(PbEnergia);
      jpL1.add(mensaje);




      add("North", jpL);
      add("East", jpB);
      add("Center", jpL1);
      add("West",canvas3D);
      add("South", jpE);
     
      setup3DGraphics();
      setVisible(true);

  }

  void setup3DGraphics() {

      DirectionalLight light1;
      SimpleUniverse universe = new SimpleUniverse(canvas3D);
      BranchGroup group = new BranchGroup();
      int primflags = Primitive.GENERATE_NORMALS +
      Primitive.GENERATE_TEXTURE_COORDS/*+Primitive.ENABLE_APPEARANCE_MODIFY */; 

          //ap.setTextureUnitState(textureUnitState);  
      sphere = new Sphere(0.5f, primflags, ap);
      sphere.setCapability(Primitive.ENABLE_APPEARANCE_MODIFY); 
      ap = sphere.getAppearance();
      ap.setCapability(Appearance.ALLOW_TEXTURE_ATTRIBUTES_WRITE);
          ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
          ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);
          group.addChild(sphere);
      universe.getViewingPlatform().setNominalViewingTransform();
      universe.addBranchGraph(group);
  }


  public static void main(String[] args) { 

      new Tamagochi();


  }


      public void windowClosing(WindowEvent e) { 

          System.exit(0); 
      }
}
