import javax.persistence.*;
import java.lang.Math;

@Entity
@Table
public class UserPoint {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;

    private double x;
    private double y;

    private int r;
    private boolean inArea;
    private String owner;

    public boolean isInArea() {
        return inArea;
    }

    public void check(){
        inArea = false;
        if(x >= 0.0 && y >= 0.0){
            inArea = x <= (double)r && y <= (double)r;
        } else if(x <= 0.0 && y >= 0.0){
            inArea = x/2.0 + ((double)r)/2.0 <= y;
        } else if(x <= 0.0 && y < 0.0){
            inArea = Math.pow(x,2) + Math.pow(y,2) <= Math.pow(((double)r)/2.0,2);
        }
    }
    public void setInArea(boolean inArea) {
        this.inArea = inArea;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
