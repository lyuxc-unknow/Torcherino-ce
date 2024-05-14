package com.ariks.torcherino.util;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class CuboidGui {
    private float size;
    private float x, y;
    private float red, green, blue;
    public void setCube(int size, int x, int y, float red, float green, float blue) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public void drawCube() {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, 0);
        GlStateManager.scale(size, size, size);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
        GlStateManager.color(red, green, blue, 1.0F);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        buffer.pos(-0.5, -0.5, 0).endVertex();
        buffer.pos(0.5, -0.5, 0).endVertex();
        buffer.pos(0.5, 0.5, 0).endVertex();
        buffer.pos(-0.5, 0.5, 0).endVertex();
        tessellator.draw();
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
    }
    public void clearCube() {
        Tessellator.getInstance().getBuffer().reset();
    }
}
