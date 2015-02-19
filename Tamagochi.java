//Esta es la primera versión del JFrame del Tamgochi (falta algo de estética, cosa que checaré mñn) /* Este es el JFrame de Tamagochi */

package tamagochi; import java.awt.; import java.awt.event.; import javax.swing.; import javax.swing.event.; import com.sun.j3d.utils.geometry.; import com.sun.j3d.utils.universe.; import com.sun.j3d.utils.image.; import javax.media.j3d.; import javax.vecmath.; /* *

@author Yareli Avilés */ 

public class Tamagochi extends Frame {

  private Canvas3D canvas3D;
  private Appearance ap;
  private Texture feliz, enfermo;
  private static Texture texture;
  private TextureLoader loader;

  private JPanel jpB;
          private JPanel jpL;
          private JPanel jpPb;
          private JPanel jpL1;


  private JButton bcomer; //comer
  private JLabel lhambre; 
  private JButton bdormir; //dormir
  private JLabel lsueno;
  private JButton bjugar; //jugar
  private JLabel lEnergia;
          private JLabel mensaje;

  private JProgressBar PbSuenio = new JProgressBar(); //pb1
  private JProgressBar PbHambre = new JProgressBar(); //pb2
  private JProgressBar PbEnergia = new JProgressBar(); //pb3


  static Sphere sphere;


  public Tamagochi() {

      super("Tamagochi 3D");


      setResizable(false); setSize(1300, 1500);
      GraphicsConfiguration config =     
      SimpleUniverse.getPreferredConfiguration();
      canvas3D = new Canvas3D(config);
                  canvas3D.setBounds(100, 100, 500, 500);


      bcomer=new JButton("Comer");
                  bcomer.setBounds(300, 200, 50, 50);
                  lhambre=new JLabel("Hambre");

      bdormir=new JButton("Dormir");
                  bdormir.setBounds(300, 200, 50, 50);
      lsueno=new JLabel("Sueno");

      bjugar=new JButton("Jugar");
                  bjugar.setBounds(300, 200, 50, 50);
      lEnergia=new JLabel("Aburrimiento");

                  mensaje = new JLabel("Hola, soy Rayman");
                  mensaje.setBounds(1000, 500, 50, 50);



      jpB = new JPanel();
                  jpL = new JPanel();
                  jpL1 = new JPanel();

      jpL.add(lhambre); jpL.add(PbSuenio);
      jpB.add(bcomer);

      jpL.add(lsueno); jpL.add(PbHambre);
      jpB.add(bdormir);

      jpL.add(lEnergia); jpL.add(PbEnergia);
      jpB.add(bjugar);
                  jpL1.add(mensaje);




                  add("North", jpL);
                  add("Center", jpB);
                  add("East", jpL1);
                  add("South",canvas3D);
      setup3DGraphics();
      setVisible(true);

  }

  void setup3DGraphics() {

      DirectionalLight light1;
      SimpleUniverse universe = new SimpleUniverse(canvas3D);
      BranchGroup group = new BranchGroup();
      int primflags = Primitive.GENERATE_NORMALS +
      Primitive.GENERATE_TEXTURE_COORDS/*+Primitive.ENABLE_APPEARANCE_MODIFY*/ ; 

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
