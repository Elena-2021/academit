package ru.academit.elena072021.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range2) {
        double from1 = from;
        double to1 = to;

        double from2 = range2.from;
        double to2 = range2.to;

        if ((from2 <= from1 || from2 >= to1) && (to2 <= from1 || to2 >= to1) && (from1 <= from2 || from1 >= to2) && (to1 <= from2 || to1 >= to2)) {
            return null;
        } else if (from2 > from1 && to2 < to1) {
            return new Range(from2, to2);
        } else if (from2 > from1 && to2 > to1) {
            return new Range(from2, to1);
        } else if (from2 < from1 && to2 > to1) {
            return new Range(from1, to1);
        }

        return new Range(from1, to2);
    }

    public Range[] getIntegration(Range range2) {
        Range[] array = null;
        double from1 = from;
        double to1 = to;

        double from2 = range2.from;
        double to2 = range2.to;

        if ((from2 < from1 || from2 > to1) && (to2 < from1 || to2 > to1) && (from1 < from2 || from1 > to2) && (to1 < from2 || to1 > to2)) {
            array = new Range[]{new Range(from1, to1), new Range(from2, to2)};
            return array;
        } else if (from2 >= from1 && to2 <= to1) {
            array = new Range[]{new Range(from1, to1)};
            return array;
        } else if (from2 >= from1 && to2 >= to1) {
            array = new Range[]{new Range(from1, to2)};
            return array;
        } else if (from2 <= from1 && to2 >= to1) {
            array = new Range[]{new Range(from2, to2)};
            return array;
        }

        array = new Range[]{new Range(from2, to1)};
        return array;
    }

    public Range[] getDifference(Range range2) {
        Range[] array = null;
        double from1 = from;
        double to1 = to;

        double from2 = range2.from;
        double to2 = range2.to;

        if ((from2 <= from1 || from2 >= to1) && (to2 <= from1 || to2 >= to1) && (from1 <= from2 || from1 >= to2) && (to1 <= from2 || to1 >= to2)) {
            array = new Range[]{new Range(from1, to1)};
            return array;
        } else if (from2 > from1 && to2 < to1) {
            array = new Range[]{new Range(from1, from2), new Range(to2, to1)};
            return array;
        } else if (from2 > from1 && to2 > to1) {
            array = new Range[]{new Range(from1, from2)};
            return array;
        } else if (from2 < from1 && to2 > to1) {
            return null;
        }

        array = new Range[]{new Range(to2, to1)};
        return array;
    }
}