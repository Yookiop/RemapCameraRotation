package com.remapcamera;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Remap camera rotation",
	description = "Simulates middle mouse button for camera rotation using a configurable key",
	tags = {"camera", "rotate", "middle mouse"}
)
public class RemapCameraPlugin extends Plugin
{
	@Inject
	private KeyManager keyManager;

	@Inject
	private RemapCameraListener inputListener;

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	@Provides
	RemapCameraConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RemapCameraConfig.class);
	}
}
