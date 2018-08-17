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

import io.github.deglans.fractal.utility.ColorPalette;

/**
 * FractalFactory is the factory for all fractal.
 *
 * @version 0.3
 * @author Deglans Dalpasso
 */
public class FractalFactory {

    /**
     * The list of all fractal.
     */
    public static final String[] FRACTAL_LIST = {
        "Mandelbrot Simple",
        "Mandelbrot Simple (default color)",
        "Mandelbrot Simple (HUE color)",
        "Julia Simple",
        "Julia Simple (default color)",
        "Julia Simple (HUE color)",
        "Mandelbrot Periodic",
        "Mandelbrot Periodic (default color)",
        "Mandelbrot Periodic (HUE color)",
        "Burning Ship Simple",
        "Burning Ship Simple (default color)",
        "Burning Ship Simple (HUE color)",
        "Burning Julia Simple",
        "Burning Julia Simple (default color)",
        "Burning Julia Simple (HUE color)",
        "Mandelbrot Lyapunov"
    };

    /**
     * Factory for create fractal instances.
     *
     * @param selectedFractal the selected fractal.
     * @param dataBox the data for calculate the fractal.
     * @param colorPalette the colors for the fractal.
     * @return the fractal ready to calculate.
     */
    public static MandelbrotBase bulidFractal(String selectedFractal,
            DataBox dataBox, ColorPalette colorPalette) {

        switch (selectedFractal) {
            case "Mandelbrot Simple":
                return new MandelbrotSimple(dataBox, colorPalette);

            case "Mandelbrot Simple (default color)":
                return new MandelbrotSimple(dataBox, false);

            case "Mandelbrot Simple (HUE color)":
                return new MandelbrotSimple(dataBox, true);

            case "Julia Simple":
                return new JuliaSimple(dataBox, colorPalette);

            case "Julia Simple (default color)":
                return new JuliaSimple(dataBox, false);

            case "Julia Simple (HUE color)":
                return new JuliaSimple(dataBox, true);

            case "Mandelbrot Periodic":
                return new MandelbrotPeriodic(dataBox, colorPalette);

            case "Mandelbrot Periodic (default color)":
                return new MandelbrotPeriodic(dataBox, false);

            case "Mandelbrot Periodic (HUE color)":
                return new MandelbrotPeriodic(dataBox, true);

            case "Burning Ship Simple":
                return new BurningShipSimple(dataBox, colorPalette);

            case "Burning Ship Simple (default color)":
                return new BurningShipSimple(dataBox, false);

            case "Burning Ship Simple (HUE color)":
                return new BurningShipSimple(dataBox, true);

            case "Burning Julia Simple":
                return new BurningJuliaSimple(dataBox, colorPalette);

            case "Burning Julia Simple (default color)":
                return new BurningJuliaSimple(dataBox, false);

            case "Burning Julia Simple (HUE color)":
                return new BurningJuliaSimple(dataBox, true);

            case "Mandelbrot Lyapunov":
                return new MandelbrotLyapunov(dataBox, false);

            default:
                return null;
        }
    }

}
