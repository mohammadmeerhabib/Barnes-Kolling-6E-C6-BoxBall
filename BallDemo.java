import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;
    Random random;
    ArrayList<Color> colors;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        random = new Random();
        colors = new ArrayList<>();
        makeColorsArray();
    }
    /**
     * makeColorsArray populates ArrayList with color to randomly choose from
     */
    public void makeColorsArray()
    {
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.CYAN);
        colors.add(Color.PINK);
    }
    /**
     * getRandomColor gets random color from color ArrayList
     * @param none
     * @return none
     */
    public Color getRandomColor()
    {
        return colors.get(random.nextInt(colors.size()));
        
    }/**
     * simulate a ball in a box, which is from min to max
     */
    public void boxBounce(int min, int max, int dia, int moves, int balls)
    {
        myCanvas.setVisible(true);
        myCanvas.setForegroundColor(Color.BLACK);
        int move = 0;
        myCanvas.drawLine(min, min, max, min);
        myCanvas.drawLine(max, min, max, max);
        myCanvas.drawLine(max, max, min, max);
        myCanvas.drawLine(min, max, min, min);
        ArrayList<BoxBall> ballList = new ArrayList<>();
        for (int i = 0; i < balls ; i++) {
            BoxBall aBoxBall = new BoxBall((random.nextInt((max-dia)-min+1)+min),
                ((random.nextInt((max-dia)-min+1)+min)) ,dia, getRandomColor(), myCanvas);
            ballList.add(aBoxBall);
            aBoxBall.draw();
        }
        
        while ( move < moves) {
            myCanvas.wait(10);
            for ( BoxBall aBoxBall : ballList) {
                aBoxBall.move(min, max , dia);
                move++;
            }
            
        }
        myCanvas.wait(500);
        for (BoxBall aBoxBall : ballList) {
            aBoxBall.erase();
        }
        //aBoxBall.erase();
    }
    /**
     * Simulate two bouncing balls
     */
    public void bounce(int balls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);
        ArrayList<BouncingBall> ballList = new ArrayList<>();
        // create and show the balls
        for (int i=0; i< balls ; i++){
            int x = random.nextInt(150);
            int y = random.nextInt(150);
            int z = random.nextInt ((20-(10+1)+10));
            BouncingBall newBall = new BouncingBall(x,y,z, Color.BLUE, ground, myCanvas);
            ballList.add (newBall);
            newBall.draw();
        /*BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();*/
        }
        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            /*ball.move();
            ball2.move();*/
            for (BouncingBall ball : ballList) {
                ball.move();
            }
            // stop once ball has travelled a certain distance on x axis
            for (BouncingBall ball : ballList) {
                if(ball.getXPosition() >= 550) {
                finished = true;
                }
            }
        }
    }
}
