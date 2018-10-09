import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A rotatable weapon
 * 
 * @Chandler Clarke 
 * @Version 1.0
 */
public class Sword extends PlayerChandler
{
    /**  The sword
     * 
     */
    //Variables
    public int PlayerChandlerX;
    public int PlayerChandlerY;
    //Methods
    public void act() 
    {
        PlayerChandlerLocator();
        orientation();
        attack();
    }
    //Makes sword follow cursor
    public void orientation(){
        //From Greenfoot user "danpost".  Turns the sword towards the mouse.
        if (Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null)
            {
                turnTowards(mouse.getX(), mouse.getY());
            }
        }
    }
    //Finds PlayerChandler location
    public void PlayerChandlerLocator(){
        int PlayerChandlerX = ((PlayerChandler) getWorld().getObjects(PlayerChandler.class).get(0)).getX()+10;
        int PlayerChandlerY = ((PlayerChandler) getWorld().getObjects(PlayerChandler.class).get(0)).getY()+2;
        setLocation(PlayerChandlerX, PlayerChandlerY);
    }
    //Generates a Sword Attack
    public void attack(){
        if (Greenfoot.mouseClicked (null)){
            SwordAttack SwordAttack = new SwordAttack();
            getWorld().addObject(SwordAttack, getX(), getY());
        }
    }
}

