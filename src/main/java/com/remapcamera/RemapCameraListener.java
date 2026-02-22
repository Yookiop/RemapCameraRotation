package com.remapcamera;

import java.awt.Canvas;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.client.input.KeyListener;

public class RemapCameraListener implements KeyListener
{
	@Inject
	private RemapCameraConfig config;

	@Inject
	private Client client;

	private boolean cameraRotateKeyPressed = false;

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (config.cameraRotateRemap() && config.cameraRotateKey().matches(e))
		{
			if (!cameraRotateKeyPressed)
			{
				cameraRotateKeyPressed = true;
				injectMouseButton(MouseEvent.MOUSE_PRESSED, MouseEvent.BUTTON2);
			}
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (config.cameraRotateRemap() && cameraRotateKeyPressed && config.cameraRotateKey().matches(e))
		{
			cameraRotateKeyPressed = false;
			injectMouseButton(MouseEvent.MOUSE_RELEASED, MouseEvent.BUTTON2);
			e.consume();
		}
	}

	private void injectMouseButton(int eventType, int button)
	{
		Canvas canvas = client.getCanvas();
		if (canvas == null)
		{
			return;
		}
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, canvas);
		MouseEvent mouseEvent = new MouseEvent(
			canvas,
			eventType,
			System.currentTimeMillis(),
			0,
			p.x,
			p.y,
			1,
			false,
			button
		);
		canvas.dispatchEvent(mouseEvent);
	}
}
