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
 * JuliaSimple is the most simple way to calculate the Julia fractals.
 * JuliaSimple use the escape-time algorithm and a simple color palette.
 *
 * http://mcgoodwin.net/julia/juliajewels.html
 *
 * @version 0.12
 * @author Deglans Dalpasso
 */
public class JuliaSimple extends MandelbrotBase {

    /**
     * The data of this fractal instance.
     */
    protected final DataBox dataBox;

    /**
     * The color palette of this fractal instance.
     */
    protected final ColorPalette colorPalette;

    /**
     * Create a JuliaSimple instance with the given data
     * and the default colors palette or HUE palette.
     *
     * @param dataBox the data of this fractal instance.
     * @param hue if true, use a HUE palette, else use the default color palette.
     */
    public JuliaSimple(DataBox dataBox, boolean hue) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = new ColorPalette(this.dataBox.getMaxIterations(), hue);
    }

    /**
     * Create a JuliaSimple instance with the given data.
     *
     * @param dataBox the data of this fractal instance.
     * @param colorPalette the palette of this fractal instance.
     */
    public JuliaSimple(DataBox dataBox, ColorPalette colorPalette) {
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
        Complex z = new Complex(c);
        int count = 0;

        while ((count < dataBox.getMaxIterations()) && (z.mod() < Math.max(2, c.mod()))) {
            z = z.pow(dataBox.getPower()).plus(dataBox.getConstant());
            count++;
        }

        return colorPalette.getColor(count);
    }

}
