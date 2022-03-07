import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(500,500);    
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  // creating random cloud dimensions
  float cloudX = random(0, 500);
  float cloudY = random(0, 500);
  float cloudSize = random(50, 100);
  float cloudDistance = cloudSize / 2; 

  public void draw() {

  // variables for the position of the cloud
  boolean cloudleft = cloudX >= 250;
  boolean cloudright = cloudX <= 249;
  boolean cloudup = cloudY <= 250; 
  boolean clouddown = cloudY >=249;

  boolean cloudtopleft = cloudup && cloudleft;
  boolean cloudtopright = cloudup && cloudright;
  boolean cloudbottemleft = clouddown && cloudleft;
  boolean cloudbottemright = clouddown && cloudright;
  boolean iscloudhigh = cloudtopleft || cloudtopright;

  // if functions to set background color and create a sun if the cloud is above the half way line
  if (cloudtopleft) {
    background(0, 0, 255);
  }
  if (cloudtopright) {
    background(0, 50, 100);
  }
  if (cloudbottemleft) {
    background(0, 100, 150);
  }
  if (cloudbottemright) {
    background(100, 0, 200);
  }
  if (iscloudhigh) {
    stroke(0);
    fill(255, 255, 0);
    ellipse(450, 50, 50, 50);
  }

  // top cloud
  stroke(0);
  fill(222, 222, 222);
  ellipse((float) (cloudX + cloudDistance * 0.25), cloudY - cloudDistance, cloudSize, cloudSize);

  // right cloud
  stroke(0);
  fill(222, 222, 222);
  ellipse(cloudX + cloudDistance, cloudY, cloudSize, cloudSize);

  // center cloud
  stroke(0);
  fill(222, 222, 222);
  fill(222, 222, 222);
  ellipse(cloudX, cloudY, cloudSize, cloudSize);

  // left cloud
  stroke(0);
  fill(222, 222, 222);
  ellipse(cloudX - cloudDistance, cloudY, cloudSize, cloudSize);


  // values for time
  int intHours = hour();
  int intMinutes = minute();
  int intSeconds = second();

  // print time
  String strTime = (str(intHours % 12) + ":" + str(intMinutes) + ":" + str(intSeconds));

  // box to put time values in
  fill(225,225,225);
  rect(0, 440, 240, 80);

  // size and font
  noStroke();
  fill(200, 0, 0);
  textSize(50);
  text(strTime, 0, 490);
  }
  
  // define other methods down here.
}