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
 * MandelbrotSimple is the most simple way to calculate the Mandelbrot fractals.
 * MandelbrotSimple use the escape-time algorithm and a simple color palette.
 *
 * @version 0.12
 * @author Deglans Dalpasso
 */
public class MandelbrotSimple extends MandelbrotBase {

    /**
     * The data of this fractal instance.
     */
    protected final DataBox dataBox;

    /**
     * The color palette of this fractal instance.
     */
    protected final ColorPalette colorPalette;

    /**
     * Create a MandelbrotSimple instance with the given data
     * and the default colors palette or HUE palette.
     *
     * @param dataBox the data of this fractal instance.
     * @param hue if true, use a HUE palette, else use the default color palette.
     */
    public MandelbrotSimple(DataBox dataBox, boolean hue) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = new ColorPalette(this.dataBox.getMaxIterations(), hue);
    }

    /**
     * Create a MandelbrotSimple instance with the given data.
     *
     * @param dataBox the data of this fractal instance.
     * @param colorPalette the palette of this fractal instance.
     */
    public MandelbrotSimple(DataBox dataBox, ColorPalette colorPalette) {
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
        int count = 0;
        Complex z = new Complex(0, 0);

        while ((count < dataBox.getMaxIterations()) && (z.mod() < 2)) {
            z = z.pow(dataBox.getPower()).plus(c);
            count++;
        }

        return colorPalette.getColor(count);
    }

}
