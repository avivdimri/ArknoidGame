
/**
 * 206322406.
 * Collidable interface specifies things that can be collided with.
 */
public interface Collidable {
    /**
     * The function return the "collision shape" of the object.
     *
     * @return collision shape of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * The function notify the object that we collided with it
     * at collisionPoint with a given velocity.
     * it return a new velocity expected after the hit.
     *
     * @param hitter          ball which collide.
     * @param collisionPoint  collision's point.
     * @param currentVelocity velocity before the hit.
     * @return velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
