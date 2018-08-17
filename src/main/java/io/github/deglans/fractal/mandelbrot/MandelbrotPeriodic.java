/*
 * Copyright (c) 2018. Deglans Dalpasso <deglans@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.deglans.fractal.mandelbrot;

import io.github.deglans.fractal.utility.Complex;
import io.github.deglans.fractal.utility.ColorPalette;

import javafx.scene.paint.Color;

/**
 * MandelbrotPeriodic is an advanced way to calculate the Mandelbrot fractals.
 * MandelbrotPeriodic use the escape-time algorithm for the power that have
 * a real part positive or equal zero and detect periodic behavior for the negative.
 * Still use a simple colors table.
 *
 * http://math.stackexchange.com/questions/1257555/how-to-compute-a-negative-multibrot-set
 *
 * @version 0.12
 * @author Deglans Dalpasso
 */
public class MandelbrotPeriodic extends MandelbrotBase {

    /**
     * The data of this fractal instance.
     */
    protected final DataBox dataBox;

    /**
     * The color palette of this fractal instance.
     */
    protected final ColorPalette colorPalette;

    /**
     * Create a MandelbrotPeriodic instance with the given data
     * and the default colors palette or HUE palette.
     *
     * @param dataBox the data of this fractal instance.
     * @param hue if true, use a HUE palette, else use the default color palette.
     */
    public MandelbrotPeriodic(DataBox dataBox, boolean hue) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = new ColorPalette(this.dataBox.getMaxIterations(), hue);
    }

    /**
     * Create a MandelbrotPeriodic instance with the given data.
     *
     * @param dataBox the data of this fractal instance.
     * @param colorPalette the palette of this fractal instance.
     */
    public MandelbrotPeriodic(DataBox dataBox, ColorPalette colorPalette) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = colorPalette;
    }

    /**
     * If the power has a real part positive or equal zero use the escape-time algorithm
     * else check the periodic behavior algorithm.
     *
     * @param c the point to be calculated.
     * @return the color of c.
     */
    @Override
    protected Color calcPoint(Complex c) {
        int count = 0;
        Complex z = new Complex(0, 0);

        if (dataBox.getPower().getReal() < 0) {
            PeriodicBehavior matcher = new PeriodicBehavior(
                    dataBox.getMaxIterations() > 1000 ? 100 : dataBox.getMaxIterations()/10);

            while ((count < dataBox.getMaxIterations()) && (!matcher.checkNumber(z))) {
                z = z.pow(dataBox.getPower()).plus(c);
                count++;
            }
        }
        else {
            while ((count < dataBox.getMaxIterations()) && (z.mod() < 2)) {
                z = z.pow(dataBox.getPower()).plus(c);
                count++;
            }
        }

        return colorPalette.getColor(count);
    }

    /**
     * PeriodicBehavior is an helper class for check the periodic behavior.
     * Need to be improved.
     *
     * @version 0.10
     * @author Deglans Dalpasso
     */
    protected class PeriodicBehavior {

        /**
         * Default buffer length.
         */
        static final int DEFAULT_BUFFER_LENGTH = 10;

        /**
         * Default delta between values.
         */
        static final double DELTA = 0.01;

        /**
         * The buffer.
         */
        private Complex[] buffer;

        /**
         * The pattern.
         */
        private Complex[] pattern;

        /**
         * The index in the buffer.
         */
        private int index;

        /**
         * Create the PeriodicBehavior with the buffer of the default length.
         */
        PeriodicBehavior() {
            this(DEFAULT_BUFFER_LENGTH);
        }

        /**
         * Create the PeriodicBehavior with the given length.
         *
         * @param len the length of the buffer.
         */
        PeriodicBehavior(int len) {
            buffer = new Complex[len];
            index = 0;
        }

        /**
         * Insert z in the buffer and check for the periodicity.
         *
         * @param z the number to check.
         * @return true if there is a periodicity.
         */
        boolean checkNumber(Complex z) {
            if (index < buffer.length) {
                buffer[index] = new Complex(z);
                index++;
                if (index == buffer.length) {
                    return checkPeriodicity();
                }
                return false;
            }
            else {
                for (int k = 0; k < buffer.length - 1; k++) {
                    buffer[k] = buffer[k+1];
                }
                buffer[buffer.length - 1] = new Complex(z);
                return checkPeriodicity();
            }
        }

        /**
         * Perform the periodicity check.
         *
         * @return true if there is a periodicity.
         */
        private boolean checkPeriodicity() {
            for (int len = buffer.length / 2; len >= 2; len--) {
                makePattern(len);
                for (int start = len; start < len * 2; start++) {
                    if (check(len)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Make the pattern for the check.
         *
         * @param len the length of the pattern.
         */
        private void makePattern(int len) {
            pattern = new Complex[len];
            for (int k = 0; k < len; k++) {
                pattern[k] = buffer[k];
            }
        }

        /**
         * Perform the periodicity check.
         *
         * @param len
         * @return true if there is a periodicity.
         */
        private boolean check(int len) {
            for (int k = 0; k < len; k++) {
                if (!pattern[k].equals(buffer[len+k], DELTA)) {
                    return false;
                }
            }
            return true;
        }

    }

}
