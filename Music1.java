import java.applet.*;

import java.awt.*;
import java.awt.event.*;

public class Music extends Applet implements ActionListener{
Button play,stop;
AudioClip audioClip;

    @Override
public void init(){
play = new Button(" Play in Loop ");
add(play);
play.addActionListener(this);
stop = new Button(" Stop ");
add(stop);
stop.addActionListener(this);
audioClip = getAudioClip(getCodeBase(), "Fast1.mp3");
}

public void actionPerformed(ActionEvent ae){
Button source = (Button)ae.getSource();
String s;
s=source.getLabel();
if (s.equals( " Play in Loop ")){
audioClip.play();
}
else if(s.equals(" Stop ")){
audioClip.stop();
}
}
}

