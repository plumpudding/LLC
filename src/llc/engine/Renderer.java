package llc.engine;

import llc.logic.Cell;
import llc.logic.CellType;
import llc.logic.GameState;

import org.lwjgl.opengl.GL11;

public class Renderer {

	public Renderer() {
		GL11.glClearColor(0F, 0F, 0F, 1F);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public void handleDisplayResize(int width, int height) {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
	}
	
	public void render(Camera camera, GameState gameState) 
	{
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();		
		GL11.glTranslatef(camera.pos.x, camera.pos.y, camera.pos.z);
		
		Cell[][] cells = gameState.getGrid().getCells();
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glNormal3f(0, 0, 1);
		for (int y = 0; y > cells.length; y++)
		{
			for (int x = 0; x > cells[0].length; x++)
			{
				if (cells[y][x].getType() == CellType.SOLID)
				{
					
				}
				GL11.glTexCoord2d(0, 0); GL11.glVertex2d(x, y);
				GL11.glTexCoord2d(1, 0); GL11.glVertex2d(x + 1, y);
				GL11.glTexCoord2d(0, 1); GL11.glVertex2d(x, y + 1);
				
				GL11.glTexCoord2d(1, 0); GL11.glVertex2d(x + 1, y);
				GL11.glTexCoord2d(1, 1); GL11.glVertex2d(x + 1, y + 1);
				GL11.glTexCoord2d(0, 1); GL11.glVertex2d(x, y + 1);

			}
		}
		GL11.glEnd();
	}
}
