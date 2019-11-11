import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Snelheid
    int speed = 3;
    int time = 0;
    WeaponButton weaponButton;
    PowerUp powerUp;
    int powerTimer;
    //Speler en Wapen
    public Player()
    {
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.WHITE);
        getImage().fillOval(0, 0, 50, 50);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 20, 70, 10);
    }
    public Player(WeaponButton weaponButton, PowerUp powerUp)
    {
        this.powerUp = powerUp;
        this.weaponButton = weaponButton;
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.WHITE);
        getImage().fillOval(0, 0, 50, 50);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 20, 70, 10);
    }
    //Movement en Shieten                  
    public void act() 
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        powerUpUsed();
        hitByZombie();
    }    
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() != null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX() + speed, getY());
    }
    //Wapen + Upgrades
    public void fireProjectile()
    {
            if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 1){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
            Greenfoot.playSound("Shot.wav");
           }  
              if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 2){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(20);
            Greenfoot.playSound("Shot.wav");
           }  
           if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 3){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(20);
            Greenfoot.playSound("Shot.wav");
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Greenfoot.playSound("Shot.wav");
           }  
    }
    //PowerUp 
    public void powerUpUsed()
    {
        if(powerUp.powerCount > 99 && powerTimer < 30)
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Projectile projectile1 = new Projectile();
            getWorld().addObject(projectile1, getX(), getY());
            projectile1.setRotation(getRotation() - 180);
            projectile1.move(20);
            Projectile projectile21 = new Projectile();
            getWorld().addObject(projectile21, getX(), getY());
            projectile21.setRotation(getRotation() + 120);
            projectile21.move(20);
            Projectile projectile31 = new Projectile();
            getWorld().addObject(projectile31, getX(), getY());
            projectile31.setRotation(getRotation() - 120);
            projectile31.move(20);
            Greenfoot.playSound("Shot.wav");
            powerTimer++;
        }
        if(powerTimer>29)
        {
            powerUp.powerCount = 0;
            powerTimer = 0;
        }
    }
    //Hits
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0,0, Zombie.class);
        if(zombie!=null)
        {
            return true;
        }
        else
        return false;
    }
}


