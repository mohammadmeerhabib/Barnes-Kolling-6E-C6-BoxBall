import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * BoxBall class take parameters and draws, moves and erases the ball within given confines.
 * Ball bounces at the confines.
 * @author M M Habib
 * @version 20231227
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private int ballDegradation =2;
    private Ellipse2D.Double ballCircle;
    private int ySpeed = 1;
    private int xSpeed = 1;
    private int xPosition;
    private int yPosition;
    private int diameter;
    private ArrayList<Color> ballColors;
    private Canvas aCanvas;
    private boolean finish;
    private Random random;
    private Color color;

    /**
     * Constructor makes BoxBall object as per parameters
     * @param are (int position x axis, int postion y axis, int diameter, int bottom of
     * container, int top of container, int left of contianer, int right of container,
     * Color object of ball, Canvas object of ball).
     * @return none
     */
    public BoxBall(int xPos, int yPos, int dia, Color col, Canvas
    can)
    {
        xPosition = xPos;
        yPosition = yPos;
        diameter = dia;
        aCanvas = can;
        finish = false;
        color = col;
        random = new Random();
    }
    
    /*
     * finishes animation if parameter is true
     * @param boolean
     * @return none
     */
    public void finish(boolean end)
    {
        finish = end;
    }
    
    /**
     *draw method draws the ball as per parameters of the constructor method
     *@param none
     *@return none
     */
    public void draw()
    {
        aCanvas.setForegroundColor(color);
        aCanvas.fillCircle(xPosition, yPosition, diameter);
        
    }
    /**
     * erase method erases the ball
     * @param none
     * @return none
     */
    public void erase()
    {
        aCanvas.eraseCircle(xPosition, yPosition, diameter);
    }
    /**
     * move method
     * @param
     * @return
     */
    public void move(int min, int max, int dia)
    {
        erase();
        xPosition += xSpeed;
        yPosition += ySpeed;
        if ((xPosition <= (min)) || (xPosition >= (max-dia))){
                xSpeed = - (xSpeed);
        }
        if ((yPosition <= (min)) || (yPosition >= (max-dia))) {
                ySpeed = - (ySpeed);
        }
        draw();
            
        
    }
    /**
     * getXPosition method returns current position on X axis
     * @param none
     * @return int X position
     */
    public int getXPosition()
    {
        return xPosition;
    }
    /**
     * getYPosition method returns current position of ball on Y axis
     * @param none
     * @return int Y position
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
