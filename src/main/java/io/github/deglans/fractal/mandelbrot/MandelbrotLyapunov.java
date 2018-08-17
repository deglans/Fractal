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
 * MandelbrotLyapunov is a more advanced way to calculate the Mandelbrot fractals.
 * This class did not work!
 *
 * http://math.stackexchange.com/questions/1257555/how-to-compute-a-negative-multibrot-set
 *
 * @version 0.2
 * @author Deglans Dalpasso
 */
public class MandelbrotLyapunov extends MandelbrotBase {

    /**
     * The data of this fractal instance.
     */
    protected final DataBox dataBox;

    /**
     * The color palette of this fractal instance.
     */
    protected final ColorPalette colorPalette;

    /**
     * Create a MandelbrotLyapunov instance with the given data
     * and the default colors palette or HUE palette.
     *
     * @param dataBox the data of this fractal instance.
     * @param hue if true, use a HUE palette, else use the default color palette.
     */
    public MandelbrotLyapunov(DataBox dataBox, boolean hue) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = new ColorPalette(this.dataBox.getMaxIterations(), hue);
    }

    /**
     * Create a MandelbrotLyapunov instance with the given data.
     *
     * @param dataBox the data of this fractal instance.
     * @param colorPalette the palette of this fractal instance.
     */
    public MandelbrotLyapunov(DataBox dataBox, ColorPalette colorPalette) {
        super(dataBox.getCartesianPlane(), dataBox.getImage());
        this.dataBox = dataBox;
        this.colorPalette = colorPalette;
    }

    @Override
    protected Color calcPoint(Complex c) {
        // http://math.stackexchange.com/questions/1257555/how-to-compute-a-negative-multibrot-set
        Complex z = new Complex(0, 0);
        Complex derivative;
        double lyapunov = 0;

        for (int count = 0; count < dataBox.getMaxIterations(); count++) {
            z = z.pow(dataBox.getPower()).plus(c);
            derivative = new Complex(z);
            lyapunov += Math.log(derivative.mod());
        }

        lyapunov /= dataBox.getMaxIterations();

        if (lyapunov <= 0) {
            // If it is equal to or less than zero, then it is part of the set.
            return Color.BLACK;
        }
        else {
            return Color.WHITE;
        }
    }

}
