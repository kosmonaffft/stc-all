package university.innopolis.stc.life.data;

public class LifeSnapshot {

    private int xsize;

    private int ysize;

    private byte[] data;

    public LifeSnapshot(int xsize, int ysize) {
        this.xsize = xsize;
        this.ysize = ysize;
        data = new byte[xsize * ysize];
    }

    public LifeSnapshot(int xsize, int ysize, byte[] data) {
        this.xsize = xsize;
        this.ysize = ysize;
        this.data = data;
    }

    public int getXsize() {
        return xsize;
    }

    public void setXsize(int xsize) {
        this.xsize = xsize;
    }

    public int getYsize() {
        return ysize;
    }

    public void setYsize(int ysize) {
        this.ysize = ysize;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
