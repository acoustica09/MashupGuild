import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The weapon's path
 * 
 * @author Chandler Clarke 
 * @version 1.0
 */
public class SwordAttack extends Sword{
    //Variables
    private boolean hasOriented;
    //Methods
    public SwordAttack(){
        score = 0;
    }

    public void act(){
        if (hasOriented == false){
            swordLocator();
        }
        swordPath();
    }
    //Finds player location
    private void swordLocator(){
        int swordX = ((Sword) getWorld().getObjects(Sword.class).get(0)).getX();
        int swordY = ((Sword) getWorld().getObjects(Sword.class).get(0)).getY();
        setLocation(swordX, swordY);
        hasOriented = true;
    }
    //Moves sword Projectile
    private void swordPath(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        turnTowards(mouse.getX(), mouse.getY());
        move(70);
        Greenfoot.delay(1);
        monsterKiller();
        getWorld().removeObject(this);
    }
    //Kills monsters
    private void monsterKiller(){
        if (isTouching(null)){
            removeTouching(null);
            MyWorld w = (MyWorld)getWorld();
            w.addScore(10);
        }
    }

}
