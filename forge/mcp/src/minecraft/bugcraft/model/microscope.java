// Date: 11/3/2013 9:51:44 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package bugcraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class microscope extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Stand;
    ModelRenderer Top;
    ModelRenderer Lens;
    ModelRenderer Arm;
    ModelRenderer Light;
  
  public microscope()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-8F, 0F, -8F, 16, 2, 16);
      Base.setRotationPoint(0F, 22F, 0F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Stand = new ModelRenderer(this, 0, 0);
      Stand.addBox(0F, 0F, 0F, 8, 14, 3);
      Stand.setRotationPoint(-4F, 9F, 5F);
      Stand.setTextureSize(64, 64);
      Stand.mirror = true;
      setRotation(Stand, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 0, 0);
      Top.addBox(0F, 0F, 0F, 8, 2, 12);
      Top.setRotationPoint(-4F, 7F, -4F);
      Top.setTextureSize(64, 64);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      Lens = new ModelRenderer(this, 16, 17);
      Lens.addBox(0F, 0F, 0F, 4, 11, 4);
      Lens.setRotationPoint(-2F, 2F, -3F);
      Lens.setTextureSize(64, 64);
      Lens.mirror = true;
      setRotation(Lens, 0F, 0F, 0F);
      Arm = new ModelRenderer(this, 0, 17);
      Arm.addBox(0F, 0F, 0F, 6, 1, 10);
      Arm.setRotationPoint(-3F, 19F, -5F);
      Arm.setTextureSize(64, 64);
      Arm.mirror = true;
      setRotation(Arm, 0F, 0F, 0F);
      Light = new ModelRenderer(this, 42, 24);
      Light.addBox(0F, 0F, -1F, 2, 1, 2);
      Light.setRotationPoint(-1F, 21F, -2F);
      Light.setTextureSize(64, 64);
      Light.mirror = true;
      setRotation(Light, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Stand.render(f5);
    Top.render(f5);
    Lens.render(f5);
    Arm.render(f5);
    Light.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}