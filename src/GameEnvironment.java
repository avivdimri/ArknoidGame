import java.util.ArrayList;
import java.util.List;

/**
 * 206322406.
 * The GameEnvironment class specifies a collection collidables,
 * in the game's environment.
 */
public class GameEnvironment {
    // fields
    private List<Collidable> collidables;

    /**
     * The constructor create a new List of collidables.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * The function add the given collidable to the environment.
     *
     * @param c given collidable.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * The function remove the given collidable to the environment.
     *
     * @param c given collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * The function assume an object moving on the trajectory given and
     * check if this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory trajectory given.
     * @return , if exist collision, the information about the closest collision,otherwise null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> collidablesCopy = new ArrayList<>(this.collidables);
        if (collidablesCopy.isEmpty()) {
            //there isn't collision
            return null;
        }
        CollisionInfo closestColl = null;
        double min = trajectory.start().distance(trajectory.end());
        // go over the collection of collidable.
        for (Collidable c : collidablesCopy) {
            // check intersection point with the collidable.
            Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (p != null) {
                // check is the collision closest
                if (trajectory.start().distance(p) < min) {
                    // update information about the closest collision
                    closestColl = new CollisionInfo(p, c);
                    min = trajectory.start().distance(p);
                }
            }
        }
        return closestColl;
    }
}