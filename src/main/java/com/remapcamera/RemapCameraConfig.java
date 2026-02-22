package com.remapcamera;

import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ModifierlessKeybind;

@ConfigGroup("remapCamera")
public interface RemapCameraConfig extends Config
{
	@ConfigSection(
		name = "Camera Remapping",
		description = "Settings for remapping the camera",
		position = 0
	)
	String cameraSection = "camera";

	@ConfigItem(
		position = 1,
		keyName = "cameraRotateRemap",
		name = "Remap camera rotating key",
		description = "When enabled, holding the camera rotating key simulates the middle mouse button to rotate the camera when moving the mouse.",
		section = cameraSection
	)
	default boolean cameraRotateRemap()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "cameraRotateKey",
		name = "Camera rotating key",
		description = "Hold this key while moving the mouse to rotate the camera (simulates middle mouse button / scroll wheel click).",
		section = cameraSection
	)
	default ModifierlessKeybind cameraRotateKey()
	{
		return new ModifierlessKeybind(KeyEvent.VK_UNDEFINED, 0);
	}
}
