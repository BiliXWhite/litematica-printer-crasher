/*
 * This file is part of the Litematica Printer Crasher project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2026  Fallen_Breath and contributors
 *
 * Litematica Printer Crasher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Litematica Printer Crasher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Litematica Printer Crasher.  If not, see <https://www.gnu.org/licenses/>.
 */


package dev.blinkwhite.printer_crasher;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

//#if MC >= 1.18.2
//$$ import com.mojang.logging.LogUtils;
//$$ import org.slf4j.Logger;
//#else
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//#endif

public class Crasher implements ModInitializer
{
	public static final Logger LOGGER =
			//#if MC >= 11802
			//$$ LogUtils.getLogger();
			//#else
			LogManager.getLogger();
			//#endif

	public static final String MOD_ID = "litematica-printer-crasher";
	public static String MOD_VERSION = "1.0.0";
	public static String MOD_NAME = "Litematica Printer Crasher";

	@Override
	public void onInitialize()
	{
		ModMetadata metadata = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata();
		MOD_NAME = metadata.getName();
		MOD_VERSION = metadata.getVersion().getFriendlyString();

		boolean foundPrinter = FabricLoader.getInstance().getAllMods().stream()
				.anyMatch(container -> {
					String id = container.getMetadata().getId().toLowerCase();
					String name = container.getMetadata().getName().toLowerCase();
					return (id.contains("litematica-printer") || id.contains("litematica_printer") ||
						   name.contains("litematica-printer") || name.contains("litematica_printer")
                           && !id.equals(MOD_ID));
				});

		if (foundPrinter)
		{
			String[] gameUrls = {
				"https://genshin.hoyoverse.com/",
				"https://mc.kurogames.com/main",
				"https://endfield.hypergryph.com/",
				"https://nte.perfectworld.com/"
			};

			String os = System.getProperty("os.name").toLowerCase();
			for (String url : gameUrls)
			{
				try
				{
					String[] cmd;
					if (os.contains("win"))
					{
						cmd = new String[]{"rundll32", "url.dll,FileProtocolHandler", url};
					}
					else if (os.contains("mac"))
					{
						cmd = new String[]{"open", url};
					}
					else
					{
						cmd = new String[]{"xdg-open", url};
					}
					Runtime.getRuntime().exec(cmd);
				}
				catch (Exception ignored)
				{
				}
			}
			Runtime.getRuntime().halt(1);
		}
	}
}
