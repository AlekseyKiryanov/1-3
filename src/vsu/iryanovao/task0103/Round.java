package vsu.iryanovao.task0103;

public class Round {
    public double x0;
    public double y0;
    public double r;

    public Round(double x0, double y0, double r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    public boolean isPointInRound(double x, double y) {
        return Math.pow(x-x0,2)+Math.pow(y-y0,2)<=Math.pow(r,2);
    }
}
