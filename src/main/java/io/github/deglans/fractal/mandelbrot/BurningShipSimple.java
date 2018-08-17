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
 * BurningShipSimple is a variant of the Mandelbrot fractals.
 * BurningShipSimple use the escape-time algorithm and a simple color palette.
 *
 * @version 0.11
 * @author Deglans Dalpasso
 */
public class BurningShipSimple extends MandelbrotBase {

    /**
     * The data of this fractal instance.
     */
    protected final DataBox dataBox;

    /**
     * The color palette of this fractal instance.
     */
    protected final ColorPalette colorPalette;

    /**
     * Create a BurningShipSimple instance with the given data
     * and the default colors palette or HUE palette.
     *
     * @param dataBox the data of this fractal instance.
     * @param hue if true, use a HUE palette, else use the default color palette.
     */
    public BurningShipSimple(DataBox dataBox, boolean hue) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = new ColorPalette(this.dataBox.getMaxIterations(), hue);
    }

    /**
     * Create a BurningShipSimple instance with the given data.
     *
     * @param dataBox the data of this fractal instance.
     * @param colorPalette the palette of this fractal instance.
     */
    public BurningShipSimple(DataBox dataBox, ColorPalette colorPalette) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = colorPalette;
    }

    /**
     * Calculate the color of c through the escape-time algorithm.
     *
     * @param c the point to be calculated.
     * @return the color of c.
     */
    @Override
    protected Color calcPoint(Complex c) {
        Complex z = new Complex(0, 0);
        Complex tmp;
        int count = 0;

        while ((count < dataBox.getMaxIterations()) && (z.mod() < 2)) {
            tmp = new Complex(Math.abs(z.getReal()), Math.abs(z.getImag()));
            z = tmp.pow(dataBox.getPower()).minus(c);
            count++;
        }

        return colorPalette.getColor(count);
    }

}
