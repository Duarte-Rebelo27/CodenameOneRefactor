package com.codename1.samples;

import com.codename1.io.Log;
import com.codename1.ui.ButtonGroup;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Component;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.RadioButton;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.GeneralPath;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class FillShapeTest {
    public void init(Object context) {
        
        updateNetworkThreadCount(2);



    }
    private RadioButton drawPathBtn, drawStringBtn;
    public void start() {
        Form f = new Form("Test Fill Shape");
        f.setLayout(BorderLayout.center());
        ButtonGroup bg = new ButtonGroup();
        drawStringBtn = RadioButton.createToggle("String", bg);
        drawPathBtn = RadioButton.createToggle("Path", bg);
        f.add(BorderLayout.CENTER, new DrawingCanvas());
        f.add(BorderLayout.NORTH, GridLayout.encloseIn(drawStringBtn, drawPathBtn));
        
        f.show();
    }
    
    public void stop(){
        
    }
    
    public void destroy(){
        
    }
    public class DrawingCanvas extends Component {
        Point center = new Point(0, 0);
        GeneralPath p = new GeneralPath();
        {
            p.arc(center.getX(), center.getY(), 100, 100, 0, 360);
        }
        Font f = Font.getDefaultFont();
        
        @Override
        public void paint(Graphics g) {
            //Log.p("Painting ", Log.INFO);
            g.setColor(0xff0000);
            //GeneralPath p = new GeneralPath();
            //p.arc(center.getX(), center.getY(), 100, 100, 0, 360);
            int tx = center.getX() - p.getBounds().getWidth()/2;
            int ty = center.getY() - p.getBounds().getHeight()/2;
            g.translate(tx, ty);
            if (drawPathBtn.isSelected()) {
                g.fillShape(p);
            } else {
                g.setFont(f);
                g.drawString("hello", 0, 0);
            }
            g.translate(-tx, -ty);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(getParent().getWidth(), getParent().getHeight());
        }

        
        
        

        @Override
        public void pointerPressed(int x, int y) {
            //Log.p("Pointer pressed ", Log.INFO);
           center.setX(x);
           center.setY(y);
           getParent().repaint();
           repaint();
        }

        @Override
        public void pointerDragged(int x, int y) {
            center.setX(x);
           center.setY(y);
           repaint();
        }

        @Override
        public void pointerReleased(int x, int y) {
            center.setX(x);
           center.setY(y);
           repaint();
        }
        
        
    }
}
