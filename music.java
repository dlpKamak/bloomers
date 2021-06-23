import java.applet.AudioClip;
import java.awt.Button;
public class music extends java.applet.Applet {
   AudioClip audioClip;
   Button play, loop, stop;
   // Applet role
   public void init() {
      // Get sound.
      audioClip =  getAudioClip( getCodeBase(), "" );
      // Create GUI.
      add( play = new Button( "play" ) );
      add( loop = new Button( "loop" ) );
      add( stop = new Button( "stop" ) );
   }
   // Component role (1.02 event model)
   public boolean handleEvent( Event event ) {
      if ( event.target == play ) {
         audioClip.play();
         return true;
      }
      if ( event.target == loop ) {
         audioClip.loop();
         return true;
      }
      if ( event.target == stop ) {
         audioClip.stop();
         return true;
      }
      return super.handleEvent( event );
   }
}
