package org.valkyrienskies.vscreate.util.render;

import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import net.minecraft.client.resources.model.BakedModel;
import org.valkyrienskies.vscreate.VSCreateMod;

public abstract class VSCreateCustomRenderedItemModel extends CustomRenderedItemModel {
    public VSCreateCustomRenderedItemModel(BakedModel template, String basePath) {
        super(template, VSCreateMod.MOD_ID, basePath);
    }

}
