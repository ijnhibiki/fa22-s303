package ngordnet.ngrams;

import java.util.*;

/** An object for mapping a year number (e.g. 1996) to numerical data. Provides
 *  utility methods useful for data analysis.
 *  @author Josh Hug
 */
public class TimeSeries extends TreeMap<Integer, Double> {
    /** Constructs a new empty TimeSeries. */
    public TimeSeries() {
        super();
    }

    /** Creates a copy of TS, but only between STARTYEAR and ENDYEAR,
     *  inclusive of both end points. */
    public TimeSeries(TimeSeries ts, int startYear, int endYear) {
        super();
        for (int i = startYear; i <= endYear; i++) {
            if (ts.containsKey(i)) {
                this.put(i, ts.get(i));
            }
        }
    }

    /** Returns all years for this TimeSeries (in any order). */
    public List<Integer> years() {
        Set<Integer> temp = this.keySet();
        List<Integer> years = new ArrayList<>();
        years.addAll(temp);
        return years;
    }

    /** Returns all data for this TimeSeries (in any order).
     *  Must be in the same order as years(). */
    public List<Double> data() {
        List<Double> data = new ArrayList<>();
        for (Integer year : this.years()) {
            data.add(this.get(year));
        }
        return data;
    }

    /** Returns the yearwise sum of this TimeSeries with the given TS. In other words, for
     *  each year, sum the data from this TimeSeries with the data from TS. Should return a
     *  new TimeSeries (does not modify this TimeSeries). */
    public TimeSeries plus(TimeSeries ts) {
        for (Integer year : ts.years()) {
            if (this.containsKey(year)) {
                this.put(year, ts.get(year) + this.get(year));
            } else {
                this.put(year, ts.get(year));
            }
        }
        return this;
    }

     /** Returns the quotient of the value for each year this TimeSeries divided by the
      *  value for the same year in TS. If TS is missing a year that exists in this TimeSeries,
      *  throw an IllegalArgumentException. If TS has a year that is not in this TimeSeries, ignore it.
      *  Should return a new TimeSeries (does not modify this TimeSeries). */
     public TimeSeries dividedBy(TimeSeries ts) {
         for (Integer year : this.years()) {
             if (!ts.containsKey(year)) {
                 throw new IllegalArgumentException("invalid input time series");
             }
             if (this.containsKey(year)) {
                 this.put(year, this.get(year) / ts.get(year));
             }
         }
         return this;
    }
}
