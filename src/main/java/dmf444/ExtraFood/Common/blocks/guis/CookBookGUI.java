package dmf444.ExtraFood.Common.blocks.guis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.AchievementPage;
import dmf444.ExtraFood.Common.RecipeHandler.CookbookButtonLoader;
import dmf444.ExtraFood.Common.RecipeHandler.CookbookTab;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.GuiLib;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class CookBookGUI extends GuiScreen {
	   private static int minDisplayColumn;
	    private static int minDisplayRow;
	    private static int maxDisplayColumn;
	    private static int maxDisplayRow;
	   
	    //mincrmatt12 movin' vars
	    private int px;
	    private int py;
	    private int x;
	    public String tab = "generic";
	    private int y;

	    private int iox = 15;
	    private int yox = 50;
	    
	    //mincrmatt12 button vars
	    private ArrayList<ClickTab> buttons;
	    
    /** The top x coordinate of the achievement map */
    private static final int guiMapTop = minDisplayColumn * 24 - 112;

    /** The left y coordinate of the achievement map */
    private static final int guiMapLeft = minDisplayRow * 24 - 112;

    /** The bottom x coordinate of the achievement map */
    private static final int guiMapBottom = maxDisplayColumn * 24 - 77;

    /** The right y coordinate of the achievement map */
    private static final int guiMapRight = maxDisplayRow * 24 - 77;
    protected static int achievementsPaneWidth = 256;
    protected static int achievementsPaneHeight = 202;
    
    private int isMouseButtonDown;
    /** The x position of the achievement map */
    protected double guiMapX;

    /** The y position of the achievement map */
    protected double guiMapY;
    protected double field_74124_q;
    protected double field_74123_r;
    
    /** The current mouse x coordinate */
    protected int mouseX;

    /** The current mouse y coordinate */
    protected int mouseY;
    protected double field_74117_m;
    protected double field_74115_n;
    
    public static final int GUI_ID = 10;
    
   public static CookBookGUI currentOpenBook = new CookBookGUI();
   //public static CookbookButtonLoader bookButton = new CookbookButtonLoader();

   public CookBookGUI() {
	


   }

	

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	{
            if (Mouse.isButtonDown(0))
            {
    			iox += -Mouse.getDX();
    			yox += Mouse.getDY();
    			if (iox < 0){
    				iox = 0;
    			}
    			if (yox < 0){
    				yox = 0;
    			}
    			if (iox > 60){
    				iox = 60; //350
    			}
    			if (yox > 85){ //550
    				yox = 85;
    			}
    	

    			//System.out.println(iox + " " + yox);

            }
            else
            {
                this.isMouseButtonDown = 0;
            }
            
            this.drawDefaultBackground();
            this.genDasBookBackground(par1, par2, par3);            
            this.drawTitle();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
    	}


    }
    protected void drawTitle()
    {
		String mainGUI = StatCollector.translateToLocal("cookbook.Title");
        int i = (this.width - this.achievementsPaneWidth) / 2;
        int j = (this.height - this.achievementsPaneHeight) / 2;
        GL11.glDisable(GL11.GL_LIGHTING);
        this.fontRendererObj.drawString(mainGUI, i + 6, j + 5, 0xFFFFFFFF); //i + 15 original
        GL11.glEnable(GL11.GL_LIGHTING);
    }
    
    
    protected void genDasBookBackground(int par1, int par2, float par3)
    {
        int k = MathHelper.floor_double(this.field_74117_m + (this.guiMapX - this.field_74117_m) * (double)par3);
        int l = MathHelper.floor_double(this.field_74115_n + (this.guiMapY - this.field_74115_n) * (double)par3);

        if (k < guiMapTop)
        {
            k = guiMapTop;
        }

        if (l < guiMapLeft)
        {
            l = guiMapLeft;
        }

        if (k >= guiMapBottom)
        {
            k = guiMapBottom - 1;
        }

        if (l >= guiMapRight)
        {
            l = guiMapRight - 1;
        }

        int i1 = (this.width - this.achievementsPaneWidth) / 2;
        int j1 = (this.height - this.achievementsPaneHeight) / 2;
        int k1 = i1 + 16;
        int l1 = j1 + 17;
        this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_GEQUAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        //GL11.glDisable(GL11.GL_LIGHTING);
        //GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        //GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        int i2 = k + 288 >> 4;
        int j2 = l + 288 >> 4;
        int k2 = (k + 288) % 16;
        int l2 = (l + 288) % 16;
        Random random = new Random();
        int i3 = 0;
        int j3;
        int k3 = 0;


        float f1 = 0.6F - (float)(j2 + i3) / 25.0F * 0.3F;
        //GL11.glColor4f(f1, f1, f1, 1.0F);


        this.mc.getTextureManager().bindTexture(GuiLib.CBback);
        GL11.glPushMatrix();
		GL11.glScalef(1.2F, 1.2F, 1.2F);
        this.drawTexturedModalRect(i1 - 13, j1 - 2, iox, yox, this.achievementsPaneWidth - 53, this.achievementsPaneHeight - 45);  
        //this.drawTexturedModalRect(i1 -13, j1 + 1, iox, yox, this.achievementsPaneWidth - 62, this.achievementsPaneHeight - 45);  
        GL11.glPopMatrix();       
       // GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
      
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GuiLib.CBborder);
        this.drawTexturedModalRect(i1, j1, 0, 0, this.achievementsPaneWidth, this.achievementsPaneHeight);
        GL11.glPopMatrix();
        this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        for (ClickTab tab : CookbookButtonLoader.bookButton.getButtons(this.tab)){
        	if (tab.x * 22 > iox && tab.x * 22 < this.achievementsPaneWidth - 30 + iox){
        		if (tab.y * 22 > yox - 2  && tab.y * 22 < this.achievementsPaneHeight - 22 + yox){ //2
        			tab.xPosition = i1 + 2 + (tab.x * 22) + -iox;
        			tab.yPosition = j1 + 2 + (tab.y * 22) + -yox;
        			for (ArrayList<int[]> xps : CookbookButtonLoader.bookButton.getXYCoordsOfLineForButton(tab.pagename, this.tab)){
        				float x1 = xps.get(0)[0] + 0.1F;
        				float y1 = xps.get(0)[1] + 0.1F;
        				float x2 = xps.get(1)[0];
        				float y2 = xps.get(1)[1];
        				int bx = 0;
        				int by = 0;
        				if (x1 < x2){
        		             bx = (int) (i1 + 2 + (x2 * 22) + -iox + 30);
        		             x1 += 0.85F;
        		             x2 += 0.6;
        		             
        		            }
        		            else {
        		             bx = (int) (i1 + 2 + (x1 * 22) + -iox + - 30);
        		             y2 -= 0.1F;
        		             x2 += 0.6;
        		            }
        		            if (y1 < y2){
        		             by = (int) (j1 + 2 + (y2 * 22) + -yox + 30);
        		             y1 += 1;
        		             y2 += 0.6;
        		             
        		            }
        		            else {
        		             by = (int) (j1 + 2 + (y1 * 22) + -yox + 15);
        		             y2 += 1;
        		             
        		            }
        				if (x1 * 22 > iox && x1 * 22 < this.achievementsPaneWidth - 2 + iox && x2 * 22 > iox && x2 * 22 < this.achievementsPaneWidth - 17 + iox){ //2
        	        		if (y1 * 22 > yox && y1 * 22 < this.achievementsPaneHeight - 20 + yox && y2 * 22 > yox && y2 * 22 < this.achievementsPaneHeight - 20 + yox){
        	        			x1 = i1 + 2 + (x1 * 22) + -iox;
        	        			x2 = i1 + 2 + (x2 * 22) + -iox;
        	        			y1 = j1 + 2 + (y1 * 22) + -yox;
        	        			y2 = j1 + 2 + (y2 * 22) + -yox;
        	        			this.plotCurve(x1, y1, bx, by, x2, y2);
        	        		}
        				}
        				
        			}
        			tab.drawButton(mc, 0, 0);
        			}
        		}
        	}
            int sy = 0;
            int sx = -28;
            for (CookbookTab cookbooktab : CookbookButtonLoader.bookButton.buttons){
            	cookbooktab.drawButton(mc, i1 + sx, j1 + sy, this);
            	sy += 28;
            
        }
        super.drawScreen(par1, par2, par3);
    }


    
    public boolean doesGuiPauseGame()
    {
        return false;
    }    
    protected void mouseMovedOrUp(int par1, int par2, int par3){
    	super.mouseMovedOrUp(par1, par2, par3);
    	if (par3 == -1){
    		if (Mouse.isButtonDown(0)){
    			int dx = par1 - x;
    			int dy = par2 - y;
    			px = x;
    			py = y;
    			x = par1;
    			y = par2;
    			iox += dx;
    			yox += dy;
    			if (iox < 0){
    				iox = 0;
    			}
    			if (yox < 0){
    				yox = 0;
    			}
    			//System.out.println(iox + " " + yox);	
    		}
    	}
    }
    protected void mouseClicked(int par1, int par2, int par3){
    	int i1 = (this.width - this.achievementsPaneWidth) / 2;
        int j1 = (this.height - this.achievementsPaneHeight) / 2;
    	for (ClickTab tab : CookbookButtonLoader.bookButton.getButtons(this.tab)){
        	if (tab.x * 22 > iox && tab.x * 22 < this.achievementsPaneWidth - 2 + iox){
        		if (tab.y * 22 > yox && tab.y * 22 < this.achievementsPaneHeight - 2 + yox){
        			if (tab.mousePressed(mc, par1, par2)){
        				if (tab.type == 0){
        				this.mc.displayGuiScreen(new CRPageGUI(tab.pagename, CookbookButtonLoader.bookButton.DoesHaveMultiPage(tab.pagename), CookbookButtonLoader.bookButton.NumOfPages(tab.pagename)));
        				} else if (tab.type == 1){
        					this.mc.displayGuiScreen(new BTPageGUI(tab.pagename, CookbookButtonLoader.bookButton.DoesHaveMultiPage(tab.pagename), CookbookButtonLoader.bookButton.NumOfPages(tab.pagename)));
        				}
        			}
        		}
        	}
    	}
        	int sx = -28;
        	int sy = 0;
        	for (CookbookTab tabby : CookbookButtonLoader.bookButton.buttons){
        		int cx = i1 + sx;
        		int cy = j1 + sy;
        		if (par1 >= cx && par1 <= cx + 22){
        			if (par2 >= cy && par2 <= cy + 22){
        				this.tab = tabby.name;
        			}
        		}
        		sy += 28;

    	}
    }
    
    private void plotCurve(double startX, double startY, int bezierX, int bezierY, double endX, double endY){
    	Tessellator tess = Tessellator.instance;
    	GL11.glPushMatrix();
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);//516
        GL11.glDisable(GL11.GL_TEXTURE_2D);//3553
        GL11.glEnable(GL11.GL_BLEND);//3042
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);//770,771
        GL11.glLineWidth(3F);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);//2848
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST); //3154, 4354
        GL11.glDisable(GL11.GL_LIGHTING);
        tess.startDrawing(3);
    	for(double t=0.0;t<=1;t+=0.01)  
    	{  
    	    int x = (int) (  (1-t)*(1-t)*startX + 2*(1-t)*t*bezierX+t*t*endX);  
    	    int y = (int) (  (1-t)*(1-t)*startY + 2*(1-t)*t*bezierY+t*t*endY);  
    	  
    	    //plot something @  x,y coordinate here...
    	    tess.setColorRGBA_F(0f, 0f, 0f, 1.0f);
    	    tess.addVertex(x, y, 0.0d + t * 10);
    	    tess.setBrightness(100);
    	    
    	    
    	}
    	tess.draw();
    	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);//770, 771
        GL11.glDisable(GL11.GL_LINE_SMOOTH);//2848
        GL11.glDisable(GL11.GL_BLEND);//3042
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);//3553
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);//516
        GL11.glPopMatrix();
    }
        
    private int cosineint(int x, int y, int z){
    	double w = (1-Math.cos(z*Math.PI))/2;
    	return (int) (x*(1-w)+y*w);
    	
    }
    
}
