import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main player class.
 * 
 * @Chandler Clarke 
 * @Version 1.0
 */
public class Player extends Actor
{
    //Variables
    public boolean paused;
    public int playerX;
    public int playerY;
    public boolean hasSword = false;
    public int score;
    public int counter;

    //Constructor
    public Player(){
        counter = 0;
    }
    //The main method
    public void act(){
        //Methods
        movementControls();
        collisionDetector();
        itemCollector();
    }
    //Moves the character around based on player input.        
    public void movementControls(){
        if (Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("A")) {
            setRotation(225);
            move (4);
            setRotation(45);
        }
        else if (Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("D")) {
            setRotation(315);
            move (4);
        }
        else if (Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("A")) {
            setRotation(135);
            move (4);
            setRotation(315);
        }
        else if (Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("D")) {
            setRotation(45);
            move (4);
        }
        else if (Greenfoot.isKeyDown("W")) {
            setRotation(270);
            move (4);
            setRotation(0);
        }
        else if (Greenfoot.isKeyDown("A")) {
            setRotation(180);
            move (4);
            setRotation(0);
        }
        else if (Greenfoot.isKeyDown("S")) {
            setRotation(90);
            move (4);
            setRotation(0);
        }
        else if (Greenfoot.isKeyDown("D")) {
            setRotation(0);
            move (4);
        }
    } 
    //Detects Collision
    public void collisionDetector(){
        //1x1 Barriers
        if (!getIntersectingObjects(RightBarrier.class).isEmpty()) move(-4);
        if (!getIntersectingObjects(LeftBarrier.class).isEmpty()) move(4);
        if (!getIntersectingObjects(BottomBarrier.class).isEmpty()){ 
            setRotation(270);
            move(4);
            setRotation(0);
        }   
        if (!getIntersectingObjects(TopBarrier.class).isEmpty()){
            setRotation(90);
            move(4);
            setRotation(0);
        }   
        //5x1 Barriers
        if (!getIntersectingObjects(LongWallRight.class).isEmpty()) move(-4);
        if (!getIntersectingObjects(LongWallLeft.class).isEmpty()) move(4);
        if (!getIntersectingObjects(LongWallBottom.class).isEmpty()){ 
            setRotation(270);
            move(4);
            setRotation(0);
        }   
        if (!getIntersectingObjects(LongWallTop.class).isEmpty()){
            setRotation(90);
            move(4);
            setRotation(0);
        }
    }
    //Collects Objects
    public boolean itemCollector(){
        if (isTouching(SwordItem.class)){
            removeTouching(SwordItem.class);
            hasSword = true;
            Sword Sword = new Sword();
            getWorld().addObject(Sword, getX(), getY());
        }
        return hasSword;
    }

    private void weaponDropper(){
        if (Greenfoot.isKeyDown("f")){
            removeTouching(Sword.class);
            SwordItem s = new SwordItem();
            getWorld().addObject(s, getX(), getY());
        }
    }

    public boolean counter(int delay){
        counter++;
        if (counter > 1000)
            counter = 500;
        if (counter > delay){
            counter = 0;
            return true;
        }
        return false;
    }
}

