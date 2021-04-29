/**
 * 206322406.
 * CollisionInfo class specifies the information about collision.
 * it holds the point at which the collision occurs,and collidable object involved in the collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * The constructor gets point and collidable and set collisionInfo.
     *
     * @param p          collision's point.
     * @param collidable collision's object.
     */
    public CollisionInfo(Point p, Collidable collidable) {
       collisionObject = collidable;
       collisionPoint = p;
    }

    /**
     * The function return the point at which the collision occurs.
     *
     * @return collision's point.
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * The function return the collidable object involved in the collision.
     *
     * @return collision's object.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}