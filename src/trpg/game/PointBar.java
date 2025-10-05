package trpg.game;

public class PointBar {
    private int value;
    private int maxValue;

    public PointBar(int maxValue) {
        this.value = this.maxValue = maxValue;
    }

    public PointBar(int maxValue, int value) {
        this.value = value;
        this.maxValue = maxValue;
    }

    public static PointBar newEmpty(int maxValue) {
        return new PointBar(maxValue, 0);
    }

    public int value() {
        return value;
    }

    public void reset() {
        this.value = 0;
    }

    public void reset(int value) {
        if(value >= 0 && value <= maxValue) {
            this.value = value;
        }
    }

    public void resetToMax() {
        this.value = maxValue;
    }


    public int getMaxValue() {
        return maxValue;
    }
    
    public void setMaxAndReset(int newMax) {
        this.maxValue = newMax;
        this.value = 0;
    }

    public int increase(int increment) {
        if(increment < 0) {
            return -1;
        } else if(this.value + increment > this.maxValue) {
            this.value = this.maxValue;
            return this.maxValue - (this.value + increment);
        } else {
            this.value += increment;
            return 0;
        }
    }

    public int decrease(int decrement) {
        if(decrement < 0) {
            return -1;
        } else if(this.value - decrement < 0) {
            this.value = 0;
            return decrement - this.value;
        } else {
            this.value -= decrement;
            return 0;
        }
    }

    public boolean isFull() {
        return (this.value == this.maxValue);
    }

    public boolean isEmpty() {
        return (this.value == 0);
    }
}
