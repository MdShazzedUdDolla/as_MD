import java.text.*;
import java.util.Scanner;

public class ProjectileMotionSimulation
{

    public static void main (String [] args)
    {
        // constants 
        final double GRAVITY = 9.81; // force of gravity in m/sec/sec
        final int TICKS_PER_SECOND = 100; // time intervals per second
        final double DELTA_T = 1.0 / TICKS_PER_SECOND; // interval 

        // variables
        double initVelocity;    // projectile's initial velocity (m/s)
        double velocity;        // projectile's current velocity (m/s)
        double height = 0.0;    // current height of the projectile
        double formulaHeight;   // height computed from physics formula
        double maxHeight = 0.0; // max height reached so far
        double time = 0.0;      // elapsed (simulation) time
        int tickCount = 0;      // time tick count
        
        Scanner kbd = new Scanner(System.in);
        System.out.print("Projectile's initial velocity? ");
        initVelocity = kbd.nextDouble();
        velocity = initVelocity;
        
        // Print table headers
        System.out.println();
        System.out.printf ("%7s %14s %14s %14s\n", "Time(s)","Vel(m/s)", 
                            "Height(sim)", "Height(formula)");
        System.out.println ("======= ============== ============== ==============");

        // Adjust values for each interval until the ball hits the ground
        while (height >= 0.0)
        {       

            // Only print a snapshot every second
            if (tickCount % TICKS_PER_SECOND == 0)
            {
                // For each second, display simulated height and velocity, 
                // along with the height calculated via the physics formula.   
                formulaHeight = initVelocity * time - 0.5 * GRAVITY * Math.pow(time,2);
                System.out.printf ("%7d %14.3f %14.3f %14.3f\n", 
                                    (int)time, velocity, height, formulaHeight);
            }

            // Adjust time 
            time = time + DELTA_T;

            // Compute new height based on existing velocity
            height = height + (velocity * DELTA_T);

            // Is this heigher than the highest so far?
            if (height > maxHeight)
            {
                maxHeight = height;
            }

            // Compute new velocity for next interval
            velocity = velocity - (GRAVITY * DELTA_T);

            tickCount++;                      
        } // end while
        System.out.printf("\nMaximum height achieved was: %.3f meters.\n", maxHeight);

    }
}
