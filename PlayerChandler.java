import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main player class.
 * 
 * @Chandler Clarke 
 * @Version 1.0
 */
public class PlayerChandler extends Actor
{
    //Variables
    public int playerX, playerY, score, counter;
    public static int SPEED;
    public boolean hasSword, paused = false;
    //Constructor
    public PlayerChandler(){
        SPEED = 4;
        counter = 0;
    }
    //The main method
    public void act(){
        //Methods
        movementControls();
        itemCollector();
    }
    //Moves the character around based on player input.        
    public void movementControls(){
        if (Greenfoot.isKeyDown("W")) {
            setLocation(getX(), getY()-SPEED);
        }
        if (Greenfoot.isKeyDown("A")) {
            setLocation(getX()-SPEED, getY());
        }
        if (Greenfoot.isKeyDown("S")) {
            setLocation(getX(), getY()+SPEED);
        }
        if (Greenfoot.isKeyDown("D")) {
            setLocation(getX()+SPEED, getY());
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

