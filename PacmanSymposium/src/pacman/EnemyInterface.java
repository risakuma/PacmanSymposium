/**
 * 
 */
package pacman;

/**
 * @author Risa
 *
 */
public interface EnemyInterface {
	
	public boolean isEaten();
	public void setEaten(boolean b);
	public void backToBase(int x, int y);
}
