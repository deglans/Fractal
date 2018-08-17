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

import io.github.deglans.fractal.utility.CartesianPlane;
import io.github.deglans.fractal.utility.Complex;

import javafx.scene.image.WritableImage;

/**
 * DataBox contains all the information about how to make fractals.
 *
 * @version 0.3
 * @author Deglans Dalpasso
 */
public class DataBox {

    /**
     * Default number of iterations for the escape-time algorithm.
     */
    public static final int DEFAULT_MAX_ITERATIONS = 100;

    /**
     * Default power to use for the calculus.
     */
    public static final Complex DEFAULT_POWER = new Complex(2, 0);

    /**
     * Default constant to use for the calculus.
     */
    public static final Complex DEFAULT_CONSTANT = new Complex(0.285, 0.013);

    /**
     * Default up left corner of the CartesianPlane.
     */
    public static final Complex DEFAULT_UP_LEFT = new Complex(-2, 2);

    /**
     * Default down right corner of the CartesianPlane.
     */
    public static final Complex DEFAULT_DOWN_RIGHT = new Complex(2, -2);

    /**
     * Effective number of iterations for the escape-time algorithm.
     */
    private final int maxIterations;

    /**
     * Effective power to use for the calculus.
     */
    private final Complex power;

    /**
     * Effective constant to use for the calculus.
     */
    private final Complex constant;

    /**
     * The CartesianPlane.
     */
    private final CartesianPlane cartesianPlane;

    /**
     * The result of the calculus.
     */
    private final WritableImage image;

    /**
     * Create a DataBox instance with the given data.
     *
     * @param maxIterations the number of max iteration for the escape-time algorithm.
     * @param power the power to use for the calculus.
     * @param constant the constant to use for the calculus.
     * @param cartesianPlane the CartesianPlane for the conversion.
     * @param image the image where write pixel.
     */
    public DataBox(int maxIterations, Complex power, Complex constant,
            CartesianPlane cartesianPlane, WritableImage image) {

        this.maxIterations = maxIterations;
        this.power = power;
        this.constant = constant;
        this.cartesianPlane = cartesianPlane;
        this.image = image;
    }

    /**
     * Return the number of max iteration for the escape-time algorithm.
     *
     * @return the number of max iteration for the escape-time algorithm.
     */
    public int getMaxIterations() {
        return maxIterations;
    }

    /**
     * Return the power to use for the calculus.
     *
     * @return the power to use for the calculus.
     */
    public Complex getPower() {
        return power;
    }

    /**
     * Return the constant to use for the calculus.
     *
     * @return the constant to use for the calculus.
     */
    public Complex getConstant() {
        return constant;
    }

    /**
     * Return the image where write pixel.
     *
     * @return the image where write pixel.
     */
    public WritableImage getImage() {
        return image;
    }

    /**
     * Return the CartesianPlane for the conversion.
     *
     * @return the CartesianPlane for the conversion.
     */
    public CartesianPlane getCartesianPlane() {
        return cartesianPlane;
    }

}
