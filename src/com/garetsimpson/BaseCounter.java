package com.garetsimpson;

import java.util.ArrayList;

public class BaseCounter {

    //Used to create a counter in a different base.
    //For example enter 2 for binary, 10 for decimal.
    //Used to count based on the length of the board.

    public ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
    private int base;
    private int index;
    private int baseTenMax;
    private int baseTen;
    private int zeroCnt;
    private int nonZeroCnt;
    private int length;



    public BaseCounter(int base, int length) {
        this.base = base;
        this.length = length;
        for (int i = 0; i < length; i++) {
            integerArrayList.add(0);
        }
        this.updateBaseTenMax();

    }

    public void increment() {

        int value = integerArrayList.get(index);
        value++;
        if (value < base) {
            integerArrayList.set(index, value);
        } else {
            integerArrayList.set(index, 0);
            index++;
            this.increment();
            index--;
        }

    }

    @Override
    public String toString() {
        return integerArrayList.toString();
    }

    public void reset() {
        for (int i = 0; i < integerArrayList.size(); i++) {
            integerArrayList.set(i,0);
        }
    }

    public void updateZeroCnt() {
        int counter = 0;
        for (int i = 0; i < integerArrayList.size(); i++) {
            if (integerArrayList.get(i) == 0) {
                counter++;
            }
        }
        setZeroCnt(counter);
    }

    public void updateNonZeroCnt() {
        int counter = 0;
        for (int i = 0; i < integerArrayList.size(); i++) {
            if (integerArrayList.get(i) != 0) {
                counter++;
            }
        }
        setNonZeroCnt(counter);
    }

    public int get(int i){
        return integerArrayList.get(i);
    }

    public void set(int index,int value){
        integerArrayList.set(index,value);
    }

    public int getZeroCnt() {
        return zeroCnt;
    }

    public void setZeroCnt(int zeroCnt) {
        this.zeroCnt = zeroCnt;
    }

    public int getBaseTenMax() {
        return baseTenMax;
    }

    public void setBaseTenMax(int baseTenMax) {
        this.baseTenMax = baseTenMax;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void updateBaseTenMax() {

        int base = this.getBase();
        double length = this.getLength();
        double decimal = 0;

        for (int i = 0; i < length; i++) {
            decimal = decimal + ((base-1) * Math.pow(base,i));
        }
        if(base == 1){
            decimal = 1;
        }

        setBaseTenMax((int)Math.round(decimal));
    }

    public int getBaseTen() {
        return baseTen;
    }

    public void setBaseTen(int baseTen) {
        this.baseTen = baseTen;
    }

    public int toBaseTen(){
        int base = this.getBase();
        double length = this.getLength();
        double decimal = 0;

        for (int i = 0; i < integerArrayList.size(); i++) {
            if(integerArrayList.get(i)!=0){
                decimal = decimal + (integerArrayList.get(i)* Math.pow(base,i));
            }

        }
        if(base == 1){
            decimal = 1;
        }
        setBaseTen((int)Math.round(decimal));
        return(getBaseTen());
    }

    public boolean hasNoDoubles(){
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < length; j++) {
                if(i!=j){
                    if (this.get(i) == this.get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNonZeroCnt() {
        return nonZeroCnt;
    }

    public void setNonZeroCnt(int nonZeroCnt) {
        this.nonZeroCnt = nonZeroCnt;
    }
}
