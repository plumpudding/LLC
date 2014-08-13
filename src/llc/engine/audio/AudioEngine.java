package llc.engine.audio;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

public class AudioEngine {
	IntBuffer buffer = BufferUtils.createIntBuffer(1);
	IntBuffer source = BufferUtils.createIntBuffer(1);
	
	public static WaveData buttonClick;
	
	public AudioEngine() {
		
	}
	
	public void initAudioEngine() {
		loadSounds();
	}
	
	private void loadSounds() {
		AL10.alGenBuffers(buffer);
		//if(AL10.alGetError() != AL10.AL_NO_ERROR)
		
		buttonClick = WaveData.create("res/sound/buttonClick.wav");
		AL10.alBufferData(buffer.get(0), buttonClick.format, buttonClick.data, buttonClick.samplerate);
		buttonClick.dispose();
	}
	
	public void playSoundAt(Sounds sound, float x, float z, float playerX, float playerY, float playerZ) {
		FloatBuffer sourcePos = BufferUtils.createFloatBuffer(3).put(new float[] {x, playerY, z});
		FloatBuffer listenerPos = BufferUtils.createFloatBuffer(3).put(new float[] {playerX, playerY, playerZ});
	}
}
