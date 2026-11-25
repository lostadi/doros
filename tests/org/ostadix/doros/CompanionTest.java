package org.ostadix.doros;

/** The relationship with its person: welcome, rhythm, affection. Touch attention is in DotLatticeTest. */
public final class CompanionTest {
    private static int checks;

    public static void main(String[] args) {
        welcomeGrowsWithAbsence();
        nightAndLiveliness();
        affectionFadesAndGrows();
        System.out.println("CompanionTest passed: " + checks + " checks");
    }

    private static void welcomeGrowsWithAbsence() {
        near(Companion.welcome(0), 0, 0, "No welcome without absence");
        near(Companion.welcome(19_999), 0, 0, "No welcome under twenty seconds");
        near(Companion.welcome(20_000), 0.25 + 0.75 * Math.log1p(20 / 60.0) / Math.log1p(240), 1e-12, "Welcome at twenty seconds");
        double previous = 0;
        for (long ms = 20_000; ms <= 12L * 3600 * 1000; ms += 60_000) {
            double w = Companion.welcome(ms);
            require(w >= previous - 1e-12 && w >= .25 && w <= 1, "Welcome must grow and stay bounded at " + ms);
            previous = w;
        }
        near(Companion.welcome(4L * 3600 * 1000), 1, 1e-12, "Full welcome after four hours");
        near(Companion.welcome(Long.MAX_VALUE), 1, 0, "Welcome stays bounded");
    }

    private static void nightAndLiveliness() {
        near(Companion.night(12), 0, 0, "Noon"); near(Companion.night(2), 1, 0, "2 am");
        near(Companion.night(22), .5, 1e-12, "22:00 ramps"); near(Companion.night(6), .5, 1e-12, "06:00 ramps");
        near(Companion.night(-1), 1, 0, "Hour wraps"); near(Companion.night(25), 1, 0, "Hour wraps forward");
        near(Companion.liveliness(0, 80, false), 1, 1e-12, "Daytime, healthy battery");
        require(Companion.liveliness(1, 80, false) < Companion.liveliness(0, 80, false), "Night is calmer");
        require(Companion.liveliness(0, 10, false) < Companion.liveliness(0, 30, false), "Low battery is sleepy");
        require(Companion.liveliness(0, 10, true) > Companion.liveliness(0, 10, false), "Charging is not sleepy");
        for (int b = -1; b <= 100; b++) for (double n = 0; n <= 1; n += .25) {
            double l = Companion.liveliness(n, b, b % 2 == 0);
            require(l >= .35 && l <= 1.2, "Liveliness bounds");
        }
        require(Companion.sleepy(15, false) && !Companion.sleepy(15, true) && !Companion.sleepy(50, false)
            && !Companion.sleepy(-1, false), "Sleepy only on a low battery that is not charging");
    }

    private static void affectionFadesAndGrows() {
        double a = 0;
        for (int i = 0; i < 200; i++) {
            double next = Companion.pet(a);
            require(next > a && next <= 1, "Petting grows affection within bounds");
            a = next;
        }
        require(a > .99, "Much play approaches full affection");
        near(Companion.fade(.8, 0), .8, 0, "No fade without time");
        near(Companion.fade(.8, (long) Companion.AFFECTION_FADE_MS), .8 / Math.E, 1e-12, "One time constant");
        require(Companion.fade(1, 30L * 24 * 3600 * 1000) < .01, "A month apart almost forgets");
        near(Companion.fade(Double.NaN, 5), 0, 0, "Invalid affection");
    }

    private static void near(double actual, double expected, double tolerance, String message) {
        checks++;
        if (!(Math.abs(actual - expected) <= tolerance)) {
            throw new AssertionError(message + ": expected " + expected + " got " + actual);
        }
    }

    private static void require(boolean condition, String message) {
        checks++;
        if (!condition) throw new AssertionError(message);
    }
}
