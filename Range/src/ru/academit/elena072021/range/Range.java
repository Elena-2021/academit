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

    public Range getIntersection(Range range) {
        if ((range.from <= from || range.from >= to) && (range.to <= from || range.to >= to) && (from <= range.from ||
                from >= range.to) && (to <= range.from || to >= range.to)) {
            return null;
        }

        if (range.from > from && range.to < to) {
            return new Range(range.from, range.to);
        }

        if (range.from > from && range.to > to) {
            return new Range(range.from, to);
        }

        if (range.from < from && range.to > to) {
            return new Range(from, to);
        }

        return new Range(from, range.to);
    }

    public Range[] getIntegration(Range range) {
        Range[] array = null;

        if ((range.from < from || range.from > to) && (range.to < from || range.to > to) && (from < range.from ||
                from > range.to) && (to < range.from || to > range.to)) {
            array = new Range[]{new Range(from, to), new Range(range.from, range.to)};
            return array;
        }

        if (range.from >= from && range.to <= to) {
            array = new Range[]{new Range(from, to)};
            return array;
        }

        if (range.from >= from && range.to >= to) {
            array = new Range[]{new Range(from, range.to)};
            return array;
        }

        if (range.from <= from && range.to >= to) {
            array = new Range[]{new Range(range.from, range.to)};
            return array;
        }

        array = new Range[]{new Range(range.from, to)};
        return array;
    }

    public Range[] getDifference(Range range) {
        Range[] array = null;

        if ((range.from <= from || range.from >= to) && (range.to <= from || range.to >= to) && (from <= range.from ||
                from >= range.to) && (to <= range.from || to >= range.to)) {
            array = new Range[]{new Range(from, to)};
            return array;
        }

        if (range.from > from && range.to < to) {
            array = new Range[]{new Range(from, range.from), new Range(range.to, to)};
            return array;
        }

        if (range.from > from && range.to > to) {
            array = new Range[]{new Range(from, range.from)};
            return array;
        }

        if (range.from < from && range.to > to) {
            return null;
        }

        array = new Range[]{new Range(range.to, to)};
        return array;
    }
}