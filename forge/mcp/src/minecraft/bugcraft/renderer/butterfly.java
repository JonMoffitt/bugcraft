package bugcraft.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class butterfly extends RenderLiving {

	public butterfly(ModelBase model, float shadowSize) {
		super(model, shadowSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return new ResourceLocation("bugcraft","textures/entities/butterflymap.png");
	}

}
