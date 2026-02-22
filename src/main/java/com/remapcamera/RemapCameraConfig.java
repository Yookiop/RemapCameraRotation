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
		name = "Remap Camera Rotate",
		description = "When enabled, holding the Camera Rotate Key simulates middle mouse button to rotate the camera.",
		section = cameraSection
	)
	default boolean cameraRotateRemap()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "cameraRotateKey",
		name = "Camera Rotate Key",
		description = "Hold this key while moving the mouse to rotate the camera (simulates middle mouse button / scroll wheel click).",
		section = cameraSection
	)
	default ModifierlessKeybind cameraRotateKey()
	{
		return new ModifierlessKeybind(KeyEvent.VK_UNDEFINED, 0);
	}
}
