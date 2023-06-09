package org.valkyrienskies.mechanica;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.mechanica.platform.SharedValues;

public class MechanicaMod {
    public static final String MOD_ID = "mechanica";

    // versioning
    public static final int BUILD_VERSION = 1;
    public static final int NETWORK_VERSION = 1;
    public static final String NETWORK_VERSION_STR = String.valueOf(NETWORK_VERSION);

    public static final ResourceLocation NETWORK_CHANNEL = MechanicaMod.asResource("main");


    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MechanicaMod.MOD_ID);
    public static final CreativeModeTab BASE_CREATIVE_TAB = SharedValues.creativeTab();
    public static final Logger MIXIN_LOGGER = LoggerFactory.getLogger("VSCreateMixins");
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        MechanicaContraptions.init();
        MechanicaPackets.init();
    }

    public static void initClient() {


    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
