package bugcraft.entity;

import bugcraft.item.net;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class butterfly extends EntityAnimal {
	public boolean caught;
	
	public butterfly(World world) {
		super(world);
		caught = false;
		this.setSize(.5F, 2F);
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setCanSwim(false);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(2, new EntityAILookIdle(this));
              
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		
		return null;
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.23000000417232513D);
    }
}
