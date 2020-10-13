/*
 * Map for the game
 * By Peter Chen
 * By Tony Lee
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class Map extends LevelObject{
    
    private int x,y;
    
    private static Image[] villageMapSprites;
    private static Image[] swampMapSprites;
    private static Image[] desertMapSprites;
    private static Image[] forestMapSprites;
    private static Image[] snowMapSprites;
    
    public static void initializeImages() {
        
        try{
            
            //Village Level
            villageMapSprites = new Image[34];
            villageMapSprites[0] = ImageIO.read(new File("images/Village/Green_Grass.png"));    //0
            villageMapSprites[1] = ImageIO.read(new File("images/Village/Road.png"));     //1
            villageMapSprites[2] = ImageIO.read(new File("images/Village/Flowers.png"));        //2
            villageMapSprites[3] = ImageIO.read(new File("images/Village/Rock.png"));           //3
            villageMapSprites[4] = ImageIO.read(new File("images/Village/Home_1-1.png"));       //4
            villageMapSprites[5] = ImageIO.read(new File("images/Village/Home_1-2.png"));       //5
            villageMapSprites[6] = ImageIO.read(new File("images/Village/Home_1-3.png"));       //6
            villageMapSprites[7] = ImageIO.read(new File("images/Village/Home_2-1.png"));       //7
            villageMapSprites[8] = ImageIO.read(new File("images/Village/Home_2-2.png"));       //8
            villageMapSprites[9] = ImageIO.read(new File("images/Village/Home_2-3.png"));       //9
            villageMapSprites[10] = ImageIO.read(new File("images/Village/Home_3-1.png"));      //10
            villageMapSprites[11] = ImageIO.read(new File("images/Village/Home_3-2.png"));      //11
            villageMapSprites[12] = ImageIO.read(new File("images/Village/Home_3-3.png"));      //12
            villageMapSprites[13] = ImageIO.read(new File("images/Village/Home_4-1.png"));      //13
            villageMapSprites[14] = ImageIO.read(new File("images/Village/Home_4-2.png"));      //14
            villageMapSprites[15] = ImageIO.read(new File("images/Village/Home_4-3.png"));      //15
            villageMapSprites[16] = ImageIO.read(new File("images/Village/Home_5-1.png"));      //16
            villageMapSprites[17] = ImageIO.read(new File("images/Village/Home_5-2.png"));      //17
            villageMapSprites[18] = ImageIO.read(new File("images/Village/Home_5-3.png"));      //18
            villageMapSprites[19] = ImageIO.read(new File("images/Village/Tree_1-2.png"));      //19
            villageMapSprites[20] = ImageIO.read(new File("images/Village/Tree_1-1.png"));      //20
            villageMapSprites[21] = ImageIO.read(new File("images/Village/Tree_2-2.png"));      //21
            villageMapSprites[22] = ImageIO.read(new File("images/Village/Tree_2-1.png"));      //22
            villageMapSprites[23] = ImageIO.read(new File("images/Village/House1_1-1.png"));    //23
            villageMapSprites[24] = ImageIO.read(new File("images/Village/House1_1-2.png"));    //24
            villageMapSprites[25] = ImageIO.read(new File("images/Village/House1_1-3.png"));    //25
            villageMapSprites[26] = ImageIO.read(new File("images/Village/House1_2-1.png"));    //26
            villageMapSprites[27] = ImageIO.read(new File("images/Village/House1_2-2.png"));    //27
            villageMapSprites[28] = ImageIO.read(new File("images/Village/House1_2-3.png"));    //28
            villageMapSprites[29] = ImageIO.read(new File("images/Village/House1_3-1.png"));    //29
            villageMapSprites[30] = ImageIO.read(new File("images/Village/House1_3-2.png"));    //30
            villageMapSprites[31] = ImageIO.read(new File("images/Village/House1_3-3.png"));    //31
            villageMapSprites[32] = ImageIO.read(new File("images/Village/Fence.png"));         //32
            villageMapSprites[33] = ImageIO.read(new File("images/Village/Village_Portal.png"));//33
            
            //Swamp Level
            swampMapSprites = new Image[5];
            swampMapSprites[0] = ImageIO.read(new File("images/Swamp/Swamp_Water.png")); //0
            swampMapSprites[1] = ImageIO.read(new File("images/Swamp/Tree_Roots.png"));  //1
            swampMapSprites[2] = ImageIO.read(new File("images/Swamp/Lilypad.png"));     //2
            swampMapSprites[3] = ImageIO.read(new File("images/Swamp/Swamp_Rock.png"));  //3
            swampMapSprites[4] = ImageIO.read(new File("images/Swamp/Swamp_Portal.png"));//4
            
            //Desert Level
            desertMapSprites = new Image[13];
            desertMapSprites[0] = ImageIO.read(new File("images/Desert/Sand.png"));          //0
            desertMapSprites[1] = ImageIO.read(new File("images/Desert/Cactus.png"));        //1
            desertMapSprites[2] = ImageIO.read(new File("images/Desert/Skeleton.png"));      //2
            desertMapSprites[3] = ImageIO.read(new File("images/Desert/Sand_Animal.png"));   //3
            desertMapSprites[4] = ImageIO.read(new File("images/Desert/Sand_Fruit.png"));    //4
            desertMapSprites[5] = ImageIO.read(new File("images/Desert/Sand_Tree_1-1.png")); //5
            desertMapSprites[6] = ImageIO.read(new File("images/Desert/Sand_Tree_1-2.png")); //6
            desertMapSprites[7] = ImageIO.read(new File("images/Desert/Sand_Tree_2-1.png")); //7
            desertMapSprites[8] = ImageIO.read(new File("images/Desert/Sand_Tree_2-2.png")); //8
            desertMapSprites[9] = ImageIO.read(new File("images/Desert/Long_Tree_1-1.png")); //9
            desertMapSprites[10] = ImageIO.read(new File("images/Desert/Long_Tree_1-2.png"));//10
            desertMapSprites[11] = ImageIO.read(new File("images/Desert/Desert_Rock.png"));  //11
            desertMapSprites[12] = ImageIO.read(new File("images/Desert/Desert_Portal.png"));  //12
            
            //Forest Level
            forestMapSprites = new Image[21];
            forestMapSprites[0] = ImageIO.read(new File("images/Forest/Forest_Grass.png"));
            forestMapSprites[1] = ImageIO.read(new File("images/Forest/Forest_Leaves.png"));
            forestMapSprites[2] = ImageIO.read(new File("images/Forest/Forest_Flowers.png"));
            forestMapSprites[3] = ImageIO.read(new File("images/Forest/Forest_Rock.png"));
            forestMapSprites[4] = ImageIO.read(new File("images/Forest/Forest_Plant.png"));
            forestMapSprites[5] = ImageIO.read(new File("images/Forest/Forest_Tree_1-1.png"));
            forestMapSprites[6] = ImageIO.read(new File("images/Forest/Forest_Tree_1-2.png"));
            forestMapSprites[7] = ImageIO.read(new File("images/Forest/Forest_Tree_2-1.png"));
            forestMapSprites[8] = ImageIO.read(new File("images/Forest/Forest_Tree_2-2.png"));
            forestMapSprites[9] = ImageIO.read(new File("images/Forest/Thick_Grass.png"));
            forestMapSprites[10] = ImageIO.read(new File("images/Forest/Path-1.png"));
            forestMapSprites[11] = ImageIO.read(new File("images/Forest/Path-2.png"));
            forestMapSprites[12] = ImageIO.read(new File("images/Forest/Path-3.png"));
            forestMapSprites[13] = ImageIO.read(new File("images/Forest/Path-4.png"));
            forestMapSprites[14] = ImageIO.read(new File("images/Forest/Path-5.png"));
            forestMapSprites[15] = ImageIO.read(new File("images/Forest/Path-6.png"));
            forestMapSprites[16] = ImageIO.read(new File("images/Forest/Path-7.png"));
            forestMapSprites[17] = ImageIO.read(new File("images/Forest/Path-8.png"));
            forestMapSprites[18] = ImageIO.read(new File("images/Forest/Path-9.png"));
            forestMapSprites[19] = ImageIO.read(new File("images/Forest/Path-10.png"));
            forestMapSprites[20] = ImageIO.read(new File("images/Forest/Forest_Portal.png"));
            
            //Snow Level
            snowMapSprites = new Image[7];
            snowMapSprites[0] = ImageIO.read(new File("images/Snow/Snow.png"));
            snowMapSprites[1] = ImageIO.read(new File("images/Snow/Snow_Rock_copy.png"));
            snowMapSprites[2] = ImageIO.read(new File("images/Snow/Snow_Tree_1-1.png"));
            snowMapSprites[3] = ImageIO.read(new File("images/Snow/Snow_Tree_1-2.png"));
            snowMapSprites[4] = ImageIO.read(new File("images/Snow/Snow_Tree_2-1.png"));
            snowMapSprites[5] = ImageIO.read(new File("images/Snow/Snow_Tree_2-2.png"));
            snowMapSprites[6] = ImageIO.read(new File("images/Snow/Snow_Portal.png"));
            
        }
        catch (IOException e) {
            System.out.println("Error: Failed to load an image");
        }
    }
    
    //-------------------------------------------------------DRAW---------------------------------------------------
    //----------------------------------------------------------------Village
    
    public void drawGreenGrass(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getGreenGrass(), x, y, null);
    }
    
    public void drawRoad(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getRoad(), x, y, null);
    }
    
    public void drawFlowers(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getFlowers(), x, y, null);
    }
    
    public void drawRock(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getRock(), x, y, null);
    }
    
    public void drawHomeOneOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeOneOne(), x, y, null);
    }
    
    public void drawHomeOneTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeOneTwo(), x, y, null);
    }
    
    public void drawHomeOneThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeOneThree(), x, y, null);
    }
    
    public void drawHomeTwoOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeTwoOne(), x, y, null);
    }
    
    public void drawHomeTwoTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeTwoTwo(), x, y, null);
    }
    
    public void drawHomeTwoThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeTwoThree(), x, y, null);
    }
    
    public void drawHomeThreeOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeThreeOne(), x, y, null);
    }
    
    public void drawHomeThreeTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeThreeTwo(), x, y, null);
    }
    
    public void drawHomeThreeThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeThreeThree(), x, y, null);
    }
    
    public void drawHomeFourOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeFourOne(), x, y, null);
    }
    
    public void drawHomeFourTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeFourTwo(), x, y, null);
    }
    
    public void drawHomeFourThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeFourThree(), x, y, null);
    }
    
    public void drawHomeFiveOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeFiveOne(), x, y, null);
    }
    
    public void drawHomeFiveTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeFiveTwo(), x, y, null);
    }
    
    public void drawHomeFiveThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHomeFiveThree(), x, y, null);
    }
    
    public void drawTreeOneTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getTreeOneTwo(), x, y, null);
    }
    
    public void drawTreeOneOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getTreeOneOne(), x, y, null);
    }
    
    public void drawTreeTwoTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getTreeTwoTwo(), x, y, null);
    }
    
    public void drawTreeTwoOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getTreeTwoOne(), x, y, null);
    }
    
    public void drawHouse1OneOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1OneOne(), x, y, null);
    }
    
    public void drawHouse1OneTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1OneTwo(), x, y, null);
    }
    
    public void drawHouse1OneThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1OneThree(), x, y, null);
    }
    
    public void drawHouse1TwoOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1TwoOne(), x, y, null);
    }
    
    public void drawHouse1TwoTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1TwoTwo(), x, y, null);
    }
    
    public void drawHouse1TwoThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1TwoThree(), x, y, null);
    }
    
    public void drawHouse1ThreeOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1ThreeOne(), x, y, null);
    }
    
    public void drawHouse1ThreeTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1ThreeTwo(), x, y, null);
    }
    
    public void drawHouse1ThreeThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getHouse1ThreeThree(), x, y, null);
    }
    
    public void drawFence (Graphics2D g2d, int x, int y) {
        g2d.drawImage(getFence(), x, y, null);
    }
    
    public void drawVillagePortal (Graphics2D g2d, int x, int y) {
        g2d.drawImage(getVillagePortal(), x, y, null);
    }    
    
    //-------------------------------------------------------------------Swamp
    
    public void drawSwamp(Graphics2D g2d, int x, int y){
        g2d.drawImage(getSwamp(), x, y, null);
    }
    
    public void drawTreeRoots(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getTreeRoots(), x, y, null);
    }
    
    public void drawLilypad(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getLilypad(), x, y, null);
    }
    
    public void drawSwampRock(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSwampRock(), x, y, null);
    }
    
    public void drawSwampPortal(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSwampPortal(), x, y, null);
    }
    
    //-----------------------------------------------------------------Desert
    
    public void drawSand(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSand(), x, y, null);
    }
    
    public void drawCactus(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getCactus(), x, y, null);
    }
    
    public void drawSkeleton(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSkeleton(), x, y, null);
    }
    
    public void drawSandAnimal(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSandAnimal(), x, y, null);
    }
    
    public void drawSandFruit(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSandFruit(), x, y, null);
    }
    
    public void drawSandTreeOneOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSandTreeOneOne(), x, y, null);
    }
    
    public void drawSandTreeOneTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSandTreeOneTwo(), x, y, null);
    }
    
    public void drawSandTreeTwoOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSandTreeTwoOne(), x, y, null);
    }
    
    public void drawSandTreeTwoTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSandTreeTwoTwo(), x, y, null);
    }
    
    public void drawLongTreeOneOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getLongTreeOneOne(), x, y, null);
    }
    
    public void drawLongTreeOneTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getLongTreeOneTwo(), x, y, null);
    }
    
    public void drawDesertRock(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getDesertRock(), x, y, null);
    }
    
    public void drawDesertPortal(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getDesertPortal(), x, y, null);
    }
    
    //-----------------------------------------------------------------Forest
    
    public void drawForestGrass(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestGrass(), x, y, null);
    }
    
    public void drawForestLeaves(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestLeaves(), x, y, null);
    }
    
    public void drawForestFlowers(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestFlowers(), x, y, null);
    }
    
    public void drawForestRock(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestRock(), x, y, null);
    }
    
    public void drawForestPlant(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestPlant(), x, y, null);
    }
    
    public void drawForestTreeOneOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestTreeOneOne(), x, y, null);
    }
    
    public void drawForestTreeOneTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestTreeOneTwo(), x, y, null);
    }
    
    public void drawForestTreeTwoOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestTreeTwoOne(), x, y, null);
    }
    
    public void drawForestTreeTwoTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestTreeTwoTwo(), x, y, null);
    }
    
    public void drawThickGrass(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getThickGrass(), x, y, null);
    }
    
    public void drawPathOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathOne(), x, y, null);
    }
    
    public void drawPathTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathTwo(), x, y, null);
    }
    
    public void drawPathThree(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathThree(), x, y, null);
    }
    
    public void drawPathFour(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathFour(), x, y, null);
    }
    
    public void drawPathFive(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathFive(), x, y, null);
    }
    
    public void drawPathSix(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathSix(), x, y, null);
    }
    
    public void drawPathSeven(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathSeven(), x, y, null);
    }
    
    public void drawPathEight(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathEight(), x, y, null);
    }
    
    public void drawPathNine(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathNine(), x, y, null);
    }
    
    public void drawPathTen(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getPathTen(), x, y, null);
    }
    
    public void drawForestPortal(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getForestPortal(), x, y, null);   
    }
    
    //---------------------------------------------------------------Snow
    
    public void drawSnow(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSnow(), x, y, null);
    }
    
    public void drawSnowRock(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSnowRock(), x, y, null);
    }
    
    public void drawSnowTreeOneOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSnowTreeOneOne(), x, y, null);
    }
    
    public void drawSnowTreeOneTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSnowTreeOneTwo(), x, y, null);
    }
    
    public void drawSnowTreeTwoOne(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSnowTreeTwoOne(), x, y, null);
    }
    
    public void drawSnowTreeTwoTwo(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSnowTreeTwoTwo(), x, y, null);
    }
    
    public void drawSnowPortal(Graphics2D g2d, int x, int y) {
        g2d.drawImage(getSnowPortal(), x, y, null);
    }
    
    //----------------------------------------GET---------------------------------------------------
    //------------------------------------------------------------------Village
    
    public Image getGreenGrass() {
        return villageMapSprites[0];
    }
    
    public Image getRoad() {
        return villageMapSprites[1];
    }
    
    public Image getFlowers() {
        return villageMapSprites[2];
    }
    
    public Image getRock() {
        return villageMapSprites[3];
    }
    
    public Image getHomeOneOne() {
        return villageMapSprites[4];
    }
    
    public Image getHomeOneTwo() {
        return villageMapSprites[5];
    }
    
    public Image getHomeOneThree() {
        return villageMapSprites[6];
    }
    
    public Image getHomeTwoOne() {
        return villageMapSprites[7];   
    }
    
    public Image getHomeTwoTwo() {
        return villageMapSprites[8];
    }
    
    public Image getHomeTwoThree() {
        return villageMapSprites[9];
    }
    
    public Image getHomeThreeOne() {
        return villageMapSprites[10];
    }
    
    public Image getHomeThreeTwo() {
        return villageMapSprites[11];
    }
    
    public Image getHomeThreeThree() {
        return villageMapSprites[12];
    }  
    
    public Image getHomeFourOne() {
        return villageMapSprites[13];
    }
    
    public Image getHomeFourTwo() {
        return villageMapSprites[14];
    }
    
    public Image getHomeFourThree() {
        return villageMapSprites[15];
    }
    
    public Image getHomeFiveOne() {
        return villageMapSprites[16];
    }
    
    public Image getHomeFiveTwo() {
        return villageMapSprites[17];
    }
    
    public Image getHomeFiveThree() {
        return villageMapSprites[18];
    }
    
    public Image getTreeOneTwo() {
        return villageMapSprites[19];
    }
    
    public Image getTreeOneOne() {
        return villageMapSprites[20];
    }
    
    public Image getTreeTwoTwo() {
        return villageMapSprites[21];
    }
    
    public Image getTreeTwoOne() {
        return villageMapSprites[22];
    }
    
    public Image getHouse1OneOne() {
        return villageMapSprites[23];
    }
    
    public Image getHouse1OneTwo() {
        return villageMapSprites[24];
    }
    
    public Image getHouse1OneThree() {
        return villageMapSprites[25];
    }
    
    public Image getHouse1TwoOne() {
        return villageMapSprites[26];
    }
    
    public Image getHouse1TwoTwo() {
        return villageMapSprites[27];
    }
    
    public Image getHouse1TwoThree() {
        return villageMapSprites[28];
    }
    
    public Image getHouse1ThreeOne() {
        return villageMapSprites[29];
    }
    
    public Image getHouse1ThreeTwo() {
        return villageMapSprites[30];
    }
    
    public Image getHouse1ThreeThree() {
        return villageMapSprites[31];
    }
    
    public Image getFence() {
        return villageMapSprites[32];
    }
    
    public Image getVillagePortal() {
        return villageMapSprites[33];
    }
    
    //------------------------------------------------------------Swamp
    
    public Image getSwamp(){
        return swampMapSprites[0];
    }
    
    public Image getTreeRoots(){
        return swampMapSprites[1];
    }
    
    public Image getLilypad(){
        return swampMapSprites[2];
    }
    
    public Image getSwampRock(){
        return swampMapSprites[3];
    }
    
    public Image getSwampPortal() {
        return swampMapSprites[4];
    }
    
    //-----------------------------------------------------------Desert
    
    public Image getSand() {
        return desertMapSprites[0];
    }
    
    public Image getCactus() {
        return desertMapSprites[1];
    }
    
    public Image getSkeleton() {
        return desertMapSprites[2];
    }
    
    public Image getSandAnimal() {
        return desertMapSprites[3];
    }
    
    public Image getSandFruit() {
        return desertMapSprites[4];
    }
    
    public Image getSandTreeOneOne() {
        return desertMapSprites[5];
    }
    
    public Image getSandTreeOneTwo() {
        return desertMapSprites[6];
    }
    
    public Image getSandTreeTwoOne() {
        return desertMapSprites[7];
    }
    
    public Image getSandTreeTwoTwo() {
        return desertMapSprites[8];
    }
    
    public Image getLongTreeOneOne() {
        return desertMapSprites[9];
    }
    
    public Image getLongTreeOneTwo() {
        return desertMapSprites[10];
    }
    
    public Image getDesertRock() {
        return desertMapSprites[11];
    }
    
    public Image getDesertPortal() {
        return desertMapSprites[12];
    }
    
    //------------------------------------------------Forest
    
    public Image getForestGrass() {
        return forestMapSprites[0];
    }
    
    public Image getForestLeaves() {
        return forestMapSprites[1];
    }
    
    public Image getForestFlowers() {
        return forestMapSprites[2];
    }
    
    public Image getForestRock() {
        return forestMapSprites[3];
    }
    
    public Image getForestPlant() {
        return forestMapSprites[4];
    }
    
    public Image getForestTreeOneOne() {
        return forestMapSprites[5];
    }
    
    public Image getForestTreeOneTwo() {
        return forestMapSprites[6];
    }
    
    public Image getForestTreeTwoOne() {
        return forestMapSprites[7];
    }
    
    public Image getForestTreeTwoTwo() {
        return forestMapSprites[8];
    }
    
    public Image getThickGrass() {
        return forestMapSprites[9];
    }
    
    public Image getPathOne() {
        return forestMapSprites[10];
    }
    
    public Image getPathTwo() {
        return forestMapSprites[11];   
    }
    
    public Image getPathThree() {
        return forestMapSprites[12];
    }
    
    public Image getPathFour() {
        return forestMapSprites[13];
    }
    
    public Image getPathFive() {
        return forestMapSprites[14];
    }
    
    public Image getPathSix() {
        return forestMapSprites[15];
    }
    
    public Image getPathSeven() {
        return forestMapSprites[16];
    }
    
    public Image getPathEight() {
        return forestMapSprites[17];
    }
    
    public Image getPathNine() {
        return forestMapSprites[18];
    }
    
    public Image getPathTen() {
        return forestMapSprites[19];
    }
    
    public Image getForestPortal() {
        return forestMapSprites[20];
    }
    
    //---------------------------------------------------Snow
    
    public Image getSnow() {
        return snowMapSprites[0];
    }
    
    public Image getSnowRock() {
        return snowMapSprites[1];
    }
    
    public Image getSnowTreeOneOne() {
        return snowMapSprites[2];
    }
    
    public Image getSnowTreeOneTwo() {
        return snowMapSprites[3];
    }
    
    public Image getSnowTreeTwoOne() {
        return snowMapSprites[4];
    }
    
    public Image getSnowTreeTwoTwo() {
        return snowMapSprites[5];
    }
    
    public Image getSnowPortal() {
        return snowMapSprites[6];
    }
    
}