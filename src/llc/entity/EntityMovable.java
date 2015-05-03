package llc.entity;

import java.util.List;

import llc.logic.Player;
import de.teamdna.databundle.DataBundle;

/**
 * Base class for movable entities.
 * @author MaxiHoeve14
 */
public abstract class EntityMovable extends Entity {

	public EntityMovable(float x, float y, int health) {
		super(x, y, health);
	}

	public EntityMovable(DataBundle data, List<Player> players) {
		super(data, players);
	}

	public EntityMovable(float x, float y) {
		super(x, y);
	}
	
	private float moveSpeed = 1;
	private int moveRange = 8;

	/**
	 * Gets the {@link EntityMoveable} move speed.
	 * @return Move Speed
	 */
	public float getMoveSpeed() {
		return moveSpeed;
	}

	/**
	 * Sets the {@link EntityMoveable} move speed.
	 * @param moveSpeed The move speed (Standard is 1)
	 */
	public void setMoveSpeed(float moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	/**
	 * Gets the {@link EntityMoveable} move range.
	 * @return Move range
	 */
	public float getMoveRange() {
		return moveRange;
	}

	/**
	 * Sets the {@link EntityMoveable} move range.
	 * @param moveRange The move range (Standard is 4)
	 */
	public void setMoveRange(int moveRange) {
		this.moveRange = moveRange;
	}
	
	/**
	 * Checks if the {@link Cell} is in range of the entity
	 * @param x X coord
	 * @param y y coord
	 * @return If the entity is in range
	 */
	public boolean isCellInRange(int x, int y) {
		return Math.abs(x - this.x) + Math.abs(y - this.y) <= this.getMoveRange();
	}
}
