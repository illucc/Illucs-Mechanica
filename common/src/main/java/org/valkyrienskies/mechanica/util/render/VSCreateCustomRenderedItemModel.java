package org.valkyrienskies.mechanica.util.render;

import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import net.minecraft.client.resources.model.BakedModel;
import org.valkyrienskies.mechanica.MechanicaMod;

public abstract class VSCreateCustomRenderedItemModel extends CustomRenderedItemModel {
    public VSCreateCustomRenderedItemModel(BakedModel template, String basePath) {
        super(template, MechanicaMod.MOD_ID, basePath);
    }

}
