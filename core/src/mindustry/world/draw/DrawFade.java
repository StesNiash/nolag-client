package mindustry.world.draw;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.gen.*;
import mindustry.world.*;
import static mindustry.Vars.*;

public class DrawFade extends DrawBlock{
    public String suffix = "-top";
    public float alpha = 0.6f, scale = 3f;
    public TextureRegion region;

    @Override
    public void draw(Building build){
        if(renderer.disableBlockAnimation) return;
        
        Draw.alpha(Mathf.absin(build.totalProgress(), scale, alpha) * build.warmup());
        Draw.rect(region, build.x, build.y);
        Draw.reset();
    }

    @Override
    public void load(Block block){
        region = Core.atlas.find(block.name + suffix);
    }
}
