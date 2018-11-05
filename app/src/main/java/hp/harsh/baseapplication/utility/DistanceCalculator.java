package hp.harsh.baseapplication.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Harsh Patel on 5/24/2016.
 */
public class DistanceCalculator {

    public static double DistanceCalculator(String lat1, String lon1, String lat2, String lon2, String unit, int places) {
        String theta = "" + (Double.parseDouble(lon1) - Double.parseDouble(lon2));
        String dist = "" + (Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta)));
        dist = "" + Math.acos(Double.parseDouble(dist));
        dist = "" + rad2deg(dist);

        if (unit.equalsIgnoreCase("M")) {
            dist = "" + Double.parseDouble(dist) * 60 * 1.1515;
        } else if (unit.equalsIgnoreCase("K")) {
            dist = "" + Double.parseDouble(dist) * 60 * 1.1515 * 1.609344;
        } else if (unit.equalsIgnoreCase("N")) {
            dist = "" + Double.parseDouble(dist) * 60 * 1.1515 * 0.8684;
        }

        return round(Double.parseDouble(dist), places);
    }

    static double deg2rad(String deg) {
        return (Double.parseDouble(deg) * Math.PI / 180.0);
    }

    static double rad2deg(String rad) {
        return (Double.parseDouble(rad) * 180 / Math.PI);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
