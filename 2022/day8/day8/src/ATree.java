public class ATree {

    int x;
    int y;
    boolean visible;
    int height;

    public ATree(){
        this.visible=false;
    }

    public ATree(int x, int y, int height){
        this.x=x;
        this.y=y;
        this.visible=false;
        this.height = height;
    }

}
