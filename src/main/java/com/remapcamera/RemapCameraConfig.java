package com.remapcamera;

import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.config.Range;

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
		description = "When enabled, holding the camera rotating key and moving the mouse will rotate the camera.",
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
		description = "Hold this key while moving the mouse to rotate the camera.",
		section = cameraSection
	)
	default ModifierlessKeybind cameraRotateKey()
	{
		return new ModifierlessKeybind(KeyEvent.VK_UNDEFINED, 0);
	}

	@Range(min = 1, max = 10)
	@ConfigItem(
		position = 3,
		keyName = "cameraSensitivity",
		name = "Camera sensitivity",
		description = "How many yaw/pitch units to move per pixel of mouse movement (1 = slow, 10 = fast).",
		section = cameraSection
	)
	default int cameraSensitivity()
	{
		return 3;
	}
}
