int sw = 6;
void setup() {
  size(1200, 600);
  strokeWeight(sw);
  background(255);
}

void draw() {
  strokeWeight(sw);
  if (mousePressed == true) {
    if (mouseButton == LEFT) {
      stroke(255);
      line(mouseX, mouseY, pmouseX, pmouseY);
    } else if (mouseButton == RIGHT) { 
      stroke(0);
      line(mouseX, mouseY, pmouseX, pmouseY);
    }
  }
}

void keyPressed() {
  if (key == '+') {
    sw++;
  }
  if (key == '-') {
    if(sw > 1) sw--;
    else sw=1;
  }
}