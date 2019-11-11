import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    final int POWER_UP_LIMIT = 100;
    int powerCount;
    int count;
    public PowerUp()
    {
        setImage(new GreenfootImage(POWER_UP_LIMIT + 2, 12));
        getImage().drawRect(0,0,POWER_UP_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,powerCount,10);
    }
    public void act() 
    {
        setImage(new GreenfootImage(POWER_UP_LIMIT + 2, 12));
        getImage().drawRect(0,0,POWER_UP_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,powerCount,10);
         World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX() + 10 ,myWorld.getPlayer().getY() - 80); 
        usePower();
    }
    public void usePower()
    {
        count++;
        if(count % 5 == 0)
        powerCount++;
     }
}
