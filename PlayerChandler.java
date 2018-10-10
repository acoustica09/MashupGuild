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
    public int playerX, playerY, score, counter, imageUpdateTimer, aniTimer, collectorTimer, dropCooldown;
    public static int SPEED, ANIMATIONCOUNT;
    public boolean hasSword, paused = false;

    private String playerImages[] =
        {"manWalk1", "manWalk2"};

    //Constructor
    public PlayerChandler(){
        SPEED = 4;
        ANIMATIONCOUNT = 2;
        aniTimer = 14;
        counter = 0;
    }
    //The main method
    public void act(){
        //Methods
        movementControls();
        itemCollector();
        itemDropper();
        collectorTimer++;
    }
    //Moves the character around based on player input.        
    public void movementControls(){
        if (Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("A")) {
            setRotation(225);
            move (4);
            setRotation(45);
            updateImage();
        }
        else if (Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("D")) {
            setRotation(315);
            move (4);
            updateImage();
        }
        else if (Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("A")) {
            setRotation(135);
            move (4);
            setRotation(315);
            updateImage();
        }
        else if (Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("D")) {
            setRotation(45);
            move (4);
            updateImage();
        }
        else if (Greenfoot.isKeyDown("W")) {
            setRotation(270);
            move (4);
            setRotation(0);
            updateImage();
        }
        else if (Greenfoot.isKeyDown("A")) {
            setRotation(180);
            move (4);
            setRotation(0);
            updateImage();
        }
        else if (Greenfoot.isKeyDown("S")) {
            setRotation(90);
            move (4);
            setRotation(0);
            updateImage();
        }
        else if (Greenfoot.isKeyDown("D")) {
            setRotation(0);
            move (4);
            updateImage();
        }
    } 
    //Collects Objects
    public boolean itemCollector(){
        if (isTouching(SwordItem.class) && collectorTimer >= 50){
            removeTouching(SwordItem.class);
            hasSword = true;
            Sword Sword = new Sword();
            getWorld().addObject(Sword, getX(), getY());
        }
        return hasSword;
    }

    private void itemDropper(){
        if (Greenfoot.isKeyDown("f") && dropCooldown >= 50){
            for (dropCooldown = 0; dropCooldown<2; dropCooldown++){
                SwordItem s = new SwordItem();
                getWorld().addObject(s, getX(), getY());
            }
            removeTouching(Sword.class);
            collectorTimer = 0;
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

    private void updateImage(){
        if (aniTimer >= 15){
            setImage(playerImages[ANIMATIONCOUNT] + ".png");
            ANIMATIONCOUNT++;
            aniTimer = 0;
        }
        if (ANIMATIONCOUNT >= 2)
            ANIMATIONCOUNT = 0;
        aniTimer++;
    }
}

